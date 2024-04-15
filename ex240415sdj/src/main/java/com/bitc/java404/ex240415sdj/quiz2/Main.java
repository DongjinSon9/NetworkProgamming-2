package com.bitc.java404.ex240415sdj.quiz2;

public class Main {
    public static void main(String[] args) {

        GsonMth gm = new GsonMth();


        try {
            String url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json";
            String serviceKey = "?key=";
            String myKey = "f5eef3421c602c6cb7ea224104795888";
            String opt1 = "&targetDt=";
            String inputDate = "20240405";
            String opt2 = "&weekGb=";
            String inputWeek = "1";

            String serviceURL = url + serviceKey + myKey + opt1 + inputDate + opt2 + inputWeek;


            gm.weeklyBoxOfficeUrl(serviceURL);

        } catch (Exception e) {
        }

    }
}
