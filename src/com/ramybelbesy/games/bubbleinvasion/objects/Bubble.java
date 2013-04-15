package com.ramybelbesy.games.bubbleinvasion.objects;

import com.ramybelbesy.games.bubbleinvasion.GameData;
import com.ramybelbesy.games.framework.DynamicGameObject3D;

public class Bubble extends DynamicGameObject3D {
	public static final int INVADER_ALIVE = 0;
	public static final int INVADER_DEAD = 1;
	public static final float INVADER_EXPLOSION_TIME = 1.6f;
	public static final float INVADER_RADIUS = 0.75f;
	public static final float INVADER_VELOCITY = 1;
	public static final int MOVE_LEFT = 0;
	public static final int MOVE_DOWN = 1;
	public static final int MOVE_RIGHT = 2;

	public int state = INVADER_ALIVE;
	public float stateTime = 0;
	public int move = MOVE_LEFT;
	public boolean wasLastStateLeft = true;
	public float movedDistance = GameData.WORLD_MAX_X / 2;

	public Bubble(float x, float y, float z) {
		super(x, y, z, INVADER_RADIUS);
	}

	public void update(float deltaTime, float speedMultiplier) {
		if (state == INVADER_ALIVE) {
			movedDistance += deltaTime * INVADER_VELOCITY * speedMultiplier;
			if (move == MOVE_LEFT) {
				position.x -= deltaTime * INVADER_VELOCITY * speedMultiplier;
				if (movedDistance > GameData.WORLD_MAX_X) {
					move = MOVE_DOWN;
					movedDistance = 0;
					wasLastStateLeft = true;
				}
			}
			if (move == MOVE_RIGHT) {
				position.x += deltaTime * INVADER_VELOCITY * speedMultiplier;
				if (movedDistance > GameData.WORLD_MAX_X) {
					move = MOVE_DOWN;
					movedDistance = 0;
					wasLastStateLeft = false;
				}
			}
			if (move == MOVE_DOWN) {
				position.z += deltaTime * INVADER_VELOCITY * speedMultiplier;
				if (movedDistance > 1) {
					if (wasLastStateLeft)
						move = MOVE_RIGHT;
					else
						move = MOVE_LEFT;
					movedDistance = 0;
				}
			}

			bounds.center.set(position);
		}

		stateTime += deltaTime;
	}

	public void kill() {
		state = INVADER_DEAD;
		stateTime = 0;
	}
}
