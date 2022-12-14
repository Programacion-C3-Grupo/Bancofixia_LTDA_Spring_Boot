package com.ProgramacionC3.ProyectoCiclo3.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transaction_id;

    private String concept;
    private Float amount;

    @JsonBackReference(value="employee-transaction")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @JsonBackReference(value="enterprise-transaction")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;

    private Date createdAt;
    private Date updatedAt;

    //Constructor
    public Transaction(){

    }

    public Transaction(String concept, Float amount, Employee employee, Enterprise enterprise) {
        this.concept = concept;
        this.amount = amount;
        this.employee = employee;
        this.enterprise = enterprise;
    }

    //Getters and Setters


    public Long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Long transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Date getCreatedAt() { return createdAt; }

    public Date getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "transaction_id=" + transaction_id +
                ", concept='" + concept + '\'' +
                ", amount=" + amount +
                ", employee=" + employee.getEmployee_id() +
                ", enterprise=" + enterprise +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
