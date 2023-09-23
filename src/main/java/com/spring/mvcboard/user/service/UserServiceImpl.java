package com.spring.mvcboard.user.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.mvcboard.user.domain.UserVO;
import com.spring.mvcboard.user.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	private final UserDAO userDAO;

    @Inject
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    // 회원 가입 처리
    @Override
    public void register(UserVO userVO) throws Exception {
        userDAO.register(userVO);
    }
}
