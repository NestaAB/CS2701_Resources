package com.example.demo;

import com.example.demo.Models.*;
import com.example.demo.Repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DatabaseInit implements CommandLineRunner{
	@Autowired 
	private UserRepository userRepository;

	@Autowired 
	private ProduceRepository produceRepository;
	
	@Autowired
	private SellerProduceRepository sellerProduceRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Autowired
	private OrderRepository orderRepository; 




	@Override
	 public void run(String... args) throws Exception {
		userRepository.deleteAll();
		
		//-----------------Users--------------------
		User user1 = new User("Bob","bob@sample.com", "largePeen", UserType.BUYER);
		userRepository.save(user1);
		
		User prapanch = new User("Prapanch", "prapanch@gmail.com", "seller", UserType.BUYER);
		userRepository.save(prapanch);

		User bleesh = new User("Bleesh", "shortmen@gmail.com", "smol", UserType.BOTH);
		userRepository.save(bleesh);

		User ademola = new User("Ademola", "ademola@gmail.com", "AdemolaPass", UserType.BOTH);
		userRepository.save(ademola);

		User zhixian = new User("Zhixian", "zhixian@gmail.com", "Tester", UserType.SELLER);
		userRepository.save(zhixian);
		
		//---------------Produce---------------
		Produce apple = new Produce("Apple");
		produceRepository.save(apple);

		Produce jam = new Produce("Jam");
		produceRepository.save(jam);

		Produce lettuce = new Produce("Lettuce");
		produceRepository.save(lettuce);

		Produce potatoes = new Produce("Potatoes");
		produceRepository.save(potatoes);

		//-------------SellerProduce-----------
		SellerProduce sp1 = new SellerProduce(prapanch, apple, 0.15, 100);
		sellerProduceRepository.save(sp1);

		SellerProduce sp2 = new SellerProduce(bleesh, jam, 1.35, 50);
		sellerProduceRepository.save(sp2);

		SellerProduce sp3 = new SellerProduce(prapanch, lettuce, 0.25, 20);
		sellerProduceRepository.save(sp3);

		SellerProduce sp4 = new SellerProduce(ademola, apple, 0.30, 50);
		sellerProduceRepository.save(sp4);

		SellerProduce sp5= new SellerProduce(ademola, potatoes, 0.05, 30);
		sellerProduceRepository.save(sp5);

		//------------- OrderItems & Orders ------------
		
		//Orders
		Order order1 = new Order(user1);
		orderRepository.save(order1);

		Order order2 = new Order(bleesh);
		orderRepository.save(order2);

		//Order Items

		//Order 1 Items
		OrderItem oi1 = new OrderItem(order1, sp3, 2, sp3.getPrice());
		orderItemRepository.save(oi1);

		OrderItem oi2 = new OrderItem(order1, sp1, 1, sp1.getPrice());
		orderItemRepository.save(oi2);

		//Order 2 Items
		OrderItem oi3 = new OrderItem(order2, sp4, 3, sp4.getPrice());
		orderItemRepository.save(oi3);

		OrderItem oi4 = new OrderItem(order2, sp5, 2, sp5.getPrice());
		orderItemRepository.save(oi4);


	
		
	}
}
