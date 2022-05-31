package com.solvd.hospital.util;

import com.solvd.hospital.DAO.impl.myBatisIMP;
import com.solvd.hospital.DAO.myBatisDAO;

import javax.swing.*;

public class myBatisRunner {
    public static void main(String[] args) {

    myBatisDAO con = new myBatisIMP();
        System.out.println(con.getVersionMysql());
    }
}


