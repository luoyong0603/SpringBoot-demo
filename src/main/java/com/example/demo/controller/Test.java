package com.example.demo.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author luoYong
 * @version 1.0
 * @date 2022/2/8 10:40
 */
public class Test {

    public static void main1(String[] args) {
//        int peach = hzct(10, 8);
//        System.out.println("第一天猴子一共摘了" + peach + "个桃子");

        bs();
    }

    /**
     * 在1-100000内，它加上100后是一个完全平方数，加上168又是一个完全平方数
     */
    public static void getNum() {
        double num1, num2;
        for (int i = 1; i <= 10000; i++) {
            num1 = Math.sqrt((i + 100));
            num2 = Math.sqrt((i + 100 + 168));

            //判断num1、num2是否为整数。
            if (num1 == (int) num1 && num2 == (int) num2) {
                System.out.println(i);
            }
        }
    }

    /**
     * 输入某年某月某日，判断这一天是这一年的第几天？
     */
    public static void getDayNum() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年份:");
        int year = scanner.nextInt();
        System.out.println("请输入月份:");
        int month = scanner.nextInt();
        System.out.println("请输入日:");
        int day = scanner.nextInt();

        int twoMonth = 28;

        //判断是否闰年
        boolean rn = isRN(year);

        //单独判断day是否大于2
        if (month > 2 && rn) {
            twoMonth = 29;
        }

        //记录总天数
        int num = 0;

