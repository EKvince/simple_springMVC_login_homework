package com.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author 王令
 * @version 1.0
 * @date 2021/5/24 15:39
 */
public class DBConn {

    private Connection conn=null;
    private PreparedStatement stmt=null;
    private ResultSet res=null;
    private String url="jdbc:mysql://localhost:3306/javaeetest?serverTimezone=UTC";
    private String user="root";
    private String password="123456";
    private String driver="com.mysql.cj.jdbc.Driver";

    private void DBconnect(){
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    public void disconnect(){
        if(res!=null){
            try{
                res.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(stmt!=null){
            try{
                stmt.close();

            } catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try{
                conn.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    public int DBupdate(final String strSQL){
        DBconnect();
        System.out.println("SQL:>"+strSQL);
        try{
            stmt=conn.prepareStatement(strSQL);
            int affectedRows=stmt.executeUpdate();
            return affectedRows;
        } catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
    public ResultSet DBquery(final String strSQL){
        DBconnect();
        System.out.println("SQL:>"+strSQL);
        try{
            stmt=conn.prepareStatement(strSQL);
            res=stmt.executeQuery();
            return res;
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public int checkUser(String username,String password){
//        DBConn db =new DBConn();
        DBconnect();
        String DB_sql="select * from userinfo where username='"+username+"'and password='"+password+"';";
        ResultSet res = DBquery(DB_sql);
        try {
            if(res.next())
                return 1;
            else
                return 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public int saveRegister(String username,String password){
//        DBConn db =new DBConn();
        DBconnect();
//    private String username;
        String DB_sql="insert into userinfo(username,password) values('"+username+"','"+password+"');";
        DBupdate(DB_sql);
        return 1;
    }


}
