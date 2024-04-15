package com.bitc.java404.ex240415sdj.quiz4;

import java.io.FileWriter;
import java.io.IOException;

public class csvWriter {

        public void saveToCsv(String title, String link) {
            try {
                FileWriter csvWriter = new FileWriter(" quiz4_SDJ.csv", true);
                csvWriter.append(title);
                csvWriter.append(",");
                csvWriter.append(link);
                csvWriter.append("\n");
                csvWriter.flush();
                csvWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
