package com.zhou.controller;

import com.zhou.entity.Department;
import com.zhou.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * @author zhoushize
 * @data 2021/12/21
 **/
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/department")
    @ResponseBody
    public List<Department> getAllDepartment() {
        List<Department> list = departmentService.getAllDepartment();
        return list;
    }
}
