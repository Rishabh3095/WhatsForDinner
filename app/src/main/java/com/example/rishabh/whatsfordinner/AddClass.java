package com.example.rishabh.whatsfordinner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;


/**
 * Created by Rishabh on 10/8/2017.
 */

public class AddClass extends AppCompatActivity{
    private saveValues myObj = saveValues.getInstance();
    public String[] ingredient;
    EditText name, descr;
    Spinner s, s2, s3, s4, s5, s6, s7, s8, s9, s10;
    Boolean update = false;
    String info;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_class);

        Intent n = getIntent();
        info = n.getStringExtra("name");

        ImageView iv = (ImageView) findViewById(R.id.addimage);

        name = (EditText) findViewById(R.id.nameText);

        descr = (EditText) findViewById(R.id.descriptionText);

        ingredient = new String[]
                {
                        "Select Item", "Tomato", "Onion", "Bread", "Broccoli", "Milk", "Carrots"
                };

        ArrayAdapter<String> adap = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ingredient);

        s = (Spinner) findViewById(R.id.spin1);
        s.setAdapter(adap);

        s2 = (Spinner) findViewById(R.id.spin2);
        s2.setAdapter(adap);

        s3 = (Spinner) findViewById(R.id.spin3);
        s3.setAdapter(adap);

        s4 = (Spinner) findViewById(R.id.spin4);
        s4.setAdapter(adap);

        s5 = (Spinner) findViewById(R.id.spin5);
        s5.setAdapter(adap);

        s6 = (Spinner) findViewById(R.id.spin6);
        s6.setAdapter(adap);

        s7 = (Spinner) findViewById(R.id.spin7);
        s7.setAdapter(adap);

        s8 = (Spinner) findViewById(R.id.spin8);
        s8.setAdapter(adap);

        s9 = (Spinner) findViewById(R.id.spin9);
        s9.setAdapter(adap);

        s10 = (Spinner) findViewById(R.id.spin10);
        s10.setAdapter(adap);

        if(info != null)
        {
            update = true;
            name.setText(info);
            descr.setText(myObj.getPrevDescription(info));

        }

        Button bt = (Button) findViewById(R.id.ADD);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (update) {

                    int k = myObj.findName(info);
                    myObj.recipeName.set(k, name.getText().toString());
                    myObj.description.set(k, descr.getText().toString());

                } else {

                boolean b = false;

                for (String rn : saveValues.getInstance().recipeName)
                {
                    String n = name.getText().toString();
                    if (n.equals(rn)) {
                        b = true;
                    }
                }

                if (b == false) {

                    String ingredients = "";
                    // add ingreidients to singleton
                    if (!isDefault(s.getSelectedItem().toString())) {
                        ingredients += s.getSelectedItem().toString();
                        myObj.ingredients.add(s.getSelectedItem().toString());
                    }
                    if (!isDefault(s2.getSelectedItem().toString())) {
                        ingredients += s2.getSelectedItem().toString();
                        myObj.ingredients.add(s2.getSelectedItem().toString());
                    }
                    if (!isDefault(s3.getSelectedItem().toString())) {
                        ingredients += s3.getSelectedItem().toString();
                        myObj.ingredients.add(s3.getSelectedItem().toString());
                    }
                    if (!isDefault(s4.getSelectedItem().toString())) {
                        ingredients += s4.getSelectedItem().toString();
                        myObj.ingredients.add(s4.getSelectedItem().toString());
                    }
                    if (!isDefault(s5.getSelectedItem().toString())) {
                        ingredients += s5.getSelectedItem().toString();
                        myObj.ingredients.add(s5.getSelectedItem().toString());
                    }
                    if (!isDefault(s6.getSelectedItem().toString())) {
                        ingredients += s6.getSelectedItem().toString();
                        myObj.ingredients.add(s6.getSelectedItem().toString());
                    }
                    if (!isDefault(s7.getSelectedItem().toString())) {
                        ingredients += s7.getSelectedItem().toString();
                        myObj.ingredients.add(s7.getSelectedItem().toString());
                    }
                    if (!isDefault(s8.getSelectedItem().toString())) {
                        ingredients += s8.getSelectedItem().toString();
                        myObj.ingredients.add(s8.getSelectedItem().toString());
                    }
                    if (!isDefault(s9.getSelectedItem().toString())) {
                        ingredients += s9.getSelectedItem().toString();
                        myObj.ingredients.add(s9.getSelectedItem().toString());
                    }
                    if (!isDefault(s10.getSelectedItem().toString())) {
                        ingredients += s10.getSelectedItem().toString();
                        myObj.ingredients.add(s10.getSelectedItem().toString());
                    }


                    String ingrd = "" + s.getSelectedItem().toString() + "," + s2.getSelectedItem().toString() + "," + s3.getSelectedItem().toString() + "," +
                            s4.getSelectedItem().toString() + "," + s5.getSelectedItem().toString() + "," + s6.getSelectedItem().toString() + "," +
                            s7.getSelectedItem().toString() + "," + s8.getSelectedItem().toString() + "," + s9.getSelectedItem().toString() + "," +
                            s10.getSelectedItem().toString();

                    myObj.newRecipe(name.getText().toString(), descr.getText().toString(), ingrd);
                }

//                for(String recipeName: saveValues.getInstance().recipeName)
//                {
//                    if(name.equals(recipeName))
//                    {
//                        b = true;
//                    }
//                }
//
//                if(b == true)
//                {
//                    saveValues.getInstance().newRecipe(name.getText().toString(), descr.getText().toString(), ingrd);
//                }
            }

            }
        });

    }

    private Boolean isDefault(String value) {
        if (value.equals("Select Item")) {
            return true;
        }
        return false;
    }

}
