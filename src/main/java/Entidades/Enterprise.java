package Entidades;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
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

    @OneToMany
    @JoinColumn(name = "employee_id")
    private List<Employee> employeeList;

    @OneToMany
    @JoinColumn(name = "transaction_id")
    private List<Transaction> transactionList;

    private Date createdAt;
    private Date updateAt;

    //Constructor
    public Enterprise(){

    }

    public Enterprise(String nit, String name, String phone, String address, List<Employee> employeeList, List<Transaction> transactionList) {
        this.nit = nit;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.employeeList = employeeList;
        this.transactionList = transactionList;
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

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}
