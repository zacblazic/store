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

package za.co.invoketech.store.presentation.model.components;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.domain.model.product.component.SolidStateDrive;
import za.co.invoketech.store.service.product.ProductService;

import com.google.inject.Inject;


/**
 * @author a.carel.g.nel@gmail.com (Carel Nel)
 */

@SessionScoped
@ManagedBean
public class SolidStateDriveBean implements Serializable {

	@Inject
	private ProductService productService;
	
	private static final long serialVersionUID = 1L;
	private String theBrand;
	private String title;
	private long stock;
	private double price;
	private Date discontinuedDate;
	private String capacity;
	private String formFactor;
	private String bus;
	private int cache;
	private int readSpeed;
	private int writeSpeed;
	
	public SolidStateDriveBean() {
		Goose.guicify(this);
	}

	public String getTheBrand() {
		return theBrand;
	}

	public void setTheBrand(String theBrand) {
		this.theBrand = theBrand;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDiscontinuedDate() {
		return discontinuedDate;
	}

	public void setDiscontinuedDate(Date discontinuedDate) {
		this.discontinuedDate = discontinuedDate;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getFormFactor() {
		return formFactor;
	}

	public void setFormFactor(String formFactor) {
		this.formFactor = formFactor;
	}

	public String getBus() {
		return bus;
	}

	public void setBus(String bus) {
		this.bus = bus;
	}

	public int getCache() {
		return cache;
	}

	public void setCache(int cache) {
		this.cache = cache;
	}

	public int getReadSpeed() {
		return readSpeed;
	}

	public void setReadSpeed(int readSpeed) {
		this.readSpeed = readSpeed;
	}

	public int getWriteSpeed() {
		return writeSpeed;
	}

	public void setWriteSpeed(int writeSpeed) {
		this.writeSpeed = writeSpeed;
	}
	
	public void insert() {
		
		SolidStateDrive ssd = new SolidStateDrive();
		ssd.setTitle(title);
		ssd.setStock(stock);
		ssd.setPrice(new BigDecimal(price));
		ssd.setCapacity(capacity);
		ssd.setFormFactor(formFactor);
		ssd.setBus(bus);
		ssd.setCache(cache);
		ssd.setReadSpeed(readSpeed);
		ssd.setWriteSpeed(writeSpeed);
				
		productService.insertProduct(ssd);
	}
}
