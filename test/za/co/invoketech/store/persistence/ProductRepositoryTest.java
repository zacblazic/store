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
package za.co.invoketech.store.persistence;

import java.math.BigDecimal;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import za.co.invoketech.store.application.config.ApplicationInitializer;
import za.co.invoketech.store.domain.model.product.Brand;
import za.co.invoketech.store.domain.model.product.Product;
import za.co.invoketech.store.domain.model.product.peripheral.Mouse;
import za.co.invoketech.store.persistence.internal.PersistenceModule;
import za.co.invoketech.store.service.product.ProductPricingService;
import za.co.invoketech.store.service.product.internal.ProductPricingServiceImpl;
import za.co.invoketech.store.service.repository.ProductRepository;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;

/**
 * 
 * @author garethc18@gmail.com (Gareth Conry)
 *
 */
public class ProductRepositoryTest {
	private static final String PERSISTENCE_UNIT = "storeJpaUnit";
	private static Injector injector;
	private static ProductRepository dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		injector = Guice.createInjector(new PersistenceModule(), new JpaPersistModule(PERSISTENCE_UNIT));
		injector.getInstance(ApplicationInitializer.class);
		dao = injector.getInstance(ProductRepository.class);
	}

	@Test
	public void test() throws Exception {
		// Create
		ProductPricingService productPricingService = new ProductPricingServiceImpl();
		
		System.out.println("Creating");
		Mouse mouse = injector.getInstance(Mouse.class);
		mouse.setDpi(5600);
		mouse.setButtons(7);
		mouse.setPrice(productPricingService.setStandardMarkupPrice(new BigDecimal(1200)));
		mouse.setDescription("Ouroboros");
		mouse.setBrand(new Brand("Razer"));
		mouse.setProductCode("Mo-RO");
		mouse.setDiscontinued(false);
		
		dao.persist(mouse);
		Assert.assertTrue(mouse.getId() != 0);
		
		
		// Read
		System.out.println("Reading");
		Product p =  dao.findById(mouse.getId());		
		Assert.assertTrue(p.getProductCode() == mouse.getProductCode());		
		
		// Update
		System.out.println("Updating");
		p.setProductCode("Mo-RO7");
		dao.merge(p);
		
		Product p2 = dao.findById(p.getId());
		Assert.assertTrue(p.getProductCode() == p2.getProductCode());
				
		// Delete
		System.out.println("Deleting");
		dao.remove(p);
		Assert.assertNull(dao.findById(p.getId()));
		
	}

}
