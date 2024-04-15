package com.bitc.java404.ex240415sdj.quiz1.dto;

public class PharmacyBodyDTO {

    private PharmacyItemsDTO items;
    private int numOfRows;
    private int pageNo;
    private int totalCount;

    public PharmacyItemsDTO getItems() {
        return items;
    }

    public void setItems(PharmacyItemsDTO items) {
        this.items = items;
    }

    public int getNumOfRows() {
        return numOfRows;
    }

    public void setNumOfRows(int numOfRows) {
        this.numOfRows = numOfRows;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
