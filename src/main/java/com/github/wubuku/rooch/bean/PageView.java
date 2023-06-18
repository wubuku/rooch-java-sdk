package com.github.wubuku.rooch.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PageView<T, C> {
    private List<T> data;
    @JsonProperty("next_cursor")
    private C nextCursor;
    @JsonProperty("has_next_page")
    private Boolean hasNextPage;

    public PageView() {
    }

    public PageView(List<T> data, C nextCursor) {
        this.data = data;
        this.nextCursor = nextCursor;
    }

    public static boolean hasNextPage(PageView page) {
        return page != null && (
                page.getHasNextPage() != null && page.getHasNextPage()
                        && page.nextCursor != null
        );
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public C getNextCursor() {
        return nextCursor;
    }

    public void setNextCursor(C nextCursor) {
        this.nextCursor = nextCursor;
    }

    public Boolean getHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(Boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    @Override
    public String toString() {
        return "Page{" +
                "data=" + data +
                ", nextCursor=" + nextCursor +
                ", hasNextPage=" + hasNextPage +
                '}';
    }
}
