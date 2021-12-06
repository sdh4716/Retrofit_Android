package com.example.myapplication;

import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.MyViewHolder> {
    private List<Phone> phoneList;

    public PhoneAdapter(List<Phone> phoneList){
        this.phoneList = phoneList;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtId, txtName, txtTel;
        View itemView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.txtId = itemView.findViewById(R.id.txtId);
            this.txtName = itemView.findViewById(R.id.txtName);
            this.txtTel = itemView.findViewById(R.id.txtTel);
        }
    }
    //insert

    //list

    //update

    //remove


    @NonNull
    @Override
    public PhoneAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.phone_list, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneAdapter.MyViewHolder holder, int position) {
        Phone phone = phoneList.get(position);

        holder.txtId.setText(Long.toString(phone.getId()));
        holder.txtName.setText(phone.getName());
        holder.txtTel.setText(phone.getTel());

    }

    @Override
    public int getItemCount() {
        return phoneList!=null ? phoneList.size() : 0;
    }



   
}
