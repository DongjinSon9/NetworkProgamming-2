package com.bitc.java404.ex240415sdj.quiz5.dto;

import java.util.List;

public class TagoBodyDTO {

    private TagoItemsDTO items;
    private String numOfRows;
    private String pageNo;
    private String totalCount;

    public TagoItemsDTO getItems() {
        return items;
    }

    public void setItems(TagoItemsDTO items) {
        this.items = items;
    }

    public String getNumOfRows() {
        return numOfRows;
    }

    public void setNumOfRows(String numOfRows) {
        this.numOfRows = numOfRows;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }
}
