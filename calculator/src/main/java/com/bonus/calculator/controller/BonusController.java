package com.bonus.calculator.controller;

import com.bonus.calculator.BaseResponse;
import com.bonus.calculator.Entities.Bonus;
import com.bonus.calculator.Entities.Employee;
import com.bonus.calculator.service.BonusCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tci/bonus")
public class BonusController {

    @Autowired
    BonusCalculatorService bonusCalculatorService;

    @PostMapping("/eligibility")
    public BaseResponse bonusEligibleEmployee(@RequestBody List<Bonus> bonus) throws Exception {
        Map<String, List<Employee>> employeeMap = new HashMap<>();
        BaseResponse baseResponse = new BaseResponse();
        try{
            employeeMap = bonusCalculatorService.calculate(bonus);
            if(employeeMap!=null && employeeMap.size()>0){
                baseResponse.setStatusCode(BaseResponse.SUCCESS);
                baseResponse.setData(employeeMap);
                baseResponse.setErrorMessage("");
            }
        }catch (Exception e){
            baseResponse.setStatusCode(BaseResponse.FAILED);
            baseResponse.setErrorMessage(e+"");
            e.printStackTrace();
        }
        return baseResponse;
    }

}
