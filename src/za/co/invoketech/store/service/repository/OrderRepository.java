package za.co.invoketech.store.service.repository;

import za.co.invoketech.store.domain.model.order.Order;
import za.co.invoketech.store.persistence.dao.GenericDao;

public interface OrderRepository extends GenericDao<Order, Long> {

}
