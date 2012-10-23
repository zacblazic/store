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

package za.co.invoketech.store.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import za.co.invoketech.store.presentation.category.Category;
import za.co.invoketech.store.presentation.category.SimpleCategory;

/**
 * @author a.carel.g.nel@gmail.com (Carel Nel)
 */

@SessionScoped
@ManagedBean
public class ProductBean implements Serializable {
		
	private static final long serialVersionUID = 1L;
	private List<Category> categories = new ArrayList<Category>();
	private List<Category> subCategories = new ArrayList<Category>();
	private List<String> extraElementList = new ArrayList<String>();
	private String selected;
	
	public ProductBean() {
		System.out.println("construct method..........");
		initialiseCategoryList();
	}
	
	public List<String> getExtraElementList() {
		return extraElementList;
	}
	
	public void setExtraElementList(List<String> extraElementList) {
		this.extraElementList = extraElementList;
	}
	
	public String getSelected() {
		System.out.println("get method.........." + selected);
		return selected;
	}
	
	public void setSelected(String selected) {
		System.out.println("set method..........");
		this.selected = selected;
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
	
	public void generateElement() {
		boolean found = false;
		for(int i = 0; i < categories.size() && !found; i++) {
			if(categories.get(i).getName().equals(selected)) {
				System.out.println(categories.get(i).getSubCategories());
				found = true;
				subCategories = categories.get(i).getSubCategories();
				if(subCategories.size() > 0 && extraElementList.size() == 0 || selected.equals("Component")) {
					extraElementList.add("");
				}
				else if(subCategories.size() > 0) {
					extraElementList.remove(0);
				}
				
			}
		}
	}
		
	private void initialiseCategoryList() {
		/*---------Component---------*/
		categories.add(new SimpleCategory("Component"));
		
		categories.get(0).addSubCategory(new SimpleCategory("Chassis"));
		
		categories.get(0).addSubCategory(new SimpleCategory("Processor"));
		categories.get(0).getSubCategory(1).addSubCategory(new SimpleCategory("Intel"));
		categories.get(0).getSubCategory(1).addSubCategory(new SimpleCategory("AMD"));
		
		categories.get(0).addSubCategory(new SimpleCategory("Motherboard"));
		categories.get(0).getSubCategory(2).addSubCategory(new SimpleCategory("Intel"));
		categories.get(0).getSubCategory(2).addSubCategory(new SimpleCategory("AMD"));
		
		categories.get(0).addSubCategory(new SimpleCategory("Graphics Card"));
		categories.get(0).getSubCategory(3).addSubCategory(new SimpleCategory("Nvidia"));
		categories.get(0).getSubCategory(3).addSubCategory(new SimpleCategory("ATi"));
		
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