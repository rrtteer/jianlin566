package com.zjl.zjl_base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.zjl.zjl_crm.constant.Constant;



public class BaseController {
	
	@ModelAttribute
	protected void preMethod(HttpServletRequest request, Model model) {
		model.addAttribute("ctx", request.getContextPath());
	}
	
	/**
     * 设置成功
     * @param result
     * @return
     */
    protected ResultInfo success(Object result) {
        return new ResultInfo(result);
    }

    /**
     * 设置失败
     * @param errorCode
     * @param result
     * @return
     */
    protected ResultInfo failure(Integer errorCode, Object result) {
        return new ResultInfo(errorCode, result);
    }

    /**
     * 设置失败
     * @param errorCode
     * @return
     */
    protected ResultInfo failure(Integer errorCode) {
        return new ResultInfo(errorCode, "系统未知异常， 请联系管理员");
    }
    
    protected ResultInfo failure(String errormessge) {
        return new ResultInfo(Constant.RESULT_ERROR, errormessge);
    }


    /**
     * 保存数据到model里面
     * @param model
     * @param name
     * @param value
     */
    protected  void saveInModel(ModelMap model, String name, Object value) {
        model.addAttribute(name, value);
    }
	
}
