package com.tejasvi7.meettheteam;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         ArrayList<HashMap<String, String>> teamList = new ArrayList();
        RecyclerView mRecyclerView;
        StringBuffer buffer1 = new StringBuffer();

        try {
            InputStream inputStream = getResources().openRawResource(R.raw.team);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line = buffer.readLine()) != null)
                buffer1.append(line + "");
            inputStream.close();
            String data = buffer1.toString();
            JSONObject jsonObject = new JSONObject(data);
            Log.d("2", "after getting data in array");
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            Log.d("1", "after getting data in array");
            for (int i = 0; i < jsonArray.length(); i++) {
                HashMap<String, String> datam = new HashMap<>();

                JSONObject c = jsonArray.getJSONObject(i);
                String avatar = c.getString("avatar");
                String firstName = c.getString("firstName");
                String id = c.getString("id");
                String lastName = c.getString("lastName");
                String title = c.getString("title");
                String bio = c.getString("bio");
                Log.d("image", avatar);

                datam.put("avatar", avatar);
                datam.put("firstName", firstName);
                datam.put("id", id);
                datam.put("lastName", lastName);
                datam.put("bio", bio);
                datam.put("title", title);


                teamList.add(i, datam);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleview);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemViewCacheSize(19);
        mRecyclerView.setDrawingCacheEnabled(true);
        mRecyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        //add animations
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        mRecyclerView.setItemAnimator(itemAnimator);
        // specify an adapter
        mAdapter = new ItemsAdapter(MainActivity.this, teamList);

        mRecyclerView.setAdapter(mAdapter);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4169E1")));

    }
}