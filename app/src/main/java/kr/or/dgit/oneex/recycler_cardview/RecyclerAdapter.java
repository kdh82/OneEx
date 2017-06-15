package kr.or.dgit.oneex.recycler_cardview;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import kr.or.dgit.oneex.R;


public class RecyclerAdapter extends RecyclerView.Adapter {

    private String[] titles = {
            "Chapter One", "Chapter Two", "Chapter Three", "Chapter Four",
            "Chapter Five", "Chapter Six", "Chpater Seven", "Chapter Eight"};

    private String[] details = {
            "Item one details", "Item two details", "Item three details",
            "Item four details", "Item five details", "Item six details",
            "Item seven details", "Item eight details"};

    private int[] images = {
            R.drawable.android_image_1, R.drawable.android_image_2, R.drawable.android_image_3,
                R.drawable.android_image_4, R.drawable.android_image_5, R.drawable.android_image_6,
                R.drawable.android_image_7, R.drawable.android_image_8};
    class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView) itemView.findViewById(R.id.item_image);
            itemTitle = (TextView) itemView.findViewById(R.id.item_title);
            itemDetail = (TextView) itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Snackbar.make(v, "Click detected on item" + position, Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
            });
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.itemTitle.setText(titles[position]);
        viewHolder.itemDetail.setText(details[position]);
        viewHolder.itemImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
