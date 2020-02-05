package com.example.swisstool.views;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Toast;

import com.example.swisstool.R;
import com.example.swisstool.model.Animal;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateAnimalFragment extends Fragment {

    private TextInputEditText etName, etBio, etAge;
    private MaterialButton btnDone;
    private CreateAnimalInteraction listener;

    public CreateAnimalFragment() {
        // Required empty public constructor
    }

    public CreateAnimalFragment(CreateAnimalInteraction listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_animal, container, false);
        etName = view.findViewById(R.id.etAnimalName);
        etBio = view.findViewById(R.id.etAnimalBio);
        etAge = view.findViewById(R.id.etAnimalAge);
        btnDone = view.findViewById(R.id.btnDone);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animal newAnimal = new Animal(
                        etName.getText().toString(),
                        etBio.getText().toString(),
                        Integer.parseInt(etAge.getText().toString())
                );

                Bundle bundle = new Bundle();
                bundle.putParcelable("ANIMAL", newAnimal);

                listener.newAnimal(bundle);

                Toast.makeText(view.getContext(), "DONE", Toast.LENGTH_SHORT).show();
            }
        });
    }

    interface CreateAnimalInteraction {
        void newAnimal(Animal animal);
        void newAnimal(Bundle animalBundle);
    }
}
