package snake;

import static org.junit.Assert.*;

import org.junit.Test;

import draw.*;

// examples of the snake games
public class SnakeWorldExamples {
	Position north = new Position( 0,-1);
	Position west  = new Position(-1, 0);
	Position south = new Position( 0, 1);
	Position east  = new Position( 1, 0);
	
	// hN and hNa respectively represent the snake in the Nth example
	// before and after moving
	
	//例1
	Snake h1 = new Snake(new Position(1,1), east,
			new ConsBody(new Node(new Position( 0, 1)),
			new ConsBody(new Node(new Position(0,0)),
					new MTBody())));
	Snake h1a = new Snake(new Position(2,1), east,
			new ConsBody(new Node(new Position( 1, 1)),
			new ConsBody(new Node(new Position( 0, 1)),
					new MTBody())));
		IList<Apple> a1 = 
				new Cons<Apple>(new Apple(new Position(9,7)),
				new Cons<Apple>(new Apple(new Position(5,9)),
				new MT<Apple>()));
	SnakeWorld g1  = new SnakeWorld(h1, a1);
	SnakeWorld g1a = new SnakeWorld(h1a,a1);

	//例2
	Snake h2 = new Snake(new Position(0,9), south,
			new ConsBody(new Node(new Position(0,8)),
			new ConsBody(new Node(new Position(1,8)),
			new ConsBody(new Node(new Position(1,9)),
					new MTBody()))));
	Snake h2a = new Snake(new Position(0,10), south,
			new ConsBody(new Node(new Position(0,9)),
			new ConsBody(new Node(new Position(0,8)),
			new ConsBody(new Node(new Position(1,8)),
					new MTBody()))));
	IList<Apple> a2 = 
			new Cons<Apple>(new Apple(new Position(9,9)),
			new Cons<Apple>(new Apple(new Position(0,0)),
			new Cons<Apple>(new Apple(new Position(0,9)),
			new MT<Apple>())));
	SnakeWorld g2  = new SnakeWorld(h2, a2);
	SnakeWorld g2a = new SnakeWorld(h2a,a2);
	
	//例3
	Snake h3 = new Snake(new Position(3,4), west,
			new ConsBody(new Node(new Position(3,3)),
			new ConsBody(new Node(new Position(2,3)),
			new ConsBody(new Node(new Position(1,3)),
					new MTBody()))));
	Snake h3a = new Snake(new Position(2,4), west,
			new ConsBody(new Node(new Position(3,4)),
			new ConsBody(new Node(new Position(3,3)),
			new ConsBody(new Node(new Position(2,3)),
					new MTBody()))));
	IList<Apple> a3 = 
			new Cons<Apple>(new Apple(new Position(0,0)),
			new MT<Apple>());
	SnakeWorld g3  = new SnakeWorld(h3, a3);
	SnakeWorld g3a = new SnakeWorld(h3a,a3);
	
	//例4
	Snake h4 = new Snake(new Position(2,4),north,
			new ConsBody(new Node(new Position(3,4)),
			new ConsBody(new Node(new Position(3,3)),
			new ConsBody(new Node(new Position(2,3)),
			new ConsBody(new Node(new Position(1,3)),
					new MTBody())))));
	Snake h4a = new Snake(new Position(2,3),north,
			new ConsBody(new Node(new Position(2,4)),
			new ConsBody(new Node(new Position(3,4)),
			new ConsBody(new Node(new Position(3,3)),
			new ConsBody(new Node(new Position(2,3)),
					new MTBody())))));
	IList<Apple> a4 = new MT<Apple>(); 
	SnakeWorld g4  = new SnakeWorld(h4, a4);
	SnakeWorld g4a = new SnakeWorld(h4a,a4);
	
	@Test
	public void testUpdate() {
		assertEquals(g1a, g1.update());
		assertEquals(g2a, g2.update());
		assertEquals(g3a, g3.update());
		assertEquals(g4a, g4.update());
	}

	@Test
	public void testOnBody() {
		assertEquals(false, h4.isOnBody());
		assertEquals(true, h4a.isOnBody());
	}

	@Test
	public void testDraw() {
		Canvas c = new Canvas(g1.getWidthPX(), g1.getHeightPX());
		//assertEquals(true, );
	}
	
	@Test
	public void testSnakeWorld() {
		assertEquals(true, g3.bigBang(g3.getWidthPX(), g3.getHeightPX(), 0.5));
	}



}
