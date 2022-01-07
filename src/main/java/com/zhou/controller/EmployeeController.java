package com.zhou.controller;

import com.github.pagehelper.PageInfo;
import com.zhou.entity.Department;
import com.zhou.entity.Employee;
import com.zhou.entity.vo.EmployeeVo;
import com.zhou.service.DepartmentService;
import com.zhou.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhoushize
 * @data 2021/12/21
 **/
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    /**
     * 前往员工列表页面
     *
     * @return
     */
    @GetMapping("/list")
    public String toList() {
        return "employee-list";
    }

    /**
     * 前往添加员工页面
     *
     * @return
     */
    @GetMapping("/toAddEmployee")
    public String toAdd() {
        return "employee-add";
    }

    /**
     * 前往员工更新页面
     *
     * @return
     */
    @GetMapping("/toUpdateEmployee/{empId}")
    public String toUpdate() {
        return "employee-update";
    }

    /**
     * 通过id获得一个员工信息，同时查询所有部门
     *
     * @param id
     * @return
     */
    @GetMapping("/employee/{id}")
    @ResponseBody
    public Map<String, Object> getEmployee(@PathVariable long id) {
        Employee employee = employeeService.getEmployee(id);
        List<Department> departments = departmentService.getAllDepartment();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("employee", employee);
        map.put("departments", departments);
        return map;
    }

    /**
     * 分页查询员工信息
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/employee/{pageNum}/{pageSize}")
    @ResponseBody
    public PageInfo<Employee> getAllEmployee(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        return employeeService.getAllEmployee(pageNum, pageSize);
    }

    /**
     * 分页条件查询员工信息
     *
     * @param pageNum
     * @param pageSize
     * @param employeeVo
     * @return
     */
    @PostMapping("/employee/{pageNum}/{pageSize}")
    @ResponseBody
    public PageInfo<Employee> getEmployeeBySearch(@PathVariable Integer pageNum, @PathVariable Integer pageSize,
                                                  EmployeeVo employeeVo) {
        if (employeeVo.getDeptId() == 0) {
            employeeVo.setDeptId(null);
        }
        return employeeService.getEmployeeBySearch(pageNum, pageSize, employeeVo);
    }

    /**
     * 添加员工信息
     *
     * @param employee
     * @return
     */
    @PostMapping("/employee")
    public String insert(Employee employee) {
        employeeService.insert(employee);
        return "redirect:/list";
    }

    /**
     * 更新员工信息
     *
     * @param employee
     * @return
     */
    @PutMapping("/employee")
    public String update(Employee employee) {
        employeeService.update(employee);
        return "redirect:/list";
    }

    /**
     * 逻辑删除一条员工信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/employee/{id}")
    public String delete(@PathVariable long id) {
        employeeService.delete(id);
        return "redirect:/list";
    }

    /**
     * 批量删除员工信息
     *
     * @param ids
     * @return
     */
    @DeleteMapping("/employeeBatch/{ids}")
    public String batchDelete(@PathVariable String ids) {
        String[] strings = ids.split(",");
        for (String s : strings) {
            if (!"".equals(s)) {
                Long id = Long.valueOf(s);
                employeeService.delete(id);
            }
        }
        return "redirect:/list";
    }

    /**
     * 判断该员工号是否存在
     *
     * @param empId
     * @return
     */
    @GetMapping("/isExit/{empId}/{type}")
    @ResponseBody
    public String isExist(@PathVariable long empId, @PathVariable String type) {
        int num = employeeService.getEmployeeByEmpId(empId);
        //新增时查看该编号人数是否等于0
        if ("insert".equals(type)) {
            if (num == 0) {
                return "ok";
            } else {
                return "no";
            }
        } else {
            //修改时判断是不是原来的员工编号，不是再判断编号人数是否等于0
            Long tempId = Long.valueOf(type);
            if (tempId == empId) {
                return "ok";
            }
            if (num == 0) {
                return "ok";
            } else {
                return "no";
            }
        }
    }
}
