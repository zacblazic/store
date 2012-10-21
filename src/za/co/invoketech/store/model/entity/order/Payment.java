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

package za.co.invoketech.store.model.entity.order;

import static com.google.common.base.Preconditions.*;

import static za.co.invoketech.store.application.util.DefensiveDate.copyDate;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author zacblazic@gmail.com (Zac Blazic)
 */
@Entity
@Table(name = "PAYMENT")
public class Payment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "PAYMENT_ID")
	private long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "PAYMENT_METHOD", nullable = false)
	private PaymentMethod method;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "PAID_DATE")
	private Date paidDate;
	
	/**
	 * @deprecated
	 * Default constructor should only be used by the persistence mechanism.
	 */
	public Payment() {}
	
	public Payment(PaymentMethod method) {
		checkMethod(method);
		this.method = method;
	}
	
	public Payment(Payment payment) {
		checkPayment(payment);
		this.id = payment.id;
		this.paidDate = copyDate(payment.paidDate);
		this.method = payment.method;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PaymentMethod getMethod() {
		return method;
	}

	public void setMethod(PaymentMethod method) {
		checkMethod(method);
		this.method = method;
	}
	
	public Date getPaidDate() {
		return copyDate(paidDate);
	}
	
	public boolean isPaid() {
		return paidDate != null ? true : false;
	}
	
	public void setPaid(boolean paid) {
		if(paid) {
			paidDate = Calendar.getInstance().getTime();
		} else {
			paidDate = null;
		}
	}
	
	private void checkMethod(PaymentMethod method) {
		checkNotNull(method, "method cannot be null");
	}
	
	private void checkPayment(Payment payment) {
		checkNotNull(payment, "payment cannot be null");
	}
}
