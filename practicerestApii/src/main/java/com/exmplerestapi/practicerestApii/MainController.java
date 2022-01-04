package com.exmplerestapi.practicerestApii;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    private CollectionOfEmployee collectionOfEmployee;
    //////////Using Get function
    @GetMapping("/employee")
    public List<EmployeeEntity> getEmployeeList(){
       return this.collectionOfEmployee.getList();
    }
    @GetMapping("/employee/{id}")
    public EmployeeEntity getBook(@PathVariable("id") int id){
        return collectionOfEmployee.getEmployeeById(id);
    }
    //using post function
    @PostMapping("/employee")
    public EmployeeEntity addEmployee(@RequestBody EmployeeEntity employee){
        this.collectionOfEmployee.addEmployee(employee);
        return employee;
    }
    @DeleteMapping("/employee/{id}")
    public void delete(@PathVariable("id") int id){
       this.collectionOfEmployee.deleteData(id);
    }
    @PutMapping("/employee/{id}")
    public EmployeeEntity UpadateData(@RequestBody EmployeeEntity emp,@PathVariable("id") int id){
        this.collectionOfEmployee. updateData(emp,id);
        return emp;
    }
}
