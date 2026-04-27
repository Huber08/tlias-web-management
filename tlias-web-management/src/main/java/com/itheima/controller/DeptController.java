package com.itheima.controller;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 查询所有部门信息
     */
    @GetMapping
     public Result findAll(){
        log.info("查询所有部门信息");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }
    /**
     * 删除部门信息
     */
    @DeleteMapping
    public Result delete(Integer id){
        log.info("已删除部门id:{}", id);
        deptService.deleteById(id);
        return Result.success();
    }
    /**
     * 添加部门信息
     */
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("已添加部门:{}", dept);
        deptService.add(dept);
        return Result.success();
    }
    /**
     * 根据id查询部门信息
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("已查询部门id:{}", id);
        Dept dept = deptService.findById(id);
        return Result.success(dept);
    }
    /**
     * 修改部门信息
     */
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("已修改部门信息:{}", dept);
        deptService.update(dept);
        return Result.success();
    }
}
