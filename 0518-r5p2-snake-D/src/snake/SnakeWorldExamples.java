package snake;

import geometry.*;
import draw.*;
import static org.junit.Assert.*;

import org.junit.Test;

import draw.Canvas;

// examples of the snake games
public class SnakeWorldExamples {
	
	
	//情報の例１つ目に対応
	Snake h1 = new Snake(new Posn(6,5), 
			new ConsSnakeBody( new BodyUnit(new Posn(5,5)), 
			new ConsSnakeBody( new BodyUnit(new Posn(5,6)),
			new MTSnakeBody())),
			new DirRight()
			);
	
	IApples a1 = 
			new ConsApples(new Apple(new Posn(8,2)),
			new ConsApples(new Apple(new Posn(1,9)),
			new MTApples()));
	
	SnakeWorld g1 = new SnakeWorld(h1,a1);
	
	//1つ目の例の蛇を移動させたもの。2つ目の例と一致するはず。
	SnakeWorld g12 = new SnakeWorld(h1.move(),a1);
	
	//情報の例２つ目に対応
	Snake h2 =new Snake(new Posn(7,5), 
			new ConsSnakeBody( new BodyUnit(new Posn(6,5)), 
			new ConsSnakeBody( new BodyUnit(new Posn(5,5)),
			new MTSnakeBody())),
			new DirRight()
			);
	
	IApples a2 = 
			new ConsApples(new Apple(new Posn(8,2)),
			new ConsApples(new Apple(new Posn(1,9)),
			new MTApples()));
	
	SnakeWorld g2 = new SnakeWorld(h2,a2);

	//情報の例3つ目に対応
		Snake h3 = new Snake(new Posn(3,1), 
				new ConsSnakeBody( new BodyUnit(new Posn(4,1)), 
				new ConsSnakeBody( new BodyUnit(new Posn(5,1)),
				new ConsSnakeBody( new BodyUnit(new Posn(5,2)),
				new ConsSnakeBody( new BodyUnit(new Posn(5,3)), 
				new ConsSnakeBody( new BodyUnit(new Posn(4,3)), 
				new ConsSnakeBody( new BodyUnit(new Posn(3,3)), 
				new ConsSnakeBody( new BodyUnit(new Posn(2,3)), 
				new ConsSnakeBody( new BodyUnit(new Posn(2,2)), 
				new ConsSnakeBody( new BodyUnit(new Posn(2,1)),
				new ConsSnakeBody( new BodyUnit(new Posn(2,0)),
				new MTSnakeBody())))))))))),
				new DirLeft()
				);
		
		IApples a3 = 
				new ConsApples(new Apple(new Posn(1,1)),
				new MTApples());
		
		SnakeWorld g3 = new SnakeWorld(h3,a3);	

		//３つ目の例の蛇を移動させたもの。4つ目の例と一致するはず。
		SnakeWorld g32 = new SnakeWorld(h3.move(),a3);

		//情報の例4つ目に対応
		Snake h4 = new Snake(new Posn(2,1), 
				new ConsSnakeBody( new BodyUnit(new Posn(3,1)), 
				new ConsSnakeBody( new BodyUnit(new Posn(4,1)), 
				new ConsSnakeBody( new BodyUnit(new Posn(5,1)),
				new ConsSnakeBody( new BodyUnit(new Posn(5,2)),
				new ConsSnakeBody( new BodyUnit(new Posn(5,3)), 
				new ConsSnakeBody( new BodyUnit(new Posn(4,3)), 
				new ConsSnakeBody( new BodyUnit(new Posn(3,3)), 
				new ConsSnakeBody( new BodyUnit(new Posn(2,3)), 
				new ConsSnakeBody( new BodyUnit(new Posn(2,2)), 
				new ConsSnakeBody( new BodyUnit(new Posn(2,1)),
				new MTSnakeBody())))))))))),
				new DirLeft()
				);
		
		IApples a4 = 
				new ConsApples(new Apple(new Posn(1,1)),
				new MTApples());
		
		SnakeWorld g4 = new SnakeWorld(h4,a4);	
	
	//Canvas
	Canvas c = new Canvas(360,360);
		
	@Test
	public void test() {
		/*
		assertEquals(true,c.show());
		assertEquals(true, g1.draw(c));
		assertEquals(true,c.pause());
		assertEquals(true, g12.draw(c));
		assertEquals(g12,g2);
		assertEquals(true,c.pause());
		assertEquals(true,g2.draw(c));
		assertEquals(true,c.pause());
		assertEquals(true,g3.draw(c));
		assertEquals(true,c.pause());
		assertEquals(true, g32.draw(c));
		assertEquals(g32,g4);
		assertEquals(true,g4.draw(c));
		assertEquals(true,c.pause());
		//fail("Not yet implemented");
		*/
		assertEquals(true, g1.bigBang(360, 360, 0.5));
	}

}
