package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.course;
import com.example.demo.entity.student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Repository
//@Service
@Mapper
public interface UserMapper2 extends BaseMapper<course> {
    /*//查询所有订单
    @Select("select * from course")
    public List<course> find();

    @Insert("insert into course values (#{cid},#{name},#{credit})")
    public int insert(course s);*/
}
