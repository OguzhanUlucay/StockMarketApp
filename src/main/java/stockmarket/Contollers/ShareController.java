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
import main.java.stockmarket.responses.ShareNotFoundException;
import main.java.stockmarket.responses.UserNotFoundException;
import main.java.stockmarket.DTOs.ShareDto;
import main.java.stockmarket.Entities.*;
import main.java.stockmarket.Handlers.ShareHandler;

@RestController
public class ShareController {

	private final ShareRepository repository;
	private final ShareHandler shareHandler;
	
	public ShareController(ShareRepository repository, ShareHandler shareHandler) {
		super();
		this.repository = repository;
		this.shareHandler = shareHandler;
	}
	
	@GetMapping("/shares")
	List<Share> all(){
		return repository.findAll();
	}
	
	@GetMapping("/shares/{shareCode}")
	Share getSpecifiedShare(@PathVariable String shareCode){
		return repository.findById(shareCode)
				.orElseThrow(() -> new ShareNotFoundException(shareCode));
	}
	
	@PostMapping("/shares")
	Share newShare(@RequestBody Share newShare) {
		shareHandler.createNewShareInfo(newShare.getShareCode(), newShare.getShareName());
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
	
	@GetMapping("/shares/sharesBook")
	List<ShareDto> getInfoAllShares() {
		return shareHandler.getInformationsAllShare();
	}
	
	@GetMapping("/shares/sharesBook/{shareCode}")
	List<ShareDto> getInfoSingleShare(@PathVariable String shareCode) {
		List<ShareDto> shareInfoList = shareHandler.getShareInfoList(shareCode);
		if(shareInfoList.size() != 0)
			return shareInfoList;
		else
			throw new ShareNotFoundException(shareCode);
	}
	
}
