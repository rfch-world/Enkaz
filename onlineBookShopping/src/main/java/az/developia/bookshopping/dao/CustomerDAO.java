package az.developia.bookshopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.bookshopping.model.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {
public Customer findByPhone(String phone);
public Customer findByEmail(String email);

}