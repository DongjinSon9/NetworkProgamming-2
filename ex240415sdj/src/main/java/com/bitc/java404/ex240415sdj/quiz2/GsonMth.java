package com.bitc.java404.ex240415sdj.quiz2;

import com.bitc.java404.ex240415sdj.quiz2.dto.WeeklyBoxOfficeDTO;
import com.bitc.java404.ex240415sdj.quiz2.dto.WeeklyBoxOfficeListDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class GsonMth {

    public void weeklyBoxOfficeUrl(String url) throws IOException {
        List<WeeklyBoxOfficeListDTO> itemList = null;
        String sRange = null;
        URL url2 = null;
        HttpURLConnection urlConn = null;
        BufferedReader reader = null;

        try {

            url2 = new URL(url);
            urlConn = (HttpURLConnection) url2.openConnection();
            urlConn.setRequestMethod("GET");
            reader = new BufferedReader(new InputStreamReader((urlConn.getInputStream())));
            StringBuilder sb = new StringBuilder();
            String line = null;

            while((line = reader.readLine()) != null) {

                sb.append(line);

            }

            com.google.gson.Gson gson = new com.google.gson.Gson();
            WeeklyBoxOfficeDTO boxOffice = gson.fromJson(sb.toString(), WeeklyBoxOfficeDTO.class);
            itemList = boxOffice.getBoxOfficeResult().getWeeklyBoxOfficeList();
            sRange = boxOffice.getBoxOfficeResult().getShowRange();

        } catch (Exception e) {

            e.printStackTrace();

        }
        finally {
            if (reader != null) {

                reader.close();

            }
            if (urlConn != null) {

                urlConn.disconnect();

            }
        }

        System.out.println("----------주간 박스오피스(" + sRange + ")---------\n");
        for(WeeklyBoxOfficeListDTO item : itemList) {

            System.out.println("영화 순위 : " + item.getRank());
            System.out.println("영화 코드 : " + item.getMovieCd());
            System.out.println("영화 이름 : " + item.getMovieNm());
            System.out.println("개봉 일자 : " + item.getOpenDt());
            System.out.println("일일 관람객 수 : " + item.getAudiCnt());
            System.out.println("누적 관람객 수 : " + item.getAudiAcc());
            System.out.println("--------------------------------------------------\n");
        }

    }

}
