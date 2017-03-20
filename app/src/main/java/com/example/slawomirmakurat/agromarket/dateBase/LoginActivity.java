package com.example.slawomirmakurat.agromarket.dateBase;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.slawomirmakurat.agromarket.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Demon on 20.03.2017.
 */

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.login_button)
    Button signInButton;
    @BindView(R.id.fab_new_user)
    Button registerButton;
    @BindView(R.id.email_edit)
    EditText email_edit;
    @BindView(R.id.password_edit)
    EditText password_edit;
    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();


    }
    @OnClick(R.id.fab_new_user)
    public void registerNewUser (View v) {
        Intent intentRegisterNewUser = new Intent(getApplicationContext(), SignNewUserActivity.class);
        startActivity(intentRegisterNewUser);
    }

    @OnClick (R.id.login_button)
    public void login (View v) {
        String userName = email_edit.getText().toString();
        String password = password_edit.getText().toString();
        String storedPassword = loginDataBaseAdapter.getSingleEntry(userName);
        if (password.equals(storedPassword)) {
            Toast.makeText(this, "LOGIN SUCCESSFULL", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "USERNAME OR PASSWORD INCCORECT", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginDataBaseAdapter.close();
    }
}
