package com.study.security.base;

// Classe para padronizar as responses do projeto
public class ApiResponse {
    private Object accessData;
    private String message;

    public ApiResponse(Object accessData, String message) {
        this.accessData = accessData;
        this.message = message;
    }

    public Object getAccessData() {
        return accessData;
    }

    public void setAccessData(Object accessData) {
        this.accessData = accessData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
