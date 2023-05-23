package transafer;

import static org.junit.Assert.*;

import org.junit.Test;

public class StationsExamples {

	ConsStations L1=new ConsStations("大井町",new MTStations());
	ConsStations L2=new ConsStations("旗の台",L1);
	@Test
	public void testAssignPost() {
		assertEquals(L2.name,((ConsStations)L1.post).name);
		
		
	}

}
