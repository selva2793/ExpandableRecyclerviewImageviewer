package com.selvamani.expandablerecyclerviewimageviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ProgressBar;

import com.selvamani.expandablerecyclerviewimageviewer.Adapter.RecyclerAdapter;
import com.selvamani.expandablerecyclerviewimageviewer.Contracts.MainContract;
import com.selvamani.expandablerecyclerviewimageviewer.Implementations.GetQuoteInteractorImpl;
import com.selvamani.expandablerecyclerviewimageviewer.Implementations.MainPresenterImpl;
import com.selvamani.expandablerecyclerviewimageviewer.Remote.Datamodel.ParentModel;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity implements MainContract.MainView, ItemClickListener{

    private ProgressBar progressBar;
    private RecyclerView expandableListView;
    MainContract.Presenter presenter;
    RecyclerAdapter recyclerAdapter;
    LinearLayoutManager linearLayoutManager;

    List<ParentModel> parentModelListnew;
    List<ParentModel> parentModelsList;
    int index = 0;
    int size  = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        expandableListView = (RecyclerView) findViewById(R.id.rcvw_parentchildlist);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        presenter = new MainPresenterImpl(this, new GetQuoteInteractorImpl());

        presenter.onAPICalled();
    }

    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        expandableListView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(GONE);
        expandableListView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setAdapter(List<ParentModel> parentModels) {
        Log.d("ddjknnn", "setAdapter: "+parentModels.size());
        parentModelsList = new ArrayList<>();
        parentModelsList = parentModels;

        parentModelListnew = new ArrayList<>();
        parentModelListnew.add(parentModelsList.get(0));
        parentModelListnew.add(parentModelsList.get(1));

        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        expandableListView.setLayoutManager(linearLayoutManager);
         recyclerAdapter = new RecyclerAdapter(this,parentModelListnew);
        expandableListView.setAdapter(recyclerAdapter);
        recyclerAdapter.setClickListener(this);
    }

    @Override
    public void onClick(View view, int position) {
        Log.d("dfnffd", "onClick: "+position);
        index = position;
        parentModelListnew = new ArrayList<>();
        Log.d("dkljndjd", "getItemCount: "+index);
        int count  = 0;

        if(parentModelsList.size()-1 == index){
            index = 0;
        }
        else{
            index++;
        }

        Log.d("dfddffezd", "getItemCount: "+index);

        for(int i = index; i<parentModelsList.size();i++)
            {
                count++;
                if (count < 3)
                    parentModelListnew.add(parentModelsList.get(i));
            }
        if(index == parentModelsList.size()-1){
            for(int i = 0; i<parentModelsList.size();i++)
            {
                count++;
                if (count < 3)
                    parentModelListnew.add(parentModelsList.get(i));
            }
        }


        recyclerAdapter = new RecyclerAdapter(this,parentModelListnew);
        expandableListView.setAdapter(recyclerAdapter);
        recyclerAdapter.setClickListener(this);
    }
}
