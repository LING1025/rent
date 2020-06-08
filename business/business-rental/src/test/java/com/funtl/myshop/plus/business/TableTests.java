package com.funtl.myshop.plus.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TableTests {
    @Test
    public void queryRptQ(){
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://192.168.168.208;database=Rental";
        Connection conn=null;
        CallableStatement cstmt=null;
        try{
            //注册驱动
            Class.forName(driver);
            //获取连接
            conn= DriverManager.getConnection(url,"sa","1234abcd.");
            //调用存储过程
            cstmt=conn.prepareCall("{call s_AchievementsRpt_Q(?,?,?,?)}");
            //对?赋值
            cstmt.setInt(1, 4);
            cstmt.setLong(2,59);
            cstmt.setString(3,"2020-01-01");
            cstmt.setString(4,"2020-01-31");
            //执行
//            cstmt.execute();
            //获取结果
            String name=cstmt.getString(1);
            System.out.println(name);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                cstmt.close();
                conn.close();
            }
            catch(Exception e1){
                e1.printStackTrace();
            }
        }
    }

    @Test
    public void test2(){
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://192.168.168.208;database=Rental";
        Connection conn=null;
        CallableStatement cstmt=null;
        try {
            //注册驱动
            Class.forName(driver);
            //获取连接
            conn= DriverManager.getConnection(url,"sa","1234abcd.");
            //调用存储过程
            cstmt=conn.prepareCall("{call s_AchievementsRpt_Q(?,?,?,?)}");
            //对?赋值
            cstmt.setInt(1, 4);
            cstmt.setLong(2,21728);
            cstmt.setString(3,"2020-01-01");
            cstmt.setString(4,"2020-01-31");
            ResultSet rs = cstmt.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString(1));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
