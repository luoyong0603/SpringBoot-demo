package com.example.demo.controller;

/**
 * @author luoYong
 * @version 1.0
 * @date 2023/1/9 9:49
 */

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Practice extends JFrame implements ActionListener{


    //创建二维数组，作为按钮名
    String name[][]= {{"1","2","3","+"},
            {"4","5","6","-"},
            {"7","8","9","*"},
            {"0",".","=","/"}};
    //创建按钮数组
    JButton button[][] = new JButton[4][4];

    //创建面板对象数组
    private JPanel temp[] = new JPanel[4];

    //创建单行文本框，作为显示
    JTextField text = new JTextField();

    //第一次的输入数组字符串，操作符，第二次的数组字符串
    private String firstInput = null;
    private String operator = null;
    private Double result;

    public Practice() {//构造方法


        super("Calculator");
        this.setBounds(300,400,400,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //设置为网格布局，5行，1列，每一行添加一个面板
        this.getContentPane().setLayout(new GridLayout(5,1));
        this.add(text);
        this.text.setHorizontalAlignment(JTextField.RIGHT);//在右边显示输入的字符
        text.setEditable(false);//设置为不可编辑

        for(int i = 0;i<4;i++) {//实例化panel对象，添加到顶层容器中

            temp[i] = new JPanel(new GridLayout(1,4));
            this.add(temp[i]);
        }

        //将按钮添加到指定位置，添加事件监听器，添加到面板中
        for(int i = 0;i < 4;i++) {

            for(int j = 0;j<4;j++) {

                button[i][j] = new JButton(name[i][j]);
                button[i][j].addActionListener(this);
                temp[i].add(button[i][j]);
            }
        }

        //添加面板
        for(int i = 0;i<4;i++) {

            this.add(temp[i]);
        }

        this.setVisible(true);


    }

    public void actionPerformed(ActionEvent e) {

        String str = e.getActionCommand();//获得所点击按钮的字符串
        if(".0123456789".indexOf(str)!=-1) {//返回目标字符串在字符串中的下标，如果没有，则返回-1

            text.setText(text.getText()+str);
        }else if(str.matches("[\\+\\-*/]{1}")){

            operator = str;//记录下操作符
            firstInput = text.getText();//将第一次输入的值记录
            text.setText("");//将文本框清空


        }else if(str.equals("=")) {

            Double num1 = Double.valueOf(firstInput);//String 类型转换为Double 型
            Double num2 = Double.valueOf(text.getText());//点击运算符之后，再次点击的数字

            switch(operator) {

                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1*num2;
                    break;
                case "/":
                    if(num2!=0) {
                        result = num1/num2;
                    }
                    break;

            }
            text.setText(result.toString());//将Double 型转换为String 型
        }
    }

    public static void main(String[] args) {
        new Practice();
    }

}