package com.itheima.pojo;

import lombok.Data;
@Data
public class ClazzQueryParam {
    private String name;        // 班级名称
    private String begin;       // 范围匹配的开始时间(结课时间)
    private String end;         // 范围匹配的结束时间(结课时间)
    private Integer page = 1;   // 分页查询的页码，默认为1
    private Integer pageSize = 10;  // 分页查询的每页记录数，默认为10
}
