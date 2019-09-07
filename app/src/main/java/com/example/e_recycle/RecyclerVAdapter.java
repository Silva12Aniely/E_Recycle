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
    private List<Artigos> martigosList;

    public RecyclerVAdapter(Context dcontext, List<Artigos> martigosList) {
        this.dcontext = dcontext;
        this.martigosList = martigosList;
    }


    @NonNull
    @Override
    public RecyclerVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        LayoutInflater layoutInflater = LayoutInflater.from(dcontext);
        view = layoutInflater.inflate(R.layout.model_artigos, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.idTitulo.setText(martigosList.get(position).getTitulo());
        holder.idImg.setImageResource(martigosList.get(position).getImgArtigo());
        holder.idConteudo.setText(martigosList.get(position).getDescricao());

        holder.idCVArtigos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dcontext, Artigos_Completo_Activity.class);
                intent.putExtra("data", martigosList.get(position).getData());
                intent.putExtra("titulo", martigosList.get(position).getTitulo());
                intent.putExtra("imgArtigo", martigosList.get(position).getImgArtigo());
                intent.putExtra("descricao", martigosList.get(position).getDescricao());
                intent.putExtra("autor", martigosList.get(position).getAutor());
                dcontext.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
    }

    @Override
    public int getItemCount() {
        return martigosList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView idTitulo, idConteudo;
        ImageView idImg;
        CardView idCVArtigos;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            idTitulo = (TextView) itemView.findViewById(R.id.txtTitulo);
            idConteudo = (TextView) itemView.findViewById(R.id.txtArtigos);
            idImg = (ImageView) itemView.findViewById(R.id.imgArtigo);
            idCVArtigos = (CardView) itemView.findViewById(R.id.idCVArtigos);
        }
    }
}
