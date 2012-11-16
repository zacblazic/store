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
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.domain.model.product.Product;
import za.co.invoketech.store.service.product.ProductService;

import com.google.inject.Inject;

/**
 * @author a.carel.g.nel@gmail.com (Carel Nel)
 */

@SessionScoped
@ManagedBean
public class ProductListBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	ProductService productService;
	
	private List<Product> products; 
	private Product product;

	public ProductListBean() {
		Goose.guicify(this);
		products = productService.findAllProducts();
	}

	public String availibility(long stock) {
		if(stock > 0) {
			return "In stock";
		}
		else {
			return "Out of stock";
		}
	}
	
	public String availibilityColor(long stock) {
		if(stock > 0) {
			return "Green";
		}
		else {
			return "Red";
		}
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public void addSelectedItemToCart() {
		
	}
}