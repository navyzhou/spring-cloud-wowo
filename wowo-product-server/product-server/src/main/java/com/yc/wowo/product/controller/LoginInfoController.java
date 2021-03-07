package com.yc.wowo.product.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.wowo.product.enums.ResultEnum;
import com.yc.wowo.product.vo.ResultVO;
import com.yc.wowo.user.client.UserFeignClient;
import com.yc.wowo.user.dto.MemberLoginInfoDTO;

@RestController
@RequestMapping("/login")
public class LoginInfoController {
	@Autowired
	private UserFeignClient userFeignClient;
	
	@PostMapping("/check")
	public ResultVO checkLogin(HttpSession session) {
		// 可以直接从session中获取，因为session已经共享
		//Object obj = session.getAttribute(SessionKeyConstant.MEMBERINFOLOGIN);
		MemberLoginInfoDTO mf = userFeignClient.checklogin();
		
		if (mf == null) {
			return new ResultVO(ResultEnum.LOGIN_ERROR);
		}
		return new ResultVO(ResultEnum.SUCCESS, mf);
	}
}
