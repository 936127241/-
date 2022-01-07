package com.zhou.mapper;

import com.zhou.entity.Employee;
import com.zhou.entity.vo.EmployeeVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhoushize
 * @data 2021/12/21
 **/
@Repository
public interface EmployeeMapper {

    List<Employee> getAllEmployee();

    void update(Employee employee);

    void insert(Employee employee);

    void delete(long id);

    Employee getEmployee(long id);

    //根据编号获得员工人数
    int getEmployeeByEmpId(long empId);

    //条件查询员工
    List<Employee> getEmployeeBySearch(EmployeeVo employeeVo);
}
