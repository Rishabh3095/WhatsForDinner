package com.example.rishabh.whatsfordinner;//package com.example.rishabh.whatsfordinner;
//
//import android.app.Activity;
//import android.graphics.Color;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.LinearLayout;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
///**
// * Created by Rishabh on 10/8/2017.
// */
//
//public class RecipeClass extends AppCompatActivity {
//    private saveValues recipeObj = saveValues.getInstance();
//    int i;
//    String m;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.recipe_class);
//
//        LinearLayout ll = (LinearLayout) findViewById(R.id.linearlayout);
//
//        recipeObj.printData();
//
//        for (i = 0; i < recipeObj.recipeName.size(); i++) {
//            Button btn = new Button(this);
//            btn.setText(recipeObj.recipeName.get(i));
//            btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//            ll.addView(btn);
//            m = recipeObj.recipeName.get(i);
//
//
//            btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    recipeObj.newMeal(m);
//                }
//            });
//        }
//    }
//}
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.GridLayout.LayoutParams;


public class RecipeClass extends AppCompatActivity {

    private saveValues recipeObj = saveValues.getInstance();
    int i;
    String m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_class);


        LinearLayout ll = (LinearLayout) findViewById(R.id.linearlayout);

        recipeObj.printData();

        for (i = 0; i < recipeObj.recipeName.size(); i++) {
            final Button btn = new Button(this);
            btn.setId(i+1);
            btn.setText(recipeObj.recipeName.get(i));
            btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            ll.addView(btn);
            m = recipeObj.recipeName.get(i);


            btn.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

//                    boolean update = true;
                    Intent intent = new Intent(RecipeClass.this, AddClass.class);
                    intent.putExtra("name", btn.getText().toString());
                    startActivity(intent);

                    Log.d("jhhsdbj", "zjhsdklslcdksclbslvjjsjlbajdbsadbvsalbhvbaskvbsalbdj");
                    return true;
                }
            });

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    switch(view.getId())
                    {
                        case 1:
                            recipeObj.newMeal((String) btn.getText());
                            break;
                        case 2:
                            recipeObj.newMeal((String) btn.getText());
                            break;
                        case 3:
                            recipeObj.newMeal((String) btn.getText());
                            break;
                        case 4:
                            recipeObj.newMeal((String) btn.getText());
                            break;
                        case 5:
                            recipeObj.newMeal((String) btn.getText());
                            break;
                        case 6:
                            recipeObj.newMeal((String) btn.getText());
                            break;
                        case 7:
                            recipeObj.newMeal((String) btn.getText());
                            break;
                        case 8:
                            recipeObj.newMeal((String) btn.getText());
                            break;
                        case 9:
                            recipeObj.newMeal((String) btn.getText());
                            break;
                        case 10:
                            recipeObj.newMeal((String) btn.getText());
                            break;
                    }
                }
            });
        }
    }
}