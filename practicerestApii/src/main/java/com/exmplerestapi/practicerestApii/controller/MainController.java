package com.exmplerestapi.practicerestApii.controller;

import com.exmplerestapi.practicerestApii.collectionOfEmployee.CollectionOfEmployee;
import com.exmplerestapi.practicerestApii.employeeEntity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {
    @Autowired
    private CollectionOfEmployee collectionOfEmployee;
    //////////Using Get function
    @GetMapping("/employee")
    public ResponseEntity <List<EmployeeEntity> >getEmployeeList(){

        List<EmployeeEntity> list=this.collectionOfEmployee.getList();
        if(list.size()<0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }
    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeEntity> getBook(@PathVariable("id") int id){

            EmployeeEntity employee = this.collectionOfEmployee.getEmployeeById(id);
            if(employee==null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }


        return ResponseEntity.of(Optional.of(employee));

    }
    //using post function
    @PostMapping("/employee")
    public ResponseEntity<EmployeeEntity> addEmployee(@RequestBody EmployeeEntity employee){
        EmployeeEntity employee1=null;
        try {
            employee1=collectionOfEmployee.addEmployee(employee);
            return ResponseEntity.of(Optional.of(employee1));
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

    }
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?>delete(@PathVariable("id") int id) {
        try {

            this.collectionOfEmployee.deleteData(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping("/employee/{id}")
    public ResponseEntity<EmployeeEntity> UpadateData(@RequestBody EmployeeEntity emp,@PathVariable("id") int id){
        try {
            EmployeeEntity employee=this.collectionOfEmployee. updateData(emp,id);
            return ResponseEntity.of(Optional.of(emp));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }
}
