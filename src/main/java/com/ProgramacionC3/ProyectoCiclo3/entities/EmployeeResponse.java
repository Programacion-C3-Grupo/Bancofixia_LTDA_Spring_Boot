package com.ProgramacionC3.ProyectoCiclo3.entities;
//Usuario response para retornar un objeto y mensaje.
public class EmployeeResponse {

    private String message;
    private Object Object;

    public EmployeeResponse(String message, java.lang.Object object) {
        this.message = message;
        Object = object;
    }

    public EmployeeResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public java.lang.Object getObject() {
        return Object;
    }

    public void setObject(java.lang.Object object) {
        Object = object;
    }
}
