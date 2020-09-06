package com.example.animedirectory;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.ViewHolder>
{
    private ArrayList<Anime> Animes;
    public AnimeAdapter(ArrayList<Anime> cities) {
        this.Animes = cities;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        public final TextView name;
        public final ImageView image;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            name = view.findViewById(R.id.name);
            image = view.findViewById(R.id.image);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anime, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Anime anime = Animes.get(position);
        final Anime temp = Animes.get(position);
        holder.name.setText(anime.getName());
        Picasso.get().load(anime.getImageURL()).into(holder.image);
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                if(temp.getName().equals("Boku no hero academia")) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());
                    alertDialogBuilder.setMessage("This anime is really addictive. \n Do you want to proceed?");
                    alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            sendMessage(v, temp.getName());
                        }
                    });
                    alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }else
                {
                    sendMessage(v, temp.getName());
                }
            }
        });
    }


    public void sendMessage(View v,String s) {
        Intent intent = new Intent(v.getContext(),activity_anime_detail.class);
        String message = s;
        intent.putExtra("name", message);
        v.getContext().startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if (Animes != null) {
            return Animes.size();
        } else {
            return 0;
        }
    }

}
