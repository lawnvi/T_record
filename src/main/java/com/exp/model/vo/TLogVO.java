package com.exp.model.vo;

import com.exp.model.pojo.TLog;

public class TLogVO {
    private TLog tLog;
    private String mName;
    private String styleClass;
    private String color;

    public TLogVO(TLog tLog) {
        this.tLog = tLog;
        if(tLog.getT() < 35.8){
            this.styleClass = "progress-bar bg-primary";
            this.color = "#57c7d4";
        }
        else if(tLog.getT() > 37 && tLog.getT() <= 37.4){
            this.styleClass = "progress-bar bg-warning";
            this.color = "#FF9E27";
        }else if(tLog.getT() > 37.4){
            this.styleClass = "progress-bar bg-danger";
            this.color = "#F25961";
        }else {
            this.styleClass = "progress-bar bg-success";
            this.color = "#2BB930";
        }
    }

    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public TLog gettLog() {
        return tLog;
    }

    public void settLog(TLog tLog) {
        this.tLog = tLog;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
