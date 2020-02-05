package com.example.swisstool.views;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swisstool.R;
import com.example.swisstool.adapter.AlphabetAdapter;

import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlphabetFragment extends Fragment {

    private RecyclerView rvAlphabet;
    private AppCompatImageButton ibListViewer;
    private AlphabetAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    public AlphabetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_alphabet, container, false);
        rvAlphabet = v.findViewById(R.id.rvAlphabet);
        linearLayoutManager = new LinearLayoutManager(requireContext());
        rvAlphabet.setLayoutManager(linearLayoutManager);
        adapter = new AlphabetAdapter(
                Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
        );
        rvAlphabet.setAdapter(adapter);
        ibListViewer = v.findViewById(R.id.ibListViewer);
        ibListViewer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rvAlphabet.getLayoutManager() == linearLayoutManager) {
                    ibListViewer.setImageResource(R.drawable.ic_list_black);
                    rvAlphabet.setLayoutManager(new GridLayoutManager(requireContext(), 4));
                } else {
                    ibListViewer.setImageResource(R.drawable.ic_grid_on_black);
                    rvAlphabet.setLayoutManager(linearLayoutManager);
                }
            }
        });
        return v;
    }

}
