package az.developia.bookshopping.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import az.developia.bookshopping.config.MySession;
import az.developia.bookshopping.dao.BookDAO;
import az.developia.bookshopping.dao.CustomerDAO;
import az.developia.bookshopping.dao.OrderDAO;
import az.developia.bookshopping.model.BasketBook;
import az.developia.bookshopping.model.Book;
import az.developia.bookshopping.model.Customer;
import az.developia.bookshopping.model.Order;
import az.developia.bookshopping.service.OrderService;

@Controller
public class OrderController {

	
	@Autowired
	private MySession mySession;
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@GetMapping(path = "/orders")
	public String showOrdersPage(Model model) {
		model.addAttribute("orders", orderDAO.findAllByUsername(mySession.getUsername()));
		return "orders";
	
	}
	@GetMapping(path = "/confirm-order")
	public String showConfirmOrderPage(Model model) {
		Customer customer=new Customer();
		model.addAttribute("customer", customer);
	
		return "confirm-order";
	
	}
	@GetMapping(path = "/order-confirmation-message")
	public String showOrderConfirmationPage(Model model) {
		
		return "order-confirmation-message";
	
	}
	
	
	@PostMapping(path = "/confirm-order-process")
	public String confirmOrderProcess(@Valid @ModelAttribute(name = "customer") Customer customer,BindingResult result) {
	if (result.hasErrors()) {
		return  "confirm-order";
	}
	
	Customer customerFindByPhone=customerDAO.findByPhone(customer.getPhone());
	if (customerFindByPhone==null) {
		
		
		Customer customerFindByEmail=customerDAO.findByEmail(customer.getEmail());

		if (customerFindByEmail==null) {}else {
			Integer id=customerFindByEmail.getId();
			customer.setId(id);
			customerDAO.save(customer);
			customer=customerDAO.findById(id).get();
			
		}
		
	}else {
		Integer id=customerFindByPhone.getId();
		customer.setId(id);
		customerDAO.save(customer);
		customer=customerDAO.findById(id).get();
	}
	orderService.save(customer);
	
		return  "redirect:/order-confirmation-message";
	
	}

}
