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

package za.co.invoketech.store.service.product;

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

/**
 * @author a.carel.g.nel@gmail.com (Carel Nel)
 * @author garethc18@gmail.com (Gareth Conry)
 */

public interface ProductService {
	
	public Product insertProduct(Product product);
	
	public Product findProductById(long id);
	
	public void updateProduct(Product product);
	
	public void removeProduct(long id);
	
	public boolean hasStock(long id);
	
	public void setDiscontinue(long id, boolean value);

	public List<Product> findAllProducts();
	public List<GraphicsCard> findAllGraphicsCards();
	public List<HardDiskDrive> findAllHardDiskDrives();
	public List<SolidStateDrive> findAllSolidStateDrives();
	public List<Memory> findAllMemory();
	public List<PowerSupplyUnit> findAllPowerSupplyUnits();
	public List<Processor> findAllProcessors();
	public List<CustomComputer> findAllCustomComputers();
	public List<PreBuiltComputer> findAllPreBuiltComputers();
	public List<Audio> findAllAudio();
	public List<Display> findAllDisplays();
	public List<Keyboard> findAllKeyboards();
	public List<Mouse> findAllMice();
	public List<AntiVirus> findAntiVirus();
	public List<Game> findGames();
	public List<OperatingSystem> findOperatingSystems();
}
