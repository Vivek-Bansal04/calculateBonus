package com.bonus.calculator.service;

import com.bonus.calculator.Entities.Bonus;
import com.bonus.calculator.Entities.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapperService {
    public Map<String,List<Employee>> eligibleEmployees (List<Bonus> bonusList) throws Exception;
}
