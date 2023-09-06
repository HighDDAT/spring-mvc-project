package com.spring.mvcboard.reply.service;

import java.util.List;

import com.spring.mvcboard.reply.domain.ReplyVO;

public interface ReplyService {
	
	 List<ReplyVO> getReplies(Integer articleNo) throws Exception;

	 void addReply(ReplyVO replyVO) throws Exception;

	 void modifyReply(ReplyVO replyVO) throws Exception;

	 void removeReply(Integer replyNo) throws Exception;

}
