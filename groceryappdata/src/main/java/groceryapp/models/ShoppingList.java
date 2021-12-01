package groceryapp.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShoppingList {
	@Id
	private int id;
	private String title;
	private Date date;

	public ShoppingList() {
	}

	public ShoppingList(String title) {
		super();
		this.title = title;
	}

	public ShoppingList(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
}
