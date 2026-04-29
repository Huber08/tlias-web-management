package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.ClazzMapper;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public PageResult<Clazz> page(ClazzQueryParam param) {
        // 1. 设置分页参数
        PageHelper.startPage(param.getPage(), param.getPageSize());

        // 2. 执行查询
        List<Clazz> clazzList = clazzMapper.list(param);

        // 3. 计算班级状态
        LocalDate now = LocalDate.now();
        clazzList.forEach(clazz -> {
            if (clazz.getEndDate() != null && now.isAfter(clazz.getEndDate())) {
                clazz.setStatus("已结课");
            } else if (clazz.getBeginDate() != null && now.isBefore(clazz.getBeginDate())) {
                clazz.setStatus("未开班");
            } else {
                clazz.setStatus("在读中");
            }
        });

        // 4. 封装分页结果
        Page<Clazz> p = (Page<Clazz>) clazzList;
        return new PageResult<>(p.getTotal(), clazzList);
    }

    @Override
    public void add(Clazz clazz) {
        // 1. 补全创建时间和更新时间
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());

        // 2. 保存班级信息
        clazzMapper.insert(clazz);
    }

    @Override
    public Clazz findById(Integer id) {
        return clazzMapper.findById(id);

    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.updateById(clazz);



    }

    @Override
    public void deleteById(Integer id) {
        clazzMapper.deleteById(id);


    }

    @Override
    public List<Clazz> list() {
        return clazzMapper.listAll();

    }
}
