package az.developia.bookshopping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message = "Must be written") 
	@Size(min = 2,message = "Minimum value must be 2 at least")
	@Size(max = 30,message = "Maximum value must be 30 at least")
	@Column(columnDefinition = "VARCHAR (30)")
	private String name;
	@Column(columnDefinition = "VARCHAR (255)")
	@Size(max=255,message = "Maximum value must be 255 at least")
	private String description;
	@Min(value =  0, message = "Minimum value must be 0")
	@Max(value = 1000,message = "Maximum value must be 1000" )
	@NotNull(message = "Must be written")
	private Double price;
	@Column(columnDefinition = "VARCHAR (30)")
	@NotEmpty(message = "Must be written")
	@Size(max = 30,message ="Maximum value must be 30 at least")
	private String author;
	@Min(value =  0, message = "Minimum value must be 0")
	@Max(value = 1000,message = "Maximum value must be 1000" )
	private Integer pageCount;
	private String image;
	private String username;
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
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
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", author="
				+ author + ", pageCount=" + pageCount + ", image=" + image + ", username=" + username + "]";
	}
	

}
