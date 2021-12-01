package groceryapp.repositories;

import org.springframework.data.repository.CrudRepository;

import groceryapp.models.ShoppingList;

public interface ShoppingListRepository extends CrudRepository<ShoppingList, Integer> {
}
