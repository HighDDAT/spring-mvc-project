package com.spring.mvcboard.article.persistence;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.spring.mvcboard.article.domain.ArticleVO;
import com.spring.mvcboard.commons.paging.Criteria;

@Repository
public class ArticleDAOlmpl implements ArticleDAO {
	
	private static final String NAMESPACE = "com.spring.mvcboard.mappers.article.ArticleMapper";

    private final SqlSession sqlSession;
    
    @Inject
	public ArticleDAOlmpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void create(ArticleVO articleVO) throws Exception {
		sqlSession.insert(NAMESPACE + ".create", articleVO);
	}

	@Override
	public ArticleVO read(Integer articleNo) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".read", articleNo);
	}

	@Override
	public void update(ArticleVO articleVO) throws Exception {
		sqlSession.update(NAMESPACE + ".update", articleVO);
	}

	@Override
	public void delete(Integer articleNo) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", articleNo);
	}

	@Override
	public List<ArticleVO> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}

	// 페이징 관련
	@Override
	public List<ArticleVO> listPaging(int page) throws Exception {
		if (page <= 0) {
	        page = 1;
	    }

	    page = (page - 1) * 10;

	    return sqlSession.selectList(NAMESPACE + ".listPaging", page);
	}

	@Override
	public List<ArticleVO> listCriteria(Criteria criteria) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listCriteria", criteria);
	}
	
	@Override
	public int countArticles(Criteria criteria) throws Exception {
	    return sqlSession.selectOne(NAMESPACE + ".countArticles", criteria);
	}

}
