package za.co.invoketech.store.service.repository;

import za.co.invoketech.store.domain.model.invoice.Invoice;
import za.co.invoketech.store.persistence.dao.GenericDao;

public interface InvoiceRepository extends GenericDao<Invoice, Long> {

}
