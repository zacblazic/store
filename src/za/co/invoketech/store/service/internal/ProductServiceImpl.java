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

package za.co.invoketech.store.service.internal;

import java.util.ArrayList;
import java.util.List;

import za.co.invoketech.store.domain.model.product.Product;
import za.co.invoketech.store.domain.model.product.component.GraphicsCard;
import za.co.invoketech.store.domain.model.product.component.HardDiskDrive;
import za.co.invoketech.store.domain.model.product.component.Memory;
import za.co.invoketech.store.domain.model.product.component.PowerSupplyUnit;
import za.co.invoketech.store.domain.model.product.component.Processor;
import za.co.invoketech.store.domain.model.product.component.SolidStateDrive;
import za.co.invoketech.store.domain.model.product.computer.CustomComputer;
import za.co.invoketech.store.domain.model.product.computer.PreBuiltComputer;
import za.co.invoketech.store.domain.model.product.peripheral.Audio;
import za.co.invoketech.store.domain.model.product.peripheral.Display;
import za.co.invoketech.store.domain.model.product.peripheral.Keyboard;
import za.co.invoketech.store.domain.model.product.peripheral.Mouse;
import za.co.invoketech.store.domain.model.product.software.AntiVirus;
import za.co.invoketech.store.domain.model.product.software.Game;
import za.co.invoketech.store.domain.model.product.software.OperatingSystem;
import za.co.invoketech.store.service.product.ProductService;
import za.co.invoketech.store.service.repository.ProductRepository;

import com.google.inject.Inject;

/**
 * @author a.carel.g.nel@gmail.com (Carel Nel)
 * @author garethc18@gmail.com (Gareth Conry)
 */

public class ProductServiceImpl implements ProductService {

	@Inject
	ProductRepository productRepository;
	
	public Product insertProduct(Product product) {
		
		/* TODO: Add Validation Checks */
		productRepository.persist(product);		
		return product;
	}
	
	public Product findProductById(long id) {
		return productRepository.findById(id);
	}
	
	public void updateProduct(Product product) {
		productRepository.merge(product);
	}
	
	public void removeProduct(long id) {
		productRepository.removeById(id);
	}
	
	public boolean hasStock(long id) {
		Product product = productRepository.findById(id);
		return product.getStock() > 0 ? true : false;
	}
	
	public void setDiscontinue(long id, boolean value) {
		Product product = productRepository.findById(id);
		product.setDiscontinued(true);
		productRepository.merge(product);
	}
	
	public List<Product> findAllProducts() {
		
		return productRepository.findAll();
	}
	
	public List<GraphicsCard> findAllGraphicsCards() {
	
		List<Product> allProducts = productRepository.findAll();
		List<GraphicsCard> specificProducts = new ArrayList<GraphicsCard>();
		for(int i = 0; i < allProducts.size(); i++) {
			if(allProducts.get(i) instanceof GraphicsCard) {
				specificProducts.add((GraphicsCard) allProducts.get(i));
			}
		}
		
		return specificProducts;
	}
	
	public List<HardDiskDrive> findAllHardDiskDrives() {
		
		List<Product> allProducts = productRepository.findAll();
		List<HardDiskDrive> specificProducts = new ArrayList<HardDiskDrive>();
		for(int i = 0; i < allProducts.size(); i++) {
			if(allProducts.get(i) instanceof HardDiskDrive) {
				specificProducts.add((HardDiskDrive) allProducts.get(i));
			}
		}
		
		return specificProducts;
	}
	
	public List<SolidStateDrive> findAllSolidStateDrives() {
		
		List<Product> allProducts = productRepository.findAll();
		List<SolidStateDrive> specificProducts = new ArrayList<SolidStateDrive>();
		for(int i = 0; i < allProducts.size(); i++) {
			if(allProducts.get(i) instanceof SolidStateDrive) {
				specificProducts.add((SolidStateDrive) allProducts.get(i));
			}
		}
		
		return specificProducts;
	}
	
	public List<Memory> findAllMemory() {
		
		List<Product> allProducts = productRepository.findAll();
		List<Memory> specificProducts = new ArrayList<Memory>();
		for(int i = 0; i < allProducts.size(); i++) {
			if(allProducts.get(i) instanceof Memory) {
				specificProducts.add((Memory) allProducts.get(i));
			}
		}
		
		return specificProducts;
	}
	
