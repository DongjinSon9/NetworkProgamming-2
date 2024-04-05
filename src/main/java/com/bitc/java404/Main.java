package com.bitc.java404;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void dbTedst() {
        System.out.println("데이터베이스 사용 테스트");
        //        데이터베이스 서버 접속용
        Connection conn = null;

        try {
//            데이터베이스 접속주소
            String url = "jdbc:mysql://localhost:3306/testdb?characterEncoding=utf8&serverTimezone=UTC";
            String userId = "java404";  // 사용자 ID
            String userPw = "java404";  // 사용자 비밀번호

//            JDBC 드라이버 로딩
            Class.forName("com.mysql.cj.jdbc.Driver");
//            DriverManager를 사용하여 지정한 데이터베이스에 사용자ID/PW를 사용하여 접속
            conn = DriverManager.getConnection(url, userId, userPw);
            System.out.println("데이터베이스 연결에 성공했습니다.");
        } catch (SQLException e) {
            System.out.println("데이터베이스 연결에 실패했습니다.");
            System.out.println("SQLException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
//                connection 객체도 외부 리소스이기 때문에 반드시 사용자가 직접 close() 해야 함
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }
    }


    public static void main(String[] args) {
        dbTedst();

        ParserToDB parser = new ParserToDB();
//        parser.insertDB();
        parser.selectDB();
        System.out.println("------데이터 삭제------");
        parser.deleteDB("test3");
        System.out.println("------데이터 수정------");
        parser.updateDB();
        parser.selectDB();

    }
}