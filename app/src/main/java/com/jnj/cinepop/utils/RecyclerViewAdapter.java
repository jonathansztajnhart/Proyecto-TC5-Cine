package com.jnj.cinepop.utils;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jnj.cinepop.R;
import com.jnj.cinepop.activities.MainActivity;
import com.jnj.cinepop.activities.MovieActivity;
import com.jnj.cinepop.models.MovieModel;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<MovieModel> mData ;


    public RecyclerViewAdapter(Context mContext, List<MovieModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.movie_card,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.movie_title.setText(mData.get(position).getTitulo());
        holder.movie_image.setImageResource(mData.get(position).getIdDrawable());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, MovieActivity.class);

                intent.putExtra("Id",mData.get(position).getId());
                intent.putExtra("Titulo",mData.get(position).getTitulo());
                intent.putExtra("Sinopsis",mData.get(position).getSinopsis());
                intent.putExtra("Edad",mData.get(position).getEdad());
                intent.putExtra("Imagen",mData.get(position).getIdDrawable());

                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView movie_title;
        ImageView movie_image;
        CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            movie_title = (TextView) itemView.findViewById(R.id.movie_title_id) ;
            movie_image = (ImageView) itemView.findViewById(R.id.movie_img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);
        }
    }
}
