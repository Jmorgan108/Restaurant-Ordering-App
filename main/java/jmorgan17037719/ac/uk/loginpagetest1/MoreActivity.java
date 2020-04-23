package jmorgan17037719.ac.uk.loginpagetest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MoreActivity extends AppCompatActivity {

    Button allergyButton;
    Button contactButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        allergyButton = (Button)findViewById(R.id.buttonAllergyInformation);
        contactButton = (Button)findViewById(R.id.buttonContact);

        allergyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent allergyIntent = new Intent(MoreActivity.this, AllergyActivity.class );
                startActivity(allergyIntent);
            }
        });

        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent contactIntent = new Intent(MoreActivity.this, ContactActivity.class );
                startActivity(contactIntent);
            }
        });
    }
}
