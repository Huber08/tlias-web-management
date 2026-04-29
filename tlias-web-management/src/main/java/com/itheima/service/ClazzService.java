package com.itheima.service;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;

import java.util.List;

public interface ClazzService {

    /**
     * 分页查询班级列表
     */
    PageResult<Clazz> page(ClazzQueryParam param);

    void add(Clazz clazz);

    Clazz findById(Integer id);

    void update(Clazz clazz);

    void deleteById(Integer id);

    List<Clazz> list();
}
