package collection;

import java.util.Objects;

public class User {
	String userid;
	String userpw;
	String username;
	
	public User(String userid, String userpw, String username) {
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
	}
	
	@Override
	public String toString() {
		return userid+"("+username+")";
	}

	@Override
	public int hashCode() {
		return Objects.hash(userid, username, userpw);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userid, other.userid) && Objects.equals(username, other.username)
				&& Objects.equals(userpw, other.userpw);
	}
	
	
}









