package com.yc.wowo.user.service;

import java.util.Map;

import com.yc.wowo.user.bean.MemberInfo;

public interface IMemberInfoService {
	public int reg(MemberInfo mf);
	
	public MemberInfo login(Map<String, Object> map);
}
