package com.spring.mvcboard.user.persistence;

import com.spring.mvcboard.user.domain.UserVO;

public interface UserDAO {

	// 회원가입 처리
    void register(UserVO userVO) throws Exception;
}
