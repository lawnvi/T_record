package com.exp.model.pojo;

public class Family {
    private Integer id;
    private Integer cid;
    private String name;
    private String address;
    private Integer number;
    private Integer reporter;
    private String psw;

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public Family(){
        this.number = 0;
        this.reporter = 0;
    }

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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getReporter() {
        return reporter;
    }

    public void setReporter(Integer report) {
        this.reporter = report;
    }
}
