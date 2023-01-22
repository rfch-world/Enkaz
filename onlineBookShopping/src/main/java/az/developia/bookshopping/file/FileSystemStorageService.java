package az.developia.bookshopping.file;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileSystemStorageService implements StorageService {

	private final Path rootLocation;

	@Autowired
	public FileSystemStorageService(StorageProperties properties) {
		this.rootLocation = Paths.get(properties.getLocation());
	}

	@Override
	public void init() {
		try {
			Files.createDirectories(rootLocation);
		} catch (IOException e) {
			throw new StorageException("File could not be found!", e);
		}

	}

	@Override
	public String store(MultipartFile file) {
		if (file.isEmpty()) {
			return "fakeimage.png";
		}
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		String randomFileName = "";
		try {
			try (InputStream inputStream = file.getInputStream()) {
				String originalFileName = file.getOriginalFilename();
				UUID uuid = UUID.randomUUID();
				randomFileName = originalFileName
						.replace(originalFileName.substring(0, originalFileName.lastIndexOf(".")), uuid.toString());

				Files.copy(inputStream, this.rootLocation.resolve(randomFileName), StandardCopyOption.REPLACE_EXISTING);
			}
		} catch (IOException e) {

			throw new StorageException("File can not be saved!: " + filename, e);
		}
		return randomFileName;
	}

	@Override
	public Path load(String filename) {
		return rootLocation.resolve(filename);
	}

	@Override
	public Resource loadAsResource(String filename) {
		try {
			Path file = load(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new StorageFileNotFoundException("File could not be read!: " + filename);
			}
		} catch (MalformedURLException e) {
			throw new StorageFileNotFoundException("File could not be read!: " + filename, e);
		}
	}

	@Override
	public void delete() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}
}
