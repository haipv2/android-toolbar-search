package com.example.haipv.loginsample;

public interface LoginModel {
    interface OnLoginFinishedListener {
        void onCanceled();

        void onPasswordError();

        void onSuccess();

    }

    void login(String username, String password, OnLoginFinishedListener listener);
}
