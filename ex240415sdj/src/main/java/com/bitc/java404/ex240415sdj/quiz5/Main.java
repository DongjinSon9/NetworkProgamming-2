package com.bitc.java404.ex240415sdj.quiz5;

import com.bitc.java404.ex240415sdj.quiz2.GsonMth;

public class Main {
    public static void main(String[] args) {

        GsonTMth gst = new GsonTMth();


        try {
            String url = "https://apis.data.go.kr/1613000/TrainInfoService/getStrtpntAlocFndTrainInfo";
            String serviceKey = "?serviceKey=";
            String myKey = "GJSg5B%2Bxk8xVApB%2BwTkP1vXZqHxmbE8a2WyLv8PgN%2BhBd3sQ%2BrSRypHGNb8G9i4mWHbLyxL2w5Al8jstKJgmCA%3D%3D";
            String opt1 = "&pageNo=";
            String inputPage = "1";
            String opt2 = "&numOfRows=";
            String inputRow = "10";
            String opt3 = "&_type=";
            String inputType = "xml";
            String opt4 = "&depPlaceId=";
            String startPlace = "NAT014445";
            String opt5 = "&arrPlaceId=";
            String endPlace = "NAT010000";
            String opt6 = "&depPlandTime=";
            String inputDate = "20240420";
            String opt7 = "&trainGradeCode=";
            String trainType = "00";


            String serviceURL = url + serviceKey + myKey + opt1 + inputPage + opt2 + inputRow + opt3 + inputType + opt4 + startPlace + opt5 + endPlace + opt6 + inputDate + opt7 + trainType; ;


            gst.tagoInfo(serviceURL);

        } catch (Exception e) {
        }

    }



}
