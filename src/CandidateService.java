import java.io.IOException;
import java.sql.SQLException;

public class CandidateService {
	public Candidate addCandidate(Candidate candidate) throws IOException, SQLException, ClassNotFoundException {
		VoterDaoInterface dao = new VoterDaoDb();
		dao.addCandidate(candidate);
		System.out.println("Candidate added successfully!");
		return candidate;
	}
}