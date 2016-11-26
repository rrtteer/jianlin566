package com.zjl.zjl_base;

import com.zjl.zjl_crm.constant.Constant;

/**
 * Created by Tony on 2016/8/22.
 */
public class ResultInfo {

    private int resultCode = Constant.RESULT_OK;
    private Object result;

    public ResultInfo() {
        super();
    }
    public ResultInfo(int resultCode) {
        super();
        this.resultCode = resultCode;
    }
    public ResultInfo(Object result) {
        super();
        this.result = result;
    }
    public ResultInfo(int resultCode, Object result) {
        super();
        this.resultCode = resultCode;
        this.result = result;
    }
    public int getResultCode() {
        return resultCode;
    }
    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }
    public Object getResult() {
        return result;
    }
    public void setResult(Object result) {
        this.result = result;
    }

}
