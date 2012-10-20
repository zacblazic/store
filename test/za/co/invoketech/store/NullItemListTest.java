package za.co.invoketech.store;

import static com.google.common.base.Preconditions.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class NullItemListTest {

	@Test
	public void test() {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(null);
		list.add(null);
		
		for(Integer i : list) {
			checkNotNull(i);
		}
		
		Assert.assertEquals(list.size(), 2);
	}

}
