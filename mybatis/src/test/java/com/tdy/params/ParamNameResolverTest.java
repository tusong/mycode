package com.tdy.params;

import com.tdy.inf.mapper.CustMapper;
import org.apache.ibatis.reflection.ParamNameResolver;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ParamNameResolverTest {

    /**
     * 测试方法参数名称解析器
     */
    @Test
    public void test01() throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        Configuration configuration = new Configuration();

        Method selectList = CustMapper.class.getMethod("selectList", int.class, RowBounds.class,String.class);
        ParamNameResolver paramNameResolver = new ParamNameResolver(configuration,selectList);
        Field field = paramNameResolver.getClass().getDeclaredField("names");
        field.setAccessible(true);
        Object names = field.get(paramNameResolver);

        System.out.println("names:"+names);

    }

}
