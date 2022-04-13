package com.tdy.interceptor;


import org.apache.ibatis.executor.SimpleExecutor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Abc {

    Configuration configuration;
    SqlSessionFactory sqlSessionFactory;
    JdbcTransaction jdbcTransaction;
    Connection connection;
    @Before
    public void init() throws IOException {
        String resource = "mybatis_config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = builder.build(resourceAsStream);
        configuration = sqlSessionFactory.getConfiguration();

        SqlSession sqlSession = sqlSessionFactory.openSession();
        connection = sqlSession.getConnection();
//        DriverManager.getConnection();
        jdbcTransaction = new JdbcTransaction(connection);

    }


    @Test
    public void simpleExecutor() throws SQLException {
        SimpleExecutor executor = new SimpleExecutor(configuration,jdbcTransaction);
        MappedStatement ms = configuration.getMappedStatement("com.tdy.inf.InfMapper.selInf");
        executor.doQuery(ms,null,new RowBounds(),null,ms.getBoundSql(null) );
        executor.doQuery(ms,null,new RowBounds(),null,ms.getBoundSql(null) );
    }



}
