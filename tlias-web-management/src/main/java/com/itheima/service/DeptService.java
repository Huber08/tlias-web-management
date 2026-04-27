package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询所有部门信息
     */
    List<Dept> findAll();

    /**
     * 删除部门信息
     */
    void deleteById(Integer id);

    /**
     * 添加部门信息
     */
    void add(Dept dept);

    /**
     * 根据id查询部门信息
     */
    Dept findById(Integer id);

    /**
     * 修改部门信息
     */
    void update(Dept dept);
}
