package com.phgof.app_withbutton;

/**
 * Created by Ph.GOF on 3/21/2018.
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class page2 extends AppCompatActivity {
    ArrayList<String> items = new ArrayList<>();
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity2);

            Button buttonBack = (Button) findViewById(R.id.button_back);
            TextView name = (TextView) findViewById(R.id.namevalue);
            TextView cshow = findViewById(R.id.cshow);
            TextView rdv = (TextView) findViewById(R.id.radiovalue);

            Bundle b = getIntent().getExtras();

            items = b.getStringArrayList("itemslist");
            for(int k=0; k < items.size(); k++)
                cshow.setText(cshow.getText() + items.get(k) + "\n");

            name.setText(b.getCharSequence("name"));
            rdv.setText(b.getCharSequence("radiotypes"));

            buttonBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(page2.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });

        }
    }