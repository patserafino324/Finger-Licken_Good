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

public class BeefListViewAdapter extends BaseAdapter{

    //variables
    Context mContext;
    LayoutInflater inflater;
    List<BeefModel> modellist;
    ArrayList<BeefModel> arrayList;

    //constructor
    public BeefListViewAdapter(Context context, List<BeefModel> modellist) {
        mContext = context;
        this.modellist = modellist;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<BeefModel>();
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
            view = inflater.inflate(R.layout.beefrow, null);

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
                if (modellist.get(postition).getTitle().equals("Beef Kaldereta")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, fbeef1.class);
                    intent.putExtra("actionBarTitle", "Beef Kaldereta");
                    intent.putExtra("contentTv", "This is Beef Kaldereta detail...");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Beef stir fry")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, fbeef2.class);
                    intent.putExtra("actionBarTitle", "Beef stir fry");
                    intent.putExtra("contentTv", "This is Beef stir fry detail...");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Kinamatisang Baka")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, fbeef3.class);
                    intent.putExtra("actionBarTitle", "Kinamatisang Baka");
                    intent.putExtra("contentTv", "This is Kinamatisang Baka detail...");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Beef Asado")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, fbeef4.class);
                    intent.putExtra("actionBarTitle", "Beef Asado");
                    intent.putExtra("contentTv", "This is Beef Asado detail...");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Beef Nachos with Cheese sauce")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, fbeef5.class);
                    intent.putExtra("actionBarTitle", "Beef Nachos with Cheese sauce");
                    intent.putExtra("contentTv", "This is Beef Nachos with Cheese sauce detail...");
                    mContext.startActivity(intent);
                }

                if (modellist.get(postition).getTitle().equals("Beef Papaitan")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, fbeef6.class);
                    intent.putExtra("actionBarTitle", "Beef Papaitan");
                    intent.putExtra("contentTv", "This is Beef Papaitan detail...");
                    mContext.startActivity(intent);
                }

                if (modellist.get(postition).getTitle().equals("Bulalo kare-kare")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, fbeef7.class);
                    intent.putExtra("actionBarTitle", "Bulalo kare-kare");
                    intent.putExtra("contentTv", "This is Bulalo kare-kare detail...");
                    mContext.startActivity(intent);
                }

                if (modellist.get(postition).getTitle().equals("Corned Beef Lomi Batangas style")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, fbeef8.class);
                    intent.putExtra("actionBarTitle", "Corned Beef Lomi Batangas style");
                    intent.putExtra("contentTv", "This is Corned Beef Lomi Batangas style detail...");
                    mContext.startActivity(intent);
                }

                if (modellist.get(postition).getTitle().equals("Saucy beef with Broccoli style")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, fbeef9.class);
                    intent.putExtra("actionBarTitle", "Saucy beef with Broccoli style");
                    intent.putExtra("contentTv", "This is Saucy beef with Broccoli style detail...");
                    mContext.startActivity(intent);
                }

                if (modellist.get(postition).getTitle().equals("Beef and baby corn stir fry")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, fbeef10.class);
                    intent.putExtra("actionBarTitle", "Beef and baby corn stir fry");
                    intent.putExtra("contentTv", "This is Beef and baby corn stir fry detail...");
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
            for (BeefModel beefModel : arrayList){
                if (beefModel.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    modellist.add(beefModel);
                }
            }
        }
        notifyDataSetChanged();
    }

}

