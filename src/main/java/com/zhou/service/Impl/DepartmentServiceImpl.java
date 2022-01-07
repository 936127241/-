package com.zhou.service.Impl;

import com.zhou.entity.Department;
import com.zhou.mapper.DepartmentMapper;
import com.zhou.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhoushize
 * @data 2021/12/21
 **/
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getAllDepartment() {
        return departmentMapper.getAllDepartment();
    }
}
