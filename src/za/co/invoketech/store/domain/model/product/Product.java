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

import static com.google.common.base.Preconditions.checkState;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.annotations.Expose;

import za.co.invoketech.store.application.util.Dates;

/**
 * @author garethc18@gmail.com (Gareth Conry)
 */
@Entity
@Table(name = "PRODUCT")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PRODUCT_TYPE", discriminatorType=DiscriminatorType.STRING)
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "PRODUCT_ID")
	private long id;
	
	@Column(name = "TITLE", nullable = false)
	@Expose
	private String title;
	
	@Column(name = "UNIT_PRICE", nullable = false)
	private BigDecimal unitPrice;
	
	@Column(name = "STOCK", nullable = false)
	@Expose
	private long stock;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DISCONTINUED_DATE")
	private Date discontinuedDate;
	
	public Product() {}

	public long getId() 
	{
		return id;
	}
	
	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}   

	public long getStock() {
		return stock;
	}
	
	public void setStock(long stock) {
		this.stock = stock;
	}
	
	public BigDecimal getUnitPrice()
	{
		return unitPrice;
	}

	public void setPrice(BigDecimal unitPrice) 
	{
		this.unitPrice = unitPrice;
	}   
	
	public Date getDiscontinuedDate() 
	{
		return Dates.copy(discontinuedDate);
	}
	
	public boolean isDiscontinued() 
	{
		return discontinuedDate != null ? true : false;
	}
	
	public void setDiscontinued(boolean discontinued) {
		if(discontinued) {
			discontinuedDate = Dates.now();
		} else {
			discontinuedDate = null;
		}
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
