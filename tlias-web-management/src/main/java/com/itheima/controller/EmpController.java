package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 员工管理
 */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(EmpQueryParam param)
    {
        log.info("分页查询员工信息,参数:{}", param);
        PageResult<Emp> pageResult = empService.page(param);
        return Result.success(pageResult);
    }

    /**
     * 添加员工
     */
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("请求参数emp: {}", emp);
        try {
            empService.save(emp);
            return Result.success();
        } catch (Exception e) {
            log.error("添加员工失败", e);
            return Result.error("添加员工失败：" + e.getMessage());
        }
    }

    /*批量删除员工*/
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("批量删除员工,ids:{}", ids);
        empService.delete(ids);
        return Result.success();
    }

    /*查询回显*/
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("查询回显员工id:{}", id);
        Emp emp = empService.findById(id);
        return Result.success(emp);
    }

    /*修改员工*/
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工信息:{}", emp);
        empService.update(emp);
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





}

