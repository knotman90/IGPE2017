package it.unical.it.igpe2017.arkanoid.GUI;

import java.util.Iterator;
import java.util.List;

import it.unical.it.igpe2017.arkanoid.core.Scene;
import it.unical.it.igpe2017.arkanoid.core.obstacle.Obstacle;
import it.unical.it.igpe2017.arkanoid.core.player.Ball;
import it.unical.it.igpe2017.arkanoid.core.player.PlayerBar;
import it.unical.it.igpe2017.arkanoid.core.utils.Vector2d;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogicgames.superjumper.Assets;
import com.badlogicgames.superjumper.World;

public class Renderer {
	
	static final float FRUSTUM_WIDTH = 10;
	static final float FRUSTUM_HEIGHT = 15;
	Scene world;
	OrthographicCamera cam;
	SpriteBatch batch;
	
	
	public Renderer (SpriteBatch batch, Scene world) {
		this.world = world;
		this.cam = new OrthographicCamera(FRUSTUM_WIDTH, FRUSTUM_HEIGHT);
		this.cam.position.set(FRUSTUM_WIDTH / 2, FRUSTUM_HEIGHT / 2, 0);
		this.batch = batch;
	}

	public void render () {
		batch.setProjectionMatrix(cam.combined);
		renderBackground();
		renderObjects();
	}
	
	public void renderBackground () {
		batch.disableBlending();
		batch.begin();
		batch.draw(AssetsManager.backgroundRegion, cam.position.x - FRUSTUM_WIDTH / 2, cam.position.y - FRUSTUM_HEIGHT / 2, FRUSTUM_WIDTH,
			FRUSTUM_HEIGHT);
		batch.end();
	}
	
	public void renderObjects () {
		batch.enableBlending();
		batch.begin();
		renderPlayerBar();
		renderBall();
		renderObstacles();
		batch.end();
	}

	private void renderObstacles() {
		List<Obstacle> obstacles;
		for (Iterator iterator = obstacles.iterator(); iterator.hasNext();) {
			Obstacle obstacle = (Obstacle) iterator.next();
			batch.draw(AssetsManager.obstacle , obstacle.getPosition().getX() , obstacle.getPosition().getY() , 2 ,2);  
			
		}
		
	}

	private void renderBall() {
		final Ball b = world.getBall();
		Vector2d bPosition = b.getPosition();
		batch.draw(AssetsManager.ball, (int)bPosition.getX(), (int)bPosition.getY(), 1 , 1);
		
	}

	private void renderPlayerBar() {
		final PlayerBar pb = world.getPlayer_bar();
		Vector2d pbPosition = pb.getPosition();
		batch.draw(AssetsManager.playerbar, (int)pbPosition.getX(), (int)pbPosition.getY(), 1 , 1);
		
	}


}
