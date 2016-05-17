package com.example.user.projectsecond.ui.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.projectsecond.R;
import com.example.user.projectsecond.model.Book;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context mContext;
    private List<Book> mBooks;
    
    public RecyclerViewAdapter(Context context, List<Book> books) {
        this.mContext = context;
        this.mBooks = books;
    }

    // View holder class with which we get a reference to each element
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout mRelativeLayout;
        public ImageButton mRemoveButton;;
        public TextView txtViewTitle;
        public ImageView imgViewIcon;


        public ViewHolder(View itemView) {
            super(itemView);
            mRelativeLayout = (RelativeLayout) itemView.findViewById(R.id.relative_layout_book);
            txtViewTitle = (TextView) itemView.findViewById(R.id.txt_book_name);
            mRemoveButton = (ImageButton) itemView.findViewById(R.id.btn_img_remove);
            imgViewIcon = (ImageView) itemView.findViewById(R.id.img_books);
        }
    }

    // Create new views (called layout's manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_book, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);

        return viewHolder;
    }


    //Replaces separate content view (called layout's manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position){
        holder.txtViewTitle.setText(mBooks.get(position).getTitle());
        holder.imgViewIcon.setImageResource(mBooks.get(position).getImageUrl());

        // Set a click listener for TextView
        holder.txtViewTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String book = mBooks.get(position).getTitle();
                Toast.makeText(mContext,book,Toast.LENGTH_SHORT).show();
            }
        });

        // Set a click listener for item remove button
        holder.mRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the clicked item label
                String itemLabel = mBooks.get(position).getTitle();

                // Remove the item on remove/button click
                mBooks.remove(position);

                notifyItemRemoved(position);

                notifyItemRangeChanged(position,mBooks.size());

                // Show the removed item label
                Toast.makeText(mContext,"Removed : " + itemLabel, Toast.LENGTH_SHORT).show();
            }
        });
    }


    // Returns the size of the data (called layout's manager)
    @Override
    public int getItemCount() {
        return  mBooks.size();
    }
}
