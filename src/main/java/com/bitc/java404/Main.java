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

//        ParserToDB parser = new ParserToDB();
//        parser.insertDB();
//        parser.selectDB();
//        System.out.println("------데이터 삭제------");
//        parser.deleteDB("test3");
//        System.out.println("------데이터 수정------");
//        parser.updateDB();
//        parser.selectDB();


        MemberDTO member = new MemberDTO();
//        member.setUser_id("test4");
//        member.setUser_pw("1234");
//        member.setUser_name("테스트유저4");
//        member.setUser_email("test4@bit.ac.kr");
//        member.setUser_phone("01013572468");
//        member.setUser_addr("서울시");

        ParserToDB parser = new ParserToDB();
//        System.out.println("---------기존 사용자 정보 확인---------");
//        parser.selectDB();
//        System.out.println("------------사용자 정보 추가-----------");
//        parser.insertDB(member);
//        System.out.println("---------추가된 사용자 정보 확인---------");
//        parser.selectDB();

        member.setUser_id("test5");
        member.setUser_pw("4321");
        member.setUser_name("테스트유저5");
        member.setUser_email("test5@bit.ac.kr");
        member.setUser_phone("01011223344");
        member.setUser_addr("서울시");

//        System.out.println("------------사용자 정보 추가-----------");
//        parser.insertDB(member);
//        System.out.println("---------추가된 사용자 정보 확인---------");
//        parser.selectDB();

        System.out.println("-----------데이터 수정하기-----------");

        member.setUser_id("test5");
        member.setUser_pw("123456789");
        member.setUser_name("유저테스터5");
        member.setUser_email("test5@gmail.com");
        member.setUser_phone("01055667788");
        member.setUser_addr("부산시");

        parser.updateDB(member);
        System.out.println("---------변경된 사용자 정보 확인---------");
        parser.selectDB();


    }
}