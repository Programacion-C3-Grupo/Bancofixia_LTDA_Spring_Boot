package Entidades;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity

public class Employee {
    //id
    @employee_id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employee_id;

    //name

    private String name; //no esta en el diagrama pero debe tener un nombre entiendo

    //email
    @email(unique=true)
    private String email;

    //profile
    @OneToOne
    @JoinColumn(name = "profile")
    private Employee profile;

    //role

    @OneToMany
    @JoinColumn(name = "Enum_RoleName") //crear Enum_RoleName como es la conexion?
    private Employee role;

    //enterprise

    @ManyToOne
    @JoinColumn(name = "Enterprise") //crear
    private Employee enterprise;

    //transaction

    @ManyToOne
    @JoinColumn(name = "id")
    private Employee Transaction;

    //updateAt
    private Date updateAt;

    //createAt

    private Date createAt;

    //Getters

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Employee getRole() {
        return role;
    }

    public Employee getEnterprise() {
        return enterprise;
    }


    //Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(Employee role) {
        this.role = role;
    }

    public void setEnterprise(Employee enterprise) {
        this.enterprise = enterprise;
    }


    //Builder


    public Employee(Long employee_id, String name, String email, Employee profile, Employee role, Employee enterprise, Employee transaction, Date updateAt, Date createAt) {
        this.employee_id = employee_id;
        this.name = name;
        this.email = email;
        this.profile = profile;
        this.role = role;
        this.enterprise = enterprise;
        Transaction = transaction;
        this.updateAt = updateAt;
        this.createAt = createAt;
    }
}
