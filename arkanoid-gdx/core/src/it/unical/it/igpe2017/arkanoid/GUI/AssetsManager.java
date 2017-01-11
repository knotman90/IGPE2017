package it.unical.it.igpe2017.arkanoid.GUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetsManager {

	//Textures
	public static Texture playerbar;
	public static Texture ball;
	public static Texture obstacle;
	
	//AUDIO
	
	public static Texture loadTexture (final String file) {
		return new Texture(Gdx.files.internal(file));
	}
	
	
	public static void loadAssets() {
		loadTextures();
		loadAudio();
		
	}


	private static void loadTextures() {
		playerbar 	= loadTexture("data/player_bar.png");
		ball 		= loadTexture("data/ball.png");
		obstacle 	= loadTexture("data/obstacle.png");
		
	}


	private static void loadAudio() {
		
		
	}
	

}
