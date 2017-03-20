package com.example.slawomirmakurat.agromarket.dateBase;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.slawomirmakurat.agromarket.R;

import butterknife.BindView;

/**
 * Created by Demon on 20.03.2017.
 */

public class SignNewUserActivity extends AppCompatActivity {

    @BindView(R.id.loginRegister_editText)
    EditText loginEditText;
    @BindView(R.id.emailRegister_editText)
    EditText emailEditText;
    @BindView(R.id.passwordRegister_editText)
    EditText passwordEditText;
    @BindView(R.id.checkPasswordRegister_editText)
    EditText checkPasswordEditText;
    @BindView(R.id.postcodeRegister_editText)
    EditText postcodeEditText;
    @BindView(R.id.phoneNumberRegister_editText)
    EditText phoneNumberEditText;

    @BindView(R.id.register_button)
    Button registerButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }
}
