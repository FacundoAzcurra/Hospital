/*package com.solvd.hospital;

import java.sql.*;

public class mysql {
    private String nombreBaseDatos = "Facundo_Azcurra";
    private String url = "jdbc:mysql://localhost:3306/" + nombreBaseDatos;
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private String USER = "root";
    private String PASS = "devintern";

    public Connection connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                con = DriverManager.getConnection(url,USER,PASS);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }

    public mysql() {
    }

    public mysql(String nombreBaseDatos, String USER, String PASS) {
        this.nombreBaseDatos = nombreBaseDatos;
        this.USER = USER;
        this.PASS = PASS;
    }

    public String getNombreBaseDatos() {
        return nombreBaseDatos;
    }

    public void setNombreBaseDatos(String nombreBaseDatos) {
        this.nombreBaseDatos = nombreBaseDatos;
    }

    public String getUSER() {
        return USER;
    }

    public void setUSER(String USER) {
        this.USER = USER;
    }

    public String getPASS() {
        return PASS;
    }

    public void setPASS(String PASS) {
        this.PASS = PASS;
    }


    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
}*/