package com.yc.wowo.user.mapper;

import java.util.Map;

import com.yc.wowo.user.bean.MemberInfo;

public interface IMemberInfoMapper {
	public int reg(MemberInfo mf);
	public MemberInfo login(Map<String, Object> map);
}
