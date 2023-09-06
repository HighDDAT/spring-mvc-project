package com.spring.mvcboard.persistence;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mvcboard.commons.paging.Criteria;
import com.spring.mvcboard.reply.domain.ReplyVO;
import com.spring.mvcboard.reply.persistence.ReplyDAO;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml"})
public class ReplyDAOTests {
	
	@Inject
	private ReplyDAO replyDAO;
	
	@Test
    public void testReplyCreate() throws Exception {

        for (int i = 1; i <= 100; i++) {
            ReplyVO replyVO = new ReplyVO();
            replyVO.setArticleNo(999);
            replyVO.setReplyText(i+"번째 댓글입니다..");
            replyVO.setReplyWriter("user0"+(i%10));
            replyDAO.create(replyVO);
        }

    }

    @Test
    public void testReplyList() throws Exception {

        log.info(replyDAO.list(999).toString());

    }

    @Test
    public void testReplyUpdate() throws Exception {

        ReplyVO replyVO = new ReplyVO();
        replyVO.setArticleNo(2);
        replyVO.setReplyText(2+"번째 댓글 수정...");
        replyDAO.update(replyVO);

    }

    @Test
    public void testReplyDelete() throws Exception {

        replyDAO.delete(3);

    }
    
    @Test
    public void testReplyPaging() throws Exception {

        Criteria criteria = new Criteria();
        criteria.setPerPageNum(20);
        criteria.setPage(1);

        List<ReplyVO> replies = replyDAO.listPaging(999, criteria);

        for (ReplyVO reply : replies) {
        	log.info(reply.getReplyNo() + " : " + reply.getReplyText());
        }

    }

}
