package com.exmplerestapi.practicerestApii.employeeEntity;



import javax.persistence.*;

@Entity
@Table(name="employeedata")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;
    private String employeeName;
    private String degignation;

    public EmployeeEntity(int employeeId, String employeeName, String degignation) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.degignation = degignation;
    }
    public EmployeeEntity(){

    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDegignation() {
        return degignation;
    }

    public void setDegignation(String degignation) {
        this.degignation = degignation;
    }
}
