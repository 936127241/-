package com.zhou.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * @author zhoushize
 * @data 2021/12/21
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private long id;
    private String deptId;
    private String deptName;
    private List<Employee> employees;
}