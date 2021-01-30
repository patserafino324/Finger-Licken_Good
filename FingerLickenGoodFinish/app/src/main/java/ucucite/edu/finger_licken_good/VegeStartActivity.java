package ucucite.edu.finger_licken_good;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class VegeStartActivity extends AppCompatActivity {
    ListView listView;
    VegeListViewAdapter adapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<VegeModel> arrayList = new ArrayList<VegeModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vege_activity_start);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Finger-lickin");

        title = new String[]{"Monggo na may kangkong at hibi","Crispy Air fried Liempo Pinakbet with Ube","Eggplant with Sardines omelet","Lumpiang Ubod","Ginataang Puso ng saging","Crispy Liempo Sinigang Rice","Talong at Tuna Turta","Shrimp Laing","Pork Monggo with kangkong","Ginataang Langka with malunggay and Dilis"};
        description = new String[]{"Monggo na may kangkong at hibi detail...","Crispy Air fried Liempo Pinakbet with Ube detail...", "Eggplant with Sardines omelet detail...", "Lumpiang Ubod detail...", "Ginataang Puso ng saging detail...", "Crispy Liempo Sinigang Rice detail...", "Talong at Tuna Turta detail...", "Shrimp Laing detail...", "Pork Monggo with kangkong detail...", "Ginataang Langka with malunggay and Dilis detail..."};
        icon = new int[]{R.drawable.vegetable1, R.drawable.vegetable2, R.drawable.vegetable3, R.drawable.vegetable4, R.drawable.vegetable5, R.drawable.vegetable6, R.drawable.vegetable7, R.drawable.vegetable8, R.drawable.vegetable9, R.drawable.vegetable10};


        listView = findViewById(R.id.listView);

        for (int i =0; i<title.length; i++){
            VegeModel vegeModel = new VegeModel(title[i], description[i], icon[i]);
            //bind all strings in an array
            arrayList.add(vegeModel);
        }

        //pass results to listViewAdapter class
        adapter = new VegeListViewAdapter(this, arrayList);

        //bind the adapter to the listview
        listView.setAdapter(adapter);

    }

    //Search Code
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.vegemenu, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)myActionMenuItem.getActionView();
        searchView.setQueryHint("Search Recipe...");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()

        {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)){
                    adapter.filter("");
                    listView.clearTextFilter();
                }
                else {
                    adapter.filter(s);
                }
                return true;
            }
        });
        return true;
    }
}
