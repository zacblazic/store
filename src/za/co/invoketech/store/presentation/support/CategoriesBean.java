package za.co.invoketech.store.presentation.support;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ApplicationScoped
@ManagedBean(eager = true)
public class CategoriesBean {

	private List<Category> categories;
	
	public CategoriesBean() {
		categories = new ArrayList<Category>();
		
		// Components
		Category components = new DefaultCategory("Components");
		components.addSubCategory(new DefaultCategory("Graphics Cards"));
		components.addSubCategory(new DefaultCategory("Memory"));
		components.addSubCategory(new DefaultCategory("Motherboards"));
		components.addSubCategory(new DefaultCategory("Power Supply Units"));
		components.addSubCategory(new DefaultCategory("Processors"));
		
		Category internalStorage = new DefaultCategory("Internal Storage");
		internalStorage.addSubCategory(new DefaultCategory("Hard Disk Drives"));
		internalStorage.addSubCategory(new DefaultCategory("Solid State Drives"));
		components.addSubCategory(internalStorage);
		categories.add(components);
		
		// Software
		Category software = new DefaultCategory("Software");
		software.addSubCategory(new DefaultCategory("Antivirus"));
		software.addSubCategory(new DefaultCategory("Games"));
		software.addSubCategory(new DefaultCategory("Operating Systems"));
		categories.add(software);
		
		// Computers
		Category computers = new DefaultCategory("Computers");
		computers.addSubCategory(new DefaultCategory("Custom Computers"));
		computers.addSubCategory(new DefaultCategory("Pre-buit Computers"));
		categories.add(computers);
		
		// Peripherals
		Category peripherals = new DefaultCategory("Peripherals");
		peripherals.addSubCategory(new DefaultCategory("Audio"));
		peripherals.addSubCategory(new DefaultCategory("Displays"));
		peripherals.addSubCategory(new DefaultCategory("Keyboards"));
		peripherals.addSubCategory(new DefaultCategory("Mice"));
		categories.add(peripherals);
	}
	
	public List<Category> getCategories() {
		return categories;
	}
}
