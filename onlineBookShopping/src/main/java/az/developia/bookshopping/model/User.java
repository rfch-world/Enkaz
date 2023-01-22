package az.developia.bookshopping.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {

@Size(min = 1,message = "User's name must contain minimum 1 letter at least")
@Size(max = 30,message ="User's name must contain maximum 30 letter at least")
@NotEmpty(message = "Must be written") 
private String username;
@Size(min = 1,message = "Password must contain minimum 1 letter at least")
@Size(max = 30,message ="Password name must contain maximum 30 letter at least")
@NotEmpty(message = "Must be written") 
private String password;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "User [username=" + username + ", password=" + password + "]";
}
}
