package com.example.slawomirmakurat.agromarket.User;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;

import com.example.slawomirmakurat.agromarket.MainActivity;
import com.example.slawomirmakurat.agromarket.R;

public class LoginActivity extends AppCompatActivity {

    public static final String KEY_ACCOUNT_CREATED = "1";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            final CoordinatorLayout container = (CoordinatorLayout) findViewById(R.id.activity_register);
            final TextInputLayout loginInputLayout = (TextInputLayout) findViewById(R.id.email_layout);
            final TextInputLayout passwordInputLayout = (TextInputLayout) findViewById(R.id.password_layout);
            final TextInputEditText emailInput = (TextInputEditText) findViewById(R.id.email_edit);
            final TextInputEditText passwordInput = (TextInputEditText) findViewById(R.id.password_edit);

            setTextWatcher(emailInput, loginInputLayout);
            setTextWatcher(passwordInput, passwordInputLayout);

            findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    boolean error = false;

                    if (TextUtils.isEmpty(emailInput.getText().toString())) {
                        loginInputLayout.setError(getString(R.string.empty_email_error));
                        error = true;
                    }

                    if (TextUtils.isEmpty(passwordInput.getText().toString())) {
                        passwordInputLayout.setError(getString(R.string.empty_password_error));
                        error = true;
                    }

                    if (!error) {
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }
                }
            });

            findViewById(R.id.fab_new_user).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                }
            });

            // Pobieramy z nadchodzącego Intentu wartość z klucza zawartego w polu KEY_ACCOUNT_CREATED
            // Jeśli pod tym kluczem nie ma wartości, przyjmujemy domyślnie "false"
            boolean accountCreated = getIntent().getBooleanExtra(KEY_ACCOUNT_CREATED, false);

            // Jeśli pod powyższym kluczem znajduje się wartość true, wyświetlamy Snackbar
            if (accountCreated) {
                Snackbar.make(container, R.string.account_created, Snackbar.LENGTH_LONG).show();
            }

            // Przycisk "Anuluj" kieruje do odpowiedniego ekranu
            findViewById(R.id.about_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
            });
        }

        /**
         * Zadaniem metody jest utworzenie i dodanie obiektu nasłuchującego zmian w widoku TextInputEditText.
         * W przypadku jeśli TextInputLayout wyświetla komunikat o błędzie, a nastąpi zmiana zawartości pola tekstowego
         * kasujemy komunikat o błędzie z TextInputLayout
         */
    private void setTextWatcher(final TextInputEditText editText, final TextInputLayout inputLayout) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (inputLayout.isErrorEnabled()) {
                    inputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }
}