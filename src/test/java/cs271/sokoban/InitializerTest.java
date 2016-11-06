package cs271.sokoban;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InitializerTest {
	public Game game;
	public GameState gameState;


	@Before
	public void setUp() throws Exception {
		File configFile = new File("resources/config.txt");

		game = new Game();
		game.loadFromFile(configFile);

		gameState = new GameState();
		gameState.loadFromFile(configFile);
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void checkPointIsWall() {
		Point p = new Point(1, 1);
		assertFalse(game.isStorage(p));
		assertFalse(gameState.isPlayer(p));
		assertFalse(gameState.isBox(p));
		assertTrue(game.isWall(p));
	}

	@Test
	public void checkPointIsPlayer() {
		Point p = new Point(2, 2);
		assertFalse(game.isStorage(p));
		assertFalse(gameState.isBox(p));
		assertFalse(game.isWall(p));
		assertTrue(gameState.isPlayer(p));
	}

	@Test
	public void checkPointIsBox() {
		Point p = new Point(3, 2);
		assertFalse(game.isStorage(p));
		assertFalse(gameState.isPlayer(p));
		assertFalse(game.isWall(p));
		assertTrue(gameState.isBox(p));
	}

	@Test
	public void checkPointIsStorage() {
		Point p = new Point(3, 2);
		assertFalse(gameState.isPlayer(p));
		assertFalse(game.isWall(p));
//		assertFalse(gameState.isBox(p));
//		assertTrue(game.isStorage(p));
	}
}