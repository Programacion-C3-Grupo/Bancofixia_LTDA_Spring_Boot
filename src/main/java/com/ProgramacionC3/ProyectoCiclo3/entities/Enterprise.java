package com.ProgramacionC3.ProyectoCiclo3.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="Enterprise")
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enterprise_id;

    @Column(unique=true)
    private String nit;

    @Column(unique=true)
    private String name;

    private String phone;
    private String address;

    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "enterprise")
    private List<Employee> employeeList;

    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "enterprise")
    private List<Transaction> transactionList;

    private Date createdAt;
    private Date updatedAt;

    //Constructor
    public Enterprise(){

    }

    public Enterprise(String nit, String name, String phone, String address) {
        this.nit = nit;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.employeeList = new ArrayList<>();
        this.transactionList = new ArrayList<>();
    }

    //Getters and

    public Long getEnterprise_id() {
        return enterprise_id;
    }

    public void setEnterprise_id(Long enterprise_id) {
        this.enterprise_id = enterprise_id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void addEmployee(Employee newEmployee) {
        this.employeeList.add(newEmployee);
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void addTransaction(Transaction transaction) {
        this.transactionList.add(transaction);
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
