package com.jxut;

/**
 * 该类是完成零钱通的各个功能的类
 * 各功能对应一个方法
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class SmallChanageSys {

    //余额
    double balance = 0;

    //退出的变量
    boolean quit = false;

    //获取当前日期并且格式化
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    String format = sdf.format(date);

    //存放零钱通明细的集合
    ArrayList<String> strList = new ArrayList<String>();

    //零钱通菜单
    public void menu() {
        while (true) {
            System.out.println("--------------零钱通菜单--------------");
            System.out.println("\t\t\t\t1 零钱通明细");
            System.out.println("\t\t\t\t2 收益入账");
            System.out.println("\t\t\t\t3 消费账单");
            System.out.println("\t\t\t\t4 退  出");
            System.out.println("请选择(1-4):");
            //用户进行选择
            select();
            //判断是否退出
            if (quit) {
                break;
            }
        }
    }

    //选择功能
    private void select() {
        Scanner s = new Scanner(System.in);
        int anInt = s.nextInt();
        if (anInt == 1) {
            //零钱通明细
            detail();
        } else if (anInt == 2) {
            //收益入账
            earnings();
        } else if (anInt == 3) {
            //消费账单
            consumption();
        } else if (anInt == 4) {
            //退出
            quit();
        }
    }

    //退出方法
    private boolean quit() {
        System.out.println("请确认是否退出(y/n):");
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        if (s1.equals("y")) {
            return quit = true;
        } else
            System.out.println("取消退出!");

        return false;
    }

    //消费账单
    private void consumption() {
        if (balance <= 0) {
            System.out.println("对不起，您的余额为零！无法消费！");
        }

        System.out.println("请输入你的消费金额：");
        Scanner ss = new Scanner(System.in);
        int anInt = ss.nextInt();

        if (anInt > balance) {
            System.out.println("对不起，您的消费金额大于余额！消费失败！");
        }

        System.out.println("请输入你的消费用处：");
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();

        //修改余额
        balance -= anInt;

        //把消费详情添加到集合中
        strList.add(s1 + "\t" + "-" + anInt + "\t" + format + " 余额:" + balance);
    }

    //收益入账
    private void earnings() {

        System.out.println("请输入你的收益：");
        Scanner s = new Scanner(System.in);
        int anInt = s.nextInt();
        if (anInt <= 0) {
            System.out.println("入账无法小于或等于0！请重新输入！");
        }
        //修改余额
        balance += anInt;

        //把收起详情添加到集合中
        strList.add("收益入账\t+" + anInt + "\t" + format + " 余额:" + balance);
    }

    //零钱通明细
    private void detail() {
        System.out.println("--------------零钱通明细--------------");
        for (String s : strList) {
            System.out.println(s);
        }
    }
}
