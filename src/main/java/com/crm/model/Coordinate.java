package com.crm.model;

import com.sun.jmx.snmp.Timestamp;

public class Coordinate {
	private Integer coordinateId;
	private Integer gameId;
	private Integer coordinateX;
	private Integer coordinateY;
	private Timestamp coordinateTime;
	public Integer getCoordinateId() {
		return coordinateId;
	}
	public void setCoordinateId(Integer coordinateId) {
		this.coordinateId = coordinateId;
	}
	public Integer getGameId() {
		return gameId;
	}
	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}
	public Integer getCoordinateX() {
		return coordinateX;
	}
	public void setCoordinateX(Integer coordinateX) {
		this.coordinateX = coordinateX;
	}
	public Integer getCoordinateY() {
		return coordinateY;
	}
	public void setCoordinateY(Integer coordinateY) {
		this.coordinateY = coordinateY;
	}
	public Timestamp getCoordinateTime() {
		return coordinateTime;
	}
	public void setCoordinateTime(Timestamp coordinateTime) {
		this.coordinateTime = coordinateTime;
	}
	
	
	
}
