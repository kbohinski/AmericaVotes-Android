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

import java.util.ArrayList;
import java.util.List;

public class RVActivity extends Activity {

    private List<Candidate> candidates;
    private RecyclerView rView;

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
        candidates.add(new Candidate("Eirik Grieve", "red", 68, 0));
        candidates.add(new Candidate("Jehosephat Armonni", "blue", 73, 1));
        candidates.add(new Candidate("Reinier Samson", "red", 98, 2));
        candidates.add(new Candidate("Socrates Haydene", "blue", 101, 3));
    }

    private void initAdapter() {
        CandidatesAdapter adapter = new CandidatesAdapter(candidates);
        rView.setAdapter(adapter);
    }

}