package com.crm.model;

import com.sun.jmx.snmp.Timestamp;

public class Game {
	private Integer gameId;
	private Integer blackUserId;
	private Integer whiteUserId;
	private Timestamp beginTime;
	private Timestamp endTime;
	private Integer status;
	private Integer winner;
	public Integer getGameId() {
		return gameId;
	}
	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}
	public Integer getBlackUserId() {
		return blackUserId;
	}
	public void setBlackUserId(Integer blackUserId) {
		this.blackUserId = blackUserId;
	}
	public Integer getWhiteUserId() {
		return whiteUserId;
	}
	public void setWhiteUserId(Integer whiteUserId) {
		this.whiteUserId = whiteUserId;
	}
	public Timestamp getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getWinner() {
		return winner;
	}
	public void setWinner(Integer winner) {
		this.winner = winner;
	}
	
	
}
