package com.example.rishabh.whatsfordinner;

import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by Rishabh on 10/8/2017.
 */

class saveValues {
    private static final saveValues ourInstance = new saveValues();

    ArrayList<String> recipeName = new ArrayList<>();
    ArrayList<String> groceryShop = new ArrayList<>();
    ArrayList<String> description = new ArrayList<>();
    ArrayList<String> mealOptions = new ArrayList<>();
    ArrayList<String> ingredients = new ArrayList<>();

    int find[] = {0,1,2,3,4,5,6,7,8};

    static saveValues getInstance() {
        return ourInstance;
    }

    private saveValues() {
    }

    public void newRecipe(String recep, String descrip, String ingred) {

//        boolean same = false;
//        for(String r: recipeName)
//        {
//            if(recep.equals(r))
//            {
//                same = true;
//            }
//        }
//        if(same == true)
//        {
            recipeName.add(recep);
            description.add(descrip);
            groceryShop.add(ingred);
//        }

        printData();
    }

    public int findName(String info)
    {
        int k=-1;
        for(int i = 0; i < recipeName.size(); i++)
        {
            k++;
            if(info.equals(recipeName.get(i)))
            {
                break;
            }
        }

        return k;
    }



    public String getPrevDescription(String name)
    {
        boolean same = false;
        int j=-1;
        for(int i = 0; i < recipeName.size(); i++)
        {
            j++;
            if(name.equals(recipeName.get(i)))
            {
                same = true;
                break;
            }
        }

        if(same)
        {
            return description.get(j);
        }
        return null;
    }


    public void newMeal(String meal)
    {
        mealOptions.add(0, "Eating Out");

        if(mealOptions.get(0)==null)
        {
            mealOptions.add("Eating Out");

        }
        mealOptions.add(meal);
        for(int i=0;i<mealOptions.size();i++) {
            Log.d("SAVEVALUES","Meals: "+mealOptions.get(i));
        }
    }

    public void printData() {

        for(int i=0;i<recipeName.size();i++) {
            Log.d("SAVEVALUES","Recipe: "+recipeName.get(i));
        }
        for(int i=0;i<groceryShop.size();i++) {
            Log.d("SAVEVALUES","Grocery: "+groceryShop.get(i));
        }
        for(int i=0;i<description.size();i++) {
            Log.d("SAVEVALUES","Description: "+description.get(i));
        }
    }

//    public String recipeName()
//    {
//        return recipeName.get(0);
//    }
//
}