package com.ramybelbesy.games.bubbleinvasion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ramybelbesy.games.bubbleinvasion.objects.Bubble;
import com.ramybelbesy.games.bubbleinvasion.objects.Gun;
import com.ramybelbesy.games.framework.math.OverlapTester;


public class GameData {
	public interface GameActionListener {
		public void explosion();
		public void shot();
	}

	public final static float WORLD_MIN_X = -14;
	public final static float WORLD_MAX_X = 14;
	final static float WORLD_MIN_Z = -15;

	GameActionListener listener;
	public int level = 1;
	public int score = 0;
	
	float speedMultiplier = 1;
	
	final List<Bubble> invaders = new ArrayList<Bubble>();
	
	public final Gun gun;
	
	long lastShotTime;
	Random random;

	public GameData() {
		gun = new Gun(0, 0, 0);
		generateInvaders();
		lastShotTime = System.nanoTime();
		random = new Random();
	}

	private void generateInvaders() {
		for (int row = 0; row < 4; row++) {
			for (int column = 0; column < 8; column++) {
				Bubble invader = new Bubble(-WORLD_MAX_X / 2 + column * 2f,
						0, WORLD_MIN_Z + row * 2f);
				invaders.add(invader);
			}
		}
	}

	public void setWorldListener(GameActionListener worldListener) {
		this.listener = worldListener;
	}

	public void update(float deltaTime, float accelX) {
//		gun.update(deltaTime, accelX);
//		updateInvaders(deltaTime);
//		updateShots(deltaTime);
//
//		checkShotCollisions();
//		checkInvaderCollisions();
//
//		if (invaders.size() == 0) {
//			generateInvaders();
//			level++;
//			speedMultiplier += 0.5f;
//		}
	}

	private void updateInvaders(float deltaTime) {
//		int len = invaders.size();
//		for (int i = 0; i < len; i++) {
//			Bubble invader = invaders.get(i);
//			invader.update(deltaTime, speedMultiplier);
//
//			if (invader.state == Bubble.INVADER_ALIVE) {
//				if (random.nextFloat() < 0.001f) {
//					Shot shot = new Shot(invader.position.x,
//							invader.position.y, invader.position.z,
//							Shot.SHOT_VELOCITY);
//					shots.add(shot);
//					listener.shot();
//				}
//			}
//
//			if (invader.state == Bubble.INVADER_DEAD
//					&& invader.stateTime > Bubble.INVADER_EXPLOSION_TIME) {
//				invaders.remove(i);
//				i--;
//				len--;
//			}
//		}
	}

	private void updateShots(float deltaTime) {
//		int len = shots.size();
//		for (int i = 0; i < len; i++) {
//			Shot shot = shots.get(i);
//			shot.update(deltaTime);
//			if (shot.position.z < WORLD_MIN_Z ||
//			    shot.position.z > 0) {
//				shots.remove(i);
//				i--;
//				len--;
//			}
//		}
	}

	private void checkInvaderCollisions() {
		if (gun.state == Gun.SHIP_EXPLODING)
			return;

		int len = invaders.size();
		for (int i = 0; i < len; i++) {
			Bubble invader = invaders.get(i);
			if (OverlapTester.overlapSpheres(gun.bounds, invader.bounds)) {
				gun.lives = 1;
				gun.kill();
				return;
			}
		}
	}

	private void checkShotCollisions() {
//		//int len = shots.size();
//		for (int i = 0; i < len; i++) {
//			//Shot shot = shots.get(i);
//			boolean shotRemoved = false;
//
//			//int len2 = shields.size();
//			for (int j = 0; j < len2; j++) {
//				//Shield shield = shields.get(j);
//				if (OverlapTester.overlapSpheres(shield.bounds, shot.bounds)) {
//					//shields.remove(j);
//					//shots.remove(i);
//					i--;
//					len--;
//					shotRemoved = true;
//					break;
//				}
//			}
//			if (shotRemoved)
//				continue;
//
//			if (shot.velocity.z < 0) {
//				len2 = invaders.size();
//				for (int j = 0; j < len2; j++) {
//					Bubble invader = invaders.get(j);
//					if (OverlapTester.overlapSpheres(invader.bounds,
//							shot.bounds)
//							&& invader.state == Bubble.INVADER_ALIVE) {
//						invader.kill();
//						listener.explosion();
//						score += 10;
//						//shots.remove(i);
//						i--;
//						len--;
//						break;
//					}
//				}
//			} else {
//				if (OverlapTester.overlapSpheres(shot.bounds, gun.bounds)
//						&& gun.state == Gun.SHIP_ALIVE) {
//					gun.kill();
//					listener.explosion();
//					//shots.remove(i);
//					i--;
//					len--;
//				}
//			}
//		}
	}

	public boolean isGameOver() {
		return gun.lives == 0;
	}

	public void shot() {
//		if (gun.state == Gun.SHIP_EXPLODING)
//			return;
//
//		int friendlyShots = 0;
//		int len = shots.size();
//		for (int i = 0; i < len; i++) {
//			if (shots.get(i).velocity.z < 0)
//				friendlyShots++;
//		}
//
//		if (System.nanoTime() - lastShotTime > 1000000000 || friendlyShots == 0) {
//			shots.add(new Shot(gun.position.x, gun.position.y,
//					gun.position.z, -Shot.SHOT_VELOCITY));
//			lastShotTime = System.nanoTime();
//			listener.shot();
//		}
	}
}
