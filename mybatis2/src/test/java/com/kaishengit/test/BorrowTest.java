package com.kaishengit.test;

import com.kaishengit.mapper.BorrowMapper;
import com.kaishengit.pojo.Admin;
import com.kaishengit.pojo.Borrow;
import com.kaishengit.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BorrowTest {
    private Logger logger = LoggerFactory.getLogger(BorrowTest.class);

    @Test
    public void testFindById(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BorrowMapper borrowMapper = sqlSession.getMapper(BorrowMapper.class);
        Borrow borrow =  borrowMapper.findById(4);
        logger.debug("admin{}:",borrow);
        logger.debug("cardcode:{},name:{},bookcode:{},booktitle:{}",borrow.getCard().getCode(),
                borrow.getCard().getName(),borrow.getBook().getCode(),borrow.getBook().getTitle());
        sqlSession.close();

        SqlSession sqlSession2 = MyBatisUtil.getSqlSession();
        BorrowMapper borrowMapper2 = sqlSession2.getMapper(BorrowMapper.class);
        Borrow borrow2 =  borrowMapper2.findById(4);
        logger.debug("admin{}:",borrow);
        logger.debug("cardcode:{},name:{},bookcode:{},booktitle:{}",borrow.getCard().getCode(),
                borrow.getCard().getName(),borrow.getBook().getCode(),borrow.getBook().getTitle());
        sqlSession.close();
    }
}
