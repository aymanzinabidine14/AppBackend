package com.doodle.backend.Response;

import lombok.Getter;

public class LoginResponse {

    @Getter
    private String Message ;
    private boolean Status;

    public LoginResponse(String message, boolean status) {
        Message = message;
        Status = status;
    }

    public LoginResponse() {
    }

    public boolean getStatus() {
        return Status;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public void setStatus(boolean status) {
        Status = status;
    }
}
