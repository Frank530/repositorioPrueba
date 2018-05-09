package com.prueba.dao;


import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
    
    private String user="root";
    private String pass="";
    private String db="prueba";
    private String url="jdbc:mysql://localhost:3306/"+db;
    private Connection con;
    
    public Connection getCon(){
        return con;
    }
    
    public void conectar() throws Exception{
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {
            System.out.println("error"+e.toString());
        }   
    }
    
    public void desconectar() throws Exception{
        try {
            if (con != null) {
                if(con.isClosed() == false){
                    con.close();
                }
            }
        } catch (Exception e) {
            throw e;
        }
        
    }
}
