package za.co.invoketech.store.presentation.support;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DefaultCategory implements Category, Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private List<Category> subCategories;
	
	public DefaultCategory(String name) {
		this(name, new ArrayList<Category>());
	}
	
	public DefaultCategory(String name, List<Category> subCategories) {
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
		
		if(!(obj instanceof DefaultCategory)) {
			return false;
		}
		
		DefaultCategory simpleCat = (DefaultCategory)obj;
		if(!simpleCat.getName().equalsIgnoreCase(this.name)) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean hasSubCategories() {
		if(subCategories.size() != 0) {
			return true;
		}
		return false;
	}
}
