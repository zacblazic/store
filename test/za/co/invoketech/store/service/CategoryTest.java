package za.co.invoketech.store.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import za.co.invoketech.store.presentation.category.Category;
import za.co.invoketech.store.presentation.category.SimpleCategory;

public class CategoryTest {

	@Test
	public void test() {
		
		List<Category> components = new ArrayList<Category>();

		/*---------Component---------*/
		components.add(new SimpleCategory("Component"));
		
		components.get(0).addSubCategory(new SimpleCategory("Chassis"));
		
		components.get(0).addSubCategory(new SimpleCategory("Processor"));
		components.get(0).getSubCategory(1).addSubCategory(new SimpleCategory("Intel"));
		components.get(0).getSubCategory(1).addSubCategory(new SimpleCategory("AMD"));
		
		components.get(0).addSubCategory(new SimpleCategory("Motherboard"));
		components.get(0).getSubCategory(2).addSubCategory(new SimpleCategory("Intel"));
		components.get(0).getSubCategory(2).addSubCategory(new SimpleCategory("AMD"));
		
		components.get(0).addSubCategory(new SimpleCategory("Graphics Card"));
		components.get(0).getSubCategory(3).addSubCategory(new SimpleCategory("Nvidia"));
		components.get(0).getSubCategory(3).addSubCategory(new SimpleCategory("ATi"));
		
		components.get(0).addSubCategory(new SimpleCategory("Memory"));
		
		components.get(0).addSubCategory(new SimpleCategory("Power Supply"));
		
		components.get(0).addSubCategory(new SimpleCategory("Internal Storage"));
		components.get(0).getSubCategory(6).addSubCategory(new SimpleCategory("Hard Disk Drive"));
		components.get(0).getSubCategory(6).addSubCategory(new SimpleCategory("Solid State Drive"));
		
		/*---------Computer---------*/
		components.add(new SimpleCategory("Computer"));
		components.get(1).addSubCategory(new SimpleCategory("Custom Computer"));
		components.get(1).addSubCategory(new SimpleCategory("Pre-Built Computer"));
		
		/*---------Peripheral---------*/		
		components.add(new SimpleCategory("Peripheral"));
		components.get(2).addSubCategory(new SimpleCategory("Audio"));
		components.get(2).addSubCategory(new SimpleCategory("Display"));
		components.get(2).addSubCategory(new SimpleCategory("Keyboard"));
		components.get(2).addSubCategory(new SimpleCategory("Mouse"));
		
		/*---------Software---------*/
		components.add(new SimpleCategory("Software"));
		components.get(3).addSubCategory(new SimpleCategory("Anti Virus"));
		components.get(3).addSubCategory(new SimpleCategory("Game"));
		components.get(3).addSubCategory(new SimpleCategory("Operating System"));
		
		
		for(Category c : components) {
			System.out.println("L1 - " + c);
			for(Category g : c.getSubCategories()) {
				System.out.println("\tL2 - " + g.getName());
				for(Category f : g.getSubCategories()) {
					System.out.println("\t\tL3 - " + f.getName());
				}
			}
		}
	}
}
