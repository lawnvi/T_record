package com.exp.model.vo;

import com.exp.model.pojo.Family;
import com.exp.model.pojo.Member;
import com.exp.model.pojo.TLog;

public class TLogVO {
    private TLog tLog;
    private String mName;

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
