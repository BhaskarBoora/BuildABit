package com.tushar.jape.wastemanagementapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{

    private ArrayList<Request> requestList;

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Request request = requestList.get(position);

        holder.date.setText("Date of request: "+request.getDateOfRequest()+"");
        holder.amount.setText("Amount: "+request.getAmount()+"");
        holder.hour.setText("Hour of request: "+request.getHourOfRequest()+"");

        if(request.getStatus() == 1)
            holder.status.setText("Status: Picked");
        else
            holder.status.setText("Status: To be picked");
        holder.type.setText("Type: "+request.getType());
    }

    @Override
    public int getItemCount() {
        return requestList.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView date, hour, type, amount, status;

        RecyclerViewHolder(View view){
            super(view);

            date = (TextView) view.findViewById(R.id.dateView);
            hour = (TextView) view.findViewById(R.id.timeView);
            type = (TextView) view.findViewById(R.id.typeView);
            amount = (TextView) view.findViewById(R.id.amtView);
            status = (TextView) view.findViewById(R.id.statusView);
        }
    }

    RecyclerAdapter(ArrayList<Request> rqList){
        requestList = rqList;
    }
}
