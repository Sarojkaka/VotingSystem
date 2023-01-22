import java.sql.SQLException;


public class LoginService {
	
	Voter login(String username, String password) throws ClassNotFoundException, SQLException {
		
		VoterDaoDb dao = new VoterDaoDb();
		Voter vot = null;
		
		try {
			vot = dao.searchByUsernameAndPassword(username, password);
		} catch (Exception e) {
			System.out.println("Some issue occurred");
			e.printStackTrace();
		}
		return vot;
	}
	
}

