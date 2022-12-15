public enum UserType {
	
	ADMIN("ADMIN"),
	USER("USER");
	
	String value;
	
	UserType(String value) {
		this.value = value;
	}
	
	static UserType getByValue(String userType) {
		for (UserType g : UserType.values()) {
			if (g.value.equals(userType)) {
				return g;
			}
		}
		return null;
	}
}
