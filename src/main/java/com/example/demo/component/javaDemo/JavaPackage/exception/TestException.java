package com.example.demo.component.javaDemo.JavaPackage.exception;

import java.util.Scanner;

public class TestException {


    public static void main(String[] args) throws AgeException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入年龄：");

        int age = scanner.nextInt();
        if (age < 18) {
            throw new AgeException("年龄太小了！");
        }

        System.out.println("年龄为：" + age);
    }

}
