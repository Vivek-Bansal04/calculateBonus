package com.bonus.calculator.service;

import com.bonus.calculator.Entities.Bonus;
import com.bonus.calculator.Entities.Employee;

import java.util.List;
import java.util.Map;

public interface BonusCalculatorService {
    Map<String,List<Employee>> calculate(List<Bonus> bonusList) throws Exception;
}
