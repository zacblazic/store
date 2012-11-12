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
import za.co.invoketech.store.domain.model.product.component.Memory;
import za.co.invoketech.store.service.product.ProductService;

import com.google.inject.Inject;

/**
 * @author a.carel.g.nel@gmail.com (Carel Nel)
 */

@SessionScoped
@ManagedBean
public class MemoryBean implements Serializable{

	@Inject
	private ProductService productService;
	
	private static final long serialVersionUID = 1L;
	private String theBrand;
	private String title;
	private long stock;
	private double price;
	private Date discontinuedDate;
	private int modules;
	private String size;
	private String type;
	private float voltage;
	private String frequency;
	private String latency;
	
	public MemoryBean() {
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

	public int getModules() {
		return modules;
	}

	public void setModules(int modules) {
		this.modules = modules;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getVoltage() {
		return voltage;
	}

	public void setVoltage(float voltage) {
		this.voltage = voltage;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getLatency() {
		return latency;
	}

	public void setLatency(String latency) {
		this.latency = latency;
	}
	
	public void insert() {
		Memory memory = new Memory();
		memory.setTitle(title);
		memory.setStock(stock);
		memory.setPrice(new BigDecimal(price));
		memory.setModules(modules);
		memory.setSize(size);
		memory.setType(type);
		memory.setVoltage(voltage);
		memory.setFrequency(frequency);
		memory.setLatency(latency);
				
		productService.insertProduct(memory);
	}
}
