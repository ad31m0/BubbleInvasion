package com.ramybelbesy.games.bubbleinvasion.objects;

import com.ramybelbesy.games.framework.DynamicGameObject3D;

public class Shot extends DynamicGameObject3D {
	public static float SHOT_VELOCITY = 10f;
	public static float SHOT_RADIUS = 0.1f;
	
	public Shot(float x, float y, float z, float velocityZ) {
		super(x, y, z, SHOT_RADIUS);
		velocity.z = velocityZ;
	}

	public void update(float deltaTime) {
		position.z += velocity.z * deltaTime;
		bounds.center.set(position);
	}
}
