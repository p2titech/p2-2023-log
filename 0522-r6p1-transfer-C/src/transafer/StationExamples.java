package transafer;

import static org.junit.Assert.*;

import org.junit.Test;

public class StationExamples {
	
	Line OimachiLine = new Line();
	Station oimachi = new Station("Oimachi", OimachiLine);
	Station hatanodai = new Station("Hatanodai", OimachiLine);
	Station ookayama= new Station("Ookayama", OimachiLine);
	Station jiyugaoka = new Station("Jiyugaoka", OimachiLine);
	Station futakotamagawa = new Station("Futakotamagawa", OimachiLine);
	Station mizonokuchi = new Station("Mizonokuchi", OimachiLine);
	
	@Test
	public void test() {
		assertEquals(mizonokuchi, ookayama.boundFor(jiyugaoka));
		assertEquals(oimachi, mizonokuchi.boundFor(oimachi));
		assertEquals(oimachi, ookayama.boundFor(oimachi));
	}

}
