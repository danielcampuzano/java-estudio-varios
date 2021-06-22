package co.com.campu.business;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl {

	List<String> bookList = new ArrayList<>();
	List<String> musicList = new ArrayList<>();
	List<String> movieList = new ArrayList<>();
	
	public ProductServiceImpl() {
		bookList.add("Inferno");
		bookList.add("Joyland");
		
		musicList.add("BadGuy");
		musicList.add("novemberrain");
		
		movieList.add("Titanic");
		movieList.add("Gameofthrones");
	}
	
	public List<String> getProductCategories() {
		
		List<String> categories = new ArrayList<>();
		categories.add("Books");
		categories.add("Music");
		categories.add("Movies");
		
		return categories;
		
	}
	
	public List<String> getProducts(String category){
		switch(category) {
		case "books":
			return bookList;
		case "music":
			return musicList;
		case "movies":
			return movieList;
		}
		return null;
	}
	
}
