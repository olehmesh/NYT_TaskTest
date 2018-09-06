package com.olehmesh.nyt_tasktest.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.olehmesh.nyt_tasktest.R;
import com.olehmesh.nyt_tasktest.models.FieldsAPI;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    OnItemClickListener onItemClickListener;

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.imageView)
    ImageView imageView;

    FieldsAPI list;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    public interface OnItemClickListener {
        void onClick(View view, int position, boolean isLongClick);
    }


    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.onItemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {

        onItemClickListener.onClick(view, getAdapterPosition(), false);

        }

    }
