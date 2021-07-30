package com.myfirst.fragmentgithubrecyclerview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentGitHub extends Fragment {

    private RecyclerView mRecyclerView;
    private EditText mId;
    private ImageButton mSearch;
    private List<ResponseGitHub> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_git_hub, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });
    }

    private void initViews(View view){
        mRecyclerView = view.findViewById(R.id.recyclerView);
        mId = view.findViewById(R.id.id);
        mSearch = view.findViewById(R.id.search);
    }

    private void callApi() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        apiService.callApi(mId.getText().toString()).enqueue(new Callback<List<ResponseGitHub>>() {
            @Override
            public void onResponse(Call<List<ResponseGitHub>> call, Response<List<ResponseGitHub>> response) {
                list = response.body();
                if(list != null)
                setRecyclerView();
            }

            @Override
            public void onFailure(Call<List<ResponseGitHub>> call, Throwable t) {

            }
        });
    }

    private void setRecyclerView(){
        GitHubAdapter gitHubAdapter = new GitHubAdapter(list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setAdapter(gitHubAdapter);
        mRecyclerView.setLayoutManager(linearLayoutManager);
    }
}