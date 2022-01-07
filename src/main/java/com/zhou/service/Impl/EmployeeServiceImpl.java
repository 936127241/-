package com.zhou.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhou.entity.Employee;
import com.zhou.entity.vo.EmployeeVo;
import com.zhou.mapper.EmployeeMapper;
import com.zhou.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author zhoushize
 * @data 2021/12/21
 **/
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public PageInfo<Employee> getAllEmployee(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Employee> list = employeeMapper.getAllEmployee();
        PageInfo<Employee> pageInfo = new PageInfo<Employee>(list,10);
        return pageInfo;
    }

    public void update(Employee employee) {
        employeeMapper.update(employee);
    }

    public void insert(Employee employee) {
        employeeMapper.insert(employee);
    }

    public void delete(long id) {
        employeeMapper.delete(id);
    }

    public Employee getEmployee(long id) {
        return employeeMapper.getEmployee(id);
    }

    public int getEmployeeByEmpId(long empId) {
        return employeeMapper.getEmployeeByEmpId(empId);
    }

    public PageInfo<Employee> getEmployeeBySearch(Integer pageNum, Integer pageSize, EmployeeVo employeeVo) {
        PageHelper.startPage(pageNum,pageSize);
        List<Employee> list = employeeMapper.getEmployeeBySearch(employeeVo);
        PageInfo<Employee> pageInfo = new PageInfo<Employee>(list,10);
        return pageInfo;
    }
}
