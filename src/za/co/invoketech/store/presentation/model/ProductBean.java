/**
 * Copyright (c) 2012 Invoke Tech
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package za.co.invoketech.store.presentation.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import za.co.invoketech.store.presentation.support.Category;
import za.co.invoketech.store.presentation.support.SimpleCategory;

/**
 * @author a.carel.g.nel@gmail.com (Carel Nel)
 */

@SessionScoped
@ManagedBean
public class ProductBean implements Serializable {
		
	private static final long serialVersionUID = 1L;
	private List<Category> categories = new ArrayList<Category>();
	private List<Category> subCategories = new ArrayList<Category>();
	private List<Category> subSubCategories = new ArrayList<Category>();
	private String selected;
	private String subSelected;
	private String subSubSelected;
	private boolean hasMoreSubCategories;
	private boolean hasMoreSubSubCategories;
	private String component;
	private boolean componentFound;
	
	// show, hide elements
	private boolean showProcessorElement;
	private boolean showGraphicsCardElement;
	private boolean showMotherboardElement;
	private boolean showHardDiskDriveElement;
	private boolean showSolidStateDriveElement;
	private boolean showMemoryElement;
	private boolean showPowerSupplyInitElement;
	private boolean showCustomComputerElement;
	private boolean showPreBuiltComputerElement;
	private boolean showAudioElement;
	private boolean showDisplayElement;
	private boolean showKeyboardElement;
	private boolean showMouseElement;
	private boolean showAntiVirusElement;
	private boolean showGameElement;
	private boolean showOperatingSystemElement;
	
	public ProductBean() {
		System.out.println("construct method..........");
		initialiseCategoryList();
		hasMoreSubCategories = false;
		componentFound = false;	
		
		showGraphicsCardElement = true;
	}
	
	public boolean isShowSolidStateDriveElement() {
		return showSolidStateDriveElement;
	}

	public void setShowSolidStateDriveElement(boolean showSolidStateDriveElement) {
		this.showSolidStateDriveElement = showSolidStateDriveElement;
	}

	public boolean isShowGraphicsCardElement() {
		return showGraphicsCardElement;
	}

	public void setShowGraphicsCardElement(boolean showGraphicsCardElement) {
		this.showGraphicsCardElement = showGraphicsCardElement;
	}

	public boolean isShowMotherboardElement() {
		return showMotherboardElement;
	}

	public void setShowMotherboardElement(boolean showMotherboardElement) {
		this.showMotherboardElement = showMotherboardElement;
	}

	public boolean isShowHardDiskDriveElement() {
		return showHardDiskDriveElement;
	}

	public void setShowHardDiskDriveElement(boolean showHardDiskDriveElement) {
		this.showHardDiskDriveElement = showHardDiskDriveElement;
	}

	public boolean isShowMemoryElement() {
		return showMemoryElement;
	}

	public void setShowMemoryElement(boolean showMemoryElement) {
		this.showMemoryElement = showMemoryElement;
	}

	public boolean isShowPowerSupplyInitElement() {
		return showPowerSupplyInitElement;
	}

	public void setShowPowerSupplyInitElement(boolean showPowerSupplyInitElement) {
		this.showPowerSupplyInitElement = showPowerSupplyInitElement;
	}

	public boolean isShowCustomComputerElement() {
		return showCustomComputerElement;
	}

	public void setShowCustomComputerElement(boolean showCustomComputerElement) {
		this.showCustomComputerElement = showCustomComputerElement;
	}

	public boolean isShowPreBuiltComputerElement() {
		return showPreBuiltComputerElement;
	}

	public void setShowPreBuiltComputerElement(boolean showPreBuiltComputerElement) {
		this.showPreBuiltComputerElement = showPreBuiltComputerElement;
	}

	public boolean isShowAudioElement() {
		return showAudioElement;
	}

	public void setShowAudioElement(boolean showAudioElement) {
		this.showAudioElement = showAudioElement;
	}

	public boolean isShowDisplayElement() {
		return showDisplayElement;
	}

	public void setShowDisplayElement(boolean showDisplayElement) {
		this.showDisplayElement = showDisplayElement;
	}

	public boolean isShowKeyboardElement() {
		return showKeyboardElement;
	}

	public void setShowKeyboardElement(boolean showKeyboardElement) {
		this.showKeyboardElement = showKeyboardElement;
	}

	public boolean isShowMouseElement() {
		return showMouseElement;
	}

	public void setShowMouseElement(boolean showMouseElement) {
		this.showMouseElement = showMouseElement;
	}

	public boolean isShowAntiVirusElement() {
		return showAntiVirusElement;
	}

	public void setShowAntiVirusElement(boolean showAntiVirusElement) {
		this.showAntiVirusElement = showAntiVirusElement;
	}

	public boolean isShowGameElement() {
		return showGameElement;
	}

	public void setShowGameElement(boolean showGameElement) {
		this.showGameElement = showGameElement;
	}

	public boolean isShowOperatingSystemElement() {
		return showOperatingSystemElement;
	}

	public void setShowOperatingSystemElement(boolean showOperatingSystemElement) {
		this.showOperatingSystemElement = showOperatingSystemElement;
	}

