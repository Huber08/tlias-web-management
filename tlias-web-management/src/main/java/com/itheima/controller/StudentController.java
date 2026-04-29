package com.itheima.controller;

import com.itheima.pojo.*;
import com.itheima.service.ClazzService;
import com.itheima.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ClazzService clazzService;

    /*分页查询学生列表*/

    @GetMapping
    public Result page(StudentQueryParam param) {
        log.info("分页查询学生信息,参数:{}", param);
        PageResult<Student> pageResult = studentService.page(param);
        return Result.success(pageResult);
    }

    /*查询所有班级信息（用于下拉框）*/
    @GetMapping("/list")
    public Result list(){
        log.info("查询所有班级信息");
        List<Clazz> clazzList = clazzService.list();
        return Result.success(clazzList);
    }

    /*添加学员*/
    @PostMapping
    public Result add(@RequestBody Student student) {
        log.info("已添加学员:{}", student);
        studentService.add(student);
        return Result.success();
    }

    /*查询回显*/
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("查询回显学员id:{}", id);
        Student student = studentService.findById(id);
        return Result.success(student);
    }

    /*修改学员*/
    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("已修改学员信息:{}", student);
        studentService.update(student);
        return Result.success();
    }

    /**
     * 批量删除学员
     */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除学员,ids:{}", ids);
        studentService.delete(ids);
        return Result.success();
    }
    /**
     * 违纪处理
     */
    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id, @PathVariable Integer score){
        log.info("违纪处理,学员id:{}, 扣分:{}", id, score);
        studentService.violation(id, score);
        return Result.success();
    }


}
