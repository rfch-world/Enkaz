package az.developia.bookshopping.model;

import java.security.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Must be written") 
	@Size(min = 2,message = "Minimum value must be 2 at least")
	@Size(max = 30,message = "Maximum value must be 30 at least")
	@Column(columnDefinition = "VARCHAR (30)")
	private String name;
	
	@NotEmpty(message = "Must be written") 
	@Size(min = 2,message = "Minimum value must be 2 at least")
	@Size(max = 200,message = "Maximum value must be 200 at least")
	@Column(columnDefinition = "VARCHAR (200)")
	private String address;
	@NotEmpty(message = "Must be written")
	@Pattern(regexp = "((\\(\\d{3}\\ ?)|(\\d{3}-))?\\d{3}-\\d{4}",message = "Phone pattern must be :000-000-0000")
	@Column(columnDefinition = "VARCHAR (20)")
	@Size(max = 20,message = "Maximum value must be 20 at least")
	private String phone;
	@NotEmpty(message = "Must be written")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", message = "Write email correctly!")
	@Column(columnDefinition = "VARCHAR (100)")
	@Size(max = 100,message = "Maximum value must be 100 at least")
	private String email;
	@Column(columnDefinition = "VARCHAR (100)")
	@Size(max = 100,message = "Maximum value must be 100 at least")
	private String note;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", email="
				+ email + ", note=" + note + "]";
	}
	
	
	
}
