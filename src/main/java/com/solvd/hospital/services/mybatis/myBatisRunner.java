package com.solvd.hospital.services.mybatis;

public class myBatisRunner {
    public static void main(String[] args) {

    myBatisDAO con = new myBatisIMP();
        System.out.println(con.getVersionMysql());
    }
}


