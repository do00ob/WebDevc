package com.example.demo.Controller;

import com.example.demo.entity.student;
import com.example.demo.mapper.UserMapper;
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
public class UserController {

    @Autowired
    private UserMapper userMapper;

    //获取
    @GetMapping("/user/get")
    public List query()
    {
        List<student> list = userMapper.selectList(null);
        System.out.println(list);
        return list;
    }

    //新增
    @PostMapping("/user/save")
    public String save(student s)
    {
        int i = userMapper.insert(s);
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
    @GetMapping("/delete")
    public Integer delete(Integer id){ return userMapper.deleteById(id);}
}
