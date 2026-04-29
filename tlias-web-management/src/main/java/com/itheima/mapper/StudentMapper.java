package com.itheima.mapper;

import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> list(StudentQueryParam param);

    void insert(Student student);

    Student findById(Integer id);

    void update(Student student);

    void delete(List<Integer> ids);

    void updateViolationScore(@Param("id") Integer id,  @Param("score")Integer score);
}
