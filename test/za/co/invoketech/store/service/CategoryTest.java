package za.co.invoketech.store.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import za.co.invoketech.store.presentation.support.Category;
import za.co.invoketech.store.presentation.support.DefaultCategory;

public class CategoryTest {

	@Test
	public void test() {
		
		List<Category> components = new ArrayList<Category>();

		/*---------Component---------*/
		components.add(new DefaultCategory("Component"));
		
		components.get(0).addSubCategory(new DefaultCategory("Chassis"));
		
		components.get(0).addSubCategory(new DefaultCategory("Processor"));
		components.get(0).getSubCategory(1).addSubCategory(new DefaultCategory("Intel"));
		components.get(0).getSubCategory(1).addSubCategory(new DefaultCategory("AMD"));
		
		components.get(0).addSubCategory(new DefaultCategory("Motherboard"));
		components.get(0).getSubCategory(2).addSubCategory(new DefaultCategory("Intel"));
		components.get(0).getSubCategory(2).addSubCategory(new DefaultCategory("AMD"));
		
		components.get(0).addSubCategory(new DefaultCategory("Graphics Card"));
		components.get(0).getSubCategory(3).addSubCategory(new DefaultCategory("Nvidia"));
		components.get(0).getSubCategory(3).addSubCategory(new DefaultCategory("ATi"));
		
		components.get(0).addSubCategory(new DefaultCategory("Memory"));
		
		components.get(0).addSubCategory(new DefaultCategory("Power Supply"));
		
		components.get(0).addSubCategory(new DefaultCategory("Internal Storage"));
		components.get(0).getSubCategory(6).addSubCategory(new DefaultCategory("Hard Disk Drive"));
		components.get(0).getSubCategory(6).addSubCategory(new DefaultCategory("Solid State Drive"));
		
		/*---------Computer---------*/
		components.add(new DefaultCategory("Computer"));
		components.get(1).addSubCategory(new DefaultCategory("Custom Computer"));
		components.get(1).addSubCategory(new DefaultCategory("Pre-Built Computer"));
		
		/*---------Peripheral---------*/		
		components.add(new DefaultCategory("Peripheral"));
		components.get(2).addSubCategory(new DefaultCategory("Audio"));
		components.get(2).addSubCategory(new DefaultCategory("Display"));
		components.get(2).addSubCategory(new DefaultCategory("Keyboard"));
		components.get(2).addSubCategory(new DefaultCategory("Mouse"));
		
		/*---------Software---------*/
		components.add(new DefaultCategory("Software"));
		components.get(3).addSubCategory(new DefaultCategory("Anti Virus"));
		components.get(3).addSubCategory(new DefaultCategory("Game"));
		components.get(3).addSubCategory(new DefaultCategory("Operating System"));
		
		
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
