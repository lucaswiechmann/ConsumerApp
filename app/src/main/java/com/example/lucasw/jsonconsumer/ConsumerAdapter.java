package com.example.lucasw.jsonconsumer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lucasw.jsonconsumer.com.example.lucasw.jsonconsumer.service.Consumer;

import java.util.List;

/**
 * Created by LucasW on 10/04/2016.
 */
public class ConsumerAdapter extends RecyclerView.Adapter<ConsumerAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView id;
        private final TextView name;
        private final TextView pwd;
        ViewHolder(View v){
            super(v);
            id = (TextView)v.findViewById(R.id.tv_id);
            name = (TextView)v.findViewById(R.id.tv_name);
            pwd = (TextView)v.findViewById(R.id.tv_pwd);
        }
    }

    private List<Consumer> mConsumers;

    ConsumerAdapter(List<Consumer> consumers){
        mConsumers = consumers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.consumer_row, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Consumer consumer = mConsumers.get(position);
        holder.id.setText(consumer.getID());
        holder.name.setText(consumer.getName());
        holder.pwd.setText(consumer.getPwd());
    }

    @Override
    public int getItemCount() {
        return mConsumers.size();
    }
}
