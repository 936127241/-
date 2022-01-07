package com.zhou.mapper;

import com.zhou.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhoushize
 * @data 2021/12/21
 **/
@Repository
public interface DepartmentMapper {
    List<Department> getAllDepartment();
}
