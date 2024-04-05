package com.bitc.java404;

import java.security.PublicKey;
import java.sql.*;
import java.text.Format;

public class ParserToDB {
    public void insertDB() {
//        데이터베이스 접속을 위한 클래스 객체 생성
        Connection conn = null;

//        JDBC를 이용한 데이터베이스 접속 주소 설정
        String dbUrl = "jdbc:mysql://localhost:3306/testdb?characterEncoding=utf8&serverTimezone=UTC";
//        사용자 ID/PW
        String dbUser = "java404";
        String dbPass = "java404";

//        JDBC에서 DBMS로 SQL 쿼리문을 대신 전달하고 해당 결과값을 받아오는 클래스
//        Statement : 간단한 SQL 쿼리문을 실행시 사용. 실행 후 객체를 닫아야 함. (재활용 불가) SQL문이 String 타입의 문자열로 만들어져 있음
//        PreparedStatement : 복잡한 SQL 쿼리문 실행시 사용.(재활용 가능) String 타입의 문자열로 만들어진 SQL에 ' ? '를 사용하여 원하는 데이터를 나중에 입력할 수 있음.
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);

//            SQL 쿼리문 생성
//            변결딜 수 있는 데이터 부분에 ' ? '를 사용하여 나중에 실제 데이터를 입력할 수 있음.
            String sql = "insert into member (user_id, user_pw, user_name, user_email, user_phone, user_addr) values (?, ?, ?, ?, ?, ?)";

//            데이터베이스에 접속된 Connection 객체를 통해서 PreparedStatement 객체를 받아옴
            pstmt = conn.prepareStatement(sql);
//            setXX() 메서드를 통해서 SQL에 입력된 ' ? ' 부분에 데이터를 추가함.
//            setXX() 메서드는 기본 데이터 타입을 모두 제공함.(String, Short, Boolean, Long, Byte, Float, Double, Int ....)
//            setXX() 메서드의 첫번째 매개변수는 ' ? '의 번호, 두번째 매개변수는 입력될 데이터
            pstmt.setString(1, "test3");
            pstmt.setString(2, "1234");
            pstmt.setString(3, "테스터3");
            pstmt.setString(4, "test3@bit.ac.kr");
            pstmt.setString(5, "01056781234");
            pstmt.setString(6, "부산시");

//            execute() : select문 실행 시 사용. 반환값으로 ResultSet이라는 타입으로 출력
//            executeUpdate() : insert, update, delete 문 실행 시 사용, 반환값으로 실행된 건수가 출력됨
            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println(result + "건의 데이터가 추가되었습니다.");
            } else {
                System.out.println("데이터베이스에 데이터가 추가되지 않았습니다.");
            }


        } catch (SQLException e) {
            System.out.println("데이터베이스 연결 중 오류가 발생했습니다.");
            System.out.println("sqlexception: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
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

    public void selectDB() {

        String dbUrl = "jdbc:mysql://localhost:3306/testdb?characterEncoding=utf8&serverTimezone=UTC";
        String dbUser = "java404";
        String dbPass = "java404";
        
        Connection conn = null;
        
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            
            String sql = "select * from member";


            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

//            next() : 데이터가 존재 시 데이터를 가져옴, 데이터가 없으면 false를 출력
            while (rs.next()) {
//                getXX() 를 사용하여 데이터를 가져옴
//                getXX()는 메서드 오버로딩을 통래서 여러가지 매개변수를 받음(주로 2개 사용)
//                1. index 번호를 받아서 해당하는 순서의 컬럼 데이터를 가져옴
//                2. 컬렴명을 직접 입력하여 해당 컬럼 데이터를 가져옴
                String userId = rs.getString("user_id");
                String userPw = rs.getString("user_pw");
                String userName = rs.getString("user_name");
                String userEmail = rs.getString("user_email");
                String userPhone = rs.getString("user_phone");
                String userAddr = rs.getString("user_addr");

                System.out.println("ID : " + userId);
                System.out.println("PW : " + userPw);
                System.out.println("Name : " + userName);
                System.out.println("Email : " + userEmail);
                System.out.println("Phone : " + userPhone);
                System.out.println("Address : " + userAddr);
                System.out.println("---------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("데이터베이스 사용 중 오류가 발생했습니다.");
            System.out.println("sqlexception: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
//                리소스 닫는 순서는 리소스를 열었던 순서의 반대로 진행
//                ResultSet > Statement > Connection
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {

            }
        }
    }


    public void deleteDB(String userId) {
        Connection conn = null;

        String dbUrl = "jdbc:mysql://localhost:3306/testdb";
        String dbUser = "java404";
        String dbPass = "java404";

        Statement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);

            String sql = "delete from member where user_id= '" + userId + "' ";

            stmt = conn.createStatement();
            int result = stmt.executeUpdate(sql);

            if (result > 0) {
                System.out.println(result + "건의 데이터가 삭제되었습니다.\n");
            } else {
                System.out.println("데이터가 삭제되지 않았습니다.\n");
            }


        } catch (SQLException e) {
            System.out.println("데이터베이스 사용 중 오류가 발생했습니다.\n");
            System.out.println("sqlexception: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {

            }
        }
    }


    public void updateDB() {

        Connection conn = null;
        String dbUrl = "jdbc:mysql://localhost:3306/testdb";
        String dbUser = "java404";
        String dbPass = "java404";

        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);

            String sql = "update member set ";
            sql += "user_name = ?, user_email = ?, user_phone = ? ";
            sql += "where user_id = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "테스트아이디1");
            pstmt.setString(2, "test2@gmail.com");
            pstmt.setString(3, "01011112222");
            pstmt.setString(4, "test1");

            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println(result + "건이 수정되었습니다.\n");
            }


        } catch (SQLException e) {
            System.out.println("데이터베이스 사용 중 오류가 발생했습니다.");
            System.out.println("sqlexception: " + e.getMessage() +"\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception e) {

            }
        }



    }










}
