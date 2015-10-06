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
 * Filename:      CandidatesAdapter.java
 * Description:   Connects a candidate's data to the candidate.xml.
 * Last Modified: 2015-10-5
 */

/* Setting Package */
package org.tcnjimmandroid.americavotes;

/* Setting Imports */
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CandidatesAdapter extends RecyclerView.Adapter<CandidatesAdapter.CandidateViewHolder> {

    public static class CandidateViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView name;
        TextView votes;
        ImageView pic;
        Button vote;

        CandidateViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            name = (TextView) itemView.findViewById(R.id.person_name);
            votes = (TextView) itemView.findViewById(R.id.num_votes);
            pic = (ImageView) itemView.findViewById(R.id.person_photo);
            vote = (Button) itemView.findViewById(R.id.vote_button);
        }
    }

    List<Candidate> candidates;

    CandidatesAdapter(List<Candidate> candidates){
        this.candidates = candidates;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public CandidateViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.candidate, viewGroup, false);
        CandidateViewHolder cvh = new CandidateViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(CandidateViewHolder candidateViewHolder, int i) {
        candidateViewHolder.name.setText(candidates.get(i).name);
        candidateViewHolder.votes.setText("" + candidates.get(i).party + "  |  Votes: " + Integer.toString(candidates.get(i).voteCount));
        candidateViewHolder.pic.setImageResource(candidates.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return candidates.size();
    }
}
