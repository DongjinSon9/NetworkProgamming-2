package com.bitc.java404.ex240415sdj.quiz4;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String url = "https://news.daum.net/?nil_profile=mini&nil_src=news";

        Document html = null;

        try {
            Connection.Response res = Jsoup.connect(url).method(Connection.Method.GET).execute();
            html = res.parse();
        } catch (IOException e) {
            System.out.println("파싱 중 오류가 발생했습니다.");
            e.printStackTrace();
        }

        Elements issueList = html.select(".list_newsissue");
        System.out.println(issueList);

        Elements newsIssue = issueList.select(".item_issue");
        csvWriter csvWriter = new csvWriter();

        System.out.println("-------------------오늘의 이슈-------------------");
        for (int i = 0; i < newsIssue.size(); i++) {
            Element item = newsIssue.get(i);
            Element aTag = newsIssue.select(".link_txt").first();
            String title = aTag.text();
            String link = aTag.attr("href");
            System.out.println("기사 " + (i + 1) + " : " + title);
            System.out.println("(링크 : " + link + ")");
            System.out.println("-------------------------------------\n");
            csvWriter.saveToCsv(title, link);
        }


    }
}
