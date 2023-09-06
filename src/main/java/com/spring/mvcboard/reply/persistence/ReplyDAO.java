package com.spring.mvcboard.reply.persistence;

import java.util.List;

import com.spring.mvcboard.reply.domain.ReplyVO;

public interface ReplyDAO {

	// Reply 관련 메서드
	List<ReplyVO> list(Integer articleNo) throws Exception;

    void create(ReplyVO replyVO) throws Exception;

    void update(ReplyVO replyVO) throws Exception;

    void delete(Integer replyNo) throws Exception;
	
}
