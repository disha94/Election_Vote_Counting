package hashtable_implementation;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class electionCount {
    Hashtable<Integer,Integer> voterdetails = new Hashtable<Integer,Integer>();
        

    public void add(int voter_id, int candidate_id) {
	/* Add function to store voter_id and candidate_id in hashTable*/
    	voterdetails.put(voter_id, candidate_id);
    }
    
    public void find(int voter_id) {
    /* Function to find the candidate for whom the vote was casted by an input voter_id */
    	
    	if (voterdetails.containsKey(voter_id)) {
    		int candidate = voterdetails.get(voter_id);
            System.out.println("Voter_id: "+voter_id+ " " +" Candidate: "+candidate);		
		}
    	else {
    		System.out.println("No such voter_id exists");
    	}
    }

    public void count(int candidate_id) {
    	/* Function to count the total no of votes received by a candidate*/

    	int total_count = 0;
    	Set<Entry<Integer, Integer>> no_of_votes = voterdetails.entrySet();
    	for(Entry<Integer, Integer> entry : no_of_votes) {
            if (entry.getValue()==candidate_id)
                total_count = total_count + 1;
        }
    	System.out.println("Total_Votes for this candidate: "+total_count);
    }
  
	public static void main(String[] args) {
		
		electionCount voterEntries = new electionCount();
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

