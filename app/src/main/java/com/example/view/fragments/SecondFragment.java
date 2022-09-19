package com.example.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.testmvvm.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {

    Button second_btn_next, second_btn_back;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        second_btn_next = (Button) view.findViewById(R.id.second_btn_next);
        second_btn_back = (Button) view.findViewById(R.id.second_btn_back);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        second_btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_secondFragment_to_thirdFragment2);
            }
        });
        second_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_secondFragment_to_firstFragment);
            }
        });
    }
}