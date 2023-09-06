package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
//@Repository
//@Service
@Mapper
public interface UserMapper extends BaseMapper<student> {
    /*//查询所有用户
    @Select("select * from student")
    public List<student> find();

    @Insert("insert into student values (#{id},#{name},#{gender})")
    public int insert(student s);*/
}
