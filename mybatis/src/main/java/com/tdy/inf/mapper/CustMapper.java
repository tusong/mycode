package com.tdy.inf.mapper;

import com.tdy.inf.domain.Cust;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

@Mapper
public interface CustMapper {
    List<Map> selectById(int id);
    List<Map> selectList();
    List<Map> selectList(int id, RowBounds rowBounds,String name);

    int insertMany(List<Cust> custs);


}
