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
		graphicsCard.setTitle("Gigabyte Nvidia GTX 670 OC");
		graphicsCard.setPrice(new BigDecimal(5024));
		graphicsCard.setStock(13);
		graphicsCard.setConnectionInterface("PCI-Express 3.0");
		graphicsCard.setMemoryType("GDDR5");
		graphicsCard.setMemorySize("2048 MB");
		graphicsCard.setMemoryInterface("256 bit");
		graphicsCard.setCoreClockSpeed("1058 MHz");
		graphicsCard.setMemoryClockSpeed("6008 MHz");
		graphicsCard.setOutputs("DVI, DisplayPort, HDMI");
		graphicsCard.setMaxResolution("2560x1600");
		graphicsCard.setDxVersion("DirectX 11");
		graphicsCard.setMultiGpuSupport("3-Way SLI");
		
		Product product = productService.insertProduct(graphicsCard);
		Assert.assertTrue("Product not of the required type", product instanceof GraphicsCard);

		//***********************************************************************************************

		GraphicsCard graphicsCard2 = new GraphicsCard();
		graphicsCard2.setTitle("Gigabyte AMD Radeon HD 6950");
		graphicsCard2.setPrice(new BigDecimal(2599));
		graphicsCard2.setStock(4);
		graphicsCard2.setConnectionInterface("PCI-Express 2.0");
		graphicsCard2.setMemoryType("GDDR5");
		graphicsCard2.setMemorySize("1024 MB");
		graphicsCard2.setMemoryInterface("256 bit");
		graphicsCard2.setCoreClockSpeed("870 MHz");
		graphicsCard2.setMemoryClockSpeed("5000 MHz");
		graphicsCard2.setOutputs("DVI, DisplayPort, HDMI");
		graphicsCard2.setMaxResolution("2560x1600");
		graphicsCard2.setDxVersion("DirectX 11");
		graphicsCard2.setMultiGpuSupport("CrossFireX");
		
		Product product2 = productService.insertProduct(graphicsCard2);
		Assert.assertTrue("Product not of the required type", product2 instanceof GraphicsCard);

		//***********************************************************************************************

		GraphicsCard graphicsCard3 = new GraphicsCard();
		graphicsCard3.setTitle("MSI Nvidia GTX 670 Power Edition");
		graphicsCard3.setPrice(new BigDecimal(5372));
		graphicsCard3.setStock(3);
		graphicsCard3.setConnectionInterface("PCI-Express 3.0");
		graphicsCard3.setMemoryType("GDDR5");
		graphicsCard3.setMemorySize("2048 MB");
		graphicsCard3.setMemoryInterface("256 bit");
		graphicsCard3.setCoreClockSpeed("1019 MHz");
		graphicsCard3.setMemoryClockSpeed("6008 MHz");
		graphicsCard3.setOutputs("DVI, DisplayPort, HDMI");
		graphicsCard3.setMaxResolution("2560x1600");
		graphicsCard3.setDxVersion("DirectX 11");
		graphicsCard3.setMultiGpuSupport("3-Way SLI");
		
		Product product3 = productService.insertProduct(graphicsCard3);
		Assert.assertTrue("Product not of the required type", product3 instanceof GraphicsCard);

		//***********************************************************************************************

		GraphicsCard graphicsCard4 = new GraphicsCard();
		graphicsCard4.setTitle("Asus AMD Radeon HD 7950");
		graphicsCard4.setPrice(new BigDecimal(5299));
		graphicsCard4.setStock(1);
		graphicsCard4.setConnectionInterface("PCI-Express 3.0");
		graphicsCard4.setMemoryType("GDDR5");
		graphicsCard4.setMemorySize("3072 MB");
		graphicsCard4.setMemoryInterface("384 bit");
		graphicsCard4.setCoreClockSpeed("900 MHz");
		graphicsCard4.setMemoryClockSpeed("5000 MHz");
		graphicsCard4.setOutputs("DVI, DisplayPort, HDMI");
		graphicsCard4.setMaxResolution("2560x1600");
		graphicsCard4.setDxVersion("DirectX 11");
		graphicsCard4.setMultiGpuSupport("CrossFireX");
		
		Product product4 = productService.insertProduct(graphicsCard4);
		Assert.assertTrue("Product not of the required type", product4 instanceof GraphicsCard);

		//***********************************************************************************************

		GraphicsCard graphicsCard5 = new GraphicsCard();
		graphicsCard5.setTitle("Gigabyte Nvidia GTX 680");
		graphicsCard5.setPrice(new BigDecimal(6441));
		graphicsCard5.setStock(3);
		graphicsCard5.setConnectionInterface("PCI-Express 3.0");
		graphicsCard5.setMemoryType("GDDR5");
		graphicsCard5.setMemorySize("2048 MB");
		graphicsCard5.setMemoryInterface("256 bit");
		graphicsCard5.setCoreClockSpeed("1137 MHz");
		graphicsCard5.setMemoryClockSpeed("6008 MHz");
		graphicsCard5.setOutputs("DVI, DisplayPort, HDMI");
		graphicsCard5.setMaxResolution("2560x1600");
		graphicsCard5.setDxVersion("DirectX 11");
		graphicsCard5.setMultiGpuSupport("3-Way SLI");
		
		Product product5 = productService.insertProduct(graphicsCard5);
		Assert.assertTrue("Product not of the required type", product5 instanceof GraphicsCard);

		//***********************************************************************************************

		GraphicsCard graphicsCard6 = new GraphicsCard();
		graphicsCard6.setTitle("MSI Nvidia GTX 680 Lightning Edition");
		graphicsCard6.setPrice(new BigDecimal(7336));
		graphicsCard6.setStock(5);
		graphicsCard6.setConnectionInterface("PCI-Express 3.0");
		graphicsCard6.setMemoryType("GDDR5");
		graphicsCard6.setMemorySize("2048 MB");
		graphicsCard6.setMemoryInterface("256 bit");
		graphicsCard6.setCoreClockSpeed("1176 MHz");
		graphicsCard6.setMemoryClockSpeed("6008 MHz");
		graphicsCard6.setOutputs("DVI, DisplayPort, HDMI");
		graphicsCard6.setMaxResolution("2560x1600");
		graphicsCard6.setDxVersion("DirectX 11");
		graphicsCard6.setMultiGpuSupport("3-Way SLI");
		
		Product product6 = productService.insertProduct(graphicsCard6);
		Assert.assertTrue("Product not of the required type", product6 instanceof GraphicsCard);
	}

	@Test
	public void hardDiskDriveTest() {
		
		HardDiskDrive hardDiskDrive = new HardDiskDrive();
		hardDiskDrive.setTitle("Seagate Barracuda 2TB");
		hardDiskDrive.setPrice(new BigDecimal(1189));
		hardDiskDrive.setStock(10);
		hardDiskDrive.setCapacity("2TB");
		hardDiskDrive.setFormFactor("3.5");
		hardDiskDrive.setBus("Sata 3");
		hardDiskDrive.setCache(64);
		hardDiskDrive.setSpinRate("7200RPM");
		
		Product product = productService.insertProduct(hardDiskDrive);
		Assert.assertTrue("Product not of the required type", product instanceof HardDiskDrive);

		//***********************************************************************************************

		HardDiskDrive hardDiskDrive2 = new HardDiskDrive();
		hardDiskDrive2.setTitle("Western Digital Caviar Green 3TB");
		hardDiskDrive2.setPrice(new BigDecimal(1599));
		hardDiskDrive2.setStock(2);
		hardDiskDrive2.setCapacity("3TB");
		hardDiskDrive2.setFormFactor("3.5");
		hardDiskDrive2.setBus("Sata 3");
		hardDiskDrive2.setCache(64);
		hardDiskDrive2.setSpinRate("5900RPM - 7200RPM");
		
		Product product2 = productService.insertProduct(hardDiskDrive2);
		Assert.assertTrue("Product not of the required type", product2 instanceof HardDiskDrive);

		//***********************************************************************************************

		HardDiskDrive hardDiskDrive3 = new HardDiskDrive();
		hardDiskDrive3.setTitle("Seagate Barracuda 3TB");
		hardDiskDrive3.setPrice(new BigDecimal(1699));
		hardDiskDrive3.setStock(5);
		hardDiskDrive3.setCapacity("3TB");
		hardDiskDrive3.setFormFactor("3.5");
		hardDiskDrive3.setBus("Sata 3");
		hardDiskDrive3.setCache(64);
		hardDiskDrive3.setSpinRate("7200RPM");
		
		Product product3 = productService.insertProduct(hardDiskDrive3);
		Assert.assertTrue("Product not of the required type", product3 instanceof HardDiskDrive);

		//***********************************************************************************************

		HardDiskDrive hardDiskDrive4 = new HardDiskDrive();
		hardDiskDrive4.setTitle("Western Digital Scorpio Black 320GB");
		hardDiskDrive4.setPrice(new BigDecimal(658));
		hardDiskDrive4.setStock(4);
		hardDiskDrive4.setCapacity("320GB");
		hardDiskDrive4.setFormFactor("2.5");
		hardDiskDrive4.setBus("Sata 2");
		hardDiskDrive4.setCache(16);
		hardDiskDrive4.setSpinRate("7200RPM");
		
		Product product = productService.insertProduct(hardDiskDrive4);
		Assert.assertTrue("Product not of the required type", product4 instanceof HardDiskDrive);

		//***********************************************************************************************

		HardDiskDrive hardDiskDrive5 = new HardDiskDrive();
		hardDiskDrive5.setTitle("Seagate Momentus XT Hybrid Drive 750GB");
		hardDiskDrive5.setPrice(new BigDecimal(1530));
		hardDiskDrive5.setStock(3);
		hardDiskDrive5.setCapacity("750GB");
		hardDiskDrive5.setFormFactor("2.5");
		hardDiskDrive5.setBus("Sata 3");
		hardDiskDrive5.setCache(32);
		hardDiskDrive5.setSpinRate("7200RPM");
		
		Product product5 = productService.insertProduct(hardDiskDrive5);
		Assert.assertTrue("Product not of the required type", product5 instanceof HardDiskDrive);

		//***********************************************************************************************

		HardDiskDrive hardDiskDrive6 = new HardDiskDrive();
		hardDiskDrive6.setTitle("Western Digital Caviar Black 2TB");
		hardDiskDrive6.setPrice(new BigDecimal(1898));
		hardDiskDrive6.setStock(1);
		hardDiskDrive6.setCapacity("2TB");
		hardDiskDrive6.setFormFactor("3.5");
		hardDiskDrive6.setBus("Sata 3");
		hardDiskDrive6.setCache(64);
		hardDiskDrive6.setSpinRate("7200RPM");
		
		Product product6 = productService.insertProduct(hardDiskDrive6);
		Assert.assertTrue("Product not of the required type", product6 instanceof HardDiskDrive);
	}
	
	@Test
	public void solidStateDriveTest() {
		
		SolidStateDrive solidStateDrive = new SolidStateDrive();
		solidStateDrive.setTitle("OCZ Vertex 4 128GB");
		solidStateDrive.setPrice(new BigDecimal(1499));
		solidStateDrive.setStock(3);
		solidStateDrive.setCapacity("128 GB");
		solidStateDrive.setFormFactor("2.5");
		solidStateDrive.setBus("Sata 3");
		solidStateDrive.setCache(1024);
		solidStateDrive.setReadSpeed(550 MB/s);
		solidStateDrive.setWriteSpeed(420 MB/s);
		
		Product product = productService.insertProduct(solidStateDrive);
		Assert.assertTrue("Product not of the required type", product instanceof SolidStateDrive);

		//***********************************************************************************************

		SolidStateDrive solidStateDrive2 = new SolidStateDrive();
		solidStateDrive2.setTitle("OCZ Vertex 4 256GB");
		solidStateDrive2.setPrice(new BigDecimal(2699));
		solidStateDrive2.setStock(2);
		solidStateDrive2.setCapacity("256 GB");
		solidStateDrive2.setFormFactor("2.5");
		solidStateDrive2.setBus("Sata 3");
		solidStateDrive2.setCache(1024);
		solidStateDrive2.setReadSpeed(550 MB/s);
		solidStateDrive2.setWriteSpeed(465 MB/s);
		
		Product product2 = productService.insertProduct(solidStateDrive2);
		Assert.assertTrue("Product not of the required type", product2 instanceof SolidStateDrive);

		//***********************************************************************************************

		SolidStateDrive solidStateDrive3 = new SolidStateDrive();
		solidStateDrive3.setTitle("Crucial 128GB");
		solidStateDrive3.setPrice(new BigDecimal(1300));
		solidStateDrive3.setStock(1);
		solidStateDrive3.setCapacity("128 GB");
		solidStateDrive3.setFormFactor("2.5");
		solidStateDrive3.setBus("Sata 3");
		solidStateDrive3.setCache();
		solidStateDrive3.setReadSpeed(415 MB/s);
		solidStateDrive3.setWriteSpeed(175 MB/s);
		
		Product product3 = productService.insertProduct(solidStateDrive3);
		Assert.assertTrue("Product not of the required type", product3 instanceof SolidStateDrive);

		//***********************************************************************************************

		SolidStateDrive solidStateDrive4 = new SolidStateDrive();
		solidStateDrive4.setTitle("OCZ Vertex 3 480GB");
		solidStateDrive4.setPrice(new BigDecimal(5499));
		solidStateDrive4.setStock(2);
		solidStateDrive4.setCapacity("480 GB");
		solidStateDrive4.setFormFactor("2.5");
		solidStateDrive4.setBus("Sata 3");
		solidStateDrive4.setCache();
		solidStateDrive4.setReadSpeed( MB/s);
		solidStateDrive4.setWriteSpeed( MB/s);
		
		Product product4 = productService.insertProduct(solidStateDrive4);
		Assert.assertTrue("Product not of the required type", product4 instanceof SolidStateDrive);

		//***********************************************************************************************

		SolidStateDrive solidStateDrive5 = new SolidStateDrive();
		solidStateDrive5.setTitle("Patriot Wildfire 120GB");
		solidStateDrive5.setPrice(new BigDecimal(2461));
		solidStateDrive5.setStock(1);
		solidStateDrive5.setCapacity("120 GB");
		solidStateDrive5.setFormFactor("2.5");
		solidStateDrive5.setBus("Sata 3");
		solidStateDrive5.setCache();
		solidStateDrive5.setReadSpeed(555 MB/s);
		solidStateDrive5.setWriteSpeed(520 MB/s);
		
		Product product5 = productService.insertProduct(solidStateDrive5);
		Assert.assertTrue("Product not of the required type", product5 instanceof SolidStateDrive);

		//***********************************************************************************************

		SolidStateDrive solidStateDrive6 = new SolidStateDrive();
		solidStateDrive6.setTitle("Transcend Value Series 64GB");
		solidStateDrive6.setPrice(new BigDecimal(879));
		solidStateDrive6.setStock(5);
		solidStateDrive6.setCapacity("64 GB");
		solidStateDrive6.setFormFactor("2.5");
		solidStateDrive6.setBus("Sata 3");
		solidStateDrive6.setCache();
		solidStateDrive6.setReadSpeed( MB/s);
		solidStateDrive6.setWriteSpeed( MB/s);
		
		Product product6 = productService.insertProduct(solidStateDrive6);
		Assert.assertTrue("Product not of the required type", product6 instanceof SolidStateDrive);
	}
	
	@Test
	public void memoryTest() {
		Memory memory = new Memory();
		memory.setTitle("Transcend JetRam 4GB");
		memory.setPrice(new BigDecimal(190));
		memory.setStock(25);
		memory.setModules(1);
		memory.setSize("4 GB");
		memory.setType("DDR 3");
		memory.setVoltage();
		memory.setFrequency("1333 MHz");
		memory.setLatency("");
		
		Product product = productService.insertProduct(memory);
		Assert.assertTrue("Product not of the required type", product instanceof Memory);

		//***********************************************************************************************

		Memory memory2 = new Memory();
		memory2.setTitle("Corsair Vengeance 8GB");
		memory2.setPrice(new BigDecimal(566));
		memory2.setStock(9);
		memory2.setModules(2);
		memory2.setSize("8 GB");
		memory2.setType("DDR 3");
		memory2.setVoltage(1.5f);
		memory2.setFrequency("1600 MHz");
		memory2.setLatency("");
		
		Product product2 = productService.insertProduct(memory2);
		Assert.assertTrue("Product not of the required type", product2 instanceof Memory);

		//***********************************************************************************************

		Memory memory3 = new Memory();
		memory3.setTitle("Corsair Vengeance 4GB OC");
		memory3.setPrice(new BigDecimal(247));
		memory3.setStock(12);
		memory3.setModules(1);
		memory3.setSize("4 GB");
		memory3.setType("DDR 3");
		memory3.setVoltage(1.5f);
		memory3.setFrequency("1600 MHz");
		memory3.setLatency("9-9-9-24");
		
		Product product3 = productService.insertProduct(memory3);
		Assert.assertTrue("Product not of the required type", product3 instanceof Memory);

		//***********************************************************************************************

		Memory memory4 = new Memory();
		memory4.setTitle("Patriot Viper Extreme Series 8GB");
		memory4.setPrice(new BigDecimal(675));
		memory4.setStock(4);
		memory4.setModules(2);
		memory4.setSize("8 GB");
		memory4.setType("DDR 3");
		memory4.setVoltage(1.65f);
		memory4.setFrequency("2133 MHz");
		memory4.setLatency("11-11-11-30");
		
		Product product4 = productService.insertProduct(memory4);
		Assert.assertTrue("Product not of the required type", product4 instanceof Memory);

		//***********************************************************************************************

		Memory memory5 = new Memory();
		memory5.setTitle("Corsair Dominator Platinum 8GB");
		memory5.setPrice(new BigDecimal(1431));
		memory5.setStock(3);
		memory5.setModules(2);
		memory5.setSize("8 GB");
		memory5.setType("DDR 3");
		memory5.setVoltage();
		memory5.setFrequency("2133 MHz");
		memory5.setLatency("9-11-10-27");
		
		Product product5 = productService.insertProduct(memory5);
		Assert.assertTrue("Product not of the required type", product5 instanceof Memory);

		//***********************************************************************************************

		Memory memory6 = new Memory();
		memory6.setTitle("AMD Entertainment Series 4GB");
		memory6.setPrice(new BigDecimal(277));
		memory6.setStock(3);
		memory6.setModules(1);
		memory6.setSize("4 GB");
		memory6.setType("DDR 3");
		memory6.setVoltage(1.5f);
		memory6.setFrequency("1600 MHz");
		memory6.setLatency("");
		
		Product product6 = productService.insertProduct(memory6);
		Assert.assertTrue("Product not of the required type", product6 instanceof Memory);
	}
	
	@Test
	public void powerSupplyTest() {
		
		PowerSupplyUnit powerSupply = new PowerSupplyUnit();
		powerSupply.setTitle("RaidMax 730W");
		powerSupply.setPrice(new BigDecimal(675));
		powerSupply.setStock(12);
		powerSupply.setPower("730 Watt");
		powerSupply.setModular(false);
		powerSupply.setAtx(3);
		powerSupply.setEps();
		powerSupply.setPcie();
		powerSupply.setMolex();
		powerSupply.setSata(6);
		powerSupply.setFloppy();
		
		Product product = productService.insertProduct(powerSupply);
		Assert.assertTrue("Product not of the required type", product instanceof PowerSupplyUnit);

		//***********************************************************************************************

		PowerSupplyUnit powerSupply2 = new PowerSupplyUnit();
		powerSupply2.setTitle("Corsair Gamimg Series 700W");
		powerSupply2.setPrice(new BigDecimal(1055));
		powerSupply2.setStock(6);
		powerSupply2.setPower("700 Watt");
		powerSupply2.setModular(false);
		powerSupply2.setAtx(1);
		powerSupply2.setEps(1);
		powerSupply2.setPcie(2);
		powerSupply2.setMolex(8);
		powerSupply2.setSata(6);
		powerSupply2.setFloppy();
		
		Product product2 = productService.insertProduct(powerSupply2);
		Assert.assertTrue("Product not of the required type", product2 instanceof PowerSupplyUnit);

		//***********************************************************************************************
		
		PowerSupplyUnit powerSupply3 = new PowerSupplyUnit();
		powerSupply3.setTitle("Thermaltake LitePower 350W");
		powerSupply3.setPrice(new BigDecimal(197));
		powerSupply3.setStock(23);
		powerSupply3.setPower("350 Watt");
		powerSupply3.setModular(false);
		powerSupply3.setAtx();
		powerSupply3.setEps();
		powerSupply3.setPcie();
		powerSupply3.setMolex();
		powerSupply3.setSata();
		powerSupply3.setFloppy();
		
		Product product3 = productService.insertProduct(powerSupply3);
		Assert.assertTrue("Product not of the required type", product3 instanceof PowerSupplyUnit);

		//***********************************************************************************************
		
		PowerSupplyUnit powerSupply4 = new PowerSupplyUnit();
		powerSupply4.setTitle("Cooler Mater Siletnt Pro M2 1000W");
		powerSupply4.setPrice(new BigDecimal(2075));
		powerSupply4.setStock(3);
		powerSupply4.setPower("1000 Watt");
		powerSupply4.setModular(true);
		powerSupply4.setAtx();
		powerSupply4.setEps();
		powerSupply4.setPcie(6);
		powerSupply4.setMolex(5);
		powerSupply4.setSata(12);
		powerSupply4.setFloppy(1);
		
		Product product4 = productService.insertProduct(powerSupply4);
		Assert.assertTrue("Product not of the required type", product4 instanceof PowerSupplyUnit);

		//***********************************************************************************************

		PowerSupplyUnit powerSupply5 = new PowerSupplyUnit();
		powerSupply5.setTitle("Corsair 1200W");
		powerSupply5.setPrice(new BigDecimal(3087));
		powerSupply5.setStock(3);
		powerSupply5.setPower("1200 Watt");
		powerSupply5.setModular(true);
		powerSupply5.setAtx(1);
		powerSupply5.setEps(2);
		powerSupply5.setPcie(6);
		powerSupply5.setMolex(12);
		powerSupply5.setSata(16);
		powerSupply5.setFloppy();
		
		Product product5 = productService.insertProduct(powerSupply5);
		Assert.assertTrue("Product not of the required type", product5 instanceof PowerSupplyUnit);

		//***********************************************************************************************

		PowerSupplyUnit powerSupply6 = new PowerSupplyUnit();
		powerSupply6.setTitle("Antec HCP 1200W");
		powerSupply6.setPrice(new BigDecimal(3003));
		powerSupply6.setStock(1);
		powerSupply6.setPower("1200 Watt");
		powerSupply6.setModular(true);
		powerSupply6.setAtx();
		powerSupply6.setEps();
		powerSupply6.setPcie();
		powerSupply6.setMolex();
		powerSupply6.setSata();
		powerSupply6.setFloppy();
		
		Product product6 = productService.insertProduct(powerSupply6);
		Assert.assertTrue("Product not of the required type", product6 instanceof PowerSupplyUnit);
	}
	
	@Test
	public void motherboardTest() {
		
		/* TODO: CHANGE TO MOTHERBOARD 
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
		*/
	}
	
	@Test
	public void processorTest() {
		
		Processor processor = new Processor();
		processor.setTitle("AMD FX 6-Core 6100 3.3GHz");
		processor.setPrice(new BigDecimal(1664));
		processor.setStock(3);
		processor.setFamily();
		processor.setClockSpeed(3.3f);
		processor.setBoostClock(3.9f);
		processor.setSocket("AM3+");
		processor.setCache(8);
		processor.setCores(6);
		processor.setThreads();
		
		Product product = productService.insertProduct(processor);
		Assert.assertTrue("Product not of the required type", product instanceof Processor);

		//***********************************************************************************************

		Processor processor2 = new Processor();
		processor2.setTitle("AMD Sempron 145 2.8GHz");
		processor2.setPrice(new BigDecimal(421));
		processor2.setStock(4);
		processor2.setFamily();
		processor2.setClockSpeed(2.8f);
		processor2.setBoostClock();
		processor2.setSocket("");
		processor2.setCache(1);
		processor2.setCores(1);
		processor2.setThreads();
		
		Product product2 = productService.insertProduct(processor2);
		Assert.assertTrue("Product not of the required type", product2 instanceof Processor);

		Processor processor3 = new Processor();
		processor3.setTitle("AMD FX 8150 8-Core 3.6GHz");
		processor3.setPrice(new BigDecimal(2415));
		processor3.setStock(4);
		processor3.setFamily();
		processor3.setClockSpeed(3.6f);
		processor3.setBoostClock(4.2f);
		processor3.setSocket("AM3+");
		processor3.setCache(8);
		processor3.setCores(8);
		processor3.setThreads();
		
		Product product3 = productService.insertProduct(processor3);
		Assert.assertTrue("Product not of the required type", product3 instanceof Processor);

		//***********************************************************************************************
	}
	
	@Test
	public void processorWithInternalGPUTest() {
		
		Processor processor = new Processor();
		processor.setTitle("Intel Core I3 2120 3.30GHz");
		processor.setPrice(new BigDecimal(1327));
		processor.setStock(7);
		processor.setFamily();
		processor.setClockSpeed(3.3f);
		processor.setBoostClock(3.8f);
		processor.setSocket("1155");
		processor.setCache(3);
		processor.setCores(2);
		processor.setThreads(4);
		
		IntegratedGPU integratedGPU = new IntegratedGPU();
		integratedGPU.setName("Intel ");
		integratedGPU.setBaseClock(850f);
		integratedGPU.setDisplays(2);
		processor.setIntegratedGPU(integratedGPU);

		Product product = productService.insertProduct(processor);
		Assert.assertTrue("Product not of the required type", product instanceof Processor);

		//***********************************************************************************************

		Processor processor2 = new Processor();
		processor2.setTitle("Intel Core I5 3570K 3.40GHz");
		processor2.setPrice(new BigDecimal(2349));
		processor2.setStock(5);
		processor2.setFamily();
		processor2.setClockSpeed(3.4f);
		processor2.setBoostClock(3.8f);
		processor2.setSocket("1155");
		processor2.setCache(6);
		processor2.setCores(4);
		processor2.setThreads(4);
		
		IntegratedGPU integratedGPU2 = new IntegratedGPU();
		integratedGPU2.setName("Intel 4000");
		integratedGPU2.setBaseClock(1150f);
		integratedGPU2.setDisplays(3);
		processor.setIntegratedGPU(integratedGPU2);

		Product product2 = productService.insertProduct(processor2);
		Assert.assertTrue("Product not of the required type", product2 instanceof Processor);

		//***********************************************************************************************

		Processor processor3 = new Processor();
		processor3.setTitle("Intel Core I7 3770K 3.50GHz");
		processor3.setPrice(new BigDecimal(3669));
		processor3.setStock(5);
		processor3.setFamily("Ivy Bridge");
		processor3.setClockSpeed(3.5f);
		processor3.setBoostClock(3.9f);
		processor3.setSocket("1155");
		processor3.setCache(8);
		processor3.setCores(4);
		processor3.setThreads(8);
		
		IntegratedGPU integratedGPU3 = new IntegratedGPU();
		integratedGPU3.setName("Intel 4000");
		integratedGPU3.setBaseClock(650f);
		integratedGPU3.setDisplays(3);
		processor.setIntegratedGPU(integratedGPU3);

		Product product3 = productService.insertProduct(processor3);
		Assert.assertTrue("Product not of the required type", product3 instanceof Processor);
	}
}