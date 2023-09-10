package com.spring.mvcboard.reply.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvcboard.article.persistence.ArticleDAO;
import com.spring.mvcboard.commons.paging.Criteria;
import com.spring.mvcboard.reply.domain.ReplyVO;
import com.spring.mvcboard.reply.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	private final ReplyDAO replyDAO;
	private final ArticleDAO articleDAO;

    @Inject
    public ReplyServiceImpl(ReplyDAO replyDAO, ArticleDAO articleDAO) {
        this.replyDAO = replyDAO;
        this.articleDAO = articleDAO;
    }

    @Override
    public List<ReplyVO> getReplies(Integer articleNo) throws Exception {
        return replyDAO.list(articleNo);
    }

    @Transactional
    @Override
    public void addReply(ReplyVO replyVO) throws Exception {
        replyDAO.create(replyVO);
        articleDAO.updateReplyCnt(replyVO.getArticleNo(), 1); // 댓글 1씩 증가
    }

    @Override
    public void modifyReply(ReplyVO replyVO) throws Exception {
        replyDAO.update(replyVO);
    }

    @Transactional
    @Override
    public void removeReply(Integer replyNo) throws Exception {
    	int articleNo = replyDAO.getArticleNo(replyNo); // 댓글의 게시물 번호 조회
        replyDAO.delete(replyNo); // 댓글 삭제
        articleDAO.updateReplyCnt(articleNo, -1); // 댓글 1씩 감소
        
    }
    
    // Reply 페이징
    @Override
    public List<ReplyVO> getRepliesPaging(Integer articleNo, Criteria criteria) throws Exception {
        return replyDAO.listPaging(articleNo, criteria);
    }

    @Override
    public int countReplies(Integer articleNo) throws Exception {
        return replyDAO.countReplies(articleNo);
    }

}
