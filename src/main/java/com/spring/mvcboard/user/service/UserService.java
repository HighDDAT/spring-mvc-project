package com.spring.mvcboard.user.service;

import com.spring.mvcboard.user.domain.UserVO;

public interface UserService {
	
	// 회원 가입 처리
    void register(UserVO userVO) throws Exception;

}
