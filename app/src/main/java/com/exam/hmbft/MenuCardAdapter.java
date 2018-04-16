package com.exam.hmbft;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.List;

public class MenuCardAdapter extends RecyclerView.Adapter<MenuCardAdapter.ViewHolder> {


    private LayoutInflater inflater;
    private ViewHolder viewHolder;
    private List<Menu> lstMenu;

    public MenuCardAdapter(List<Menu> lstMenu) {
        this.lstMenu = lstMenu;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (null == inflater) {
            inflater = LayoutInflater.from(parent.getContext());
        }

        View view = inflater.inflate(R.layout.layout_cart_row, parent, false);

        viewHolder = new ViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        viewHolder.lblItemName.setText(lstMenu.get(position).getName());
        viewHolder.npCount.setDisplayedValues(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"});
        viewHolder.npCount.setMinValue(1);
        viewHolder.npCount.setMaxValue(10);

        viewHolder.npCount.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {

                if (i != i1) {
                    lstMenu.get(position).setCount(i1);
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return lstMenu.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView lblItemName;
        NumberPicker npCount;

        public ViewHolder(View itemView) {
            super(itemView);

            lblItemName = itemView.findViewById(R.id.lblItemName);
            npCount = itemView.findViewById(R.id.npCount);

        }
    }

}
