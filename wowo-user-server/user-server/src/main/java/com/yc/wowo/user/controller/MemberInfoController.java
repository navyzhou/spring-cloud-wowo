package com.yc.wowo.user.controller;

import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yc.wowo.user.bean.MemberInfo;
import com.yc.wowo.user.dto.MemberLoginInfoDTO;
import com.yc.wowo.user.dto.SessionKeyConstant;
import com.yc.wowo.user.enums.ResultEnum;
import com.yc.wowo.user.service.IMemberInfoService;
import com.yc.wowo.user.util.SendMailUtil;
import com.yc.wowo.user.vo.ResultVO;

/**
 * 商品类型控制
 * company 源辰信息
 * @author navy
 * @date 2020年10月26日
 * Email haijunzhou@hnit.edu.cn
 */
@RestController
@RequestMapping("/member")
public class MemberInfoController {
	@Autowired
	private SendMailUtil sendEmialUtil;

	@Autowired
	private IMemberInfoService memberInfoServiceImpl;


	@RequestMapping("/check")
	public ResultVO check(HttpSession session) throws IOException {
		Object obj = session.getAttribute(SessionKeyConstant.MEMBERINFOLOGIN);
		if (obj == null) {
			return new ResultVO(ResultEnum.ERROR);
		}
		return new ResultVO(ResultEnum.SUCCESS, obj);
	}

	@RequestMapping("/send")
	public ResultVO sendCode(@RequestParam("email") String receiveMail, String nickName, HttpSession session) {
		String code = "";
		Random rd = new Random();
		while (code.length() < 6) {
			code += rd.nextInt(10);
		}

		if (sendEmialUtil.sendEmail(receiveMail, code, nickName)) {
			session.setAttribute(SessionKeyConstant.EMAILCODE, code); // 存到session

			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					session.removeAttribute(SessionKeyConstant.EMAILCODE);
				}
			};

			Timer timer = new Timer();
			timer.schedule(task, 180000); // 3分钟后执行任务一次
			return new ResultVO(ResultEnum.SUCCESS);
		}
		return new ResultVO(ResultEnum.ERROR);
	}

	@RequestMapping("/login")
	public ResultVO login(@RequestParam Map<String, Object> map, HttpSession session) {
		MemberInfo mf = memberInfoServiceImpl.login(map);
		if (mf != null) {
			MemberLoginInfoDTO memberInfoLoginDTO = new MemberLoginInfoDTO();
			// 属性拷贝，将相同的属性名的值拷贝到对应的属性中
			BeanUtils.copyProperties(mf, memberInfoLoginDTO);

			session.setAttribute(SessionKeyConstant.MEMBERINFOLOGIN, memberInfoLoginDTO);
			return new ResultVO(ResultEnum.SUCCESS);
		}
		return new ResultVO(ResultEnum.LOGIN_ERROR);
	}

	@RequestMapping("/reg")
	public ResultVO reg(MemberInfo mf, HttpSession session, String vcode, String code) {
		String scode = String.valueOf(session.getAttribute(SessionKeyConstant.VERIFICATIONCODE));
		String svcode = String.valueOf(session.getAttribute(SessionKeyConstant.EMAILCODE));

		if (!scode.equalsIgnoreCase(code)) {
			return new ResultVO(ResultEnum.CODE_ERROR);
		}

		if (!svcode.equalsIgnoreCase(vcode)) {
			return new ResultVO(ResultEnum.CODE_ERROR);
		}

		if (memberInfoServiceImpl.reg(mf) > 0) {
			return new ResultVO(ResultEnum.SUCCESS);
		}
		return new ResultVO(ResultEnum.ERROR);
	}
}
