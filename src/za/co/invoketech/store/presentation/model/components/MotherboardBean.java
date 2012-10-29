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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.domain.model.product.Brand;
import za.co.invoketech.store.domain.model.product.component.Motherboard;
import za.co.invoketech.store.service.product.ProductService;
import za.co.invoketech.store.service.repository.BrandRepository;

import com.google.inject.Inject;

/**
 * @author a.carel.g.nel@gmail.com (Carel Nel)
 */

public class MotherboardBean implements Serializable{

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
	private String chipset;
	private String socket;
	private String memoryType;
	private String memoryChannel;
	private String memorySlots;
	private String maxMemory;
	private int pcie;
	private int pci;
	private int ide;
	private int sata3;
	private int sata2;
	private String lan;
	private int usb3;
	private int usb2;
	private int audio;
	private int firewire;
	private int esata;
	private int vga;
	private int hdmi;
	private int dvi;
	private String formFactor;
	private boolean sliCrossfire;
	
	public MotherboardBean() {
		Goose.guicify(this);
		brands = brandRepository.findAll();
	}

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

	public String getChipset() {
		return chipset;
	}

	public void setChipset(String chipset) {
		this.chipset = chipset;
	}

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

	public String getMemoryType() {
		return memoryType;
	}

	public void setMemoryType(String memoryType) {
		this.memoryType = memoryType;
	}

	public String getMemoryChannel() {
		return memoryChannel;
	}

	public void setMemoryChannel(String memoryChannel) {
		this.memoryChannel = memoryChannel;
	}

	public String getMemorySlots() {
		return memorySlots;
	}

	public void setMemorySlots(String memorySlots) {
		this.memorySlots = memorySlots;
	}

	public String getMaxMemory() {
		return maxMemory;
	}

	public void setMaxMemory(String maxMemory) {
		this.maxMemory = maxMemory;
	}
	
	public void setPcie(int pcie) {
		this.pcie = pcie;
	}
	
	public int getPcie() {
		return pcie;
	}
	
	public int getPci() {
		return pci;
	}

	public void setPci(int pci) {
		this.pci = pci;
	}

	public int getIde() {
		return ide;
	}

	public void setIde(int ide) {
		this.ide = ide;
	}

	public int getSata3() {
		return sata3;
	}

	public void setSata3(int sata3) {
		this.sata3 = sata3;
	}

	public int getSata2() {
		return sata2;
	}

	public void setSata2(int sata2) {
		this.sata2 = sata2;
	}

	public String getLan() {
		return lan;
	}

	public void setLan(String lan) {
		this.lan = lan;
	}

	public int getUsb3() {
		return usb3;
	}

	public void setUsb3(int usb3) {
		this.usb3 = usb3;
	}

	public int getUsb2() {
		return usb2;
	}

	public void setUsb2(int usb2) {
		this.usb2 = usb2;
	}

	public int getAudio() {
		return audio;
	}

	public void setAudio(int audio) {
		this.audio = audio;
	}

	public int getFirewire() {
		return firewire;
	}

	public void setFirewire(int firewire) {
		this.firewire = firewire;
	}

	public int getEsata() {
		return esata;
	}

	public void setEsata(int esata) {
		this.esata = esata;
	}

	public int getVga() {
		return vga;
	}

	public void setVga(int vga) {
		this.vga = vga;
	}

	public int getHdmi() {
		return hdmi;
	}

	public void setHdmi(int hdmi) {
		this.hdmi = hdmi;
	}

	public int getDvi() {
		return dvi;
	}

	public void setDvi(int dvi) {
		this.dvi = dvi;
	}

	public String getFormFactor() {
		return formFactor;
	}

	public void setFormFactor(String formFactor) {
		this.formFactor = formFactor;
	}

	public boolean isSliCrossfire() {
		return sliCrossfire;
	}

	public void setSliCrossfire(boolean sliCrossfire) {
		this.sliCrossfire = sliCrossfire;
	}
	
	public void insert() {
		Motherboard motherboard = new Motherboard();
		motherboard.setTitle(title);
		motherboard.setStock(stock);
		motherboard.setChipset(chipset);
		motherboard.setSocket(socket);
		motherboard.setMemoryType(memoryType);
		motherboard.setMemoryChannel(memoryChannel);
		motherboard.setMemorySlots(memorySlots);
		motherboard.setPcie(pcie);
		motherboard.setPci(pci);
		motherboard.setIde(ide);
		motherboard.setSata3(sata3);
		motherboard.setSata2(sata2);
		motherboard.setUsb3(usb3);
		motherboard.setUsb2(usb2);
		motherboard.setAudioPorts(audio);
		motherboard.setFirewire(firewire);
		motherboard.setEsata(esata);
		motherboard.setVga(vga);
		motherboard.setHdmi(hdmi);
		motherboard.setDvi(dvi);
		motherboard.setFormFactor(formFactor);
		motherboard.setSliCrossfire(sliCrossfire);
		
		Brand brand = new Brand(theBrand);
		productService.insertProduct(motherboard, brand);
	}
}
