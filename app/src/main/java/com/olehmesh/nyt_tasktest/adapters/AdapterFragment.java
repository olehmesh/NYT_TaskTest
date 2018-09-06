package com.olehmesh.nyt_tasktest.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.olehmesh.nyt_tasktest.DetailsActivity;
import com.olehmesh.nyt_tasktest.R;
import com.olehmesh.nyt_tasktest.models.FieldsAPI;

import java.util.List;

public class AdapterFragment extends RecyclerView.Adapter<ItemViewHolder> {

    Context context;
    List<FieldsAPI> list;
    Intent intent;

    public AdapterFragment(Context context, List<FieldsAPI> list) {

        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);

        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder itemViewHolder, int i) {

        itemViewHolder.list = list.get(i);
        itemViewHolder.title.setText(list.get(i).getTitle());
        itemViewHolder.description.setText(list.get(i).getDescription());

        Glide.with(context).applyDefaultRequestOptions(new RequestOptions().placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder))
                .load(list.get(i).getMedia().get(0).getMediaMetaData().get(0).getUrl())
                .into(itemViewHolder.imageView);

        itemViewHolder.setOnItemClickListener(new ItemViewHolder.OnItemClickListener() {

            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                intent = new Intent(context, DetailsActivity.class);
                intent.putExtra(String.valueOf(R.string.TITLE), itemViewHolder.title.getText());
                intent.putExtra(String.valueOf(R.string.DESCRIPTION), itemViewHolder.description.getText());
                intent.putExtra(String.valueOf(R.string.DATE), itemViewHolder.list.getDate());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}