# Election_Vote_Counting

The output of an Electronic Voting Machine(EVM) is a text file consisting of (voter_id, candidate_id) pairs. Suppose that voter_id is a 6-digit integer and candidate_id is a 3-digit integer. 

**Input** : You are provided a file containing the consolidated output of EVMs from a constituency. Note that the exact values of voter_id and candidate_id are not revealed.

Implement the following methods for a class named electionCount. You must use the direct addressing method and hash table implementation.
 1) ADD: Takes a (voter_id, candidate_id) pair from the given file as input and stores it
 2) FIND: Takes a voter_id as input and outputs the candidate_id for whom the vote was cast
 3) COUNT: Takes a candidate_id as input and outputs the total number of votes received by him/her