	public List<PowerSupplyUnit> findAllPowerSupplyUnits() {
		
		List<Product> allProducts = productRepository.findAll();
		List<PowerSupplyUnit> specificProducts = new ArrayList<PowerSupplyUnit>();
		for(int i = 0; i < allProducts.size(); i++) {
			if(allProducts.get(i) instanceof PowerSupplyUnit) {
				specificProducts.add((PowerSupplyUnit) allProducts.get(i));
			}
		}
		
		return specificProducts;
	}
	
	public List<Processor> findAllProcessors() {
		
		List<Product> allProducts = productRepository.findAll();
		List<Processor> specificProducts = new ArrayList<Processor>();
		for(int i = 0; i < allProducts.size(); i++) {
			if(allProducts.get(i) instanceof Processor) {
				specificProducts.add((Processor) allProducts.get(i));
			}
		}
		
		return specificProducts;
	}
	
	public List<CustomComputer> findAllCustomComputers() {
		
		List<Product> allProducts = productRepository.findAll();
		List<CustomComputer> specificProducts = new ArrayList<CustomComputer>();
		for(int i = 0; i < allProducts.size(); i++) {
			if(allProducts.get(i) instanceof CustomComputer) {
				specificProducts.add((CustomComputer) allProducts.get(i));
			}
		}
		
		return specificProducts;
	}
	
	public List<PreBuiltComputer> findAllPreBuiltComputers() {
		
		List<Product> allProducts = productRepository.findAll();
		List<PreBuiltComputer> specificProducts = new ArrayList<PreBuiltComputer>();
		for(int i = 0; i < allProducts.size(); i++) {
			if(allProducts.get(i) instanceof PreBuiltComputer) {
				specificProducts.add((PreBuiltComputer) allProducts.get(i));
			}
		}
		
		return specificProducts;
	}
	
	public List<Audio> findAllAudio() {
		
		List<Product> allProducts = productRepository.findAll();
		List<Audio> specificProducts = new ArrayList<Audio>();
		for(int i = 0; i < allProducts.size(); i++) {
			if(allProducts.get(i) instanceof Audio) {
				specificProducts.add((Audio) allProducts.get(i));
			}
		}
		
		return specificProducts;
	}
	
	public List<Display> findAllDisplays() {
		
		List<Product> allProducts = productRepository.findAll();
		List<Display> specificProducts = new ArrayList<Display>();
		for(int i = 0; i < allProducts.size(); i++) {
			if(allProducts.get(i) instanceof Display) {
				specificProducts.add((Display) allProducts.get(i));
			}
		}
		
		return specificProducts;
	}
	
	public List<Keyboard> findAllKeyboards() {
		
		List<Product> allProducts = productRepository.findAll();
		List<Keyboard> specificProducts = new ArrayList<Keyboard>();
		for(int i = 0; i < allProducts.size(); i++) {
			if(allProducts.get(i) instanceof Keyboard) {
				specificProducts.add((Keyboard) allProducts.get(i));
			}
		}
		
		return specificProducts;
	}
	
	public List<Mouse> findAllMice() {
		
		List<Product> allProducts = productRepository.findAll();
		List<Mouse> specificProducts = new ArrayList<Mouse>();
		for(int i = 0; i < allProducts.size(); i++) {
			if(allProducts.get(i) instanceof Mouse) {
				specificProducts.add((Mouse) allProducts.get(i));
			}
		}
		
		return specificProducts;
	}
	
	public List<AntiVirus> findAntiVirus() {
		
		List<Product> allProducts = productRepository.findAll();
		List<AntiVirus> specificProducts = new ArrayList<AntiVirus>();
		for(int i = 0; i < allProducts.size(); i++) {
			if(allProducts.get(i) instanceof AntiVirus) {
				specificProducts.add((AntiVirus) allProducts.get(i));
			}
		}
		
		return specificProducts;
	}
	
	public List<Game> findGames() {
		
		List<Product> allProducts = productRepository.findAll();
		List<Game> specificProducts = new ArrayList<Game>();
		for(int i = 0; i < allProducts.size(); i++) {
			if(allProducts.get(i) instanceof Game) {
				specificProducts.add((Game) allProducts.get(i));
			}
		}
		
		return specificProducts;
	}
	
	public List<OperatingSystem> findOperatingSystems() {
		
		List<Product> allProducts = productRepository.findAll();
		List<OperatingSystem> specificProducts = new ArrayList<OperatingSystem>();
		for(int i = 0; i < allProducts.size(); i++) {
			if(allProducts.get(i) instanceof OperatingSystem) {
				specificProducts.add((OperatingSystem) allProducts.get(i));
			}
		}
		
		return specificProducts;
	}
}
