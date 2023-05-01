package functionalprogramming.chapter10.service;

import functionalprogramming.chapter10.model.User;

public interface EmailProvider {
	String getEmail(User user);
}
