package com.randy.wisatasemarang.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.randy.wisatasemarang.R;
import com.randy.wisatasemarang.model.Wisata;

import java.util.List;

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.WisataViewHolder> {

    private Context context;
    private List<Wisata> listWisata;

    public WisataAdapter(Context context, List<Wisata> listWisata) {
        this.context = context;
        this.listWisata = listWisata;
    }

    @Override
    public WisataAdapter.WisataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wisata, parent, false);
        return new WisataViewHolder(itemView);
    }

    public class WisataViewHolder extends RecyclerView.ViewHolder {
        ImageView ivItemGambarWisata;
        TextView tvItemNamaWisata;
        TextView tvItemAlamatWisata;

        public WisataViewHolder(View itemView) {
            super(itemView);
            ivItemGambarWisata = (ImageView) itemView.findViewById(R.id.iv_item_gambar);
            tvItemNamaWisata = (TextView) itemView.findViewById(R.id.tv_item_nama);
            tvItemAlamatWisata = (TextView) itemView.findViewById(R.id.tv_item_alamat);
        }
    }

    @Override
    public void onBindViewHolder(WisataAdapter.WisataViewHolder holder, int position) {
        String linkGambar = listWisata.get(position).getGambarWisata();
        Glide.with(context).load("")
    }
}