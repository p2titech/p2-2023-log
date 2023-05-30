package snake;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListExamples {
	IList<Integer> l1 = 
			new Cons<Integer>(3, 
					new Cons<Integer>(2, 
							new MT<Integer>())); 
	IList<String> l2 = 
			new Cons<String>("3", 
					new Cons<String>("2", 
							new MT<String>()));
	
	class ToString implements IFun<Integer,String> {
		@Override
		public String process(Integer x) {
			return Integer.toString(x);
		}
	}
	
	class Sum implements IOp<Integer,Integer> {
		@Override
		public Integer combine(Integer x, Integer y) {
			return x+y;
		}
	}
	class Product implements IOp<Integer,Integer> {
		@Override
		public Integer combine(Integer x, Integer y) {
			return x*y;
		}
	}
	
	@Test
	public void testMap() {
		assertEquals(l2, l1.map(new ToString()));
	}

	@Test
	public void testFold() {
		assertEquals(5, (int)(l1.fold(new Sum(),0)));
		assertEquals(6, (int)(l1.fold(new Product(),1)));
	}

}