        switch (month - 1) {
            case 1:
                num = 31;
                break;
            case 2:
                num = 31 + twoMonth;
                break;
            case 3:
                num = 31 + twoMonth + 31;
                break;
            case 4:
                num = 31 + twoMonth + 31 + 30;
                break;
            case 5:
                num = 31 + twoMonth + 31 + 30 + 31;
                break;
            case 6:
                num = 31 + twoMonth + 31 + 30 + 31 + 30;
                break;
            case 7:
                num = 31 + twoMonth + 31 + 30 + 31 + 30 + 31;
                break;
            case 8:
                num = 31 + twoMonth + 31 + 30 + 31 + 30 + 31 + 31;
                break;
            case 9:
                num = 31 + twoMonth + 31 + 30 + 31 + 30 + 31 + 31 + 30;
                break;
            case 10:
                num = 31 + twoMonth + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
                break;
            case 11:
                num = 31 + twoMonth + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30;
                break;
        }
        //将零头加起来
        num = num + day;
        System.out.println(year + "年" + month + "月" + day + "日" + "是这一年的第" + num + "天");
    }

    /**
     * 判断是否闰年
     */
    public static boolean isRN(int year) {
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        }
        return false;
    }

    /**
     * 三个数进行比较
     */
    public static void sort() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数:");
        int x = scanner.nextInt();
        System.out.println("请输入第二个数:");
        int y = scanner.nextInt();
        System.out.println("请输入第三个数:");
        int z = scanner.nextInt();

        //定义一个临时变量
        int temp;
        //枚举三种情况，然后交换数字大小。
        if (x > y) {
            temp = y;
            y = x;
            x = temp;
        }
        if (x > z) {
            temp = z;
            z = x;
            x = temp;
        }
        if (y > z) {
            temp = z;
            z = y;
            y = temp;
        }
        System.out.println("这三个数从小到大依次输出为：" + x + " " + y + " " + z);
    }

    /**
     * 九九乘法表
     */
    public static void jjcfb() {

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "\t");
            }
            System.out.println();
        }


    }

    /**
     * 猴子吃桃问题
     *
     * @param day   吃到第几天
     * @param peach 桃子剩余数
     */
    public static int hzct(int peach, int day) {

        for (int i = 1; i < day; i++) {
            peach = 2 * (peach + 1); //从最后一天计算
        }
        return peach;
    }


    /**
     * 两个乒乓球队进行比赛，各出三人。
     */
    public static void bs() {
        String[] temp1 = {"a", "b", "c"};
        String[] temp2 = {"x", "y", "z"};
        for (int i = 0; i < temp1.length; i++) {
            for (int j = 0; j < temp2.length; j++) {

                //排除不能组队的组合。a不和x比
                if (temp1[i].equals("a") && temp2[j].equals("x")) {
                    continue;
                }
                //c不和x,z比
                if ((temp1[i].equals("c") && temp2[j].equals("x")) || (temp1[i].equals("c") && temp2[j].equals("z"))) {
                    continue;
                }
                System.out.println(temp1[i] + temp2[j]);
            }
        }
    }


    public static void main2(String[] args) {
        printX();
    }

    /**
     * 打印出如下图案（菱形）
     */
    public static void printX() {

        //上半递增部分;
        for (int i = 1; i < 5; i++) {
            String s = printXX(i);
            System.out.println(s);
        }

        //下半递减部分;
        for (int i = 3; i > 0; i--) {
            String s = printXX(i);
            System.out.println(s);
        }
    }

    /**
     * 打印*
     */
    private static String printXX(int num) {

        String x = "*";
        //先区分一个*的情况
        if (num == 1) {
            return x;
        }

        //递增是按两颗*
        for (int i = 2; i <= num; i++) {
            x += "**";
        }

        //返回
        return x;
    }


    /**
     * 判断一个五位数是不是回文数
     */
    public static boolean isHWS(int num) {

        //个位数
        int a = num % 10000;
        //十位数
        int b = num % 100 / 10;
        //千位数
        int c = num / 1000 % 10;
        //万位数
        int d = num / 10000;
        if (a == d && b == c) {
            return true;
        }
        return false;
    }

    public static boolean isHWS1(int num) {

        //转成字符串
        String strNum = String.valueOf(num);

        //个位数
        char a = strNum.charAt(4);
        //十位数
        char b = strNum.charAt(3);
        //千位数
        char c = strNum.charAt(1);
        //万位数
        char d = strNum.charAt(0);
        if (a == d && b == c) {
            return true;
        }
        return false;
    }


    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个五位的数字：");
        int num = scanner.nextInt();
        //检验是否为5位数
        if (String.valueOf(num).length() != 5) {
            System.out.println("它不是五位数，请重新输入！");
            return;
        }
        if (isHWS(num)) {
            System.out.println(num + "是回文数");
        } else {
            System.out.println(num + "不是回文数");
        }
    }


    /**
     * 请输入星期几的第一个字母来判断一下是星期几，如果第一个字母一样，则继续判断第二个字母。
     * 英文的星期数：Sunday Monday Tuesday Wednesday Thursday Friday Saturday
     * 对应的中文：  星期天  星期一   星期二   星期三   星期四   星期五   星期六
     */
    public static String checkWeek(String str) {

        //先将小写字符转换为大写
        String week = str.toUpperCase();
        char[] weeks = week.toCharArray();
        if (weeks[0] == 'S') {
            if (weeks.length == 1) {
                return "无法判断，请重新输入";
            }
            if (weeks[1] == 'U') {
                return "星期天";
            } else if (weeks[1] == 'A') {
                return "星期六";
            } else {
                return ("您输入的数据有误...");
            }
        } else if (weeks[0] == 'M') {
            return "星期一";
        } else if (weeks[0] == 'T') {
            if (weeks.length == 1) {
                return "无法判断，请重新输入";
            }
            if (weeks[1] == 'U') {
                return ("星期二");
            } else if (weeks[1] == 'H') {
                return "星期四";
            } else {
                return "您输入的数据有误...";
            }
        } else if (weeks[0] == 'W') {
            return "星期三";
        } else if (weeks[0] == 'F') {
            return "星期五";
        }
        return "您输入的数据有误...";
    }

    public static void main4(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 获取用户输入英文的星期单词
        System.out.println("请输入英文星期单词: ");
        String week = sc.next();
        String s = checkWeek(week);
        System.out.println("你输入的是：" + s);
    }

    /**
     * 判断是否是质数
     */
    public static boolean isZS(int num) {

        //排除1不是质数
        if (num == 1) {
            return false;
        }
        for (int i = 2; i < num - 1; i++) {
            //进行求余;只要余数为0，说明i被整除，该i就是num的一个因子。
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 101-200范围内
     */
    public static String printZS(int n) {
        //用于统计质数
        String zs = "";
        //循环101-200
        for (int i = 1; i <= n; i++) {
            //true表示是质数
            if (isZS(i)) {
                zs += "," + i;
                continue;
            }
        }
        return zs;
    }

    public static void main5(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 获取用户输入英文的星期单词
        System.out.println("请输入你要找的素数范围n，从1到n: ");
        int n = sc.nextInt();

        String strZS = printZS(n);
        //去掉第一个逗号；
        String subZS = strZS.substring(1);
        System.out.println(subZS);
    }


    /**
     * 实现数组排序
     */
    public static void sortNum(int[] nums) {
        Arrays.sort(nums);
    }


    public static void main(String[] args) {
        int[] nums = {2, 6, -8, 6, -3, 9, 1, -12, -3, 16};
        System.out.println("排序前数组：");
        printNum(nums);
        //进行从小到大排序
        Arrays.sort(nums);
        System.out.println("排序后数组：");
        printNum(nums);
    }

    public static void printNum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                System.out.print(nums[i]);
                break;
            }
            System.out.print(nums[i] + ",");
        }
        System.out.println();
    }

}
