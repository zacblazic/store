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
package za.co.invoketech.store.presentation.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.application.util.Faces;
import za.co.invoketech.store.domain.model.product.Product;
import za.co.invoketech.store.presentation.model.ProductDisplayBean;
import za.co.invoketech.store.service.product.ProductService;

import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;

/**
 * 
 * @author a.carel.g.nel@gmail.com (Carel Nel)
 *
 */
@RequestScoped
@ManagedBean
public class ProductController {

	@Inject 
	private ProductService productService;
	
	@ManagedProperty(value = "#{productDisplayBean}")
	private ProductDisplayBean productDisplayBean;
	
	@ManagedProperty(value = "#{param.id}")
	private long productId;
		
	private Product product;
	
	public ProductController() {
		Goose.guicify(this);
	}
	
	public void populateFields() {		
		if (productId != 0){
			try {
				product = productService.findProductById(productId);
			}
			catch (Exception e) {
				Faces.showErrorMessage("Product Display Error", "Unknown Error: ");
				e.printStackTrace();
			}
			productDisplayBean.setId(productId);
			productDisplayBean.setPrice(product.getUnitPrice());
			productDisplayBean.setStock(product.getStock());
			productDisplayBean.setTitle(product.getTitle());
		}
	}

	public ProductDisplayBean getProductDisplayBean() {
		return productDisplayBean;
	}

	public void setProductDisplayBean(ProductDisplayBean productDisplayBean) {
		this.productDisplayBean = productDisplayBean;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}	

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}
}
