package za.co.invoketech.store.persistence.internal;

import za.co.invoketech.store.domain.model.invoice.Invoice;
import za.co.invoketech.store.service.repository.InvoiceRepository;

import com.google.inject.persist.Transactional;

@Transactional
class InvoiceRepositoryImpl extends GenericDaoImpl<Invoice, Long> implements InvoiceRepository {
	
	InvoiceRepositoryImpl() {
		super(Invoice.class);
	}
}
