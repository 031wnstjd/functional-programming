package functionalprogramming.chapter6;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import functionalprogramming.chapter6.model.Order;
import functionalprogramming.chapter6.model.User;
import functionalprogramming.chapter6.model.Order.OrderStatus;

public class Chapter6Section4 {
	public static void main(String[] args) {
		User user1 = new User()
				.setId(101)
				.setName("Alice")
				.setVerified(true)
				.setEmailAddress("alice@fastcampus.co.kr");
		User user2 = new User()
				.setId(102)
				.setName("Bob")
				.setVerified(false)
				.setEmailAddress("bob@fastcampus.co.kr");
		User user3 = new User()
				.setId(103)
				.setName("Charlie")
				.setVerified(true)
				.setEmailAddress("charlie@fastcampus.co.kr");
		List<User> users = Arrays.asList(user1, user2, user3);
		
		List<String> emails = new ArrayList<>();
		for (User user : users) {
			if(!user.isVerified()) {
				String email = user.getEmailAddress();
				emails.add(email);
			}
		}
//		System.out.println(emails);
		
		List<String> emails2 = users.stream()
			.filter(user -> !user.isVerified())
			.map(User::getEmailAddress)
			.collect(Collectors.toList());
//		System.out.println(emails2);
		
		LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
		Order order1 = new Order()
				.setId(1001)
				.setStatus(OrderStatus.CREATED)
				.setCreatedByUserId(101)
				.setCreatedAt(now.minusHours(4));
		Order order2 = new Order()
				.setId(1002)
				.setStatus(OrderStatus.ERROR)
				.setCreatedByUserId(103)
				.setCreatedAt(now.minusHours(1));
		Order order3 = new Order()
				.setId(1003)
				.setStatus(OrderStatus.PROCESSED)
				.setCreatedByUserId(102)
				.setCreatedAt(now.minusHours(36));
		Order order4 = new Order()
				.setId(1004)
				.setStatus(OrderStatus.ERROR)
				.setCreatedByUserId(104)
				.setCreatedAt(now.minusHours(40));
		Order order5 = new Order()
				.setId(1005)
				.setStatus(OrderStatus.IN_PROGRESS)
				.setCreatedByUserId(101)
				.setCreatedAt(now.minusHours(10));
		List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);
		
		List<Long> userIds = orders.stream()
				.filter(order -> order.getStatus() == OrderStatus.ERROR)
				.map(Order::getCreatedByUserId)
				.collect(Collectors.toList());
//		System.out.println(userIds);
		
		List<Order> ordersInErrorStatusIn24hrs = orders.stream()
			.filter(order -> order.getStatus() == OrderStatus.ERROR)
			.filter(order -> order.getCreatedAt().isAfter(now.minusHours(24)))
			.collect(Collectors.toList());
		System.out.println(ordersInErrorStatusIn24hrs);
	}
}
