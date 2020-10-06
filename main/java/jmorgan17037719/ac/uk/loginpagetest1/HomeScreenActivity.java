package jmorgan17037719.ac.uk.loginpagetest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreenActivity extends AppCompatActivity {

    Button logOffButton;
    Button moreButton;
    Button menuButton;
    Button orderButton;
    Button tableButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        logOffButton = (Button)findViewById(R.id.buttonLogOut);
        moreButton = (Button)findViewById(R.id.buttonMore);
        orderButton = (Button)findViewById(R.id.buttonOrder);
        menuButton = (Button)findViewById(R.id.buttonMenu);
        tableButton = (Button)findViewById(R.id.buttonTables);

        logOffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logOffIntent = new Intent(HomeScreenActivity.this, LoginStartActivity.class );
                startActivity(logOffIntent);
                //By implementing finish it stops someone from coming over and just pressing back to get back onto the home screen without logging in.
                finish();
            }
        });

        moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moreIntent = new Intent(HomeScreenActivity.this, MoreActivity.class );
                startActivity(moreIntent);
            }
        });

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent orderIntent = new Intent(HomeScreenActivity.this, OrderActivity.class );
                startActivity(orderIntent);
            }
        });

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuIntent = new Intent(HomeScreenActivity.this, MenuActivity.class );
                startActivity(menuIntent);
            }
        });

        tableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tableIntent = new Intent(HomeScreenActivity.this, TablesActivity.class );
                startActivity(tableIntent);
            }
        });
    }
}
