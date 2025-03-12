package com.CRUD.First.Crud.entity;

public class ApiResponse<T> { // here T is generic type data
    private String status;
    private String message;
    private T data;

    public ApiResponse(String status , String message , T data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }
}
