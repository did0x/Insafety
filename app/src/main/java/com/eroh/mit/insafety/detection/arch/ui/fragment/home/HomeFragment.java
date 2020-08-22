package com.eroh.mit.insafety.detection.arch.ui.fragment.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.eroh.mit.insafety.detection.arch.ui.fragment.archives.ArchivesFragment;

import org.tensorflow.lite.examples.detection.R;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        Button btnArchives = view.findViewById(R.id.btn_archives);
        btnArchives.setOnClickListener(v -> {
            ((AppCompatActivity)getActivity()).getSupportFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.frame, new ArchivesFragment())
                    .addToBackStack("Archives")
                    .commit();
        });


        return view;
    }
}