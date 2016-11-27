package inputs;

import entities.actors.Actor;

public class Move implements StatInput {

	Actor source;
	Actor destination;
	Integer distance;
	Integer time;

	public Move(Integer time, Actor source, Actor destination, Integer distance) {
		super();
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.time = time;
	}

	public Actor getSource() {
		return source;
	}

	public void setSource(Actor source) {
		this.source = source;
	}

	public Actor getDestination() {
		return destination;
	}

	public void setDestination(Actor destination) {
		this.destination = destination;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

}
