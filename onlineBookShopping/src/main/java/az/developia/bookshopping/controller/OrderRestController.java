package az.developia.bookshopping.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.bookshopping.config.MySession;
import az.developia.bookshopping.dao.BookDAO;
import az.developia.bookshopping.dao.OrderDAO;
import az.developia.bookshopping.model.BasketBook;
import az.developia.bookshopping.model.Book;
import az.developia.bookshopping.model.Order;

@RestController
@RequestMapping(path = "/rest/orders")
public class OrderRestController {

	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private MySession mySession;
	

	@GetMapping
	public List<Order> findAll() {
		return orderDAO.findAll();
	}

	@PostMapping
	public List<Order> save(@RequestBody Order order) {

		ArrayList<String> usernames = new ArrayList<>();
		for (int i = 0; i < order.getBasketBooks().size(); i++) {
			BasketBook basketBook = order.getBasketBooks().get(i);
			if (usernames.contains(basketBook.getBook().getUsername())) {
			
			}

		}
		List<Order> orders=new ArrayList<>();
		
		for (int i = 0; i < usernames.size(); i++) {
			Order o=new Order();
			o.setNote(order.getNote());
			o.setCustomer(order.getCustomer());
			double totalPrice=0;
			for (int j = 0; j < order.getBasketBooks().size(); j++) {
				if (order.getBasketBooks().get(j).getBook().getUsername().equals(usernames.get(i))){
					o.getBasketBooks().add(order.getBasketBooks().get(j));
					totalPrice+=order.getBasketBooks().get(j).getBook().getPrice()*
							order.getBasketBooks().get(j).getCount();
					}
			}
			o.setTotalPrice(totalPrice);
			o.setUsername(usernames.get(i));
			orders.add(o);
			
		}
		return orderDAO.saveAll(orders);
	}

	@GetMapping(path = "/{id}")
	public Order findById(@PathVariable(name = "id") Integer id) {
		return orderDAO.findById(id).get();
	}

	@GetMapping(path = "/{username}")
	public List<Order> findAllByUsername(@PathVariable(name = "username") String username) {
		return orderDAO.findAllByUsername(username);
	}
	
	@PostMapping(path = "/save-basket-books")
	public Boolean saveBasketBooks(@RequestBody List<BasketBook> basketBooks) {
		System.out.println(basketBooks);
		mySession.setBasketBooks(basketBooks);
		
		return true;
	}
	
	
}
