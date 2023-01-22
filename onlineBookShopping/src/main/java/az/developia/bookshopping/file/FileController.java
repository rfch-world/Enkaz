package az.developia.bookshopping.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.net.HttpHeaders;
@Controller
public class FileController {
	private final StorageService storageService;

	@Autowired
	public FileController(StorageService storageService) {
		this.storageService =storageService;
	}
	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename){
	
	Resource file = storageService.loadAsResource(filename);
	return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
			"attachment; filename=\""+file.getFilename() + "\"").body(file);
	
	}
	
	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStoragefileNotFound(StorageFileNotFoundException exc){
		return ResponseEntity.notFound().build();
	}
	
}
