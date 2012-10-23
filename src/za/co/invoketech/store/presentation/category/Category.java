package za.co.invoketech.store.presentation.category;

import java.util.List;

public interface Category {
	
	String getName();
	List<Category> getSubCategories();
	void addSubCategory(Category category);
	Category getSubCategory(int index);
	Category getSubCategory(String index);
}
