package com.eroh.mit.insafety.detection.arch.ui.fragment.archives;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.eroh.mit.insafety.detection.arch.model.Archive;

import org.tensorflow.lite.examples.detection.R;

import java.util.List;

public class ArchivesAdapter extends RecyclerView.Adapter<ArchivesAdapter.ViewHolder> {
    private List<Archive> archives;

    public ArchivesAdapter(List<Archive> archives) {
        this.archives = archives;
    }

    @NonNull
    @Override
    public ArchivesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_date, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArchivesAdapter.ViewHolder holder, int position) {
        Archive archive = archives.get(position);
        String dateOnly = archive.getDate().split("[ \\t\\n\\,\\?\\;\\.\\:\\!]")[0];
        holder.textAltDate.setText(dateOnly);
        holder.textDate.setText(archive.getDate());
        String workers = archive.getCountWorker() + " Pekerja Hadir";
        holder.textCountWorkers.setText(workers);
    }

    @Override
    public int getItemCount() {
        return archives.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public AppCompatTextView textAltDate, textDate, textCountWorkers;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textAltDate = itemView.findViewById(R.id.text_alt_date);
            textDate = itemView.findViewById(R.id.text_date);
            textCountWorkers = itemView.findViewById(R.id.text_workers);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
