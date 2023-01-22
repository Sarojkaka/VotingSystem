
public class Candidate {
	private Integer candidateId;
	private String firstName;
	private String lastName;
	private String partyName;
	
	public Candidate( String firstName, String lastName, String partyName) {
		super();
		this.candidateId = candidateId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.partyName = partyName;
	}



	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
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

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", partyName=" + partyName + "]";
	}

}
