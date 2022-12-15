
public class Voting {
	Integer votingId;
	String votingStatus;
	Integer cadidateId;
	Integer id;
	public Voting(Integer id,Integer cadidateId) {
		super();
		this.votingId = votingId;
		this.votingStatus = votingStatus;
		this.cadidateId = cadidateId;
		this.id = id;
	}

	public Integer getVotingId() {
		return votingId;
	}
	public void setVotingId(Integer votingId) {
		this.votingId = votingId;
	}
	public String getVotingStatus() {
		return votingStatus;
	}
	public void setVotingStatus(String votingStatus) {
		this.votingStatus = votingStatus;
	}
	public Integer getCadidateId() {
		return cadidateId;
	}
	public void setCadidateId(Integer cadidateId) {
		this.cadidateId = cadidateId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
