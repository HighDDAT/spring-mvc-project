package com.spring.mvcboard.reply.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.mvcboard.commons.paging.Criteria;
import com.spring.mvcboard.reply.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	private static String NAMESPACE = "com.spring.mvcboard.mappers.reply.ReplyMapper";

    private final SqlSession sqlSession;

    @Inject
    public ReplyDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<ReplyVO> list(Integer articleNo) throws Exception {
        return sqlSession.selectList(NAMESPACE + ".list", articleNo);
    }

    @Override
    public void create(ReplyVO replyVO) throws Exception {
        sqlSession.insert(NAMESPACE + ".create", replyVO);
    }

    @Override
    public void update(ReplyVO replyVO) throws Exception {
        sqlSession.update(NAMESPACE + ".update", replyVO);
    }

    @Override
    public void delete(Integer replyNo) throws Exception {
        sqlSession.delete(NAMESPACE + ".delete", replyNo);
    }

    // Reply 페이징 오버라이드
    @Override
    public List<ReplyVO> listPaging(Integer articleNo, Criteria criteria) throws Exception {

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("articleNo", articleNo);
        paramMap.put("criteria", criteria);

        return sqlSession.selectList(NAMESPACE + ".listPaging", paramMap);
    }

    @Override
    public int countReplies(Integer articleNo) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".countReplies", articleNo);
    }
    
    
}