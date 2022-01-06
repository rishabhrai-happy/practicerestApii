package com.exmplerestapi.practicerestApii.dao;

import com.exmplerestapi.practicerestApii.employeeEntity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<EmployeeEntity,Integer> {
     public EmployeeEntity findById(int id);
}
