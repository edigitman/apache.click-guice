package ro.agitman.model.mo;

import java.util.HashSet;
import java.util.Set;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("user")
public class User {

	@Id
	private ObjectId id;
	private String name;
	private String password;
	private Set<String> roles = new HashSet<>();

	public User(String name, String password, Set<String> roles) {
		super();
		this.name = name;
		this.password = password;
		this.roles = roles;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	/*
	 * ============================================= BUILDE PATTERN =============================================
	 */

	public static class Builder {

		private ObjectId id;
		private String name;
		private String password;
		private Set<String> roles;

		public Builder() {
		}

		public Builder(User u) {
			this.id = u.getId();
			this.name = u.getName();
			this.password = u.getPassword();
			this.roles = u.getRoles();
		}

		public Builder id(ObjectId id) {
			this.id = id;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public Builder roles(Set<String> roles) {
			this.roles = roles;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}

	private User(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.password = builder.password;
		this.roles = builder.roles;
	}
}
