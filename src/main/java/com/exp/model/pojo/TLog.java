package com.exp.model.pojo;

import com.exp.utli.Utils;

public class TLog {
    private Integer id;
    private Integer mid;
    private String date;
    private String time;
    private Double t;
    private String notes;

    public TLog(){
        this.date = Utils.getDate();
        this.time = Utils.getTime();
        System.out.println("date:"+date+"time:"+time);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getT() {
        return t;
    }

    public void setT(Double t) {
        this.t = t;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
