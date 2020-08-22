package com.eroh.mit.insafety.detection.arch.ui.fragment.history;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.eroh.mit.insafety.detection.arch.model.History;

import org.tensorflow.lite.examples.detection.R;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private static int TYPE_DONE = 1;
    private static int TYPE_DANGER = 2;
    private ArrayList<History> histories;

    public HistoryAdapter(ArrayList<History> histories) {
        this.histories = histories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_DONE) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_done, parent, false);
            return new ViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_danger, parent, false);
            return new ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        History history = histories.get(position);
        holder.textName.setText(history.getName());
        holder.textDetail.setText(history.getDetail());
    }

    @Override
    public int getItemViewType(int position) {
        if (histories.get(position).getResult().equals("DONE")) {
            return TYPE_DONE;
        } else
            return TYPE_DANGER;
    }

    @Override
    public int getItemCount() {
        return histories.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        AppCompatTextView textName, textDetail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.text_name);
            textDetail = itemView.findViewById(R.id.text_detail);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
