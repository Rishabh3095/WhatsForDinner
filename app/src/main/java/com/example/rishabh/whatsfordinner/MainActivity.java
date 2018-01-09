package com.example.rishabh.whatsfordinner;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {

    ImageButton bWFD;
    ImageButton bMeal;
    ImageButton bRecipe;
    ImageButton bGroc;
    ImageButton bAdd;
    LayoutInflater layoutInflater;
    ConstraintLayout constraintLayout;
    PopupWindow popupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bWFD = (ImageButton) findViewById(R.id.WFD);
        constraintLayout = (ConstraintLayout) findViewById(R.id.constraint);

        bWFD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bWFD.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                        ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.popup, null);

                        popupWindow = new PopupWindow(container, 1250, 1000, true);
                        popupWindow.showAtLocation(constraintLayout, Gravity.NO_GRAVITY, 150, 1000);

                        container.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View view, MotionEvent motionEvent) {
                                popupWindow.dismiss();
                                return true;
                            }
                        });

                    }
                });

                bMeal = (ImageButton) findViewById(R.id.meal);
                bMeal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, MealClass.class));
                    }
                });
                bRecipe = (ImageButton) findViewById(R.id.recipe);
                bRecipe.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, RecipeClass.class));
                    }
                });
                bGroc = (ImageButton) findViewById(R.id.groc);
                bGroc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, GrocClass.class));
                    }
                });
                bAdd = (ImageButton) findViewById(R.id.add);
                bAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        startActivity(new Intent(MainActivity.this, AddClass.class));

                    }
                });
            }
        });
    }
}