package com.ProgramacionC3.ProyectoCiclo3.entities;
//Usuario response para retornar un objeto y mensaje.
public class UserResponse {

    private String message;
    private Object Object;

    public UserResponse(String message, java.lang.Object object) {
        this.message = message;
        Object = object;
    }

    public UserResponse() {
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
