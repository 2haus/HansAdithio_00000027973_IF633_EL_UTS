package com.example.hansadithio_27973_uts;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class DaftarLaguAdapter extends RecyclerView.Adapter<DaftarLaguAdapter.ItemLaguViewHolder> {
    private LinkedList<SausLagu> mDaftarLagu;
    private LayoutInflater mInflater;
    private Context mContext;
    public DaftarLaguAdapter(Context context, LinkedList<SausLagu> daftarLagu){
        this.mContext = context;
        this.mDaftarLagu = daftarLagu;
        this.mInflater = LayoutInflater.from(context);
    }
    public ItemLaguViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.mixtape_item_layout, parent, false);
        return new ItemLaguViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLaguViewHolder holder, int position){
        SausLagu mSausLagu = mDaftarLagu.get(position);
        holder.playerJudul.setText(mSausLagu.getJudul());
        holder.playerKeterangan.setText(mSausLagu.getKeterangan());
    }
    @Override
    public int getItemCount() { return mDaftarLagu.size(); }
    class ItemLaguViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView CoverSong;
        private TextView playerJudul;
        private TextView playerKeterangan;
        private TextView playerURI;
        private DaftarLaguAdapter mAdapter;
        private int mPosisi;
        private SausLagu mSausLagu;

        public ItemLaguViewHolder(@NonNull View itemView, DaftarLaguAdapter adapter){
            super(itemView);
            mAdapter = adapter;
            CoverSong = (ImageView) itemView.findViewById(R.id.CoverSong);
            playerJudul = (TextView) itemView.findViewById(R.id.playerJudul);
            playerKeterangan = (TextView) itemView.findViewById(R.id.playerKeterangan);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            mPosisi = getLayoutPosition(); mSausLagu = mDaftarLagu.get(mPosisi);
            Intent detailsIntent = new Intent(mContext, DetailsMixtapeActivity.class);
            Bundle bundle = new Bundle(); bundle.putSerializable("DetailsLagu", mDaftarLagu);
            bundle.putSerializable("PosisiLagu", mPosisi);
            detailsIntent.putExtras(bundle); mContext.startActivity(detailsIntent);
        }
    }
}
