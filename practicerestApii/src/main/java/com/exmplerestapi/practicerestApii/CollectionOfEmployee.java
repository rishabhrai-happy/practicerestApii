package com.exmplerestapi.practicerestApii;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CollectionOfEmployee {
    private static List<EmployeeEntity> list=new ArrayList<>();
    static {
        list.add(new EmployeeEntity(121,"Rishabh Rai","BackendDeveloper"));
        list.add(new EmployeeEntity(122,"Happy Rai","BackendDeveloper"));
        list.add(new EmployeeEntity(123,"Anupriya Singh","frontendDeveloper"));
    }
    //getemployee

    public static List<EmployeeEntity> getList() {
        return list;
    }
    public EmployeeEntity getEmployeeById(int id){
       EmployeeEntity emplo= list.stream().filter(e->e.getEmployeeId()==id).findFirst().get();
       return emplo;
    }
    public void addEmployee(EmployeeEntity employee){
       list.add(employee);

    }
    //Delete the employee data
    public void deleteData(int id){
       list=list.stream().filter(e->{
           if(e.getEmployeeId()!=id){
               return true;
           }else{
               return false;
           }
       }).collect(Collectors.toList());
    }
}
