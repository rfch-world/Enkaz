package az.developia.bookshopping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.bookshopping.config.MySession;
import az.developia.bookshopping.dao.OrderDAO;
import az.developia.bookshopping.model.BasketBook;
import az.developia.bookshopping.model.Customer;
import az.developia.bookshopping.model.Order;

@Service
public class OrderService {

	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private MySession mySession;
	
	
	public List<Order> save(Customer customer){
		
		 List<BasketBook> basketBooks = mySession.getBasketBooks();
		 Order order=new Order();
		 order.setCustomer(customer);
		 order.setBasketBooks(basketBooks);
		 order.setNote(customer.getNote());
		 
		 System.out.println(order);
		 
		 

			ArrayList<String> usernames=new ArrayList<>();
			for (int i = 0; i < order.getBasketBooks().size(); i++) {
				BasketBook basketBook=order.getBasketBooks().get(i);
				if(usernames.contains(basketBook.getBook().getUsername())){}else{
					usernames.add(basketBook.getBook().getUsername());
				}
			}
			
			List<Order> orders=new ArrayList<>();
			
			for (int i = 0; i < usernames.size(); i++) {
				Order o=new Order();
				o.setNote(order.getNote());
				o.setCustomer(order.getCustomer());
				double totalPrice=0;
				
				for (int j = 0; j < order.getBasketBooks().size(); j++) {
					if( order.getBasketBooks().get(j).getBook().getUsername().equals(usernames.get(i))){
						o.getBasketBooks().add(order.getBasketBooks().get(j));
						totalPrice+=order.getBasketBooks().get(j).getBook().getPrice()*
								order.getBasketBooks().get(j).getCount();
					}
				}
				o.setTotalPrice(totalPrice);
				o.setUsername(usernames.get(i));
				orders.add(o);
			}
			
			mySession.setBasketBooks(null);
			return orderDAO.saveAll(orders);
			
			
	}
	
	
}
