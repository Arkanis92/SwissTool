package com.example.swisstool.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swisstool.R;

import java.util.List;

public class AlphabetAdapter extends RecyclerView.Adapter<AlphabetAdapter.AlphabetViewHolder> {

    private List<Character> alphabets;

    public AlphabetAdapter(List<Character> alphabets) {
        this.alphabets = alphabets;
    }

    @NonNull
    @Override
    public AlphabetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.alphabet_item, parent, false);
        return new AlphabetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlphabetViewHolder holder, int position) {
        Character currentLetter = alphabets.get(position);
        holder.tvAlphabet.setText(currentLetter.toString());
    }

    @Override
    public int getItemCount() {
        return alphabets.size();
    }

    class AlphabetViewHolder extends RecyclerView.ViewHolder {
        TextView tvAlphabet;

        AlphabetViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAlphabet = itemView.findViewById(R.id.tvAlphabet);
        }
    }
}
