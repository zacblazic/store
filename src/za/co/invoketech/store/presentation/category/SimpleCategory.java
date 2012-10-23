package za.co.invoketech.store.presentation.category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SimpleCategory implements Category, Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private List<Category> subCategories;
	
	public SimpleCategory(String name) {
		this(name, new ArrayList<Category>());
	}
	
	public SimpleCategory(String name, List<Category> subCategories) {
		this.name = name;
		this.subCategories = subCategories;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public List<Category> getSubCategories() {
		return subCategories;
	}
	
	@Override
	public Category getSubCategory(int index) {
		return subCategories.get(index);
	}
	
	@Override
	public void addSubCategory(Category category) {
		subCategories.add(category);
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof SimpleCategory)) {
			return false;
		}
		
		SimpleCategory simpleCat = (SimpleCategory)obj;
		if(!simpleCat.getName().equalsIgnoreCase(this.name)) {
			return false;
		}
		
		return true;
	}

	@Override
	public Category getSubCategory(String index) {
		// TODO Auto-generated method stub
		return null;
	}
}
