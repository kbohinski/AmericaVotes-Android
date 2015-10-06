/**
 * @author Kevin Bohinski <bohinsk1@tcnj.edu>
 * @author Justin Cheng <chengj1@tcnj.edu>
 * @author Meghan McEneaney <mceneam1@tcnj.edu>
 * @version 1.0
 * @since 2015-9-22
 *
 * Course:        TCNJ - IMM 271-04 - Native Android Development
 * Instructor:    Prof. Justin Dilks
 * Project Name:  Voting App - Final Project
 * Description:   Basic android voting app.
 *
 * Filename:      RVActivity.java
 * Description:   Connects candidates to a recycler view.
 * Last Modified: 2015-10-5
 */

/* Setting Package */
package org.tcnjimmandroid.americavotes;

/* Setting Imports */

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class RVActivity extends Activity {

    /* Declaring Global Vars */
    private List<Candidate> candidates;
    private RecyclerView rView;
    String data = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recycle_view);

        rView = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rView.setLayoutManager(llm);
        rView.setHasFixedSize(true);

        initData();
        initAdapter();
    }

    private void initData() {
        candidates = new ArrayList<>();
        String url = "http://www.justindilks.com/candidates.json";

        StringRequest candidateReq = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.w("HTTP Req", response);
                        data = response;
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.w("HTTP Req", "Err");
            }
        }
        );
        Volley.newRequestQueue(this).add(candidateReq);

        try {
            JSONArray json = new JSONArray(data);
            for (int i = 0; i < json.length(); i++) {
                String name = json.getJSONObject(i).get("name").toString();
                String party = json.getJSONObject(i).get("party").toString();
                int votes = Integer.parseInt(json.getJSONObject(i).get("votes").toString());
                Candidate tmp = new Candidate(name, party, votes, i);
                candidates.add(tmp);
            }
        } catch (Exception e) {

        }
    }

    private void initAdapter() {
        CandidatesAdapter adapter = new CandidatesAdapter(candidates);
        rView.setAdapter(adapter);
    }

}