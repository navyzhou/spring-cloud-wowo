package com.yc.wowo.user.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.wowo.user.bean.MemberInfo;
import com.yc.wowo.user.mapper.IMemberInfoMapper;
import com.yc.wowo.user.service.IMemberInfoService;
import com.yc.wowo.user.util.StringUtil;

@Service
public class MemberInfoServiceImpl implements IMemberInfoService{
	@Autowired
	private IMemberInfoMapper memberInfoMapper;
	
	@Override
	public int reg(MemberInfo mf) {
		if (StringUtil.checkNull(mf.getNickName(), mf.getEmail(), mf.getPwd())) {
			return -1;
		}
		return memberInfoMapper.reg(mf);
	}

	@Override
	public MemberInfo login(Map<String, Object> map) {
		if (StringUtil.checkNull(String.valueOf(map.get("account")), String.valueOf(map.get("pwd")))) {
			return null;
		}
		return memberInfoMapper.login(map);
	}
}
