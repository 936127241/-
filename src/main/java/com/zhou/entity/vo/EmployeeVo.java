package com.zhou.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhoushize
 * @data 2021/12/24
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeVo {
    private String empName;
    private Integer deptId;
}
