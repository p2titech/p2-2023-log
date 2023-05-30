package block;
import static org.junit.Assert.*;

import org.junit.Test;
//import draw.*;

//an example of the block worlds 
public class BlockWorldExample {
  BlockWorld w1 = new BlockWorld();

  @Test
  public void testBlockWorld() {
    assertEquals(true, w1.bigBang(w1.getCanvasWidth(), w1.getCanvasHeight(), 0.5));
  }

//  //@Test
//  public void testDraw() {
//	  Canvas c = new Canvas(w1.getCanvasWidth(),w1.getCanvasHeight());
//	  assertEquals(true, c.show());
//	  assertEquals(true, w1.drawAll(c));
//	  assertEquals(true, c.pause());
//	  assertEquals(true, ((BlockWorld) w1.onTick()).drawAll(c));
//	  assertEquals(true, c.pause());
//  }
//  
//  @Test
//  public void testConstructor() {
//	  assertEquals(new DrpBlock(0,0), ((ConsBlocks)w1.fixed).fst);
//	  assertEquals(new DrpBlock(1,0), 
//			  ((ConsBlocks)((ConsBlocks)w1.fixed).rst).fst);
//  }
//
//  @Test
//  public void testOnTick() {
//	  BlockWorld w2 = (BlockWorld) w1.onTick();
//	  assertEquals(w1.fixed, w2.fixed);
//	  BlockWorld w6 = (BlockWorld) w2.onTick().onTick().onTick().onTick().onTick();
//	  assertEquals(true, ((ConsBlocks)w6.falling).fst.equals(new DrpBlock(6,w1.WIDTH/2)));
//	  
//  }
//  
////  @Test
//  public void testLanded() {
//	  assertEquals(false, w1.falling.landed(w1.fixed));
//	  BlockWorld w13 = (BlockWorld) w1.onTick().onTick().onTick().onTick()
//			  .onTick().onTick().onTick().onTick().onTick().onTick()
//			  .onTick().onTick().onTick().onTick();
//	BlockWorld w14 = (BlockWorld) w13.onTick();
//	BlockWorld w16 = (BlockWorld) w14.onTick().onTick();
//	  assertEquals(false, (w13.falling.landed(w13.fixed)));
//	  assertEquals(false, (w14.falling.landed(w14.fixed)));
//	  assertEquals(true, (w16.falling.landed(w16.fixed)));
//  }
//    Canvas c = new Canvas(200, 200);
//
//  @Test
//  public void testDrop() {
//    assertEquals(true, c.show()
//        && b1.draw(c)
//        && b1.drop().drop().drop().drop().drop().drop().drop().drop().drop()
//            .drop().drop().draw(c));
//    assertEquals(new DrpBlock(11, 20), b1.drop());
//  }
//

}
