package com.yc.wowo.user.enums;

/**
 * 返回结果的状态枚举
 * Company 源辰信息
 * @author navy
 * @date 2021年3月6日
 * Email haijunzhou@hnit.edu.cn
 */
public enum ResultEnum {
	ERROR(500, "失败"),
	SUCCESS(200, "成功"),
	DATA_NULL(301, "数据为空"),
	CODE_ERROR(501, "验证码错误"),
	CODE_TIMEOUT(502, "验证码过期"),
	LOGIN_ERROR(503, "账号或密码错误"),
	LOGIN_INFO(201, "已登录");
	
	private Integer code;
	private String msg;
	
	private ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
