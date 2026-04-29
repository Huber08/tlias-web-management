package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public PageResult<Student> page(StudentQueryParam param) {
        /*设置分页参数*/
        try (Page<Object> ignored = PageHelper.startPage(param.getPage(), param.getPageSize())) {
            List<Student> studentList = studentMapper.list(param);

            Page<Student> p = (Page<Student>) studentList;
            return new PageResult<>(p.getTotal(), studentList);
        }
    }

    @Override
    public void add(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insert(student);

    }

    @Override
    public Student findById(Integer id) {
        return studentMapper.findById(id);


    }

    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);

    }

    @Override
    public void delete(List<Integer> ids) {
        studentMapper.delete(ids);

    }

    @Override
    public void violation(Integer id, Integer score) {
        studentMapper.updateViolationScore(id, score);
    }
}
