package com.myfirst.fragmentgithubrecyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class GitHubViewHolder extends RecyclerView.ViewHolder {

    private TextView mName,mLogin;
    private ImageView mAvatar;

    public GitHubViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews();
    }

    private void initViews() {
        mName = itemView.findViewById(R.id.name);
        mLogin = itemView.findViewById(R.id.login);
        mAvatar = itemView.findViewById(R.id.avatar);
    }

    public void setData(ResponseGitHub responseGitHub){
        mName.setText(responseGitHub.getName());
        mLogin.setText(responseGitHub.getOwner().getLogin());
        Glide.with(mAvatar).load(responseGitHub.getOwner().getAvatarUrl()).into(mAvatar);
    }
}
