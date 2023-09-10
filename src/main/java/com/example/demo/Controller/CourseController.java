package com.example.demo.Controller;

import com.example.demo.entity.course;
import com.example.demo.entity.student;
import com.example.demo.mapper.UserMapper;
import com.example.demo.mapper.UserMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//Cross这个注解可以使当前控制器允许跨域
//想要全部都能跨域 要么每个控制器都加注解 要么添加一个配置类
@CrossOrigin
public class CourseController {

    @Autowired
    private UserMapper2 userMapper2;

    //获取
    @GetMapping("/user/getC")
    public List query2()
    {
        List<course> list = userMapper2.selectList(null);
        System.out.println(list);
        return list;
    }

    //新增
    @PostMapping("/user/saveC")
    public String save(course s)
    {
        int i = userMapper2.insert(s);
        if(i>0)
        {
            return "插入成功";
        }
        else
        {
            return "插入失敗";
        }
    }

    //删除
    @GetMapping("/deleteC")
    public Integer delete(Integer cid){ return userMapper2.deleteById(cid);}
}
