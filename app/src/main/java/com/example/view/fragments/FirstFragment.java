package com.example.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.testmvvm.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#onCreateView(LayoutInflater, ViewGroup, Bundle)} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {
    private Button first_btn_next;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        // Inflate the layout for this fragment
        first_btn_next = (Button) view.findViewById(R.id.first_btn_next);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        first_btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_firstFragment_to_secondFragment);
            }
        });
    }
}