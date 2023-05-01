package functionalprogramming.chapter10.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class User {
	private int id;
	private String name;
	private String emailAddress;
	private boolean isVerified;
	private LocalDateTime createdAt;
	private List<Integer> friendUserIds;
	
	public User(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.emailAddress = builder.emailAddress;
		this.isVerified = builder.isVerified;
		this.createdAt = builder.createdAt;
		this.friendUserIds = builder.friendUserIds;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Optional<String> getEmailAddress() {
		return Optional.ofNullable(emailAddress);
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	public boolean isVerified() {
		return isVerified;
	}
	
	public List<Integer> getFriendUserIds() {
		return friendUserIds;
	}
	
	public static Builder builder(int id, String name) {
		return new Builder(id, name);
	}
	
	public static class Builder {
		private int id;
		private String name;
		public String emailAddress;
		public boolean isVerified;
		public LocalDateTime createdAt;
		public List<Integer> friendUserIds = new ArrayList<>(); // default 값 설정하여 null이 아닌 값이 되게끔 함
		
		private Builder(int id, String name) {
			this.id = id;
			this.name = name;
		}
		
		public Builder with(Consumer<Builder> consumer) {
			consumer.accept(this); // 전달 받은 consumer에 this를 인자로 넘겨 실행
			return this;
		}
		
		public User build() {
			return new User(this);
		}
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", " + (name != null ? "name=" + name + ", " : "")
				+ (emailAddress != null ? "emailAddress=" + emailAddress + ", " : "") + "isVerified=" + isVerified
				+ ", " + (friendUserIds != null ? "friendUserIds=" + friendUserIds : "") + "]";
	}
	
	
}
