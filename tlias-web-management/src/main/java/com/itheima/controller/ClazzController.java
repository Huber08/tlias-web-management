package com.itheima.controller;
import com.itheima.pojo.*;
import com.itheima.service.ClazzService;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;
    @Autowired
    private EmpService empService;

    /**
     * 分页查询班级列表
     */
    @GetMapping
    public Result page(ClazzQueryParam param) {
        log.info("分页查询班级信息,参数:{}", param);
        PageResult<Clazz> pageResult = clazzService.page(param);
        return Result.success(pageResult);
    }
    /*新增班级*/
    @PostMapping
    public Result add(@RequestBody Clazz clazz) {
        log.info("新增班级信息,参数:{}", clazz);
        clazzService.add(clazz);
        return Result.success();
    }
    /**
     * 查询所有员工信息（用于下拉框）
     */
    @GetMapping("/list")
    public Result list(){
        log.info("查询所有员工信息");
        List<Emp> empList = empService.list();
        return Result.success(empList);
    }
    /*查询回显*/
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("查询回显班级id:{}", id);
        Clazz clazz = clazzService.findById(id);
        return Result.success(clazz);
    }
    /*修改班级*/
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("已修改班级信息:{}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }
    /**
     * 删除班级
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("已删除班级id:{}", id);
        clazzService.deleteById(id);
        return Result.success();
    }






}
