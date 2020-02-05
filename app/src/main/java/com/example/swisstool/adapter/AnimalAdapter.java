package com.example.swisstool.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swisstool.R;
import com.example.swisstool.model.Animal;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {

    private List<Animal> animalList;

    public AnimalAdapter() {
        animalList = new ArrayList<>();
        animalList.addAll(
                Arrays.asList(
                        new Animal("Johny"),
                        new Animal("Zabomafoo"),
                        new Animal("Clifford"),
                        new Animal("Courage", "Scared of everything.", 7),
                        new Animal("Garfield", "Love to eat", 2)
                )
        );
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.animal_view, parent, false
        );
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        Animal animal = animalList.get(position);
        holder.tvAnimalName.setText(animal.getName());
        holder.tvAnimalBio.setText(animal.getBio());
        holder.tvAnimalAge.setText(String.valueOf(animal.getAge()));
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public void addNewAnimal(Animal animal) {
        animalList.add(animal);
        notifyItemInserted(animalList.size() - 1);
    }

    class AnimalViewHolder extends RecyclerView.ViewHolder {
        MaterialTextView tvAnimalName, tvAnimalBio, tvAnimalAge;

        AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAnimalName = itemView.findViewById(R.id.tvAnimalName);
            tvAnimalBio = itemView.findViewById(R.id.tvAnimalBio);
            tvAnimalAge = itemView.findViewById(R.id.tvAnimalAge);
        }
    }
}
