package main.java.stockmarket.Contollers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import main.java.stockmarket.Repositories.ShareRepository;

import main.java.stockmarket.Entities.*;

@RestController
public class ShareController {

	private final ShareRepository repository;
	
	public ShareController(ShareRepository repository) {
		super();
		this.repository = repository;
	}
	
	@GetMapping("/shares")
	List<Share> all(){
		return repository.findAll();
	}
	
	@GetMapping("/shares/{shareCode}")
	Share getSpecifiedShare(@PathVariable String shareCode){
		return repository.getOne(shareCode); // TO DO: Add exception
	}
	
	@PostMapping("/shares")
	Share newShare(@RequestBody Share newShare) {
		return repository.save(newShare);
	}	
	
	@PutMapping("/shares/{shareCode}")
	Share replaceEmployee(@RequestBody Share newShare, @PathVariable String shareCode) {
		return repository.findById(shareCode)
				.map(share -> {
					share.setShareName(newShare.getShareName());
					return repository.save(share);
					})
				.orElseGet(() -> {
					newShare.setShareCode(shareCode);
					return repository.save(newShare);
				});
	}
	
	@DeleteMapping("/shares/{id}")
	void deleteShare(@PathVariable String shareCode) {
		repository.deleteById(shareCode);
	}
	
	
}
