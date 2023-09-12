package com.example.demo.Controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.QueryPageParam;
import com.example.demo.entity.student;
import com.example.demo.mapper.UserMapper;
import com.example.demo.common.Result;
import com.example.demo.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
//Cross这个注解可以使当前控制器允许跨域
//想要全部都能跨域 要么每个控制器都加注解 要么添加一个配置类
@CrossOrigin
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    //获取
    @GetMapping("/user/get")
    public List query()
    {
        List<student> list = userMapper.selectList(null);
        System.out.println(list);
        return list;
    }

    @GetMapping("findByNo")
    public Result findByNo(@RequestBody String id)
    {
        List list = userService.lambdaQuery().eq(student::getId,id).list();
        return list.size()>0?Result.suc(list):Result.fail();
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

    @PostMapping("/save2")
    public Result save2(@RequestBody student std)
    {
        return userService.save(std)?Result.suc():Result.fail();
    }

    //删除
    @GetMapping("/delete")
    public Integer delete(Integer id){ return userMapper.deleteById(id);}

    @PostMapping("/listPage")
    public List<student> listPage(@RequestBody QueryPageParam query)
    {
        System.out.println(query);
        System.out.println("num==="+query.getPageNum());
        System.out.println("size==="+query.getPageSize());

        HashMap param = query.getParam();
        String name = (String)param.get("name");

        Page<student> page = new Page();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        LambdaQueryWrapper<student> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.like(student::getName,name);

        return null;
    }

    @PostMapping("/findByPage")
    public Result findByPage(@RequestBody QueryPageParam query)
    {
        System.out.println(query);
        System.out.println("num==="+query.getPageNum());
        System.out.println("size==="+query.getPageSize());

        HashMap param = query.getParam();
        String name = (String)param.get("name");
        String gender =(String)param.get("gender");

        Page<student> page = new Page();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        LambdaQueryWrapper<student> lambdaQueryWrapper = new LambdaQueryWrapper();
        if(StringUtils.isNotBlank(name)){
            lambdaQueryWrapper.like(student::getName,name);
        }
        if(StringUtils.isNotBlank(gender)){
            lambdaQueryWrapper.eq(student::getGender,gender);
        }

        IPage result = userService.page(page,lambdaQueryWrapper);
        //IPage result = userService.pageC(page);
        //System.out.println("total==="+result.getTotal());
        page.setTotal(result.getTotal());
        System.out.println(result.getRecords());
        return Result.suc(result.getRecords(),result.getTotal());
    }
}
