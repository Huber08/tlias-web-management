package com.itheima.service;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;

import java.util.List;


public interface StudentService {
    PageResult<Student> page(StudentQueryParam param) ;


    void add(Student student);

    Student findById(Integer id);

    void update(Student student);

    void delete(List<Integer> ids);

    /**
     * 违纪处理
     */
    void violation(Integer id, Integer score);
}
