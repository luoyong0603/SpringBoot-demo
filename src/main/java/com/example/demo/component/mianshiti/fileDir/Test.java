package com.example.demo.component.mianshiti.fileDir;

import java.io.File;

/**
 * 列出一个目录下的所有文件
 *
 * @author luoYong
 * @version 1.0
 * @date 2022/11/22 17:30
 */
public class Test {

    public static void main(String[] args) {
        Test.showDirectory(new File("./src/main/resources"));
    }

    //进行文件层级递归
    public static void showDirectory(File f) {
        //从根目录开始
        Test.walkDirectory(f, 0);
    }

    //对目录进行递归调用
    private static void walkDirectory(File f, int level) {
        //判断是否为文件夹
        if (f.isDirectory()) {
            //打印文件夹名称
            System.out.println(f.getName() + ":");
            for (File temp : f.listFiles()) {
                long length = temp.length();
                System.out.println(length);
                Test.walkDirectory(temp, level + 1);
            }
        } else {//文件直接输出
            //打印间隔
            for (int i = 0; i < level - 1; i++) {
                System.out.print("  ");
            }
            //打印文件名名称
            System.out.println(f.getName());
        }
    }
}
