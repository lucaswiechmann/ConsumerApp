package com.example.lucasw.jsonconsumer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.lucasw.jsonconsumer.com.example.lucasw.jsonconsumer.service.Consumer;
import com.example.lucasw.jsonconsumer.com.example.lucasw.jsonconsumer.service.ConsumerCloud;
import com.example.lucasw.jsonconsumer.com.example.lucasw.jsonconsumer.service.ConsumerService;
import com.example.lucasw.jsonconsumer.com.example.lucasw.jsonconsumer.service.DataJson;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONStringer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ConsumerAdapter mAdapter;
    private List<Consumer> mConsumers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create retrofit service
        ConsumerService service = ConsumerCloud.getService();
        service.getConsumers(new Callback<DataJson>() {
            @Override
            public void success(DataJson dataJson, Response response) {
                mConsumers.clear();
                if( (dataJson.consumers != null) && (dataJson.consumers.size() > 0) ){
                    for(int i=0; i < dataJson.consumers.size(); i++) {
                        mConsumers.add(dataJson.consumers.get(i));
                    }
                }

                /*show info on list*/
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(TAG, "erro: " + error.toString());
            }
        });



        /*get the recycler  view and set the adapter*/
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rv_consumer_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mConsumers = new ArrayList<Consumer>();
        mAdapter = new ConsumerAdapter(mConsumers);
        recyclerView.setAdapter(mAdapter);
    }
}
