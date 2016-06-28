package com.kaishengit.test;

import com.kaishengit.mapper.BorrowMapper;
import com.kaishengit.pojo.Borrow;
import com.kaishengit.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BorrowMapperTestCase {
    private Logger logger = LoggerFactory.getLogger(BorrowMapperTestCase.class);
    @Test
    public void testFindById(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BorrowMapper borrowMapper = sqlSession.getMapper(BorrowMapper.class);
        Borrow borrow = borrowMapper.findById(4);
        logger.debug("{}",borrow);
        logger.debug("cardcode:{},name:{},bookcode:{},booktitle:{}",borrow.getCard().getCode(),
                borrow.getCard().getName(),borrow.getBook().getCode(),borrow.getBook().getTitle());

    }
}
