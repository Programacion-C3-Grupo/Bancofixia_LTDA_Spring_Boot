package com.ProgramacionC3.ProyectoCiclo3.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;

    @Column(unique=true)
    private Long documentId;

    private String name;

    @Column(unique=true)
    private String email;

    private String image;
    private String phone;
    private boolean admin;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;

    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<Transaction> transactionList;

    private Date updateAt;
    private Date createAt;

    //Constructor
    public Employee () {

    }

    public Employee(Long documentId, String name, String email, String image, String phone, boolean admin, Enterprise enterprise) {
        this.documentId = documentId;
        this.name = name;
        this.email = email;
        this.image = image;
        this.phone = phone;
        this.admin = admin;
        this.enterprise = enterprise;
        this.transactionList = new ArrayList<>();
    }

    //Getters and Setters


    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void addTransaction(Transaction transaction) {
        this.transactionList.add(transaction);
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public Date getCreateAt() {
        return createAt;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", documentId=" + documentId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", image='" + image + '\'' +
                ", phone='" + phone + '\'' +
                ", admin=" + admin +
                ", enterprise=" + enterprise +
                ", transactionList=" + transactionList +
                ", updateAt=" + updateAt +
                ", createAt=" + createAt +
                '}';
    }
}
