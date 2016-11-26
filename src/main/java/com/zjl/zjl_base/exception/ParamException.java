package com.zjl.zjl_base.exception;

import com.zjl.zjl_crm.constant.Constant;

/**
 * Created by Tony on 2016/8/22.
 */
@SuppressWarnings("serial")
public class ParamException extends RuntimeException {

    private int errorCode;

    public  ParamException() {
    }
    public ParamException(String message) {
        super(message);
        this.errorCode = Constant.RESULT_ERROR;
    }
    public ParamException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
