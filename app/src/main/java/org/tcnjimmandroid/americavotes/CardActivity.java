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

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CardActivity extends Activity {

    TextView name;
    TextView votes;
    ImageView pic;
    Button vote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.card_activity);
        name = (TextView) findViewById(R.id.person_name);
        votes = (TextView) findViewById(R.id.num_votes);
        pic = (ImageView) findViewById(R.id.person_photo);
        vote = (Button) findViewById(R.id.vote_button);

        name.setText("Emma Test");
        votes.setText("Test description");
        pic.setImageResource(R.drawable.emma);
    }

}