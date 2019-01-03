package com.example.haipv.loginsample;

import android.os.AsyncTask;

/**
 * inner layer is business logic layer, where you resolve solve problems. <br/>
 * The layer does not contain any framework code, it is able to run it with out emulator <br/>
 * So it's easy to test.
 *
 */
public class LoginModelImpl implements LoginModel {

    private OnLoginFinishedListener listener;

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };

    @Override
    public void login(String username, String password, OnLoginFinishedListener listener) {
        this.listener = listener;
        new UserLoginTask(username, password).execute((Void) null);

    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

            for (String credential : DUMMY_CREDENTIALS) {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(mEmail)) {
                    // Account exists, return true if the password matches.
                    return pieces[1].equals(mPassword);
                }
            }

            // TODO: register the new account here.
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {

            if (success) {
                listener.onSuccess();
            } else {
                listener.onPasswordError();
            }
        }

        @Override
        protected void onCancelled() {
            listener.onCanceled();
        }
    }
}
