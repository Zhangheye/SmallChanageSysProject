package com.jxut;

import javafx.scene.SceneAntialiasing;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChanageSys {
    public static void main(String[] args) {

        double money = 0;
        double balance = 0;
        menu(money,balance);

    }
    public static void menu(double money,double balance){
        while (true){
            System.out.println("--------------零钱通菜单--------------");
            System.out.println("\t\t\t\t1 零钱通明细");
            System.out.println("\t\t\t\t2 收益入账");
            System.out.println("\t\t\t\t3 消费账单");
            System.out.println("\t\t\t\t4 退  出");
            System.out.println("请选择(1-4):");
            select(money,balance);
            if (money < -1){
                break;
            }
        }
    }

    private static void select(double money,double balance) {
        Scanner s = new Scanner(System.in);
        int anInt = s.nextInt();
        if (anInt == 1){
            detail(money);
        }else if (anInt == 2){
            earnings(money,balance);
        }else if (anInt==3){
            consumption(money,balance);
        }else if (anInt == 4){
            quit();
        }
    }

    //退出
    private static void quit() {

    }

    //消费账单
    private static void consumption(double money,double balance) {
        System.out.println("请输入你的消费去处：");
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();

        System.out.println("请输入你的消费金额：");
        Scanner ss = new Scanner(System.in);
        int anInt = ss.nextInt();

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format = sdf.format(date);

        balance = money - anInt;

        System.out.println(s1 + " -"+anInt +" "+ format+"余额：" +balance);
    }

    //收益入账
    private static void earnings(double money,double balance) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format = sdf.format(date);

        System.out.println("请输入你的收益：");
        Scanner s = new Scanner(System.in);
        int anInt = s.nextInt();
        balance = money+anInt;
        System.out.println("收益入账  +" + anInt +" "+format+"余额：" +balance );

    }

    //零钱通明细
    private static void detail(double money) {
        System.out.println("--------------零钱通明细--------------");
        System.out.println("");
    }
}
