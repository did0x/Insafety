package com.eroh.mit.insafety.detection.arch.ui.fragment.archives;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.eroh.mit.insafety.detection.arch.model.Archive;

import org.tensorflow.lite.examples.detection.R;

import java.util.ArrayList;

public class ArchivesFragment extends Fragment {

    private ArrayList<Archive> list = new ArrayList<>();
    private RecyclerView recyclerView;

    public ArchivesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_archives, container, false);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setTitle("Data Arsip");
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);

        recyclerView = view.findViewById(R.id.recycler_archives);
        return view;
    }

    private ArrayList<Archive> getList() {
        String[] dataDate = getResources().getStringArray(R.array.data_date);
        String[] dataWorkers = getResources().getStringArray(R.array.data_workers);
        ArrayList<Archive> list = new ArrayList<>();
        for (int i = 0; i < dataDate.length; i++) {
            Archive archive = new Archive(dataDate[i], dataWorkers[i]);
            list.add(archive);
        }
        return list;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list.addAll(getList());
        showRecycler();
    }

    private void showRecycler() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        ArchivesAdapter adapter = new ArchivesAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            getActivity().getSupportFragmentManager().popBackStackImmediate();
        }
        return super.onOptionsItemSelected(item);
    }


}