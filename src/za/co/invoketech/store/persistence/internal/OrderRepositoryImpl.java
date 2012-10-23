package za.co.invoketech.store.persistence.internal;

import za.co.invoketech.store.domain.model.order.Order;
import za.co.invoketech.store.service.repository.OrderRepository;

import com.google.inject.persist.Transactional;

@Transactional
class OrderRepositoryImpl extends GenericDaoImpl<Order, Long> implements OrderRepository {
	
	public OrderRepositoryImpl() {
		super(Order.class);
	}
}
