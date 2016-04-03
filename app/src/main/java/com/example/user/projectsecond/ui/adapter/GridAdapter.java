package com.example.user.projectsecond.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.projectsecond.R;


public class GridAdapter extends BaseAdapter {
    private Context context;
    LayoutInflater inflater;
    String[] genresMovies;

    public Integer[] mImagesId = {R.drawable.ic_adventure_movie, R.drawable.ic_comedy_movie,
            R.drawable.ic_cooking_movie, R.drawable.ic_detective_movie,
            R.drawable.ic_fantasy_movie, R.drawable.ic_historical_movie,
            R.drawable.ic_mystery_movie, R.drawable.ic_romantic_movie,
            R.drawable.ic_scientific_movie, R.drawable.ic_western_movie};

    public GridAdapter(Context context, String[] genresMovies){
        this.context = context;
        this.genresMovies = genresMovies;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mImagesId.length;
    }

    @Override
    public Object getItem(int position) {
        return mImagesId[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder{
        public ImageView imageView;
        public TextView textView;

        public ViewHolder(View item){
            imageView = (ImageView) item.findViewById(R.id.image_genre);
            textView = (TextView) item.findViewById(R.id.text_genre);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        View cellView = convertView;
        if(cellView == null){
            cellView = inflater.inflate(R.layout.cell_grid, null, true);
            holder = new ViewHolder(cellView);
            cellView.setTag(holder);
        }else{
            holder = (ViewHolder) cellView.getTag();
        }
        holder.imageView.setImageResource(mImagesId[position]);
        holder.textView.setText(genresMovies[position]);

        return cellView;
    }
}
