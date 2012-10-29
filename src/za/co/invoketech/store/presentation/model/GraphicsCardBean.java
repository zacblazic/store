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
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import za.co.invoketech.store.domain.model.product.Brand;
import za.co.invoketech.store.domain.model.product.component.GraphicsCard;
import za.co.invoketech.store.service.product.ProductService;
import za.co.invoketech.store.service.repository.BrandRepository;

import com.google.inject.Inject;

/**
 * @author a.carel.g.nel@gmail.com (Carel Nel)
 */

@SessionScoped
@ManagedBean
public class GraphicsCardBean implements Serializable{

	@Inject
	private BrandRepository brandRepository;
	@Inject
	private ProductService productService;
	
	private static final long serialVersionUID = 1L;
	private List<Brand> brands = new ArrayList<Brand>();
	private String theBrand;
	private String title;
	private long stock;
	private Date discontinuedDate;
	private String connectionInterface;
	private String memoryType;
	private String memorySize;
	private String memoryInterface;
	private String coreClockSpeed;
	private String memoryClockSpeed;
	private String outputs;
	private String maxResolution;
	private String dxVersion;
	private String multipleGpuSupport;
	public List<Brand> getBrands() {
		return brands;
	}
	public void setBrands(List<Brand> brands) {
		this.brands = brands;
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
	public Date getDiscontinuedDate() {
		return discontinuedDate;
	}
	public void setDiscontinuedDate(Date discontinuedDate) {
		this.discontinuedDate = discontinuedDate;
	}
	public String getConnectionInterface() {
		return connectionInterface;
	}
	public void setConnectionInterface(String connectionInterface) {
		this.connectionInterface = connectionInterface;
	}
	public String getMemoryType() {
		return memoryType;
	}
	public void setMemoryType(String memoryType) {
		this.memoryType = memoryType;
	}
	public String getMemorySize() {
		return memorySize;
	}
	public void setMemorySize(String memorySize) {
		this.memorySize = memorySize;
	}
	public String getMemoryInterface() {
		return memoryInterface;
	}
	public void setMemoryInterface(String memoryInterface) {
		this.memoryInterface = memoryInterface;
	}
	public String getCoreClockSpeed() {
		return coreClockSpeed;
	}
	public void setCoreClockSpeed(String coreClockSpeed) {
		this.coreClockSpeed = coreClockSpeed;
	}
	public String getMemoryClockSpeed() {
		return memoryClockSpeed;
	}
	public void setMemoryClockSpeed(String memoryClockSpeed) {
		this.memoryClockSpeed = memoryClockSpeed;
	}
	public String getOutputs() {
		return outputs;
	}
	public void setOutputs(String outputs) {
		this.outputs = outputs;
	}
	public String getMaxResolution() {
		return maxResolution;
	}
	public void setMaxResolution(String maxResolution) {
		this.maxResolution = maxResolution;
	}
	public String getDxVersion() {
		return dxVersion;
	}
	public void setDxVersion(String dxVersion) {
		this.dxVersion = dxVersion;
	}
	public String getMultipleGpuSupport() {
		return multipleGpuSupport;
	}
	public void setMultipleGpuSupport(String multipleGpuSupport) {
		this.multipleGpuSupport = multipleGpuSupport;
	}
	
	public void insertNew() {
		GraphicsCard graphicsCard = new GraphicsCard();
		graphicsCard.setTitle(title);
		graphicsCard.setStock(stock);
		graphicsCard.setConnectionInterface(connectionInterface);
		graphicsCard.setMemoryType(memoryType);
		graphicsCard.setMemorySize(memorySize);
		graphicsCard.setMemoryInterface(memoryInterface);
		graphicsCard.setCoreClockSpeed(coreClockSpeed);
		graphicsCard.setMemoryClockSpeed(memoryClockSpeed);
		graphicsCard.setOutputs(outputs);
		graphicsCard.setMaxResolution(maxResolution);
		graphicsCard.setDxVersion(dxVersion);
		graphicsCard.setMultiGpuSupport(multipleGpuSupport);
		
		Brand brand = new Brand(theBrand);
		
		productService.insertProduct(graphicsCard, brand);
	}
}
