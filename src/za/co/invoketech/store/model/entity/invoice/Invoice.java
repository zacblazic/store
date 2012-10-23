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

package za.co.invoketech.store.model.entity.invoice;

import static com.google.common.base.Preconditions.checkNotNull;
import static za.co.invoketech.store.application.util.DefensiveDate.copyDate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import za.co.invoketech.store.model.entity.order.Order;

/**
 * @author zacblazic@gmail.com (Zac Blazic)
 */
@Entity
@Table(name = "INVOICE")
public class Invoice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "INVOICE_ID")
	private long id;
	
	@OneToOne(mappedBy = "invoice", fetch = FetchType.LAZY)
	@JoinColumn(name = "INVOICE_ID", nullable = false)
	private Order order;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "INVOICE_DATE", nullable = false)
	private Date invoiceDate;
	
	/**
	 * @deprecated
	 * Default constructor should only be used by the persistence mechanism.
	 */
	public Invoice() {}
	
	public Invoice(Order order) {
		checkOrder(order);
		this.order = order;
		this.invoiceDate = Calendar.getInstance().getTime();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}
	
	public Date getInvoiceDate() {
		return copyDate(invoiceDate);
	}
	
	public int getItemCount() {
		return order.getItemCount();
	}
	
	public BigDecimal getAmount() {
		return order.getAmount();
	}
	
	public BigDecimal getTax() {
		return order.getTax();
	}
	
	public BigDecimal getAmountWithTax() {
		return order.getAmountWithTax();
	}
	
	private void checkOrder(Order order) {
		checkNotNull(order, "order cannot be null");
	}
}
