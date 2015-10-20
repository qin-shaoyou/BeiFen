package com.way.fragment;


import android.content.res.Resources;
import android.text.TextUtils;

import com.way.yahoo.App;
import com.way.yahoo.R;

/**
 * 应用的异常申明<br/>
 * 1、包含四种基本环境类型错误申明<br/>
 * 2、业务类型异常，如果没有设置msg字段，请初始化Declare获取msg信息
 *
 */
public class TaskException extends Exception {

	private static final long serialVersionUID = -6262214243381380676L;

	public enum TaskError {
		// 无网络链接
		noneNetwork, 
		// 连接超时
		timeout, 
		// 响应超时
		socketTimeout,
		// 返回数据不合法
		resultIllegal
	}
	
	private String code;

    private String msg;
	
	private static IExceptionDeclare exceptionDeclare;
	
	public TaskException(String code) {
		this.code = code;
	}

    public TaskException(String code, String msg) {
        this(code);
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

	@Override
	public String getMessage() {
        if (!TextUtils.isEmpty(msg))
            return msg;

		if (!TextUtils.isEmpty(code) && exceptionDeclare != null) {
			String msg = exceptionDeclare.declareMessage(code);
			if (!TextUtils.isEmpty(msg)) {
				return msg;
			}
		}

        try {
            Resources res = App.getApplication().getResources();

            TaskError error = TaskError.valueOf(code);
            if (error == TaskError.noneNetwork)
                msg = res.getString(R.string.comm_error_noneNetwork);
            else if (error == TaskError.socketTimeout || error == TaskError.timeout)
                msg = res.getString(R.string.comm_error_timeout);
            else if (error == TaskError.resultIllegal)
                msg = res.getString(R.string.comm_error_resultIllegal);
            if (!TextUtils.isEmpty(msg))
                return msg;
        } catch (Exception e) {
        }

		return super.getMessage() + "";
	}
	
	public static void config(IExceptionDeclare declare) {
		TaskException.exceptionDeclare = declare;
	}

}
