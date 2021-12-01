package groceryapp.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groceryapp.models.ShoppingList;
import groceryapp.repositories.ShoppingListRepository;

@Service
public class ShoppingListService {

	@Autowired
	private ShoppingListRepository repository;

	private List<ShoppingList> shoppingLists = Arrays.asList(new ShoppingList(1, "HEBZ"), new ShoppingList(2, "Walmartz"), new ShoppingList(3, "Fiestaz"));

	public ShoppingListService() {
		/*
		 * shoppingLists = new ArrayList<ShoppingList>(); shoppingLists.add(new ShoppingList(1, "HEBZ")); shoppingLists.add(new ShoppingList(2, "Walmartz")); shoppingLists.add(new ShoppingList(3, "Fiestaz"));
		 */
	}

	public void addShoppingList(ShoppingList sl) {
		repository.save(sl);
		// this.shoppingLists.add(sl);
	}

	public void updateShoppingList(ShoppingList sl) {
		ShoppingList ret = getShoppingListById(sl.getId()); // Returns an Optional
		if (ret != null)
			repository.save(sl); // .save() will do an update if the rec exists
		// this.shoppingLists.add(sl);
	}

	public void deleteShoppingList(int id) {
		ShoppingList ret = getShoppingListById(id); // Returns an Optional
		if (ret != null)
			repository.deleteById(id);
		// ShoppingList sl = getShoppingListById(id);
		// shoppingLists.remove(sl);
	}

	public List<ShoppingList> getAllShoppingLists() {
		List<ShoppingList> shoppingList = new ArrayList<>();
		repository.findAll().forEach(shoppingList::add);
		// repository.findAll().forEach(x -> shoppingList.add(x));
		return shoppingList;
		// return shoppingLists;
	}

	public ShoppingList getShoppingListById(int id) {
		return repository.findById(id).orElse(null); // Returns an Optional
		// return this.shoppingLists.stream().filter(x -> x.getId() == id).findFirst().get();
		// return shoppingLists.get(id); // This will return the idx not the value in the id!
	}
}