package com.jxut;

/**
 * 该类是完成零钱通的各个功能的类
 *  各功能对应一个方法
 * */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class SmallChanageSys {

    double money = 0;
    double balance = 0;

    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    String format = sdf.format(date);

    ArrayList<String> strList = new ArrayList<String>();

    public  void menu(){
        while (true){
            System.out.println("--------------零钱通菜单--------------");
            System.out.println("\t\t\t\t1 零钱通明细");
            System.out.println("\t\t\t\t2 收益入账");
            System.out.println("\t\t\t\t3 消费账单");
            System.out.println("\t\t\t\t4 退  出");
            System.out.println("请选择(1-4):");
            select();
        }
    }

    private  void select() {
        Scanner s = new Scanner(System.in);
        int anInt = s.nextInt();
        if (anInt == 1){
            detail();
        }else if (anInt == 2){
            earnings();
        }else if (anInt==3){
            consumption();
        }else if (anInt == 4){
            return;
        }
    }

    //消费账单
    private  void consumption() {
        if (balance < 0){
            System.out.println("对不起，您的余额为零！无法消费！");
        }

        System.out.println("请输入你的消费金额：");
        Scanner ss = new Scanner(System.in);
        int anInt = ss.nextInt();

        if (anInt > money){
            System.out.println("对不起，您的消费金额大于余额！消费失败！");
        }

        System.out.println("请输入你的消费用处：");
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();


        balance -= (money - anInt);

        strList.add(s1 + " -"+anInt +" "+ format+" 余额：" +balance);

        System.out.println(s1 + " -"+anInt +" "+ format+" 余额：" +balance);
    }

    //收益入账
    private  void earnings() {

        System.out.println("请输入你的收益：");
        Scanner s = new Scanner(System.in);
        int anInt = s.nextInt();
        if (anInt < 0){
            System.out.println("入账无法小于0！请重新输入！");
        }
        balance += (money+anInt);

        strList.add("收益入账  +" + anInt +" "+format+" 余额：" +balance );
        System.out.println("收益入账  +" + anInt +" "+format+" 余额：" +balance );

    }

    //零钱通明细
    private  void detail() {
        System.out.println("--------------零钱通明细--------------");
        for (String s :strList){
            System.out.println(s);
        }
    }
}
