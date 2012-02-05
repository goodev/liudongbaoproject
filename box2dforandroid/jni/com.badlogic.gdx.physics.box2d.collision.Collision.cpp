#include <com.badlogic.gdx.physics.box2d.collision.Collision.h>

#include <Box2D/Box2D.h>

JNIEXPORT void JNICALL Java_com_badlogic_gdx_physics_box2d_collision_Collision_jniGetPointStates(
		JNIEnv* env, jobject object, jintArray intState1, jintArray intState2,
		jlong oldManifoldAddr, jlong manifoldAddr) {
	b2PointState state1[b2_maxManifoldPoints], state2[b2_maxManifoldPoints];
	b2GetPointStates(state1, state2, (b2Manifold*) oldManifoldAddr,
			(b2Manifold*) manifoldAddr);
	for (int i = 0; i < b2_maxManifoldPoints; i++) {
		intState1[i] = state1[i];
		intState2[i] = state2[i];
	}
}
