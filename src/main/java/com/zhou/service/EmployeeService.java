package com.zhou.service;

import com.github.pagehelper.PageInfo;
import com.zhou.entity.Employee;
import com.zhou.entity.vo.EmployeeVo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zhoushize
 * @data 2021/12/21
 **/
public interface EmployeeService {
    PageInfo<Employee> getAllEmployee(Integer pageNum, Integer pageSize);

    void update(Employee employee);

    void insert(Employee employee);

    void delete(long id);

    Employee getEmployee(long id);

    int getEmployeeByEmpId(long empId);

    PageInfo<Employee> getEmployeeBySearch(Integer pageNum,Integer pageSize,EmployeeVo employeeVo);
}
