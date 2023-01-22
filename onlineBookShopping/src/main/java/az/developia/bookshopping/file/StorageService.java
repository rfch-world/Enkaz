package az.developia.bookshopping.file;

import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
	void init();//qovluq yaradir
	String store(MultipartFile file);//file yadda saxlayib geriye file adini qaytaracaq
	Path load(String filename);//file'in path'ini qaytaracaq adina gore
	Resource loadAsResource(String filename);//file'in ozunu qaytaracaq
	void delete();//file'larin hamisini silecek
	

}
