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


public class BeefStartActivity extends AppCompatActivity {
    ListView listView;
    BeefListViewAdapter adapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<BeefModel> arrayList = new ArrayList<BeefModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beef_activity_start);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Finger-lickin");

        title = new String[]{"Beef Kaldereta","Beef stir fry","Kinamatisang Baka","Beef Asado","Beef Nachos with Cheese sauce","Beef Papaitan","Bulalo kare-kare","Corned Beef Lomi Batangas style","Saucy beef with Broccoli style","Beef and baby corn stir fry"};
        description = new String[]{"Beef Kaldereta detail...","Beef stir fry detail...", "Kinamatisang Baka detail...", "Beef Asado detail...", "Beef Nachos with Cheese sauce detail...", "Beef Papaitan detail...", "Bulalo kare-kare detail...", "Corned Beef Lomi Batangas style detail...", "Saucy beef with Broccoli style detail...", "Beef and baby corn stir fry detail..."};
        icon = new int[]{R.drawable.beef1, R.drawable.beef2, R.drawable.beef3, R.drawable.beef4, R.drawable.beef5, R.drawable.beef6, R.drawable.beef7, R.drawable.beef8, R.drawable.beef9, R.drawable.beef10};


        listView = findViewById(R.id.listView);

        for (int i =0; i<title.length; i++){
            BeefModel beefModel = new BeefModel(title[i], description[i], icon[i]);
            //bind all strings in an array
            arrayList.add(beefModel);
        }

        //pass results to listViewAdapter class
        adapter = new BeefListViewAdapter(this, arrayList);

        //bind the adapter to the listview
        listView.setAdapter(adapter);

    }

    //Search Code
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.beefmenu, menu);

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
