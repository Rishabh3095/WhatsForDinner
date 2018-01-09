package com.example.rishabh.whatsfordinner;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Rishabh on 10/8/2017.
 */



import android.graphics.Color;
        import android.graphics.drawable.ColorDrawable;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.text.SpannableString;
        import android.text.Spanned;
        import android.text.style.StrikethroughSpan;
        import android.util.Log;
        import android.util.StringBuilderPrinter;
        import android.view.View;
        import android.widget.ArrayAdapter;

        import com.baoyz.swipemenulistview.SwipeMenu;
        import com.baoyz.swipemenulistview.SwipeMenuCreator;
        import com.baoyz.swipemenulistview.SwipeMenuItem;
        import com.baoyz.swipemenulistview.SwipeMenuListView;

        import java.awt.font.TextAttribute;
        import java.text.AttributedString;
        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.HashMap;
        import java.util.HashSet;
        import java.util.Map;
        import java.util.Set;

import static com.example.rishabh.whatsfordinner.R.id.listView;


public class GrocClass extends Activity{

    ArrayAdapter adapter;
    saveValues mySingleton = saveValues.getInstance();
    ArrayList<String> draft = new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();
    ArrayList<String> key = new ArrayList<>();
    ArrayList<Integer> value = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.groc_class);

        SwipeMenuListView lV = (SwipeMenuListView) (findViewById(listView));

        draft.addAll(mySingleton.ingredients);

//        for(int i = 0; i < mySingleton.individualGroceries.size(); i+

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < draft.size(); i++) {
            Log.d("TEST", "" + draft.get(i));
            if (map.containsKey(draft.get(i))) {
                map.put(draft.get(i), map.get(draft.get(i)) + 1);
            } else {
                map.put(draft.get(i), 1);
            }
        }

        for (Map.Entry me : map.entrySet()) {

            key.add(me.getKey().toString());
            value.add((Integer) me.getValue());
            Log.d("checking", "" + me.getKey() + "\t Quantity: " + String.valueOf(me.getValue()));
            list.add(me.getKey() + "\t Quantity: " + String.valueOf(me.getValue()));

        }

        adapter = new ArrayAdapter(GrocClass.this, android.R.layout.simple_list_item_1, list);
        lV.setAdapter(adapter);

        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0x00, 0x00,
                        0xFF)));
                // set item width
                openItem.setWidth(170);
                // set item title

                openItem.setIcon(R.mipmap.ic_add);

                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0x00,
                        0x00, 0x00)));
                // set item width
                deleteItem.setWidth(170);
                // set a icon
                deleteItem.setIcon(R.mipmap.ic_delete);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };
        lV.setMenuCreator(creator);

        lV.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                Log.d("***", "" + position + "   " + index);
                switch (index) {
                    case 0:

                        int itemValuePlus = value.get(position);
                        if(itemValuePlus < 0) {
                            value.add(position, 0);
                            itemValuePlus = 0;
                        }
                        value.add(position, itemValuePlus + 1);
                        list.set(position, key.get(position) + "\t Quantity: " + String.valueOf(value.get(position)));
                        adapter.notifyDataSetChanged();
                        break;
                    case 1:
                        // delete
                        //break;
                        int itemValueMinus = value.get(position);
                        if (itemValueMinus <= 1) {
                            value.add(position, 0);

                            AttributedString attr = new AttributedString(key.get(position));
                            attr.addAttribute(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);

//                            StringBuilder str = new StringBuilder(key.get(position));

                            SpannableString str = new SpannableString(key.get(position));
                            str.setSpan(new StrikethroughSpan(), 0, str.length(), 0);

                            list.set(position, str + "\t Quantity: " + String.valueOf(value.get(position)));

                        } else {
                            value.add(position, itemValueMinus - 1);
                            list.set(position, key.get(position) + "\t Quantity: " + String.valueOf(value.get(position)));
                        }
                        adapter.notifyDataSetChanged();
                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });


    }
}