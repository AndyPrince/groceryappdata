package groceryapp.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import groceryapp.models.ShoppingList;
import groceryapp.services.ShoppingListService;

@RestController
public class ShoppingListController {

	@Autowired
	private ShoppingListService service;

	private List<ShoppingList> shoppingLists = Arrays.asList(new ShoppingList("HEB"), new ShoppingList("Walmart"));

	@RequestMapping("/shoppinglists")
	public List<ShoppingList> getShoppingLists() {
		return this.service.getAllShoppingLists();
		// return this.shoppingLists;
	}

	// @RequestMapping(method=RequestMethod.POST, value= "/shoppinglist/")
	// public ShoppingList addShoppingList(@RequestBody ShoppingList shoppingList) {
	// return shoppingList;
	// }

	@RequestMapping(method = RequestMethod.POST, value = "/shoppinglist/")
	public void addShoppingList(@RequestBody ShoppingList sl) {
		service.addShoppingList(sl);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/shoppinglist/")
	public void updateShoppingList(@RequestBody ShoppingList sl) {
		service.updateShoppingList(sl);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/shoppinglist/")
	public void deleteShoppingList(@RequestBody ShoppingList sl) {
		System.out.println("deleteShoppingList().deleteShoppingList() sl=" + sl);
		service.deleteShoppingList(sl.getId());
	}

	@RequestMapping("/shoppinglist/{id}")
	public ShoppingList getShoppingList(@PathVariable int id) {
		return service.getShoppingListById(id);
		// return new ShoppingList(title);
	}

	@RequestMapping("/shoppinglist")
	public ShoppingList getShoppingList() {
		ShoppingList shoppingList = new ShoppingList();
		shoppingList.setTitle("Walmart");
		return shoppingList;
	}

	// http://localhost:8080/
	@RequestMapping("/")
	public String hello() {
		return "Hello World";
	}
}