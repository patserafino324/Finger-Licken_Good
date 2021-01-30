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


public class PorkStartActivity extends AppCompatActivity {
    ListView listView;
    PorkListViewAdapter adapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<PorkModel> arrayList = new ArrayList<PorkModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fork_activity_start);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Finger-lickin");

        title = new String[]{"Pata kare-kare","Pork Sisig","Tokwa at Baby humbay","Sweet Pata Asado","Spare Rebs Hamonado","Coke Pork Adobo","Sprite Pork Adobo","Crispy Liempo Sinigang rice","Pork Menudo sa Gata"};
        description = new String[]{"Pata kare-kare detail...","Pork Sisig detail...", "Tokwa at Baby humbay detail...", "Sweet Pata Asado detail...", "Spare Rebs Hamonado detail...", "Coke Pork Adobo detail...", "Sprite Pork Adobo detail...", "Crispy Liempo Sinigang rice detail...", "Pork Menudo sa Gata detail..."};
        icon = new int[]{R.drawable.pork1, R.drawable.pork2, R.drawable.pork3, R.drawable.pork4, R.drawable.pork5, R.drawable.pork6, R.drawable.pork7, R.drawable.pork8, R.drawable.prok9};


        listView = findViewById(R.id.listView);

        for (int i =0; i<title.length; i++){
            PorkModel porkModel = new PorkModel(title[i], description[i], icon[i]);
            //bind all strings in an array
            arrayList.add(porkModel);
        }

        //pass results to listViewAdapter class
        adapter = new PorkListViewAdapter(this, arrayList);

        //bind the adapter to the listview
        listView.setAdapter(adapter);

    }

    //Search Code
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.forkmenu, menu);

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
