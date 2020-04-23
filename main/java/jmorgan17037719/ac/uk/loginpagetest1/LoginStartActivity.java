package jmorgan17037719.ac.uk.loginpagetest1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginStartActivity extends AppCompatActivity {

    EditText loginUsername;
    EditText loginPassword;

    Button loginButton;
    TextView registerClick;
    DatabaseHelper Database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Database = new DatabaseHelper(this);
        loginUsername = (EditText)findViewById(R.id.textUsername);
        loginPassword = (EditText)findViewById(R.id.textPassword);
        loginButton = (Button)findViewById(R.id.buttonLogin);
        registerClick = (TextView)findViewById(R.id.textRegister);
        registerClick.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginStartActivity.this, RegisterActivity.class );
                startActivity(registerIntent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = loginUsername.getText().toString().trim();
                String pass = loginPassword.getText().toString().trim();
                Boolean res = Database.checkUser(user, pass);
                if (res == true)
                {
                    Toast.makeText(LoginStartActivity.this, "You have logged in",Toast.LENGTH_SHORT).show();
                    Intent HomeScreen = new Intent(LoginStartActivity.this, HomeScreenActivity.class);
                    startActivity(HomeScreen);
                }
                else
                {
                    Toast.makeText(LoginStartActivity.this, "Error try again",Toast.LENGTH_SHORT).show();
                }
                finish();

            }
        });
    }
}
