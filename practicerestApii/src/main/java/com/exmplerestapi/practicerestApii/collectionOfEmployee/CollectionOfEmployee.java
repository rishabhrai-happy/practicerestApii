package com.exmplerestapi.practicerestApii.collectionOfEmployee;

import com.exmplerestapi.practicerestApii.employeeEntity.EmployeeEntity;
import com.exmplerestapi.practicerestApii.dao.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CollectionOfEmployee {
    @Autowired
    private EmployeeRepo employeeRepo;


    public  List<EmployeeEntity> getList() {
        List<EmployeeEntity>list=(List<EmployeeEntity>) this.employeeRepo.findAll();
        return list;
    }
    //get employee data by id
    public EmployeeEntity getEmployeeById(int id){
        return this.employeeRepo.getById(id);

    }
    //post the employee data
    public void addEmployee(EmployeeEntity employee){
      employeeRepo.save(employee);


    }
    //Delete the employee data
    public void deleteData(int id){
      employeeRepo.deleteById(id);
    }
    //update the data
    public void updateData(EmployeeEntity emp,int id){
        employeeRepo.save(emp);
    }
}
