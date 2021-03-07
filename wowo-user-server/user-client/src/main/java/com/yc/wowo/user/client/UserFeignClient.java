package com.yc.wowo.user.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yc.wowo.user.dto.MemberLoginInfoDTO;

/**
 * 用户服务的声明式调用接口
 * Company 源辰信息
 * @author navy
 * @date 2021年3月7日
 * Email haijunzhou@hnit.edu.cn
 */
@FeignClient(name="wowo-user-server", fallback = UserFeignClient.UserFeignClientFallback.class)
public interface UserFeignClient {
	@PostMapping("/member/loginout") // 访问@FeignClient指定的服务器中的哪个方法
	public int loginout(@RequestParam String openid);
	
	@PostMapping("/member/checkLogin")
	public MemberLoginInfoDTO checklogin();
	
	@Component
	public static class UserFeignClientFallback implements UserFeignClient {

		@Override
		public int loginout(String openid) {
			return -1;
		}

		@Override
		public MemberLoginInfoDTO checklogin() {
			return null;
		}
	}
}
