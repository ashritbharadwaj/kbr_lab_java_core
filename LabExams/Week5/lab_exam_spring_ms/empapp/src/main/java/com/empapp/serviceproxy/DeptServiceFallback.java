package com.empapp.serviceproxy;

import com.empapp.dto.Department;
import org.springframework.stereotype.Component;

@Component
public class DeptServiceFallback implements DeptServiceProxy {

    @Override
    public Department getByName(String name) {
        return new Department(1, "IT", "BTM");
    }
}
