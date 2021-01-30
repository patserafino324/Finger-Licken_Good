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

public class VegeListViewAdapter extends BaseAdapter{

    //variables
    Context mContext;
    LayoutInflater inflater;
    List<VegeModel> modellist;
    ArrayList<VegeModel> arrayList;

    //constructor
    public VegeListViewAdapter(Context context, List<VegeModel> modellist) {
        mContext = context;
        this.modellist = modellist;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<VegeModel>();
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
            view = inflater.inflate(R.layout.vegerow, null);

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
                if (modellist.get(postition).getTitle().equals("Monggo na may kangkong at hibi")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, dvegetable1.class);
                    intent.putExtra("actionBarTitle", "Monggo na may kangkong at hibi");
                    intent.putExtra("contentTv", "This is Monggo na may kangkong at hibi detail...");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Crispy Air fried Liempo Pinakbet with Ube")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, dvegetable2.class);
                    intent.putExtra("actionBarTitle", "Crispy Air fried Liempo Pinakbet with Ube");
                    intent.putExtra("contentTv", "This is Crispy Air fried Liempo Pinakbet with Ube detail...");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Eggplant with Sardines omelet")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, dvegetable3.class);
                    intent.putExtra("actionBarTitle", "Eggplant with Sardines omelet");
                    intent.putExtra("contentTv", "This is Eggplant with Sardines omelet detail...");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Lumpiang Ubod")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, dvegetable4.class);
                    intent.putExtra("actionBarTitle", "Lumpiang Ubod");
                    intent.putExtra("contentTv", "This is Lumpiang Ubod detail...");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Ginataang Puso ng saging")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, dvegetable5.class);
                    intent.putExtra("actionBarTitle", "Ginataang Puso ng saging");
                    intent.putExtra("contentTv", "This is Ginataang Puso ng saging detail...");
                    mContext.startActivity(intent);
                }

                if (modellist.get(postition).getTitle().equals("Crispy Liempo Sinigang Rice")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, dvegetable6.class);
                    intent.putExtra("actionBarTitle", "Crispy Liempo Sinigang Rice");
                    intent.putExtra("contentTv", "This is Crispy Liempo Sinigang Rice detail...");
                    mContext.startActivity(intent);
                }

                if (modellist.get(postition).getTitle().equals("Talong at Tuna Turta")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, dvegetable7.class);
                    intent.putExtra("actionBarTitle", "Talong at Tuna Turta");
                    intent.putExtra("contentTv", "This is Talong at Tuna Turta detail...");
                    mContext.startActivity(intent);
                }

                if (modellist.get(postition).getTitle().equals("Shrimp Laing")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, dvegetable8.class);
                    intent.putExtra("actionBarTitle", "Shrimp Laing");
                    intent.putExtra("contentTv", "This is Shrimp Laing detail...");
                    mContext.startActivity(intent);
                }

                if (modellist.get(postition).getTitle().equals("Pork Monggo with kangkong")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, dvegetable9.class);
                    intent.putExtra("actionBarTitle", "Pork Monggo with kangkong");
                    intent.putExtra("contentTv", "This is Pork Monggo with kangkong detail...");
                    mContext.startActivity(intent);
                }

                if (modellist.get(postition).getTitle().equals("Ginataang Langka with malunggay and Dilis")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, dvegetable10.class);
                    intent.putExtra("actionBarTitle", "Ginataang Langka with malunggay and Dilis");
                    intent.putExtra("contentTv", "This is Ginataang Langka with malunggay and Dilis detail...");
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
            for (VegeModel vegeModel : arrayList){
                if (vegeModel.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    modellist.add(vegeModel);
                }
            }
        }
        notifyDataSetChanged();
    }

}

