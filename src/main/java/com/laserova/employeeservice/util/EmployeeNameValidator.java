package com.laserova.employeeservice.util;

import com.laserova.employeeservice.exceptions.EmployeeIllegalNameException;
import org.apache.commons.lang3.StringUtils;

public class EmployeeNameValidator {
    public static void checkEmployeeName(String...names){
        for (String name:names) {
            if(!StringUtils.isAlpha(name)){
                throw new EmployeeIllegalNameException();
            }
        }
    }
}
