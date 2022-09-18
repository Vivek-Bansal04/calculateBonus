package com.bonus.calculator.serviceImpl;

import com.bonus.calculator.Entities.Bonus;
import com.bonus.calculator.Entities.Employee;
import com.bonus.calculator.service.EmployeeMapperService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeMapperService {

    @Override
    public Map<String, List<Employee>> eligibleEmployees(List<Bonus> bonusList) throws Exception{
        if(bonusList==null || bonusList.isEmpty()){
            throw new Exception("Not a valid list");
        }
        Map<String, List<Employee>> empList = null;
        try{
                    empList= bonusList.stream().filter(
                    bonus -> StringUtils.hasText(bonus.getEmpName()) && StringUtils.hasText(bonus.getCurrency()) && bonus.getAmount()>0)
                    .sorted(Comparator.comparing(Bonus::getEmpName))
                    .collect(Collectors.groupingBy(p->p.getCurrency(),Collectors.mapping(g->new Employee(g.getEmpName(), g.getAmount()),Collectors.toList())));
        }catch (Exception e){
            e.printStackTrace();
        }
        return empList;
    }
}
