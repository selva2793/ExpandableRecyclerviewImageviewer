package com.selvamani.expandablerecyclerviewimageviewer.Adapter;

import android.content.Context;
import android.os.AsyncTask;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.selvamani.expandablerecyclerviewimageviewer.ItemClickListener;
import com.selvamani.expandablerecyclerviewimageviewer.R;
import com.selvamani.expandablerecyclerviewimageviewer.Remote.Datamodel.ParentModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private ItemClickListener clickListener;

    Context context;
    List<ParentModel> parentModelList;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ConstraintLayout parentLayout;
        TextView parentId;
        ImageView imageDisp;
        public MyViewHolder(View view) {
            super(view);
            parentLayout = (ConstraintLayout)view.findViewById(R.id.cl_parent);
            parentId = (TextView)view.findViewById(R.id.tv_parent);
            imageDisp = (ImageView)view.findViewById(R.id.iv_imageview);
                view.setOnClickListener((View.OnClickListener) this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
    }

    public RecyclerAdapter(Context context, List<ParentModel> parentModels) {
        this.context = context;
        this.parentModelList = parentModels;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.parentdessign, parent, false);
        Log.d("itemView", "onCreateViewHolder: "+itemView);
        return new MyViewHolder(itemView);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


            holder.parentId.setText(String.valueOf(parentModelList.get(position).getId()));
            Glide.with(context).load(parentModelList.get(position).getImage_URL()).into(holder.imageDisp);
    }
    @Override
    public int getItemCount() {

        return parentModelList.size();
    }


}
