package org.example.service.impl;

import org.example.mapper.EmpMapper;
import org.example.pojo.Employee;
import org.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;


    @Override
    public List<Employee> queryAll() {
        return empMapper.selectAll();
    }
}
