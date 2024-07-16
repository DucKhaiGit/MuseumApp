package com.example.store;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{

    private List<Item> mListItem;

    private Context mContext;


    public ItemAdapter(List<Item> mListItem,Context context) {
        this.mListItem = mListItem;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        Item item = mListItem.get(position);
        if (item == null)
        {
            return ;
        }
        holder.img_avt.setImageResource(item.getSourceId());
        holder.name.setText(item.getName());
        holder.script.setText(item.getScript());

        holder.layoutItemDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClickGotoDetail(item);
            }
        });
    }

    private void OnClickGotoDetail(Item item){
            Intent intent = new Intent(mContext,ItemDetailActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("object_item",item);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if(mListItem != null)
        {
            return mListItem.size();
        }
        return 0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        private ImageView img_avt;
        private TextView name;

        private TextView script;

        private RelativeLayout layoutItemDetail;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            img_avt=itemView.findViewById(R.id.img_avt);
            name=itemView.findViewById(R.id.item_name);
            script=itemView.findViewById(R.id.item_script);

            layoutItemDetail = itemView.findViewById(R.id.layout_itemdetail);
        }
    }
}
