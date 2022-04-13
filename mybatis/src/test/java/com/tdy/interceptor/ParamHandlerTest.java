package com.tdy.interceptor;

import com.tdy.inf.InfMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;

public class ParamHandlerTest {

    private SqlSession sqlSession;
    private InfMapper mapper;

    @Before
    public void init() throws IOException {
        String resource = "mybatis_config.xml";
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = builder.build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(InfMapper.class);

    }

    @After
    public void over(){
        sqlSession.close();
    }
}
