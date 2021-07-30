package com.myfirst.fragmentgithubrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GitHubAdapter extends RecyclerView.Adapter<GitHubViewHolder> {

    private List<ResponseGitHub> list = new ArrayList<>();

    public GitHubAdapter(List<ResponseGitHub> list) {
        this.list = list;
    }

    @NonNull
    @Override



    public GitHubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_github,parent,false);
        return new GitHubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GitHubViewHolder holder, int position) {
        holder.setData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
