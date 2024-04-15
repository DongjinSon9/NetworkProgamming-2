package com.bitc.java404.ex240415sdj.quiz5;

import com.bitc.java404.ex240415sdj.quiz5.dto.TagoDTO;
import com.bitc.java404.ex240415sdj.quiz5.dto.TagoItemDTO;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class GsonTMth {

    public void tagoInfo(String serviceUrl) throws IOException {
        List<TagoItemDTO> itemList = null;
        URL url = null;
        HttpURLConnection urlConn = null;
        BufferedReader reader = null;

        try {
            url = new URL(serviceUrl);
            urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setRequestMethod("GET");

            reader = new BufferedReader(new InputStreamReader((urlConn.getInputStream())));

            StringBuilder sb = new StringBuilder();
            String line = null;

            while((line = reader.readLine()) != null) {
                sb.append(line);
            }

            Gson gson = new Gson();
            TagoDTO tago = gson.fromJson(sb.toString(), TagoDTO.class);
            itemList = tago.getResponse().getBody().  getItems().getItem();
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

        for(TagoItemDTO item : itemList){
            System.out.println("------------------열차 정보------------------");
            System.out.println("열차번호 : " + item.getTrainno());
            System.out.println("열차종류 : " + item.getTraingradename());
            System.out.println("출발지 : " + item.getDepplacename());
            System.out.println("출발시간 : " + item.getDepplandtime());
            System.out.println("도착지 : " + item.getArrplacename());
            System.out.println("도착시간 : " + item.getArrplandtime());
            System.out.println("열차운임 : " + item.getAdultcharge());
            System.out.println("--------------------------------------------\n");
        }
    }

}
