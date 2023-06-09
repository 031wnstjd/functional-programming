package functionalprogramming.chapter8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import functionalprogramming.chapter8.model.User;
import functionalprogramming.chapter8.service.EmailService;

public class Chapter8Section9 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(3, 5, 2, 1);
//		numbers.stream().forEach(number -> System.out.println("The number is " + number));
		numbers.forEach(number -> System.out.println("The number is " + number));
		
		User user1 = new User()
				.setId(101)
				.setName("Alice")
				.setEmailAddress("alice@fastcampus.co.kr")
				.setVerified(true);
		User user2 = new User()
				.setId(102)
				.setName("Bob")
				.setEmailAddress("bob@fastcampus.co.kr")
				.setVerified(false);
		User user3 = new User()
				.setId(103)
				.setName("Charlie")
				.setEmailAddress("charlie@fastcampus.co.kr")
				.setVerified(false);
		List<User> users = Arrays.asList(user1, user2, user3);
		
		EmailService emailService = new EmailService();
		users.stream()
			.filter(user -> !user.isVerified())
			.forEach(emailService::sendVerifyYourEmailEmail);
		
//		for (int i = 0; i < users.size(); i++) {
//			User user = users.get(i);
//			System.out.println("Do an operation on user " + user.getName() + "at index " + i);
//		}
	
		IntStream.range(0, users.size()).forEach(i -> {
			User user = users.get(i);
			System.out.println("Do an operation on user " + user.getName() + "at index " + i);
		});
	}

}
