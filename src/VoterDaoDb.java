import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VoterDaoDb implements VoterDaoInterface {
	private final static String USERNAME = "root";

	private final static String PASSWORD = "root";

	private final static String URL = "jdbc:mysql://localhost:3306/voter";

	@Override
	public Voter addVoter(Voter voter) throws IOException, ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		Class.forName("com.mysql.cj.jdbc.Driver");

		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		String insertQuery = "INSERT INTO voters(firstname,lastname,dateofbirth,gender,username,password,usertype) values (?,?,?,?,?,?,?)";

		pst = con.prepareStatement(insertQuery);

		pst.setString(1, voter.getFirstName());

		pst.setString(2, voter.getLastName());

		pst.setObject(3, voter.getDateOfBirth());

		pst.setString(4, voter.getGender().value);

		pst.setString(5, voter.getUsername());

		pst.setString(6, voter.getPassword());

		pst.setString(7, "USER");

		int resultvalue = pst.executeUpdate();

		if (resultvalue == 0) {
			System.out.println("Failed to insert data. Check your data and try again : ");

		}
		pst.close();
		con.close();
		return voter;
	}

	@Override
	public void viewAll() throws IOException {
		Connection con = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String query = "SELECT * from voters where not voterid = '1'";

			// System.out.println(query);

			statement = con.createStatement();

			ResultSet results = statement.executeQuery(query);

			while (results.next()) {
				System.out.println("*****----------------------------------------------------------------------*****");
				System.out.println(
						results.getInt(1) + "." + "Full Name: " + results.getString(2) + " " + results.getString(3)
								+ " DOB:" + " " + results.getString(4) + " " + "Gender:" + results.getString(5));

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Override
	public void viewAllCandidate() throws IOException {
		Connection con = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String query = "SELECT * from candidate";

			// System.out.println(query);

			statement = con.createStatement();

			ResultSet results = statement.executeQuery(query);

			while (results.next()) {

				System.out.println(results.getInt(1) + "." + "Candidate Full Name: " + results.getString(2) + " "
						+ results.getString(3) + " Party Name:" + " " + results.getString(4));

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Override
	public void votingProcess() {
		// TODO Auto-generated method stub

	}

	@Override
	public Voting addVoting(Voting voting) throws IOException, SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement pst = null;

		Class.forName("com.mysql.cj.jdbc.Driver");

		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		String insertQuery = "INSERT INTO voting(voterid,candidate_id,voting_status) values (?,?,?)";

		pst = con.prepareStatement(insertQuery);

		pst.setInt(1, voting.getId());

		pst.setInt(2, voting.getCadidateId());

		pst.setString(3, "voted");

		int resultvalue = pst.executeUpdate();

		if (resultvalue == 0) {
			System.out.println("Failed to insert data. Check your data and try again : ");

		}
		pst.close();
		con.close();
		return voting;
	}

	@Override
	public Voter searchByUsernameAndPassword(String username, String password)
			throws IOException, ClassNotFoundException, SQLException {
		Connection con = null;
		Statement statement = null;
		Voter vot = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String query = "Select * from voters where username='" + username + "' and password='" + password + "'";

			statement = con.createStatement();
			ResultSet results = statement.executeQuery(query);

			while (results.next()) {
				vot = new Voter();
				vot.setVoterId(results.getInt(1));
				vot.setFirstName(results.getString(2));
				vot.setLastName(results.getString(3));
				vot.setGender(Gender.getByValue(results.getString(5)));
				vot.setUsername(results.getString(6));
				vot.setPassword(results.getString(7));
				vot.setUsertype(UserType.valueOf(results.getString(8)));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return vot;
	}

	@Override
	public Voter searchById(Integer id) throws IOException {
		Connection con = null;
		Statement statement = null;
		Voter vot = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String query = "select * from voters where voterid = voterid";

			statement = con.createStatement();
			ResultSet results = statement.executeQuery(query);

			while (results.next()) {

				vot = new Voter();
				vot.setVoterId(results.getInt(1));
				vot.setFirstName(results.getString(2));
				vot.setLastName(results.getString(3));
				vot.setDateOfBirth(results.getString(4));
				vot.setGender(Gender.getByValue(results.getString(5)));
				vot.setUsername(results.getString(6));
				vot.setPassword(results.getString(7));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return vot;

	}

	@Override
	public Candidate addCandidate(Candidate candidate) throws IOException, ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pst = null;

		Class.forName("com.mysql.cj.jdbc.Driver");

		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		String insertQuery = "INSERT INTO candidate(candidate_firstname,candidate_lastname,party_name) values (?,?,?)";

		pst = con.prepareStatement(insertQuery);

		pst.setString(1, candidate.getFirstName());

		pst.setString(2, candidate.getLastName());

		pst.setObject(3, candidate.getPartyName());

		int resultvalue = pst.executeUpdate();

		if (resultvalue == 0) {
			System.out.println("Failed to insert data. Check your data and try again : ");

		}
		pst.close();
		con.close();
		return candidate;
	}

	
	public Voter TotalCountVoted() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement stmt = con.createStatement();
			String querytotal = "Select count(*) from voters where voterid in(select voterid from voting where voting_status = 'voted' )";
			ResultSet rs = stmt.executeQuery(querytotal);
			rs.next();
			int count = rs.getInt(1);
			System.out.println("Total Voters Voted : " + count);
			return null;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public Voter TotalCountVoters() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement stmt = con.createStatement();
			String querytotal = "SELECT COUNT(*) FROM voters where not voterid = '1'";
			ResultSet rs = stmt.executeQuery(querytotal);
			rs.next();
			int count = rs.getInt(1);
			System.out.println("Total Voters Number : " + count);
			return null;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	@Override
	public Voter viewVotedVoters() {

		Connection con = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String query = "Select * from voters where voterid in(select voterid from voting where voting_status = 'voted' )";

			statement = con.createStatement();

			ResultSet results = statement.executeQuery(query);

			while (results.next()) {

				System.out.println("*****----------------------------------------------------------------------*****");
				System.out.println("Voted Voters List :" + "Voter ID:" + results.getInt(1) + "." + "Full Name: "
						+ results.getString(2) + " " + results.getString(3) + " DOB:" + " " + results.getString(4) + " "
						+ "Gender:" + results.getString(5));

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return null;
	}

	@Override
	public Voter searchByVoted(String voted) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	public Voter TotalCountVoteCandidates() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement stmt = con.createStatement();
			String querytotal = "select *,count(candidate_id) from(\n"
					+ "select ca.candidate_id,ca.candidate_firstname,ca.candidate_lastname,ca.party_name from candidate as ca\n"
					+ "left join voting as vo on ca.candidate_id = vo.candidate_id) as total group by 1,2,3,4 order by count(candidate_id)desc";
			ResultSet rs = stmt.executeQuery(querytotal);
			while(rs.next()) {
			int id = rs.getInt(1);
			String firstname = rs.getString(2);
			String lastname = rs.getString(3);
			String partyname = rs.getString(4);
			int total = rs.getInt(5);
			System.out.println("Candidate ID: " + id + " Full Name: "+firstname+" "+lastname+" partyname: "+partyname+" Total Vote: "+total);
			System.out.println(" ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}