package com.exp.model.pojo;

public class Community {
    private Integer id;
    private String name;
    private String address;
    private Integer FNumber;//多少住户
    private Integer MNumber;//多少居民
    private Integer infection;//确诊 此属性不处理 做样子

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getFNumber() {
        return FNumber;
    }

    public void setFNumber(Integer FNumber) {
        this.FNumber = FNumber;
    }

    public Integer getMNumber() {
        return MNumber;
    }

    public void setMNumber(Integer MNumber) {
        this.MNumber = MNumber;
    }

    public Integer getInfection() {
        return infection;
    }

    public void setInfection(Integer infection) {
        this.infection = infection;
    }
}
