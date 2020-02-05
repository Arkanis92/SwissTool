package com.example.swisstool.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swisstool.HomeOptions;
import com.example.swisstool.R;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private List<HomeOptions> itemNames;
    private HomeAdapterInteraction listener;

    public HomeAdapter(List<HomeOptions> itemNames) {
        this.itemNames = itemNames;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.home_item,
                parent,
                false
        );
        return new HomeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        HomeOptions itemName = itemNames.get(position);
        holder.tvItemName.setText(itemName.getName());
    }

    @Override
    public int getItemCount() {
        return itemNames.size();
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {
        TextView tvItemName;

        HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItemName = itemView.findViewById(R.id.tvItemName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null)
                        listener.onItemClicked(itemNames.get(getAdapterPosition()));
                }
            });
        }
    }

    public void setListener(HomeAdapterInteraction listener) {
        this.listener = listener;
    }

    public interface HomeAdapterInteraction {
        void onItemClicked(HomeOptions itemName);
    }
}