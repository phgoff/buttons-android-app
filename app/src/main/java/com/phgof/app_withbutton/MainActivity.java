package com.phgof.app_withbutton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private View view;
    private TextView tv2,tv3;
    private Button btn1,btn2;
    private RadioGroup radioGroup;
    private EditText tvname;
    ArrayList<String> items = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv2 = findViewById(R.id.tv2);
        btn2 = findViewById(R.id.btn2);
        tvname = findViewById(R.id.tvname);
        radioGroup = (RadioGroup) findViewById(R.id.radiotypes);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), page2.class);
                Bundle b = new Bundle();

                b.putString("name", tvname.getText().toString());
                int id = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(id);
                b.putString("radiotypes", radioButton.getText().toString());

                i.putExtras(b);

                i.putExtra("itemslist",items);
                startActivity(i);
            }
        });
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_meat:
                if (checked)
//                    tv2.setText("Put some meat on the sandwich");
                    items.add("Meat");
                else
                    items.remove("Meat");
                break;
            case R.id.checkbox_cheese:
                if (checked)
                    items.add("Cheese");
                else
                    items.remove("Cheese");
                break;
            case R.id.checkbox_rice:
                if (checked)
                    items.add("Rice");
                else
                    items.remove("Rice");
                break;
            case R.id.checkbox_coke:
                if (checked)
                    items.add("Coke");
                else
                    items.remove("Coke");
                break;
        }
    }
//    public void showitems(View view) {
//
//        String res = " ";
//        for(String itemvalue : items)
//            res += itemvalue + "\n";
//        tv3.setText(res);
//    }
}
