package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.Employee;

import java.util.List;


public interface EmpMapper {

    List<Employee> selectAll();
}
