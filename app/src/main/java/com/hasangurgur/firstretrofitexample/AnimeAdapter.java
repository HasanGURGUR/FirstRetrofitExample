package com.hasangurgur.firstretrofitexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.ViewHolder> {


    private List<AnimeModel> animelists;

    public AnimeAdapter(List<AnimeModel> animelists) {
        this.animelists = animelists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.anime_list_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeAdapter.ViewHolder holder, int position) {

        holder.anime.setText(animelists.get(position).getAnimeName());
        holder.character.setText(animelists.get(position).getCharName());
        holder.queto.setText(animelists.get(position).getQuoteName());

    }

    @Override
    public int getItemCount() {
        return animelists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView anime;
        TextView character;
        TextView queto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            anime=itemView.findViewById(R.id.tv_anime);
            character=itemView.findViewById(R.id.tv_char);
            queto=itemView.findViewById(R.id.tv_queto);
        }
    }
}
