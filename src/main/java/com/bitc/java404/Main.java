package com.bitc.java404;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("데이터베이스 사용 테스트");


        Connection conn = null;

        try {
            String url = "jdbc:mysql://localhost:3306/testdb?characterEncoding=utf8&serverTimezone=UTC";
            String userId = "java404";
            String userPw = "java404";

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, userId, userPw);
            System.out.println("데이터베이스 연결에 성공했습니다.");
        } catch (SQLException e) {
            System.out.println("데이터베이스 연결에 실패했습니다.");
            System.out.println("SQLException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }

    }
}