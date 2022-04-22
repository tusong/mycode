package com.tdy;

import com.tdy.inf.domain.Cust;
import com.tdy.inf.mapper.CustMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class InsertManyTest {
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
    public void testInsertMany() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<Cust> authors = new ArrayList<>();
            Cust cust = new Cust();
            cust.setName("张三");
            authors.add(cust);
            authors.add(cust);
            System.out.println("\nBefore Insert: ");
            authors.forEach(author -> System.out.println(" " + author));
            CustMapper authorDao = session.getMapper(CustMapper.class);
            authorDao.insertMany(authors);
            session.commit();
            System.out.println("\nAfter Insert: ");
            authors.forEach(author -> System.out.println(" " + author));
        } finally {
            session.close();
        }
    }
}
