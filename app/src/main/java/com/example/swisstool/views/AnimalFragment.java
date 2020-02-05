package com.example.swisstool.views;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.swisstool.R;
import com.example.swisstool.adapter.AnimalAdapter;
import com.example.swisstool.model.Animal;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnimalFragment extends Fragment {

    private RecyclerView rvAnimals;
    private FloatingActionButton fabAddNewAnimal;
    private AnimalAdapter animalAdapter;
    private AnimalInteraction listener;

    public AnimalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animal, container, false);
        fabAddNewAnimal = view.findViewById(R.id.fabNewAnimal);
        rvAnimals = view.findViewById(R.id.rvAnimals);
        rvAnimals.setLayoutManager(new LinearLayoutManager(requireContext()));
        animalAdapter = new AnimalAdapter();
        rvAnimals.setAdapter(animalAdapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fabAddNewAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.createNewAnimal();
                Toast.makeText(view.getContext(), "ADD NEW ANIMAL", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void setListener(AnimalInteraction listener) {
        this.listener = listener;
    }

    void newAnimalAdded(Animal animal) {
        animalAdapter.addNewAnimal(animal);
    }

    interface AnimalInteraction {
        void createNewAnimal();
    }
}
