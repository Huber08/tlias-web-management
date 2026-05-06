package com.itheima.service;

import com.itheima.pojo.ClazzChartData;
import com.itheima.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    /**
     * 统计各个职位的员工人数
     */
    JobOption getEmpJobData();

    /**
     * 统计男女员工人数
     */
    List<Map<String,Object>> getEmpGenderData();

    List<Map<String, Object>> getStudentDegreeData();

    ClazzChartData getClazzStudentData();
}

