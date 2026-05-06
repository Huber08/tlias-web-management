package com.itheima.controller;

import com.itheima.pojo.ClazzChartData;
import com.itheima.pojo.JobOption;
import com.itheima.pojo.Result;
import com.itheima.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 统计各个职位的员工人数
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("统计各个职位的员工人数");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    /**
     * 统计男女员工人数
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计男女员工人数");
        List<Map<String,Object>> genderDataList = reportService.getEmpGenderData();
        return Result.success(genderDataList);
    }

    /*学员学历统计*/
    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData(){
        log.info("统计学员学历数据");
        List<Map<String,Object>> degreeDataList = reportService.getStudentDegreeData();
        return Result.success(degreeDataList);
    }

    /**
     * 统计各班级人数
     */
    @GetMapping("/studentCountData")
    public Result getStudentCountData(){
        log.info("统计各班级人数");
        ClazzChartData chartData = reportService.getClazzStudentData();
        return Result.success(chartData);
    }




}
