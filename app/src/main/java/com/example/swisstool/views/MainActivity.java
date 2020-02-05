package com.example.swisstool.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.swisstool.R;
import com.example.swisstool.model.Animal;
import com.example.swisstool.views.AlphabetFragment;
import com.example.swisstool.views.HomeFragment;

public class MainActivity extends AppCompatActivity implements
        HomeFragment.HomeFragmentInteraction, AnimalFragment.AnimalInteraction,
        CreateAnimalFragment.CreateAnimalInteraction {

    private AnimalFragment animalFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadHomeFragment();
    }

    private void loadHomeFragment() {
        loadFragment(new HomeFragment(this));
    }

    @Override
    public void loadAlphabetViewer() {
        loadFragmentWithBackStack(new AlphabetFragment(), "AlphabetFragment");
    }

    @Override
    public void loadStressTapper() {

    }

    @Override
    public void loadBirthstones() {

    }

    @Override
    public void loadAnimalHouse() {
        animalFragment = new AnimalFragment();
        animalFragment.setListener(this);
        loadFragmentWithBackStack(animalFragment, "AnimalFragment");
    }

    @Override
    public void createNewAnimal() {
        loadFragmentWithBackStack(new CreateAnimalFragment(this), "CreateAnimalFragment");
    }


    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame1, fragment)
                .commit();
    }

    private void loadFragmentWithBackStack(Fragment fragment, String fragName) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame1, fragment)
                .addToBackStack(fragName)
                .commit();
    }

    @Override
    public void newAnimal(Animal animal) {
        animalFragment.newAnimalAdded(animal);
        onBackPressed();
    }

    @Override
    public void newAnimal(Bundle animalBundle) {
        Animal newAnimal = animalBundle.getParcelable("ANIMAL");
        newAnimal(newAnimal);
    }
}