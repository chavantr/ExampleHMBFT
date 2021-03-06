package com.exam.hmbft;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.ViewHolder> {

    private ViewHolder viewHolder;
    private List<String> lstTables;
    private LayoutInflater inflater;
    private OnItemClickListener onItemClickListener;

    public TableAdapter(List<String> lstTables) {
        this.lstTables = lstTables;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_row, parent, false);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        viewHolder.lblTitle.setText(lstTables.get(position));
        viewHolder.lblTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstTables.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView lblTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            lblTitle = itemView.findViewById(R.id.lblTitle);
        }
    }
}
