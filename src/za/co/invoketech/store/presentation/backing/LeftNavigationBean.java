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

package za.co.invoketech.store.presentation.backing;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

import za.co.invoketech.store.presentation.support.CategoriesBean;
import za.co.invoketech.store.presentation.support.Category;

/**
 * @author zacblazic@gmail.com (Zac Blazic)
 */

@SessionScoped
@ManagedBean
public class LeftNavigationBean {
	
	@ManagedProperty(value = "#{categoriesBean}")
	private CategoriesBean categoriesBean;
	
	private MenuModel model;
	
	public LeftNavigationBean() {
		model = new DefaultMenuModel();
	}
	
	@PostConstruct
	public void init() {
		for(Category category : categoriesBean.getCategories()) {
			UIComponent component = createSubmenu(category);
			
			if(component instanceof Submenu) {
				model.addSubmenu((Submenu)component);
			} else {
				model.addMenuItem((MenuItem)component);
			}
		}
	}
	
	private UIComponent createSubmenu (Category category) {
		if(category.hasSubCategories()) {
			Submenu submenu = new Submenu();
			submenu.setLabel(category.getName());
			
			for(Category c : category.getSubCategories()) {
				submenu.getChildren().add(createSubmenu(c));
			}
			
			return submenu;
		} else {
			MenuItem menuItem = new MenuItem();
			menuItem.setValue(category.getName());
			return menuItem;
		}
	}
	
	public MenuModel getModel() {
		return model;
	}

	public void setCategoriesBean(CategoriesBean categoriesBean) {
		this.categoriesBean = categoriesBean;
	}
}