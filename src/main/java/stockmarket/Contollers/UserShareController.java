package main.java.stockmarket.Contollers;

import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.java.stockmarket.Repositories.*;
import main.java.stockmarket.responses.*;
import main.java.stockmarket.Entities.*;

@RestController
public class UserShareController {

	// TO DO: Check if user exist
	private final UserRepository userRepository;
	private final ShareRepository shareRepository;
	private final UserShareRepository userShareRepository;
	
	//private final Map<Long, Map<String, Map<Double, Integer>>> userShare;
	

	public UserShareController(UserRepository userRepository, ShareRepository shareRepository, UserShareRepository userShareRepository) {
		super();
		this.userRepository = userRepository;
		this.shareRepository = shareRepository;
		this.userShareRepository = userShareRepository;
		//this.userShare = new HashMap<Long, Map<String, Map<Double, Integer>>>();
	}
	 
	@PostMapping("/users/{userId}/shares/{shareCode}")
	UserShare newUser(@PathVariable Long userId, @PathVariable String shareCode, @RequestParam double price, @RequestParam int count) {
		UserShareKey userShareKey;
		UserShare userShare;

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException(userId));
		Share share =  shareRepository.findById(shareCode)
				.orElseThrow(() -> new ShareNotFoundException(shareCode));

		userShareKey = new UserShareKey(userId, shareCode, price);
		user = userRepository.getOne(userId);
		share = shareRepository.getOne(shareCode);
		userShare = new UserShare(userShareKey, user, share, count);
			
		user.getUserShare().add(userShare);
		share.getUserShare().add(userShare);
		
		userRepository.save(user);
		shareRepository.save(share);
		userShareRepository.save(userShare);
			
		return userShare;
	}
	
	@GetMapping("/users/{userId}/shares")
	List<UserShare> getOne(@PathVariable Long userId) {
		
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException(userId));
		Set<UserShare> userShares = user.getUserShare();

		return new ArrayList<UserShare>(userShares);
	}
	
	@DeleteMapping("/users/{userId}/shares/{shareCode}")
	void deleteEmployee(@PathVariable Long userId, @PathVariable String shareCode, @RequestParam double price) {
		UserShareKey userShareKey;
		UserShare userShare;
		
		userShareKey = new UserShareKey(userId, shareCode, price);
		userShareRepository.deleteById(userShareKey);
		
	}
	
}
