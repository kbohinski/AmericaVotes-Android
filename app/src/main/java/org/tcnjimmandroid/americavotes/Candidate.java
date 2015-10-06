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
 * Filename:      Candidate.java
 * Description:   Abstract Data Type (ADT) to hold data on Candidates.
 * Last Modified: 2015-9-22
 */

/*
 * Incoming JSON: http://justindilks.com/candidates.json
 * 
 * {"candidates":[
 *	{name:"Eirik Grieve", party:"red", votes:"67"},
 *	{name:"Jehosephat Armonni", party:"blue", votes:"73"},
 *	{name:"Reinier Samson", party:"red", votes:"98"},
 *	{name:"Socrates Hayden", party:"blue", votes:"100"}
 * ]}
 */

/* Setting Package */
package org.tcnjimmandroid.americavotes;

/* Setting Imports */
public class Candidate {

    /* ADT Vars */
    String name;
    String party;
    int voteCount;
    int photoId;
    String color;

    /**
     * Constructor: Creates a new Candidate object based on the given input
     * params.
     *
     * @param name : Name of the candidate.
     * @param party : Party of the candidate.
     * @param voteCount : Number of votes for the candidate.
     * @param photoId : Photo number for the candidate.
     */
    Candidate(String name, String party, int voteCount, int photoId) {
        this.name = name;
        this.party = party;
        this.voteCount = voteCount;
        this.photoId = photoId;
        if (party.toLowerCase().equals("red") || party.toLowerCase().equals("republican")) {
            color = "#B71C1C";
        } else if (party.toLowerCase().equals("blue") || party.toLowerCase().equals("democrat")) {
            color = "#1A237E";
        }
    }

} /* Candidate.java */