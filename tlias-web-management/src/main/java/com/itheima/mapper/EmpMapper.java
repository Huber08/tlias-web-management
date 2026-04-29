package com.itheima.mapper;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {
    List<Emp> list (EmpQueryParam param);

    /**
     * 新增员工数据
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);


    void deleteByids(List<Integer> ids);

    Emp findById(Integer id);

    void updateById(Emp emp);

    /**
     * 统计各个职位的员工人数
     */
    List<Map<String,Object>> countEmpJobData();

    /**
     * 统计男女员工人数
     */
    List<Map<String,Object>> countEmpGenderData();

    /**
     * 查询所有员工信息（不带分页）
     */
    List<Emp> listAll();
}
