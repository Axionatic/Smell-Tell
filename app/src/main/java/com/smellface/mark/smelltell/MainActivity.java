package com.smellface.mark.smelltell;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button quitButton;
    private Button againButton;
    private TextView insultee;
    private TextView flavour;
    private String[] insultees;
    private String[] flavours;

    private void someoneSmells() {
        /* randomly insult someone (or sometimes compliment them)
         * TODO: prevent the same insultee/flavour twice in a row */
        Random r = new Random();
        insultee.setText(insultees[r.nextInt(insultees.length)]);
        flavour.setText(flavours[r.nextInt(flavours.length)]);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /* auto-generated, I'm not 100% sure what it does. Seems important? */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* initialise variables */
        this.insultee = (TextView)this.findViewById(R.id.insultee);
        this.flavour = (TextView)this.findViewById(R.id.flavour);
        this.insultees = this.getResources().getStringArray(R.array.insultees);
        this.flavours = this.getResources().getStringArray(R.array.flavours);

        /* let the smelling commence! */
        someoneSmells();

        /* code I stole from the internet to make the quit button work */
        this.quitButton = (Button)this.findViewById(R.id.quit);
        this.quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /* the above code, copied and modified to re-run someoneSmells() */
        this.againButton = (Button)this.findViewById(R.id.again);
        this.againButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someoneSmells();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
