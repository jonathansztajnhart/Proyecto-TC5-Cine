package com.jnj.cinepop.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jnj.cinepop.R;
import com.jnj.cinepop.models.MovieModel;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    private Context mContext;
    private List<MovieModel> movieList;


    public MovieAdapter(Context mContext, List<MovieModel> movieList){
        this.mContext = mContext;
        this.movieList = movieList;
    }

    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.movie_card, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MovieAdapter.MyViewHolder viewHolder, int i){
        viewHolder.title.setText(movieList.get(i).getOriginalTitle());

        String poster = "https://image.tmdb.org/t/p/w500" + movieList.get(i).getPosterPath();

        Glide.with(mContext)
                .load(poster)
                .placeholder(R.drawable.load)
                .into(viewHolder.thumbnail);
    }

    @Override
    public int getItemCount(){
        return movieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title, userrating;
        public ImageView thumbnail;

        public MyViewHolder(View view){
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            userrating = (TextView) view.findViewById(R.id.userrating);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);

            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    int pos = getAdapterPosition();
                    //if (pos != RecyclerView.NO_POSITION){
                    MovieModel clickedDataItem = movieList.get(pos);
                    //Intent intent = new Intent(mContext, DetailActivity.class);
                    //intent.putExtra("movies", clickedDataItem );
                    //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    //mContext.startActivity(intent);
                    Toast.makeText(v.getContext(), "You clicked " + clickedDataItem.getOriginalTitle(), Toast.LENGTH_SHORT).show();
                    //}
                }
            });
        }
    }
}
