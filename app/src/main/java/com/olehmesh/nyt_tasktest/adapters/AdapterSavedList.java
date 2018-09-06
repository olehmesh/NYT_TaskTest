package com.olehmesh.nyt_tasktest.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.olehmesh.nyt_tasktest.R;
import com.olehmesh.nyt_tasktest.models.EntityDatabase;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterSavedList extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<EntityDatabase> dataModels;
    private OnDeleteListener onDeleteListener;
    private Context context;

    public AdapterSavedList(Context context, List<EntityDatabase> dataModels) {
        this.context = context;
        this.dataModels = dataModels;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_list_item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final NewsViewHolder viewHolder = (NewsViewHolder) holder;
        viewHolder.savedTitle.setText(dataModels.get(position).getTitle());
        viewHolder.savedDate.setText(dataModels.get(position).getDate());
        viewHolder.savedDescription.setText(dataModels.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.savedTitle)
        public TextView savedTitle;
        @BindView(R.id.savedDescription)
        public TextView savedDescription;
        @BindView(R.id.savedDate)
        public TextView savedDate;

        @BindView(R.id.delete)
        public TextView delete;

        public NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            delete.setOnClickListener(view -> {
                onDeleteListener.onDelete(dataModels.get(getAdapterPosition()));
                dataModels.remove(getAdapterPosition());
                notifyItemRemoved(getAdapterPosition());
            });
        }
    }

    public void setOnDeleteListener(OnDeleteListener onDeleteListener) {
        this.onDeleteListener = onDeleteListener;
    }

    public interface OnDeleteListener {
        void onDelete(EntityDatabase entityDatabase);
    }
}
