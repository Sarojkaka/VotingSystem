import java.io.IOException;
import java.sql.SQLException;


public class VoterService {
	public Voter addVoter(Voter vote) throws IOException, SQLException, ClassNotFoundException {
		VoterDaoInterface dao = new VoterDaoDb();
		dao.addVoter(vote);
		System.out.println("Voter added successfully!");
		
		return vote;
	}



	public static void viewAll(Voter vote1) throws IOException {
		VoterDaoInterface dao = new VoterDaoDb();
		dao.viewAll();
		
	}



	public void addVoting(Voting voting) throws IOException, SQLException, ClassNotFoundException {
		VoterDaoInterface dao = new VoterDaoDb();
		dao.addVoting(voting);
		System.out.println("You Voted successfully!");
		return;
		
	}



	public static void viewAllCandidate() throws IOException {
		VoterDaoInterface dao = new VoterDaoDb();
		dao.viewAllCandidate();
		
	}

	public static void viewVotedVoters() throws IOException {
		VoterDaoInterface dao = new VoterDaoDb();
		dao.viewVotedVoters();
		
	}

	public static Voter searchById(int id) throws IOException {
		VoterDaoInterface dao = new VoterDaoDb();
		
		return dao.searchById(id);
	}



	public void TotalCountVoted() {
		VoterDaoInterface dao = new VoterDaoDb();
		dao.TotalCountVoted();
	}



	public void TotalCountVoters() {
		VoterDaoInterface dao = new VoterDaoDb();
		dao.TotalCountVoters();
		
	}
	public void TotalCountVoteCandidates() {
		VoterDaoInterface dao = new VoterDaoDb();
		dao.TotalCountVoteCandidates();
		
	}
	
}