package com.example.nitjamshedpurfaculty.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.nitjamshedpurfaculty.Adapter.FacultyAdapter;
import com.example.nitjamshedpurfaculty.ModalClass.FacultyInfo;
import com.example.nitjamshedpurfaculty.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FacultyActivity extends AppCompatActivity {
RecyclerView recyclerView;
FacultyAdapter adapter;
List<FacultyInfo> list;
Context ctx;
int index;
String[] string ={"cse","mca","chemistry","civil","eee","ece","maths","me","meta","PROD","physics","humanities"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        Intent i = getIntent();
        index = i.getIntExtra("index",0);
        setTitle(string[index].toUpperCase());
        recyclerView = findViewById(R.id.recycler_view);
        ctx = FacultyActivity.this;
        list = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getreccyclerview();
    }
    public void getreccyclerview(){
        String url="https://nitjsr.herokuapp.com/faculties";
        RequestQueue requestQueue = Volley.newRequestQueue(Objects.requireNonNull(FacultyActivity.this));
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try{
                for(int i=0;i<response.length();i++){
                        JSONObject obj = response.getJSONObject(i);
                        if(obj.getString("branch").equals(string[index])){
                            FacultyInfo l = new FacultyInfo(
                                    obj.getString("image"),
                                    obj.getString("name"),
                                    obj.getString("des"),
                                    obj.getString("link")
                            );
                            list.add(l);
                        }
                    }
                Log.i("k", String.valueOf(list));
                    adapter = new FacultyAdapter(list,ctx);
                    recyclerView.setAdapter(adapter);}
                catch (JSONException e) {
                        e.printStackTrace();
                    }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(request);
    }

}