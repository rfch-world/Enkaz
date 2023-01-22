package az.developia.bookshopping.file;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {//qovluqun adi
	private String location ="upload-dir-book-shopping-spring-ajax";

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
