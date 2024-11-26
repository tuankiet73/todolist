package com.example.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private final List<Task> tasks;
    private final OnEditListener onEditListener;
    private final OnDeleteListener onDeleteListener;

    // Constructor for TaskAdapter
    public TaskAdapter(List<Task> tasks, OnEditListener onEditListener, OnDeleteListener onDeleteListener) {
        this.tasks = tasks;
        this.onEditListener = onEditListener;
        this.onDeleteListener = onDeleteListener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = tasks.get(position);
        holder.tvTaskName.setText(task.getName());
        holder.tvDescription.setText("Description: " + task.getDescription());
        holder.tvSchedule.setText("Schedule: " + task.getSchedule());
        holder.tvDuration.setText("Duration: " + task.getDuration() + " mins");

        holder.ivEdit.setOnClickListener(view -> onEditListener.onEdit(task));
        holder.ivDelete.setOnClickListener(view -> onDeleteListener.onDelete(task));
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView tvTaskName, tvDescription, tvSchedule, tvDuration;
        ImageView ivEdit, ivDelete;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTaskName = itemView.findViewById(R.id.tvTaskName);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvSchedule = itemView.findViewById(R.id.tvSchedule);
            tvDuration = itemView.findViewById(R.id.tvDuration);
            ivEdit = itemView.findViewById(R.id.ivEdit);
            ivDelete = itemView.findViewById(R.id.ivDelete);
        }
    }

    public interface OnEditListener {
        void onEdit(Task task);
    }

    public interface OnDeleteListener {
        void onDelete(Task task);
    }
}
