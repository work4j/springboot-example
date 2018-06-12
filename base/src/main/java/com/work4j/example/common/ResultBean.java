package com.work4j.example.common;

import com.github.pagehelper.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * ResultBean
 */
@Data
public class ResultBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code = "0"; // code
    private String msg = ""; // msg
    private long count; // count
    private List data; // data

    public ResultBean() {
    }

    public ResultBean(List data) {
        if (data instanceof Page) {
            Page page = (Page) data;
            this.count = page.getTotal();
        } else {
            this.count = data.size();
        }
        this.data = data;
    }

    public ResultBean(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultBean(String code, String msg, List data) {
        this.code = code;
        this.msg = msg;
        if (data instanceof Page) {
            Page page = (Page) data;
            this.count = page.getTotal();
        } else {
            this.count = data.size();
        }
        this.data = data;
    }

    public ResultBean(String code, String msg, long count, List data) {
        this.code = code;
        this.msg = msg;
        if (data instanceof Page) {
            Page page = (Page) data;
            this.count = page.getTotal();
        } else {
            this.count = data.size();
        }
        this.data = data;
    }
}