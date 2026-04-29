package com.itheima.mapper;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface ClazzMapper {

    /**
     * 分页查询班级列表
     */
    List<Clazz> list(ClazzQueryParam param);
    /**
     * 新增班级信息
     */

    void insert(Clazz clazz);

    Clazz findById(Integer id);

    void updateById(Clazz clazz);

    void deleteById(Integer id);

    List<Clazz> listAll();
}
