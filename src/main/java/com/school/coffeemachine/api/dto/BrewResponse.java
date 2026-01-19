package com.school.coffeemachine.api.dto;

public class BrewResponse {
    private String status;
    private String message;

    public BrewResponse() {}
    public BrewResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() { return status; }
    public String getMessage() { return message; }
}
