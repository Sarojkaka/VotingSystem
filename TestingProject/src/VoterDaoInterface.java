import java.io.IOException;
import java.sql.SQLException;

public interface VoterDaoInterface {

	public Voter addVoter(Voter vote) throws IOException, SQLException, ClassNotFoundException;

	void viewAll() throws IOException;

	public void votingProcess()throws IOException, SQLException, ClassNotFoundException;

	public void viewAllCandidate() throws IOException;

	public Voting addVoting(Voting voting) throws IOException, SQLException, ClassNotFoundException;


	public Voter searchByUsernameAndPassword(String username, String password) throws IOException, ClassNotFoundException, SQLException;

	Voter searchById(Integer id) throws IOException;

	Candidate addCandidate(Candidate candidate) throws IOException, ClassNotFoundException, SQLException;

	public Voter viewVotedVoters();

	Voter searchByVoted(String voted) throws IOException;

	public Voter TotalCountVoted();

	public Voter TotalCountVoters();
	
	public Voter TotalCountVoteCandidates();
	
}
