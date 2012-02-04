package com.hellogame;

import com.badlogic.gdx.math.Vector2;
import com.box2dforandroid.Body;
import com.box2dforandroid.BodyDef;
import com.box2dforandroid.BodyDef.BodyType;
import com.box2dforandroid.CircleShape;
import com.box2dforandroid.EdgeShape;
import com.box2dforandroid.Joint;
import com.box2dforandroid.PolygonShape;
import com.box2dforandroid.joints.GearJoint;
import com.box2dforandroid.joints.GearJointDef;
import com.box2dforandroid.joints.PrismaticJoint;
import com.box2dforandroid.joints.PrismaticJointDef;
import com.box2dforandroid.joints.RevoluteJoint;
import com.box2dforandroid.joints.RevoluteJointDef;

public class GearsGame extends Box2DTestGame {

	RevoluteJoint joint1 = null;
	RevoluteJoint joint2 = null;
	PrismaticJoint joint3 = null;
	GearJoint joint4 = null;
	GearJoint joint5 = null;
	private Body groundBody;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		super.create();
		// Ground
		BodyDef groundBodyDef = new BodyDef();
		groundBody = world.createBody(groundBodyDef);
		EdgeShape edgeShape = new EdgeShape();
		edgeShape.set(new Vector2(50.0f, 0.0f), new Vector2(50.0f, 0.0f));
		groundBody.createFixture(edgeShape, 0.0f);
       
		createFirstGroupShape();
		// the second group
		createSecondGroupShape();
	}

	private void createSecondGroupShape() {

		CircleShape circle1 = new CircleShape();
		circle1.setRadius(1.0f);

		CircleShape circle2 = new CircleShape();
		circle2.setRadius(2.0f);

		PolygonShape box = new PolygonShape();
		box.setAsBox(0.5f, 5.0f);

		BodyDef bd1 = new BodyDef();
		bd1.type = BodyType.DynamicBody;
		bd1.position.set(-3.0f, 12.0f);
		Body body1 = world.createBody(bd1);
		body1.createFixture(circle1, 5.0f);

		BodyDef bd2 = new BodyDef();
		bd2.type = BodyType.DynamicBody;
		bd2.position.set(0.0f, 12.0f);
		Body body2 = world.createBody(bd2);
		body2.createFixture(circle2, 5.0f);

		RevoluteJointDef jd1 = new RevoluteJointDef();
		jd1.bodyA = groundBody;
		jd1.bodyB = body1;
		jd1.localAnchorA.set(groundBody.getLocalPoint(bd1.position));
		jd1.localAnchorB.set(body1.getLocalPoint(bd1.position));
		jd1.referenceAngle = body1.getAngle() - groundBody.getAngle();
		jd1.initialize(body2, body1, bd1.position);
		joint1 = (RevoluteJoint) world.createJoint(jd1);

		RevoluteJointDef jd2 = new RevoluteJointDef();
		jd2.initialize(groundBody, body2, bd2.position);
		joint2 = (RevoluteJoint) world.createJoint(jd2);

		BodyDef bd3 = new BodyDef();
		bd3.type = BodyType.DynamicBody;
		bd3.position.set(2.5f, 12.0f);
		Body body3 = world.createBody(bd3);
		body3.createFixture(box, 5.0f);

		PrismaticJointDef jd3 = new PrismaticJointDef();
		jd3.initialize(groundBody, body3, bd3.position, new Vector2(0.0f, 1.0f));
		jd3.lowerTranslation = -5.0f;
		jd3.upperTranslation = 5.0f;
		jd3.enableLimit = true;
		joint3 = (PrismaticJoint) world.createJoint(jd3);

		GearJointDef jd4 = new GearJointDef();
		jd4.bodyA = body1;
		jd4.bodyB = body2;
		jd4.joint1 = joint1;
		jd4.joint2 = joint2;
		jd4.ratio = circle2.getRadius() / circle1.getRadius();
		joint4 = (GearJoint) world.createJoint(jd4);

		GearJointDef jd5 = new GearJointDef();
		jd5.bodyA = body2;
		jd5.bodyB = body3;
		jd5.joint1 = joint2;
		jd5.joint2 = joint3;
		jd5.ratio = -1.0f / circle2.getRadius();
		joint5 = (GearJoint) world.createJoint(jd5);

	}

	private void createFirstGroupShape() {
		CircleShape circle1 = new CircleShape();
		circle1.setRadius(1.0f);

		PolygonShape box = new PolygonShape();
		box.setAsBox(0.5f, 5.0f);

		CircleShape circle2 = new CircleShape();
		circle2.setRadius(2.0f);

		BodyDef bd1 = new BodyDef();
		bd1.type = BodyType.StaticBody;
		bd1.position.set(10.0f, 9.0f);
		Body body1 = world.createBody(bd1);
		body1.createFixture(circle1, 5.0f);

		BodyDef bd2 = new BodyDef();
		bd2.type = BodyType.DynamicBody;
		bd2.position.set(10.0f, 8.0f);
		Body body2 = world.createBody(bd2);
		body2.createFixture(box, 5.0f);

		BodyDef bd3 = new BodyDef();
		bd3.type = BodyType.DynamicBody;
		bd3.position.set(10.0f, 6.0f);
		Body body3 = world.createBody(bd3);
		body3.createFixture(circle2, 5.0f);

		RevoluteJointDef jd1 = new RevoluteJointDef();
		jd1.initialize(body2, body1, bd1.position);
		Joint joint1 = world.createJoint(jd1);

		RevoluteJointDef jd2 = new RevoluteJointDef();
		jd2.initialize(body2, body3, bd3.position);
		Joint joint2 = world.createJoint(jd2);

		GearJointDef jd4 = new GearJointDef();//��
		jd4.bodyA = body1;
		jd4.bodyB = body3;
		jd4.joint1 = joint1;
		jd4.joint2 = joint2;
		jd4.ratio = circle2.getRadius() / circle1.getRadius();
		//world.createJoint(jd4);
	}
}
