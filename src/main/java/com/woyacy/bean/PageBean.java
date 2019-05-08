package com.woyacy.bean;

import java.io.Serializable;
import java.util.List;

public class PageBean implements Serializable {

    private long total;
    private List data;

    public PageBean(long total, List data) {
        this.total = total;
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
