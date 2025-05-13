package com.powerup.propertymicroservice.domain.ports.in;

import com.powerup.propertymicroservice.domain.model.DepartmentModel;
import java.util.List;

public interface DepartmentServicePort {
    
    DepartmentModel getDepartmentByName(String name);
    List<DepartmentModel> getAllDepartments(boolean orderAsc);
}
