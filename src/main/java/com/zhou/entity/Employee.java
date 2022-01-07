package com.zhou.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhoushize
 * @data 2021/12/21
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private long id;
    private long empId;
    private String empName;
    private String gender;
    private String email;
    private long deptId;
    private Department department;
}
