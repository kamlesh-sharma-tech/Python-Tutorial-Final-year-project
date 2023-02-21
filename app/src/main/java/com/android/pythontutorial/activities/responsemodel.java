package com.android.pythontutorial.activities;

public class responsemodel {

    User user;

    String success,message;

    public responsemodel(User user, String success, String message) {
        this.user = user;
        this.success = success;
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