	public boolean isShowProcessorElement() {
		return showProcessorElement;
	}
	
	public void setShowProcessorElement(boolean showProcessorElement) {
		this.showProcessorElement = showProcessorElement;
	}
	
	public void setComponentFound(boolean componentFound) {
		this.componentFound = componentFound;
	}
	
	public boolean isComponentFound() {
		return componentFound;
	}
	
	public String getComponent() {
		return component;
	}
	
	public void setComponent(String component) {
		this.component = component;
	}
	
	public boolean getHasMoreSubCategories() {
		return hasMoreSubCategories;
	}
	
	public boolean getHasMoreSubSubCategories() {
		return hasMoreSubSubCategories;
	}
	
	public String getSelected() {
		System.out.println("get method.........." + selected);
		return selected;
	}
	
	public void setSelected(String selected) {
		System.out.println("set method..........");
		this.selected = selected;
	}
	
	public String getSubSelected() {
		System.out.println("get method.........." + subSelected);
		return subSelected;
	}
	
	public void setSubSelected(String subSelected) {
		System.out.println("set method..........");
		this.subSelected = subSelected;
	}
	
	public String getSubSubSelected() {
		System.out.println("get method.........." + subSubSelected);
		return subSubSelected;
	}
	
	public void setSubSubSelected(String subSubSelected) {
		System.out.println("set method..........");
		this.subSubSelected = subSubSelected;
	}
	
	public List<Category> getCategories() {
		return categories;
	}
	
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public List<Category> getSubCategories() {
		return subCategories;
	}
	
	public void setSubCategories(List<Category> subCategories) {
		this.subCategories = subCategories;
	}
	
	public List<Category> getSubSubCategories() {
		return subSubCategories;
	}
	
	public void setSubSubCategories(List<Category> subSubCategories) {
		this.subSubCategories = subSubCategories;
	}
	
	public void generateElement() {
		boolean found = false;
		if(selected != "select..") {
			for(int i = 0; i < categories.size() && !found; i++) {
				if(categories.get(i).getName().equals(selected)) {
					System.out.println(categories.get(i).getSubCategories());
					found = true;
					subCategories = categories.get(i).getSubCategories();
					if(subCategories.size() > 0) {
						hasMoreSubCategories = true;
					}
					else {
						hasMoreSubCategories = false;
						component = subCategories.get(i).getName();
					}
				}
			}
		}
		else {
			hasMoreSubCategories = false;
		}
	}
	
	public void generateSubElement() {
		boolean found = false;
		if(selected != "select..") {
			for(int i = 0; i < subCategories.size() && !found; i++) {
				if(subCategories.get(i).getName().equals(subSelected)) {
					System.out.println(subCategories.get(i).getSubCategories() + "create sub sub");
					found = true;
					subSubCategories = subCategories.get(i).getSubCategories();
					if(subSubCategories.size() > 0) {
						hasMoreSubSubCategories = true;
					}
					else {
						hasMoreSubSubCategories = false;
						component = subSubCategories.get(i).getName();
					}
				}
			}
		}
		else {
			hasMoreSubSubCategories = false;
		}
	}
	
	private void initialiseCategoryList() {
		/*---------Component---------*/
		categories.add(new SimpleCategory("Component"));
		
		categories.get(0).addSubCategory(new SimpleCategory("Chassis"));
		
		categories.get(0).addSubCategory(new SimpleCategory("Processor"));
		
		categories.get(0).addSubCategory(new SimpleCategory("Motherboard"));
		
		categories.get(0).addSubCategory(new SimpleCategory("Graphics Card"));
		
		categories.get(0).addSubCategory(new SimpleCategory("Memory"));
		
		categories.get(0).addSubCategory(new SimpleCategory("Power Supply"));
		
		categories.get(0).addSubCategory(new SimpleCategory("Internal Storage"));
		categories.get(0).getSubCategory(6).addSubCategory(new SimpleCategory("Hard Disk Drive"));
		categories.get(0).getSubCategory(6).addSubCategory(new SimpleCategory("Solid State Drive"));
		
		/*---------Computer---------*/
		categories.add(new SimpleCategory("Computer"));
		categories.get(1).addSubCategory(new SimpleCategory("Custom Computer"));
		categories.get(1).addSubCategory(new SimpleCategory("Pre-Built Computer"));
		
		/*---------Peripheral---------*/		
		categories.add(new SimpleCategory("Peripheral"));
		categories.get(2).addSubCategory(new SimpleCategory("Audio"));
		categories.get(2).addSubCategory(new SimpleCategory("Display"));
		categories.get(2).addSubCategory(new SimpleCategory("Keyboard"));
		categories.get(2).addSubCategory(new SimpleCategory("Mouse"));
		
		/*---------Software---------*/
		categories.add(new SimpleCategory("Software"));
		categories.get(3).addSubCategory(new SimpleCategory("Anti Virus"));
		categories.get(3).addSubCategory(new SimpleCategory("Game"));
		categories.get(3).addSubCategory(new SimpleCategory("Operating System"));
	}
}