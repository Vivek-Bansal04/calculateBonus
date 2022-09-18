package com.bonus.calculator.serviceImpl;

import com.bonus.calculator.Entities.Bonus;
import com.bonus.calculator.Entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import com.bonus.calculator.service.BonusCalculatorService;
import com.bonus.calculator.service.EmployeeMapperService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BonusCalculatorServiceImpl implements BonusCalculatorService {

    @Autowired
    EmployeeMapperService employeeMapperService;

    @Override
    public Map<String, List<Employee>> calculate(List<Bonus> bonusList) throws Exception{
        if(bonusList==null || bonusList.isEmpty()){
            throw new Exception("Please send a valid list");
        }
        Map<String,List<Employee>> empList= null;
        try{
            List<Bonus> bList = bonusList.stream()
                    .filter(bonus-> {
                        try {
                            return bonus.validBonus();
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        return false;
                    })
                    .collect(Collectors.toList());
             empList = employeeMapperService.eligibleEmployees(bList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return empList;
    }
}
