package com.eroh.mit.insafety.detection.arch.ui.fragment.history;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eroh.mit.insafety.detection.arch.model.Archive;
import com.eroh.mit.insafety.detection.arch.model.History;

import org.tensorflow.lite.examples.detection.R;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {

    private ArrayList<History> list = new ArrayList<>();
    RecyclerView recyclerView;

    public HistoryFragment() {
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
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setTitle("Riwayat");

        recyclerView = view.findViewById(R.id.recycler_history);
        return view;
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
        HistoryAdapter adapter = new HistoryAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<History> getList() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDetail = getResources().getStringArray(R.array.data_detail);
        String[] dataResult = getResources().getStringArray(R.array.data_result);
        ArrayList<History> list = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            History history = new History(dataName[i], dataDetail[i], dataResult[i]);
            list.add(history);
        }
        return list;
    }
}