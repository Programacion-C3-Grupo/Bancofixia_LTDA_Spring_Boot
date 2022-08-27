package Entidades;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    private Long id;
    private String concept;
    private Float amount;
    //user
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee_id;  // falta crear la entidad empleado
    //enterpice
    @ManyToOne
    @JoinColumn(name = "enterpice_id")
    private Enterpice enterpice;   //Falta crear la entidad empresa
    private Date createdAt;
    private Date updateAt;

    public Transaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Employee getEmployede() {
        return employee;
    }

    public void setEmployede(Employee employede) {
        this.employee = employee;
    }

    public Enterprice getEnterpice() {
        return enterprice;
    }

    public void setEnterpice(Enterprice enterpice) {
        this.enterprice = enterprice;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
