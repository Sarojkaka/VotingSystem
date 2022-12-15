import java.time.LocalDate;
import java.util.Objects;


public class Voter {
	private Integer voterId;

    private String firstName;

    private String lastName;
    
    private Gender gender;
    
    private String dateOfBirth;
    
    private String username;
    
    private String password;
    
    private UserType usertype;
    

	public Voter(String firstName, String lastName, String dateOfBirth,Gender gender,String username, String password) {

		this.voterId = voterId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}



	public Voter() {
		super();
	}




	public Integer getVoterId() {
		return voterId;
	}

	public void setVoterId(Integer voterId) {
		this.voterId = voterId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public UserType getUsertype() {
		return usertype;
	}


	public void setUsertype(UserType usertype) {
		this.usertype = usertype;
	}

	@Override
	public String toString() {
		return "Voter [voterId=" + voterId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", dateOfBirth=" + dateOfBirth + ", username=" + username + ", password=" + password
				+ ", usertype=" + usertype + "]";
	}
	
}
