package com.phgof.app_withbutton;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private View view;
    private TextView tv2,tv3,tvX;
    private Button btn2;
    private RadioGroup radioGroup;
    private EditText tvname;
    ArrayList<String> items = new ArrayList<String>();
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private String[] mDrawerTitle = {"New", "Custom List"};
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv2 = findViewById(R.id.tv2);
        tvX = findViewById(R.id.tvX);
        btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
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
        // Hamburger Menu
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,
                mDrawerLayout,
                R.string.open_drawer,
                R.string.close_drawer);
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mListView = (ListView) findViewById(R.id.drawer);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mDrawerTitle);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,mDrawerTitle[position],Toast.LENGTH_SHORT).show();
                //String  itemValue    = (String) mListView.getItemAtPosition(position);
//                mDrawerLayout.closeDrawers();
//                tvX.setText("Position :"+ position+"  ListItem : " +itemValue);
            }
        });
        //-----
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

        //Hamburger
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            //when click Hamburger will show the menu
            if (actionBarDrawerToggle.onOptionsItemSelected(item))
                return true;
        return super.onOptionsItemSelected(item);
        }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }




}
