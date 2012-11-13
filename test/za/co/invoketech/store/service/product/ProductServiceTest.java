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

import java.math.BigDecimal;

import junit.framework.Assert;

import org.junit.Test;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.domain.model.product.Product;
import za.co.invoketech.store.domain.model.product.component.GraphicsCard;
import za.co.invoketech.store.domain.model.product.component.HardDiskDrive;
import za.co.invoketech.store.domain.model.product.component.IntegratedGPU;
import za.co.invoketech.store.domain.model.product.component.Memory;
import za.co.invoketech.store.domain.model.product.component.PowerSupplyUnit;
import za.co.invoketech.store.domain.model.product.component.Processor;
import za.co.invoketech.store.domain.model.product.component.SolidStateDrive;

import com.google.inject.Inject;

/**
 * @author a.carel.g.nel@gmail.com (Carel Nel)
 */

public class ProductServiceTest {

	@Inject
	private ProductService productService;
	
	public ProductServiceTest() {
		Goose.getInjectorForTesting().injectMembers(this);
	}
		
	@Test
	public void graphicsCardTest() {
		
		GraphicsCard graphicsCard = new GraphicsCard();
		graphicsCard.setTitle("Gigabyte Nvidia GTX 670");
		graphicsCard.setPrice(new BigDecimal(5400));
		graphicsCard.setStock(13);
		graphicsCard.setConnectionInterface("PCI-Express");
		graphicsCard.setMemoryType("GDDR5");
		graphicsCard.setMemorySize("1024 MB");
		graphicsCard.setMemoryInterface("256 bit");
		graphicsCard.setCoreClockSpeed("100 MHz");
		graphicsCard.setMemoryClockSpeed("3600 MHz");
		graphicsCard.setOutputs("DVI, HDMI");
		graphicsCard.setMaxResolution("2400x1600");
		graphicsCard.setDxVersion("DirectX 10");
		graphicsCard.setMultiGpuSupport("3-Way SLI");
		
		Product product = productService.insertProduct(graphicsCard);
		Assert.assertTrue("Product not of the required type", product instanceof GraphicsCard);
	}

	@Test
	public void hardDiskDriveTest() {
		
		HardDiskDrive hardDiskDrive = new HardDiskDrive();
		hardDiskDrive.setTitle("Western Digital Caviar Green");
		hardDiskDrive.setPrice(new BigDecimal(850));
		hardDiskDrive.setStock(10);
		hardDiskDrive.setCapacity("2TB");
		hardDiskDrive.setFormFactor("3.5");
		hardDiskDrive.setBus("Sata 3");
		hardDiskDrive.setCache(64);
		hardDiskDrive.setSpinRate("5900RPM - 7200RPM");
		
		Product product = productService.insertProduct(hardDiskDrive);
		Assert.assertTrue("Product not of the required type", product instanceof HardDiskDrive);
	}
	
	@Test
	public void solidStateDriveTest() {
		
		SolidStateDrive solidStateDrive = new SolidStateDrive();
		solidStateDrive.setTitle("OCZ Vertex 4");
		solidStateDrive.setPrice(new BigDecimal(2400));
		solidStateDrive.setStock(3);
		solidStateDrive.setCapacity("256 GB");
		solidStateDrive.setFormFactor("2.5");
		solidStateDrive.setBus("Sata 3");
		solidStateDrive.setCache(64);
		solidStateDrive.setReadSpeed(580);
		solidStateDrive.setWriteSpeed(460);
		
		Product product = productService.insertProduct(solidStateDrive);
		Assert.assertTrue("Product not of the required type", product instanceof SolidStateDrive);
	}
	
	@Test
	public void memoryTest() {
		Memory memory = new Memory();
		memory.setTitle("Corsair Dominator Platinum");
		memory.setPrice(new BigDecimal(2100));
		memory.setStock(1);
		memory.setModules(3);
		memory.setSize("4 GB");
		memory.setType("DDR 3");
		memory.setVoltage(1.5f);
		memory.setFrequency("2200 MHz");
		memory.setLatency("10-4-8-65-5");
		
		Product product = productService.insertProduct(memory);
		Assert.assertTrue("Product not of the required type", product instanceof Memory);
	}
	
	@Test
	public void powerSupplyTest() {
		
		PowerSupplyUnit powerSupply = new PowerSupplyUnit();
		powerSupply.setTitle("Corsair Performance Series");
		powerSupply.setPrice(new BigDecimal(879.56));
		powerSupply.setStock(28);
		powerSupply.setPower("800 Watt");
		powerSupply.setModular(true);
		powerSupply.setAtx(1);
		powerSupply.setEps(1);
		powerSupply.setPcie(3);
		powerSupply.setMolex(6);
		powerSupply.setSata(10);
		powerSupply.setFloppy(0);
		
		Product product = productService.insertProduct(powerSupply);
		Assert.assertTrue("Product not of the required type", product instanceof PowerSupplyUnit);
	}
	
	@Test
	public void motherboardTest() {
		
		/* TODO: CHANGE TO MOTHERBOARD */
		Processor processor = new Processor();
		processor.setTitle("Intel I7 780");
		processor.setPrice(new BigDecimal(3499.95));
		processor.setStock(2);
		processor.setFamily("BloomField");
		processor.setClockSpeed(3.2f);
		processor.setBoostClock(4.5f);
		processor.setSocket("1156");
		processor.setCache(8);
		processor.setCores(4);
		processor.setThreads(8);
		
		Product product = productService.insertProduct(processor);
		Assert.assertTrue("Product not of the required type", product instanceof Processor);
	}
	
	@Test
	public void processorTest() {
		
		Processor processor = new Processor();
		processor.setTitle("Intel I7 780");
		processor.setPrice(new BigDecimal(3499.95));
		processor.setStock(2);
		processor.setFamily("BloomField");
		processor.setClockSpeed(3.2f);
		processor.setBoostClock(4.5f);
		processor.setSocket("1156");
		processor.setCache(8);
		processor.setCores(4);
		processor.setThreads(8);
		
		Product product = productService.insertProduct(processor);
		Assert.assertTrue("Product not of the required type", product instanceof Processor);
	}
	
	@Test
	public void processorWithInternalGPUTest() {
		
		Processor processor = new Processor();
		processor.setTitle("Intel I7 680");
		processor.setPrice(new BigDecimal(3499.95));
		processor.setStock(2);
		processor.setFamily("YorkField");
		processor.setClockSpeed(2.8f);
		processor.setBoostClock(3.6f);
		processor.setSocket("1155");
		processor.setCache(8);
		processor.setCores(4);
		processor.setThreads(8);
		
		IntegratedGPU integratedGPU = new IntegratedGPU();
		integratedGPU.setName("Intel 8400");
		integratedGPU.setBaseClock(800f);
		integratedGPU.setDisplays(2);
		processor.setIntegratedGPU(integratedGPU);

		Product product = productService.insertProduct(processor);
		Assert.assertTrue("Product not of the required type", product instanceof Processor);
	}
	
	@Test
	public void consolidatedTest() {
	}
}