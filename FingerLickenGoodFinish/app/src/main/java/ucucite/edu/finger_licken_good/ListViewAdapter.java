package ucucite.edu.finger_licken_good;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter{

    //variables
    Context mContext;
    LayoutInflater inflater;
    List<Model> modellist;
    ArrayList<Model> arrayList;

    //constructor
    public ListViewAdapter(Context context, List<Model> modellist) {
        mContext = context;
        this.modellist = modellist;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Model>();
        this.arrayList.addAll(modellist);
    }

    public class ViewHolder{
        TextView mTitleTv, mDescTv;
        ImageView mIconIv;
    }

    @Override
    public int getCount() {
        return modellist.size();
    }

    @Override
    public Object getItem(int i) {
        return modellist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int postition, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row, null);

            //locate the views in row.xml
            holder.mTitleTv = view.findViewById(R.id.mainTitle);
            holder.mDescTv = view.findViewById(R.id.mainDesc);
            holder.mIconIv = view.findViewById(R.id.mainIcon);

            view.setTag(holder);

        }
        else {
            holder = (ViewHolder)view.getTag();
        }
        //set the results into textviews
        holder.mTitleTv.setText(modellist.get(postition).getTitle());
        holder.mDescTv.setText(modellist.get(postition).getDesc());
        //set the result in imageview
        holder.mIconIv.setImageResource(modellist.get(postition).getIcon());

        //listview item clicks
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code later
                if (modellist.get(postition).getTitle().equals("Chicken Sotanghon Soup")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, chicken1.class);
                    intent.putExtra("actionBarTitle", "Chicken Sotanghon Soup");
                    intent.putExtra("contentTv", "This is Chicken Sotanghon Soup detail...");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Chicken Potato Salad")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, chicken2.class);
                    intent.putExtra("actionBarTitle", "Chicken Potato Salad");
                    intent.putExtra("contentTv", "This is Chicken Potato Salad detail...");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Adobong Manok Sa Gata")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, chicken3.class);
                    intent.putExtra("actionBarTitle", "Adobong Manok Sa Gata");
                    intent.putExtra("contentTv", "This is Adobong Manok Sa Gata detail...");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Chicken Caldereta")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, chicken4.class);
                    intent.putExtra("actionBarTitle", "Chicken Caldereta");
                    intent.putExtra("contentTv", "This is Chicken Caldereta detail...");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Chicken Adobong Puti")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, chicken5.class);
                    intent.putExtra("actionBarTitle", "Chicken Adobong Puti");
                    intent.putExtra("contentTv", "This is Chicken Adobong Puti detail...");
                    mContext.startActivity(intent);
                }

                if (modellist.get(postition).getTitle().equals("Spicy Sotanghon Chicken Recipe")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, chicken6.class);
                    intent.putExtra("actionBarTitle", "Spicy Sotanghon Chicken Recipe");
                    intent.putExtra("contentTv", "This is Spicy Sotanghon Chicken Recipe detail...");
                    mContext.startActivity(intent);
                }

                if (modellist.get(postition).getTitle().equals("Chicken Asparagus Soup Recipe")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, chicken7.class);
                    intent.putExtra("actionBarTitle", "Chicken Asparagus Soup Recipe");
                    intent.putExtra("contentTv", "Chicken Asparagus Soup Recipe detail...");
                    mContext.startActivity(intent);
                }

                if (modellist.get(postition).getTitle().equals("Chicken Liver and Gizzard Stew")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, chicken8.class);
                    intent.putExtra("actionBarTitle", "Chicken Liver and Gizzard Stew");
                    intent.putExtra("contentTv", "This is Chicken Liver and Gizzard Stew Puti detail...");
                    mContext.startActivity(intent);
                }

                if (modellist.get(postition).getTitle().equals("Chicken Barbecue")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, chicken9.class);
                    intent.putExtra("actionBarTitle", "Chicken Barbecue");
                    intent.putExtra("contentTv", "This is Chicken Barbecue detail...");
                    mContext.startActivity(intent);
                }

                if (modellist.get(postition).getTitle().equals("Chicken Pasta with creamy bassil sauce")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, chicken10.class);
                    intent.putExtra("actionBarTitle", "Chicken Pasta with creamy bassil sauce");
                    intent.putExtra("contentTv", "This is Chicken Pasta with creamy bassil sauce detail...");
                    mContext.startActivity(intent);
                }
            }
        });

        return view;
    }

    //filter
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        modellist.clear();
        if (charText.length()==0){
            modellist.addAll(arrayList);
        }
        else {
            for (Model model : arrayList){
                if (model.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    modellist.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }

}

