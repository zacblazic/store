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
import za.co.invoketech.store.domain.model.product.component.IntegratedGPU;
import za.co.invoketech.store.domain.model.product.component.Processor;
import za.co.invoketech.store.service.product.ProductService;

import com.google.inject.Inject;

/**
 * @author a.carel.g.nel@gmail.com (Carel Nel)
 */

@SessionScoped
@ManagedBean
public class ProcessorBean implements Serializable {

	@Inject
	private ProductService productService;
	
	private static final long serialVersionUID = 1L;
	private String theBrand;
	private String title;
	private long stock;
	private double price;
	private Date discontinuedDate;
	private String family;
	private float clockSpeed;
	private float boostClock;
	private String socket;
	private int cache;
	private int cores;
	private int threads;
	
	private boolean showGPU;
	private String gpuName;
	private float gpuBaseClock;
	private float gpuBoostClock;
	private int gpuDisplays;
	
	public ProcessorBean() {
		Goose.guicify(this);
		showGPU = false;
	}
	
	public void setTheBrand(String theBrand) {
		this.theBrand = theBrand;
	}
	
	public String getTheBrand() {
		return theBrand;
	}
	
	public void setShowGPU(boolean showGPU) {
		this.showGPU = showGPU;
		System.out.println("Set" + showGPU);
	}
	
	public boolean isShowGPU() {
		return showGPU;
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

	public Date getDiscontinuedDate() {
		return discontinuedDate;
	}

	public void setDiscontinuedDate(Date discontinuedDate) {
		this.discontinuedDate = discontinuedDate;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public float getClockSpeed() {
		return clockSpeed;
	}

	public void setClockSpeed(float clockSpeed) {
		this.clockSpeed = clockSpeed;
	}

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

	public int getCache() {
		return cache;
	}

	public void setCache(int cache) {
		this.cache = cache;
	}

	public int getCores() {
		return cores;
	}

	public void setCores(int cores) {
		this.cores = cores;
	}

	public int getThreads() {
		return threads;
	}

	public void setThreads(int threads) {
		this.threads = threads;
	}

	public String getGpuName() {
		return gpuName;
	}

	public void setGpuName(String gpuName) {
		this.gpuName = gpuName;
	}

	public float getGpuBaseClock() {
		return gpuBaseClock;
	}

	public void setGpuBaseClock(float gpuBaseClock) {
		this.gpuBaseClock = gpuBaseClock;
	}

	public float getGpuBoostClock() {
		return gpuBoostClock;
	}

	public void setGpuBoostClock(float gpuBoostClock) {
		this.gpuBoostClock = gpuBoostClock;
	}

	public int getGpuDisplays() {
		return gpuDisplays;
	}

	public void setGpuDisplays(int gpuDisplays) {
		this.gpuDisplays = gpuDisplays;
	}
	
	public float getBoostClock() {
		return boostClock;
	}
	
	public void setBoostClock(float boostClock) {
		this.boostClock = boostClock;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void toggleGPU(){
		System.out.println("showGPU: " + showGPU);
		
		if(!showGPU) {
			showGPU = true;
		}
		else if(showGPU) {
			showGPU = false;
		}
		else {
			showGPU = true;
		}
	}
	
	public void insert() {
		Processor processor = new Processor();
		processor.setTitle(title);
		processor.setStock(stock);
		processor.setPrice(new BigDecimal(price));
		processor.setFamily(family);
		processor.setClockSpeed(clockSpeed);
		processor.setBoostClock(boostClock);
		processor.setSocket(socket);
		processor.setCache(cache);
		processor.setCores(cores);
		processor.setThreads(threads);
		
		if(showGPU) {
			IntegratedGPU integratedGPU = new IntegratedGPU();
			integratedGPU.setName(gpuName);
			integratedGPU.setBaseClock(gpuBaseClock);
			integratedGPU.setBoostClock(gpuBoostClock);
			integratedGPU.setDisplays(gpuDisplays);
			
			processor.setIntegratedGPU(integratedGPU);
		}
		
		productService.insertProduct(processor);
	}
}
