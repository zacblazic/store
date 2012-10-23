package za.co.invoketech.store.repository.dao.internal;

import za.co.invoketech.store.domain.model.invoice.Invoice;
import za.co.invoketech.store.service.dao.InvoiceDao;

import com.google.inject.persist.Transactional;

@Transactional
class InvoiceDaoImpl extends GenericDaoImpl<Invoice, Long> implements InvoiceDao {
	
	InvoiceDaoImpl() {
		super(Invoice.class);
	}
}
