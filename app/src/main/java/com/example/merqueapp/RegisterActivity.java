package com.example.merqueapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.hdodenhof.circleimageview.CircleImageView;

public class RegisterActivity extends AppCompatActivity {

    CircleImageView mCircleImageViewBack;
    TextInputEditText mTextInputEditTextUsername;
    TextInputEditText mTextInputEditTexEmailR;
    TextInputEditText mTextInputEditTexPasswordR;
    TextInputEditText mTextInputEditTexConfirmPassword;
    Button mButtonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //Instancias
        mCircleImageViewBack = findViewById(R.id.circleimageback);
        mTextInputEditTextUsername = findViewById(R.id.textInputEditTextUserName);
        mTextInputEditTexEmailR = findViewById(R.id.textInputEditTextEmailR);
        mTextInputEditTexPasswordR = findViewById(R.id.textInputEditTextPasswordR);
        mTextInputEditTexConfirmPassword = findViewById(R.id.textInputEditTextConfirmPassword);
        mButtonRegister = findViewById(R.id.btnRegister);

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });

        mCircleImageViewBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish(); /* metodo finish nos lleva a la pantalla anterior*/
            }
        });
    }

    private void register() {
        String username = mTextInputEditTextUsername.getText().toString();
        String email = mTextInputEditTexEmailR.getText().toString();
        String password = mTextInputEditTexPasswordR.getText().toString();
        String confirmpassword = mTextInputEditTexConfirmPassword.getText().toString();

        if (!username.isEmpty() && !email.isEmpty() && !password.isEmpty() && !confirmpassword.isEmpty()) {
            if (isEmailValid(email)) {
                Toast.makeText(this, "insertaste todos los campos y el email es valido", Toast.LENGTH_SHORT).show();
                if (password.equals(confirmpassword)) {
                    if (password.length() >= 6) {
                        createUser(email, password);
                    } else {
                        Toast.makeText(this, "Las contraseñas debe tener 6 caracteres", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(this, "Inserto todos los campos y el correo no es valido", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private void createUser(String email, String password) {
    }

    

}
