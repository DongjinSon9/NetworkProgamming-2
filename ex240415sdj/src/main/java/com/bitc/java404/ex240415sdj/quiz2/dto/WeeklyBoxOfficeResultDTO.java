package com.bitc.java404.ex240415sdj.quiz2.dto;

import java.util.List;

public class WeeklyBoxOfficeResultDTO {

    private String boxofficeType;
    private String showRange;
    private String yearWeekTime;
    private List<WeeklyBoxOfficeListDTO> weeklyBoxOfficeList;

    public String getBoxofficeType() {
        return boxofficeType;
    }

    public void setBoxofficeType(String boxofficeType) {
        this.boxofficeType = boxofficeType;
    }

    public String getShowRange() {
        return showRange;
    }

    public void setShowRange(String showRange) {
        this.showRange = showRange;
    }

    public String getYearWeekTime() {
        return yearWeekTime;
    }

    public void setYearWeekTime(String yearWeekTime) {
        this.yearWeekTime = yearWeekTime;
    }

    public List<WeeklyBoxOfficeListDTO> getWeeklyBoxOfficeList() {
        return weeklyBoxOfficeList;
    }

    public void setWeeklyBoxOfficeList(List<WeeklyBoxOfficeListDTO> weeklyBoxOfficeList) {
        this.weeklyBoxOfficeList = weeklyBoxOfficeList;
    }
}
