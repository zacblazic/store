package za.co.invoketech.store.model.entity.order;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Invoice
 *
 */
@Entity
@Table(name = "INVOICE")
public class Invoice implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "INVOICE_ID")
	private long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "INVOICE_DATE")
	private Date invoiceDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "PRINT_DATE")
	private Date printDate;
}
