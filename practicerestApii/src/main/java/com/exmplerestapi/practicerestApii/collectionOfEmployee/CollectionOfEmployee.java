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
        EmployeeEntity employee=null;
        try {
            employee = this.employeeRepo.findById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return employee;
    }
    //post the employee data
    public EmployeeEntity addEmployee(EmployeeEntity employee){
      return employeeRepo.save(employee);


    }
    //Delete the employee data
    public void deleteData(int id){
      employeeRepo.deleteById(id);
    }
    //update the data
    public EmployeeEntity updateData(EmployeeEntity emp,int id){

        return employeeRepo.save(emp);
    }
}
