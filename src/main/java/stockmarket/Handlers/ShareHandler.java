package main.java.stockmarket.Handlers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import main.java.stockmarket.DTOs.*;

@Component
public class ShareHandler {
	
	private HashMap<String, List<ShareDto>> shareInformations;
	private RandomValueHandler randomValueHandler;
	
	public ShareHandler(RandomValueHandler randomValueHandler) {
		shareInformations = new HashMap<String, List<ShareDto>>();
		this.randomValueHandler = randomValueHandler;
	}
	
	
	// Create new share information.
	// it adds different price and counts for same share.
	public void createNewShareInfo(String shareCode, String shareName) {
		//List<ShareDto> infoList;
		String dateTime = extractDate();
		// Add try-catch
		double price = randomValueHandler.generateRandomDoubleInRange(0.50, 26.00);
		int count = randomValueHandler.generateRandomIntInRange(1, 200);
				
		ShareDto newShareDto = new ShareDto(shareCode, shareName, price, count, dateTime);
		
		getShareInfoList(shareCode).add(newShareDto);
		//shareInformations.put(shareCode, newShareInfo);
	}
	
	// Get reference of information list of specific share.
	public List<ShareDto> getShareInfoList(String shareCode){
		boolean shareInfoExist = shareInformations.containsKey(shareCode);
		
		if(!shareInfoExist)
			shareInformations.put(shareCode, new ArrayList<ShareDto>());
			
		return shareInformations.get(shareCode);
	}

	private String extractDate() {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); 
	    String formattedDate = myDateObj.format(myFormatObj); 
		return formattedDate;
	}
	

	public List<ShareDto> getInformationsAllShare() {
		List<ShareDto> resultList = new ArrayList<ShareDto>();
		shareInformations.values().forEach(resultList::addAll);
		return resultList;
	}

	

//	private <T> generateRandomValue(){
//		
//	}
	
}
