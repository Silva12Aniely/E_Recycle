package com.example.e_recycle;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerVAdapter extends RecyclerView.Adapter<RecyclerVAdapter.MyViewHolder> {
    private Context dcontext;
    private List<Artigos> artigosList;

    public RecyclerVAdapter(Context dcontext, List<Artigos> artigosList) {
        this.dcontext = dcontext;
        this.artigosList = artigosList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        LayoutInflater layoutInflater = LayoutInflater.from(dcontext);
        view = layoutInflater.inflate(R.layout.model_artigos, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageArtigo.setImageResource(artigosList.get(position).getImgArtigo());
        holder.titulo.setText(artigosList.get(position).getTitulo());
        holder.descricao.setText(artigosList.get(position).getDescricao());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return artigosList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageArtigo;
        TextView titulo, descricao;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageArtigo = (ImageView) itemView.findViewById(R.id.imgArtigo);
            titulo = (TextView) itemView.findViewById(R.id.txtTitulo);
            descricao = (TextView) itemView.findViewById(R.id.txtArtigos);
            cardView = (CardView) itemView.findViewById(R.id.idCVArtigos);
        }
    }
}
