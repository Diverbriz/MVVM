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
 * Use the {@link ThirdFragment#} factory method to
 * create an instance of this fragment.
 */
public class ThirdFragment extends Fragment {
    Button third_btn_next;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        third_btn_next = (Button) view.findViewById(R.id.third_btn_next);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        third_btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_thirdFragment2_to_firstFragment);
            }
        });
    }
}