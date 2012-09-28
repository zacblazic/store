package za.co.invoketech.store.service.repository;

import java.util.List;

import za.co.invoketech.store.model.address.Address;
import za.co.invoketech.store.repository.dao.GenericDao;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

@Transactional
public class AddressRepository {

	@Inject
	private GenericDao<Address, Long> dao;

	public void setClazz(Class<Address> clazz) {
		dao.setClazz(clazz);
	}

	public Address findById(Long id) {
		return dao.findById(id);
	}

	public Address findByAttribute(String attribute, String value) {
		return dao.findByAttribute(attribute, value);
	}

	public List<Address> findEntitiesByAttribute(String attribute, String value) {
		return dao.findEntitiesByAttribute(attribute, value);
	}

	public List<Address> findInRange(int start, int end) {
		return dao.findInRange(start, end);
	}

	public List<Address> findAll() {
		return dao.findAll();
	}

	public void persist(Address entity) {
		dao.persist(entity);
	}

	public void merge(Address entity) {
		dao.merge(entity);
	}

	public void remove(Address entity) {
		dao.remove(entity);
	}

	public void removeById(Long id) {
		dao.removeById(id);
	}

	public long count() {
		return dao.count();
	}
}
