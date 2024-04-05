package com.bitc.java404;

import com.bitc.java404.DTO.DailyBoxOfficeList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

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
//        dbTedst();

//        ParserToDB parser = new ParserToDB();
//        parser.insertDB();
//        parser.selectDB();
//        System.out.println("------데이터 삭제------");
//        parser.deleteDB("test3");
//        System.out.println("------데이터 수정------");
//        parser.updateDB();
//        parser.selectDB();


//        MemberDTO member = new MemberDTO();
//        member.setUser_id("test4");
//        member.setUser_pw("1234");
//        member.setUser_name("테스트유저4");
//        member.setUser_email("test4@bit.ac.kr");
//        member.setUser_phone("01013572468");
//        member.setUser_addr("서울시");

//        ParserToDB parser = new ParserToDB();
//        System.out.println("---------기존 사용자 정보 확인---------");
//        parser.selectDB();
//        System.out.println("------------사용자 정보 추가-----------");
//        parser.insertDB(member);
//        System.out.println("---------추가된 사용자 정보 확인---------");
//        parser.selectDB();

//        member.setUser_id("test5");
//        member.setUser_pw("4321");
//        member.setUser_name("테스트유저5");
//        member.setUser_email("test5@bit.ac.kr");
//        member.setUser_phone("01011223344");
//        member.setUser_addr("서울시");

//        System.out.println("------------사용자 정보 추가-----------");
//        parser.insertDB(member);
//        System.out.println("---------추가된 사용자 정보 확인---------");
//        parser.selectDB();

//        System.out.println("-----------데이터 수정하기-----------");
//
//        member.setUser_id("test5");
//        member.setUser_pw("123456789");
//        member.setUser_name("유저테스터5");
//        member.setUser_email("test5@gmail.com");
//        member.setUser_phone("01055667788");
//        member.setUser_addr("부산시");
//
//        parser.updateDB(member);
//        System.out.println("---------변경된 사용자 정보 확인---------");
//        parser.selectDB();


        System.out.println("\n------------url을 통한 json 데이터 db에 저장하기-----------\n");

//        Json 데이터를 제공하는 서비스 주소
        String url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
//        서비스를 사용하기 위한 키
        String serviceKey = "?key=";
        String myKey = "f5eef3421c602c6cb7ea224104795888";
//        서비스 제공 옵션
        String opt1 = "&targetDt=";
        String date = "20240401";

//        전체 서비스 URL 생성
        String serviceUrl = url + serviceKey + myKey + opt1 + date;

//        BoxOfficeParser 타입의 객체 생성
        BoxOfficeParser boxOfficeParser = new BoxOfficeParser();
//        jsonToObjectUrl()를 실행하여 api 서비스에 접속하여 json 데이터를 가져와서 파싱해서 itemList에 저장
        List<DailyBoxOfficeList> itemList = boxOfficeParser.jsonToObjectUrl(serviceUrl);

        for (DailyBoxOfficeList item : itemList) {
            boxOfficeParser.insertDailyBoxOffice(item);
        }

    }
}