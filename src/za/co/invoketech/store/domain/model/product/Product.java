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

package za.co.invoketech.store.domain.model.product;

import static com.google.common.base.Preconditions.*; 

import java.io.Serializable;
import java.lang.String;
import java.math.BigDecimal;

import javax.persistence.*;

/**
 * @author garethc18@gmail.com (Gareth Conry)
 */
@Entity
@Table (name = "PRODUCT")
@Inheritance (strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PRODUCT_TYPE", discriminatorType=DiscriminatorType.STRING)
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "PRODUCT_ID")
	private long id;
	
	@Column (name = "PRODUCT_CODE", unique = true)
	private String productCode;
	
	@Column (name = "DESCRIPTION")
	private String description;
	
	@Column (name = "PRICE")
	private BigDecimal price;
	
	@Column (name = "DISCONTINUED")
	private boolean discontinued;
	
	public Product() {
	}
	
	public static Product getInstance() {
		Product product = new Product();
		return product;
	}

	public long getId() 
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getProductCode() 
	{
		return this.productCode;
	}

	public void setProductCode(String productCode) 
	{
		this.productCode = productCode;
	}   
	
	public String getDescription() 
	{
		return this.description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}   
	
	public BigDecimal getPrice()
	{
		return this.price;
	}

	public void setPrice(BigDecimal price) 
	{
		this.price = price;
	}   
	
	public boolean getDiscontinued() 
	{
		return this.discontinued;
	}

	public void setDiscontinued(boolean discontinued) 
	{
		this.discontinued = discontinued;
	}
	
	@Override
	public boolean equals(Object object) {
		if(!(object instanceof Product)) {
			return false;
		}
		
		Product other = (Product)object;
		checkState(this.id != 0, "entity has not been persisted");
		checkState(other.id != 0, "entity has not been persisted");
		
		if(this.id != other.id) {
			return false;
		}
		
		return true;
	}
}
