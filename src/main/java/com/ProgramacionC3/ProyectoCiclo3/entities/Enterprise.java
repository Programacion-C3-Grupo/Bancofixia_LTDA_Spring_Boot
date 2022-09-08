package com.ProgramacionC3.ProyectoCiclo3.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="Enterprise")
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String nit;

    @Column(unique=true)
    private String name;

    private String phone;
    private String address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enterprise")
    private List<Employee> employeeList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enterprise")
    private List<Transaction> transactionList;

    private Date createdAt;
    private Date updateAt;

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

    //Getters and Setters
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

    public Date getUpdateAt() {
        return updateAt;
    }
}
