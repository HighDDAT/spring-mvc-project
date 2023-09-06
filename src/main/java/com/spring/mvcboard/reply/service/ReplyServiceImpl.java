package com.spring.mvcboard.reply.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.mvcboard.reply.domain.ReplyVO;
import com.spring.mvcboard.reply.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	private final ReplyDAO replyDAO;

    @Inject
    public ReplyServiceImpl(ReplyDAO replyDAO) {
        this.replyDAO = replyDAO;
    }

    @Override
    public List<ReplyVO> getReplies(Integer articleNo) throws Exception {
        return replyDAO.list(articleNo);
    }

    @Override
    public void addReply(ReplyVO replyVO) throws Exception {
        replyDAO.create(replyVO);
    }

    @Override
    public void modifyReply(ReplyVO replyVO) throws Exception {
        replyDAO.update(replyVO);
    }

    @Override
    public void removeReply(Integer replyNo) throws Exception {
        replyDAO.delete(replyNo);
    }

}
