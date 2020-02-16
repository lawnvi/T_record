package com.exp.model.pojo;

public class CommunityLog {
    private Integer id;
    private Integer cid;
    private Integer infection;//确诊 此属性不处理 做样子
    private Integer abnormal;
    private Integer newTravel;
    private String date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getInfection() {
        return infection;
    }

    public void setInfection(Integer infection) {
        this.infection = infection;
    }

    public Integer getAbnormal() {
        return abnormal;
    }

    public void setAbnormal(Integer abnormal) {
        this.abnormal = abnormal;
    }

    public Integer getNewTravel() {
        return newTravel;
    }

    public void setNewTravel(Integer newTravel) {
        this.newTravel = newTravel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
