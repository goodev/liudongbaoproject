package com.badlogic.gdx.physics.box2d.collision;

import com.badlogic.gdx.physics.box2d.Manifold;

public class Collision {
	public enum PointState {
		nullState, // /< point does not exist
		addState, // /< point was added in the update
		persistState, // /< point persisted across the update
		removeState // /< point was removed in the update
	}

	private PointState getPointState(int state) {
		if (state == 0)
			return PointState.nullState;
		if (state == 1)
			return PointState.addState;
		if (state == 2)
			return PointState.persistState;
		return PointState.removeState;
	}

	public void getPointStates(PointState[] state1, PointState[] state2,
			Manifold oldManifold, Manifold manifold) {
		int[] intState1 = new int[state1.length];
		int[] intState2 = new int[state2.length];
		jniGetPointStates(intState1, intState2, oldManifold.getAddr(),
				manifold.getAddr());
		for (int i = 0; i < state1.length; i++) {
			state1[i] = getPointState(intState1[i]);
		}
		for (int i = 0; i < state2.length; i++) {
			state2[i] = getPointState(intState2[i]);
		}
	}

	private native void jniGetPointStates(int[] intState1, int[] intState2,
			long oldManifoldAddr, long manifoldAddr);
}
