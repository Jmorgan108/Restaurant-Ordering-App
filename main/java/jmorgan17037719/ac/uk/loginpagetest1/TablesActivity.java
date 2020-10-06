package jmorgan17037719.ac.uk.loginpagetest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TablesActivity extends AppCompatActivity {


    Button returnHomeTables;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);


        returnHomeTables = (Button) findViewById(R.id.buttonReturnHomeTables);
        returnHomeTables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent returnTablesIntent = new Intent(TablesActivity.this, HomeScreenActivity.class);
                startActivity(returnTablesIntent);
            }
        });
    }
}
