package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
public class manager {
    //指定主键自增
    @TableId(type = IdType.AUTO)
    private Long id;

    private String userName;

    private String password;
}
