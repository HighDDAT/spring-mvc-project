package com.spring.mvcboard.persistence;

import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mvcboard.article.domain.ArticleVO;
import com.spring.mvcboard.article.persistence.ArticleDAO;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml"})
public class ArticleDAOTests {
	
	@Inject
	private ArticleDAO articleDAO;
	
	@Test
    public void testCreate() throws Exception {
        ArticleVO article = new ArticleVO();
        article.setTitle("새 글 작성 테스트 제목");
        article.setContent("새 글 작성 테스트 내용");
        article.setWriter("새 글 작성 테스트 작성자");
        articleDAO.create(article);
    }

    @Test
    public void testRead() throws Exception {
        log.info(articleDAO.read(1).toString());
    }

    @Test
    public void testUpdate() throws Exception {
    	ArticleVO article = new ArticleVO();
        article.setArticleNo(1);
        article.setTitle("글 수정 테스트 제목");
        article.setContent("글 수정 테스트 내용");
        articleDAO.update(article);
    }

    @Test
    public void testDelete() throws Exception {
        articleDAO.delete(1);
    }

}
