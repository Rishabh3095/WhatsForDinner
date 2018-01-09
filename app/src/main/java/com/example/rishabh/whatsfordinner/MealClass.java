package com.example.rishabh.whatsfordinner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Rishabh on 10/8/2017.
 */

public class MealClass extends Activity{

    private saveValues mealObj = saveValues.getInstance();
    Spinner s,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21;
    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meal_class);

        btn = (Button) findViewById(R.id.nutriitionManager);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MealClass.this, NutriManager.class));
            }
        });
        ArrayAdapter<String> adap = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, mealObj.mealOptions);

        s = (Spinner) findViewById(R.id.monBreakSpin);
        s.setAdapter(adap);
        s1 = (Spinner) findViewById(R.id.monLuchSpin);
        s1.setAdapter(adap);
        s2 = (Spinner) findViewById(R.id.monDinnerSpin);
        s2.setAdapter(adap);
        s3 = (Spinner) findViewById(R.id.tueBreakSpin);
        s3.setAdapter(adap);
        s4 = (Spinner) findViewById(R.id.tueLunchSpin);
        s4.setAdapter(adap);
        s5 = (Spinner) findViewById(R.id.tueDinnerSpin);
        s5.setAdapter(adap);
        s6 = (Spinner) findViewById(R.id.wedBreakSpin);
        s6.setAdapter(adap);
        s7 = (Spinner) findViewById(R.id.wedLunchSpin);
        s7.setAdapter(adap);
        s8 = (Spinner) findViewById(R.id.wedDinnerSpin);
        s8.setAdapter(adap);
        s9 = (Spinner) findViewById(R.id.thursBreakSpin);
        s9.setAdapter(adap);
        s10 = (Spinner) findViewById(R.id.thursLunchSpin);
        s10.setAdapter(adap);
        s11 = (Spinner) findViewById(R.id.thursDinnerSpin);
        s11.setAdapter(adap);
        s12 = (Spinner) findViewById(R.id.fridBreakSpin);
        s12.setAdapter(adap);
        s13 = (Spinner) findViewById(R.id.fridLunchSpin);
        s13.setAdapter(adap);
        s14 = (Spinner) findViewById(R.id.fridDinnerSpin);
        s14.setAdapter(adap);
        s15 = (Spinner) findViewById(R.id.satBreakSpin);
        s15.setAdapter(adap);
        s16 = (Spinner) findViewById(R.id.satLunchSpin);
        s16.setAdapter(adap);
        s17 = (Spinner) findViewById(R.id.satDinnerSpin);
        s17.setAdapter(adap);
        s18 = (Spinner) findViewById(R.id.sunBreakSpin);
        s18.setAdapter(adap);
        s19 = (Spinner) findViewById(R.id.sunLunchSpin);
        s19.setAdapter(adap);
        s20 = (Spinner) findViewById(R.id.sunDinnerSpin);
        s20.setAdapter(adap);
    }
}
