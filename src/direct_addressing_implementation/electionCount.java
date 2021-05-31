package direct_addressing_implementation;

import java.util.*;
import java.io.*;

class Record {    
	/*Class to store voter and candidate id's*/
	int voter_id;  
	int candidate_id;
}
	
class VotingDetails{
	/*Creating a array for Voter details in our specified range*/
	
	Record[] list;
	VotingDetails(){
	list = new Record[900000];
	}
	    
 public void add(int voter_id, int candidate_id) {
	/* Add function to store voter_id and candidate_id in array*/
	 
	   Record rd = new Record();
	   rd.voter_id = voter_id;
	   rd.candidate_id = candidate_id;
	   list[voter_id-100000] = rd;
	   System.out.println("Successfully added voter_id: "+voter_id);
	}

 public void find(int voter_id) {
	/* Function to find the candidate for whom the vote was casted by an input voter_id */
	 
	if(list[voter_id-100000] !=null) {
		Record rd = list[voter_id-100000];
	    System.out.println("Voter_id: "+rd.voter_id+ " " +" Candidate: "+rd.candidate_id);
	        }
	else {
		System.out.println("No such voter_id exists");
	    }
	}

 public void count(int candidate_id) {
	/* Function to count the total no of votes received by a candidate*/
	 
		int total_count = 0;
	    for(int i=0;i<list.length;i++){
	        if(list[i]!=null) {
	            if(list[i].candidate_id == candidate_id)
	                total_count = total_count + 1;
	    }
	}
	    System.out.println("Total_Votes for this candidate: "+total_count);
	}
}
/*
 * Uncomment this function to check all voter entries
 public void printallVoter_records() {
	for(int i=0;i<list.length;i++){
		if(list[i]!=null) {
	    	System.out.println("VoterID: "+list[i].voter_id+" CandidateID: "+list[i].candidate_id);
	        }
	    }
	}
	*/
	 
public class electionCount {	    
	 public static void main(String[] args) {
	 VotingDetails voterEntries = new VotingDetails();
	 try{
		 /* Reading the voter details from the input file */
		 FileInputStream filestream = new FileInputStream("data.txt");
	     DataInputStream input = new DataInputStream(filestream);
	     BufferedReader br = new BufferedReader(new InputStreamReader(input));
	     
	     String filecontents; 
	     while ((filecontents = br.readLine()) != null){
	    	 String[] values = filecontents.split("\\s+");
	    	 voterEntries.add(Integer.parseInt(values[0]),Integer.parseInt(values[1]));
	      }
	     System.out.println("Successfully added all voter_ids");
	     input.close();
	   }
	 catch (Exception e){
	     System.err.println("Error: " + e.getMessage());
	   }
	 
/* This section is added to test the other two functions and can be modified depending on how you want to test*/
	  System.out.println("Enter a voterid to check the candidate for whom the vote was cast");
	  Scanner reader = new Scanner(System.in);  // Reading from System.in
	  int input_voter_id = reader.nextInt();
	  voterEntries.find(input_voter_id);
	  
/* This section is added to test the other two functions and can be modified depending on how you want to test*/  
	  System.out.println("Enter a candidate_id to check his/her total no of votes");
	  int input_candidate_id = reader.nextInt();
	  voterEntries.count(input_candidate_id);
	  reader.close();
	}
	}

