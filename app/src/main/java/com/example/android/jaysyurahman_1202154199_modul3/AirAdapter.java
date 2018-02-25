package com.example.android.jaysyurahman_1202154199_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jaysyurahman on 25/02/2018.
 */

public class AirAdapter extends RecyclerView.Adapter<AirAdapter.AirViewHolder>{

    public ArrayList<AirItem> datas;

    public AirAdapter(ArrayList<AirItem> datas) {
        this.datas = datas;
    }

    @Override
    public AirViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_item, parent, false);
        return new AirViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AirViewHolder holder, int position) {
        final AirItem item = datas.get(position);
        holder.bindTo(item);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go = new Intent(view.getContext().getApplicationContext(),Detail.class);
                go.putExtra("etitle",item.getNama());
                go.putExtra("edesc",item.getDeskripsi());
                go.putExtra("eimg",item.getGambar());
                view.getContext().startActivity(go);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class AirViewHolder extends RecyclerView.ViewHolder{

        private TextView mLblMinumanJudul;
        private TextView mLblMinumanInfo;
        private ImageView mLblMinumanImg;
        private Context mContext;
        private AirItem mCurrentMinuman;

        public AirViewHolder(View itemView) {
            super(itemView);
            mLblMinumanJudul = (TextView)itemView.findViewById(R.id.lblItemJudul);
            mLblMinumanInfo = (TextView)itemView.findViewById(R.id.lblItemDeskripsi);
            mLblMinumanImg = (ImageView)itemView.findViewById(R.id.lblItemImg);
        }

        public void bindTo(AirItem minuman){
            mCurrentMinuman = minuman;
            mLblMinumanImg.setImageResource(minuman.getGambar());
            mLblMinumanJudul.setText(minuman.getNama());
            mLblMinumanInfo.setText(minuman.getInfo());
        }
    }
}
