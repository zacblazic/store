package za.co.invoketech.store;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import za.co.invoketech.store.application.config.ApplicationInitializer;
import za.co.invoketech.store.application.config.PersistenceModule;
import za.co.invoketech.store.model.address.Address;
import za.co.invoketech.store.model.address.PhysicalAddress;
import za.co.invoketech.store.model.address.PostOfficeBoxAddress;
import za.co.invoketech.store.model.address.PrivateBagAddress;
import za.co.invoketech.store.service.dao.AddressDao;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;


public class AddressDaoTest {

 private static final String PERSISTENCE_UNIT = "storeJpaUnit";
 private static Injector injector;
 private static AddressDao dao;
 
 @BeforeClass
 public static void setUpBeforeClass() throws Exception {
  
  injector = Guice.createInjector(new PersistenceModule(), new JpaPersistModule(PERSISTENCE_UNIT));
  injector.getInstance(ApplicationInitializer.class);
  dao = injector.getInstance(AddressDao.class);
 }
 
 @Test
 public void test() {

  List<Address> addressList = createAddresses();
  List<Long> addressIds = new ArrayList<Long>();
  testPersist(addressList, addressIds);
  testUpdate(addressIds);
  testDelete(addressIds);
 }
 
 private List<Address> createAddresses(){
  
  List<Address> addressList = new ArrayList<Address>();
  
  PhysicalAddress home = injector.getInstance(PhysicalAddress.class);  
  home.setUnitNumber("122");
  home.setStreetName("Athens Road");
  home.setSuburb("Table View");
  home.setCity("Cape Town");
  home.setCountry("South Africa");
  home.setPostalCode("7441");
  home.setFirstName("Zac");
  home.setLastName("Blazic");
  home.setPhoneNumber("+27215577102");
  addressList.add(home);
  
  PostOfficeBoxAddress pobox = injector.getInstance(PostOfficeBoxAddress.class);
  pobox.setBoxNumber("441");
  pobox.setSuburb("Century City");
  pobox.setCity("Cape Town");
  pobox.setCountry("South Africa");
  pobox.setPostalCode("7530");
  pobox.setFirstName("Carel");
  pobox.setLastName("Nel");
  pobox.setPhoneNumber("+27722239110");
  addressList.add(pobox);
  
  PrivateBagAddress pbag = injector.getInstance(PrivateBagAddress.class);
  pbag.setBagNumber("747");
  pbag.setSuburb("Zonnebloem");
  pbag.setCity("Cape Town");
  pbag.setCountry("South Africa");
  pbag.setPostalCode("8000");
  pbag.setFirstName("Ruan");
  pbag.setLastName("Möller");
  pbag.setPhoneNumber("+27768346153");
  addressList.add(pbag);
  
  return addressList;
 }
 
 private void testPersist(List<Address> addressList, List <Long>addressIds) {
  
	for(int i = 0; i < addressList.size(); i++){
   
		dao.persist(addressList.get(i));
		addressIds.add(addressList.get(i).getAddressId());
		Assert.assertNotNull(dao.findById(addressIds.get(i)));
	}
 }
 
 private void testUpdate(List<Long> addressIds){
	 
	 Address initialAddress = dao.findById(addressIds.get(1));
	 initialAddress.setCity("Johannesburg");
	 dao.merge(initialAddress);
	 Address updatedAddress = dao.findById(initialAddress.getAddressId());
	 Assert.assertTrue(updatedAddress.getCity().equals("Johannesburg"));
 }
 
 private void testDelete(List<Long> addressIds){
	 Address add = dao.findById(addressIds.get(1));
	 Long id = add.getAddressId();
	 dao.removeById(id);
	 Assert.assertNull(dao.findById(id));
 }
}