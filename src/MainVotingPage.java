import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class MainVotingPage {

	static int choice = 0;

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException, ParseException, SQLException, IOException {

		loginpage();
	}

	private static void loginpage() throws ParseException, ClassNotFoundException, SQLException, IOException {
		VoterService voteService = new VoterService();
		Voter voter = null;
		LoginService loginService = new LoginService();
		Voter vot = null;

		while (true) {
			System.out.println("\n\n \t\t\t\t Welcome to Election \t\t\n\n");
			System.out.println("1. Voter Registration \t 2. Login");
			System.out.println(" ");
			System.out.print("Enter your choice:: ");
			choice = sc.nextInt();

			if (choice == 1) {

				checkdobPage();

			} else if (choice == 2) {
				System.out.println("Enter your username::");
				String username = sc.next();

				System.out.println("Enter your password");
				String password = sc.next();

				vot = loginService.login(username, password);

				if (vot != null) {
					System.out.println("User logged in Successfully.");
				} else {
					System.out.println("Login Failed. Incorrect username/password. Try again.");
					loginpage();

				}

				System.out.println("Welcome, " + vot.getFirstName() + " " + vot.getLastName());

				int choice = 0;

				if (vot.getUsertype() == UserType.ADMIN) {

					// Admin functionalities
					while (true) {
						System.out.println("-----------------------");
						System.out.println("1. Voter Registration");
						System.out.println("2. Candidate Registration");
						System.out.println("3. View All Voter List ");
						System.out.println("4. View All Candidate List");
						System.out.println("5. Voting process ");
						System.out.println("6. Voting Result ");
						System.out.println("7. Logout");
						System.out.println("Enter your choice::");
						choice = sc.nextInt();

						if (choice == 1) {
							checkdobPage();
						} else if (choice == 2) {
							addcandidatepage();
						} else if (choice == 3) {
							// View all voter list
							try {
								VoterService.viewAll(voter);
							} catch (IOException e) {
								throw new RuntimeException(e);
							}
						} else if (choice == 4) {
							try {
								VoterService.viewAllCandidate();
							} catch (Exception e) {
								throw new RuntimeException(e);
							}
						} else if (choice == 5) {
							try {
								voteService.TotalCountVoters();
								voteService.TotalCountVoted();
								VoterService.viewVotedVoters();
							} catch (Exception e) {
								throw new RuntimeException(e);
							}
						} else if (choice == 6) {
							voteService.TotalCountVoteCandidates();
						} else if (choice == 7) {
							loginpage();
						} else {
							System.err.println("Invalid Selection");
						}
					}
				} else if (vot.getUsertype() == UserType.USER) {
					// User functionalities
					while (true) {
						System.out.println("--------------------");
						System.out.println("1. View my Details");
						System.out.println("2. Vote");
						System.out.println("3. Logout");
						System.out.println("Enter your choice::");
						choice = sc.nextInt();

						if (choice == 1) {
							System.out.println("Enter Any Number To Continue:: ");
							int id = sc.nextInt();

							try {
								Voter vote = VoterService.searchById(id);
								if (vote != null) {
									System.out.println(vote.toString());
								} else {
									System.out.println("\n\n\n Records not present. \n\n\n");

								}
							} catch (IOException e) {
								System.out.println("Failed to get records.");
								e.printStackTrace();
							}
						} else if (choice == 2) {
							while (true) {
								System.out.println("Enter your ID");
								Integer id = sc.nextInt();
								System.out.println("List of Candidate : ");
								System.out.println("----------------------");
								VoterService.viewAllCandidate();
								System.out.println("----------------------");
								System.out.println("Choose Candidate : ");
								Integer cadidateId = sc.nextInt();
								Voting voting = new Voting(id, cadidateId);
								try {
									voteService.addVoting(voting);
									loginpage();
								} catch (Exception e) {
									System.out.println("You already voted.Come in next Election");
									loginpage();
								}
							}

						} else if (choice == 3) {

							loginpage();

						} else {
							System.err.println("Invalid Selection");
							
						}
					}
				}
			}
		}
	}

	private static void addcandidatepage() {

		CandidateService candidateService = new CandidateService();
		Candidate candidate = null;

		// candidate registration

		System.out.println("Enter First Name : ");
		String firstname = sc.next();

		System.out.println("Enter Last Name: ");
		String lastname = sc.nextLine();

		System.out.println("Enter Party Name: ");
		String partyname = sc.next();
		Candidate candidate1 = new Candidate(firstname, lastname, partyname);
		try {
			candidateService.addCandidate(candidate1);

		} catch (IOException | ClassNotFoundException | SQLException e) {
			System.out.println("Can't add voter. Please try again later.");
			e.printStackTrace();
		}
	}

	private static void checkdobPage() throws ClassNotFoundException, ParseException, SQLException, IOException {
		// checking if voters is eligible for voting
		System.out.println("Enter Date of Birth : yyyy-mm-dd");
		String checkdate = sc.next();
		LocalDate checkdob = LocalDate.parse(checkdate);
		LocalDate curDate = LocalDate.now();

		// calculates the amount of time between two dates
		int year = Period.between(checkdob, curDate).getYears();
		if ((checkdob != null) && (curDate != null) && (year > 17)) {
			System.out.println("You are " + year + " years old and eligible for voting");
			votersPage();
		} else if ((checkdob != null) && (curDate != null) && (year < 18)) {
			System.err.println("You are " + year + " years old and not eligible for voting");
			System.out.println("Thank You For Using Voting System");
			loginpage();

		} else {
			System.err.println("Invalid Entry ! ");
		}

	}

	private static void votersPage() throws ClassNotFoundException, ParseException, SQLException, IOException {

		VoterService voteService = new VoterService();
		Voter voter = null;

		// voter registration

		System.out.println("Enter First Name : ");
		String firstname = sc.next();

		System.out.println("Enter Last Name: ");
		String lastname = sc.next();

		
		// checking if voters is eligible for voting
				System.out.println("Enter Date of Birth : yyyy-mm-dd format");
				String dob = sc.next();
				LocalDate checkdob = LocalDate.parse(dob);
				LocalDate curDate = LocalDate.now();

				// calculates the amount of time between two dates
				int year = Period.between(checkdob, curDate).getYears();
				if ((checkdob != null) && (curDate != null) && (year > 17)) {
					LocalDate insertdob = LocalDate.parse(dob);
				} else if ((checkdob != null) && (curDate != null) && (year < 18)) {
					System.err.println("You are " + year + " years old and not eligible for voting");
					System.out.println("Thank You For Using Voting System");
					loginpage();

				} else {
					System.err.println("Invalid Entry ! ");
				}

		Gender g = null;
		while (true) {
			System.out.println("1.Male\t 2.Female\t 3.Others");
			System.out.println("Choose Gender : ");
			int genderChoice = sc.nextInt();
			if (genderChoice == 1) {
				g = Gender.MALE;
			} else if (genderChoice == 2) {
				g = Gender.FEMALE;
			} else if (genderChoice == 3) {
				g = Gender.OTHERS;
			} else {
				System.err.println("Invalid Option...");
				continue;
			}
			break;
		}

		System.out.println("Enter Username : ");
		String username = sc.next();

		System.out.println("Enter Password: ");
		String password = sc.next();

		Voter vote1 = new Voter(firstname, lastname, dob, g, username, password);
		try {
			voteService.addVoter(vote1);

		} catch (IOException | ClassNotFoundException | SQLException e) {
			System.out.println("Can't add voter. Please try again later.");
			e.printStackTrace();
		}
	}

}
