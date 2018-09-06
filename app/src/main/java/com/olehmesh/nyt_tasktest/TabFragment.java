package com.olehmesh.nyt_tasktest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.olehmesh.nyt_tasktest.adapters.AdapterFragment;
import com.olehmesh.nyt_tasktest.models.FieldsAPI;
import com.olehmesh.nyt_tasktest.network.MostPopularApi;
import com.olehmesh.nyt_tasktest.models.RequestAll;
import com.olehmesh.nyt_tasktest.network.RetrofitInstance;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class TabFragment extends Fragment {

    private Unbinder unbinder;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeLayout;

    private String tabTitle;
    private String type;
    String nameTab;

    List<FieldsAPI> fieldsAPIList;
    AdapterFragment adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getType(nameTab);
        requestData();
    }

   private void requestData() {

        MostPopularApi api = RetrofitInstance.getInstance().create(MostPopularApi.class);

                 api.getData(type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                         .subscribe(new DisposableSingleObserver<RequestAll>() {
                            @Override
                            public void onSuccess(RequestAll requestAll) {
                                fieldsAPIList = requestAll.getList();
                                recyclerView.setAdapter(new AdapterFragment(getActivity(), fieldsAPIList));

                            }

                            @Override
                            public void onError(Throwable e) {
                                Toast.makeText(getContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
                            }

                        });

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new AdapterFragment(getActivity(), fieldsAPIList);
        recyclerView.setAdapter(adapter);

        return view;
}

   @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()  {
         @Override
           public void onRefresh() {
                requestData();
                swipeLayout.setRefreshing(false);

            }
      });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void addTabTitle(String title) {
        this.tabTitle = title;
        nameTab = title;
    }

    public String getNameTab() {
        return nameTab;
    }

    public String getType(String nameTab) {
        StringBuilder st = new StringBuilder();
        st.append(nameTab);
        st.deleteCharAt(4);
        return st.toString();

    }

}