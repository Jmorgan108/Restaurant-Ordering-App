package jmorgan17037719.ac.uk.loginpagetest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class RegisterActivity extends AppCompatActivity {

    EditText confirmPassword;
    EditText loginUsername;
    EditText loginPassword;
    DatabaseHelper Database;
    Button registerButton;
    TextView alreadyRegisteredClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Database = new DatabaseHelper(this);
        loginUsername = (EditText)findViewById(R.id.textUsername);
        loginPassword = (EditText)findViewById(R.id.textPassword);
        confirmPassword = (EditText)findViewById(R.id.textConfirmPassword);
        registerButton = (Button)findViewById(R.id.buttonRegister);
        alreadyRegisteredClick = (TextView)findViewById(R.id.textAlreadyRegistered);
        alreadyRegisteredClick.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(RegisterActivity.this, LoginStartActivity.class);
                startActivity(LoginIntent);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = loginUsername.getText().toString().trim();
                String pass = loginPassword.getText().toString().trim();
                String confirm_pass = confirmPassword.getText().toString().trim();

                if (pass.equals(confirm_pass)) {
                    long val = Database.addUser(user, pass);
                    if (val > 0) {
                        Toast.makeText(RegisterActivity.this, "Registration complete", Toast.LENGTH_SHORT).show();
                        Intent moveToLoginScreen = new Intent(RegisterActivity.this, LoginStartActivity.class);
                        startActivity(moveToLoginScreen);
                    } else {
                        Toast.makeText(RegisterActivity.this, "Registration Error", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(RegisterActivity.this,"Password is not matching",Toast.LENGTH_SHORT).show();
                }
             }
        });
    }
}