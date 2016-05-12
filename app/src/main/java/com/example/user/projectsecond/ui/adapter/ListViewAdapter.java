package com.example.user.projectsecond.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.projectsecond.R;


public class ListViewAdapter extends BaseAdapter {
    private final Context mContext;
    LayoutInflater mInflater;
    private final String[] mNames;
    private final String[] mNamesAuthor;

    public ListViewAdapter(Context context, String[] names, String[] namesAuthor) {
        this.mContext = context;
        this.mNames = names;
        this.mNamesAuthor = namesAuthor;
    }

    @Override
    public int getCount() {
        return mNames.length;
    }

    @Override
    public Object getItem(int position) {
        return mNames[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // Класс для сохранения во внешний класс и для ограничения доступа
    // из потомков класса
    static class ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public TextView textViewAuthor;
        public ImageView imageViewStar;

        public ViewHolder(View item) {
            textView = (TextView) item.findViewById(R.id.firstLine);
            textViewAuthor = (TextView) item.findViewById(R.id.secondLine);
            imageView = (ImageView) item.findViewById(R.id.icon);
            imageViewStar = (ImageView) item.findViewById(R.id.icon_star);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // ViewHolder буферизирует оценку различных полей шаблона элемента
        ViewHolder holder;
        // Очищает сущетсвующий шаблон, если параметр задан
        // Работает только если базовый шаблон для всех классов один и тот же
        View rowView = convertView;
        if (rowView == null) {
            mInflater = LayoutInflater.from(parent.getContext());
            rowView = mInflater.inflate(R.layout.activity_list_view_item, null, true);
            holder = new ViewHolder(rowView);
            rowView.setTag(holder);
        } else {
            holder = (ViewHolder) rowView.getTag();
        }

        holder.textView.setText(mNames[position]);
        holder.textViewAuthor.setText(mNamesAuthor[position]);
        holder.imageView.setImageResource(R.drawable.ic_launcher);
        holder.imageViewStar.setImageResource(R.drawable.ic_star);

        return rowView;
    }
}