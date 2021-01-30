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

public class PorkListViewAdapter extends BaseAdapter{

    //variables
    Context mContext;
    LayoutInflater inflater;
    List<PorkModel> modellist;
    ArrayList<PorkModel> arrayList;

    //constructor
    public PorkListViewAdapter(Context context, List<PorkModel> modellist) {
        mContext = context;
        this.modellist = modellist;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<PorkModel>();
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
            view = inflater.inflate(R.layout.forkrow, null);

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
                if (modellist.get(postition).getTitle().equals("Pata kare-kare")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, epork1.class);
                    intent.putExtra("actionBarTitle", "Pata kare-kare");
                    intent.putExtra("contentTv", "This is Pata kare-kare detail...");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Pork Sisig")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, epork2.class);
                    intent.putExtra("actionBarTitle", "Pork Sisig");
                    intent.putExtra("contentTv", "This is Pork Sisig detail...");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Tokwa at Baby humbay")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, epork3.class);
                    intent.putExtra("actionBarTitle", "Tokwa at Baby humbay");
                    intent.putExtra("contentTv", "This is Tokwa at Baby humbay detail...");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Sweet Pata Asado")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, epork4.class);
                    intent.putExtra("actionBarTitle", "Sweet Pata Asado");
                    intent.putExtra("contentTv", "This is Sweet Pata Asado detail...");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Spare Rebs Hamonado")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, epork5.class);
                    intent.putExtra("actionBarTitle", "Spare Rebs Hamonado");
                    intent.putExtra("contentTv", "This is Spare Rebs Hamonado detail...");
                    mContext.startActivity(intent);
                }

                if (modellist.get(postition).getTitle().equals("Coke Pork Adobo")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, epork6.class);
                    intent.putExtra("actionBarTitle", "Coke Pork Adobo");
                    intent.putExtra("contentTv", "This is Coke Pork Adobo detail...");
                    mContext.startActivity(intent);
                }

                if (modellist.get(postition).getTitle().equals("Sprite Pork Adobo")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, epork7.class);
                    intent.putExtra("actionBarTitle", "Sprite Pork Adobo");
                    intent.putExtra("contentTv", "This is Sprite Pork Adobo detail...");
                    mContext.startActivity(intent);
                }

                if (modellist.get(postition).getTitle().equals("Crispy Liempo Sinigang rice")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, epork8.class);
                    intent.putExtra("actionBarTitle", "Crispy Liempo Sinigang rice");
                    intent.putExtra("contentTv", "This is Crispy Liempo Sinigang rice detail...");
                    mContext.startActivity(intent);
                }

                if (modellist.get(postition).getTitle().equals("Pork Menudo sa Gata")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, epork9.class);
                    intent.putExtra("actionBarTitle", "Pork Menudo sa Gata");
                    intent.putExtra("contentTv", "This is Pork Menudo sa Gata detail...");
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
            for (PorkModel porkModel : arrayList){
                if (porkModel.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    modellist.add(porkModel);
                }
            }
        }
        notifyDataSetChanged();
    }

}

