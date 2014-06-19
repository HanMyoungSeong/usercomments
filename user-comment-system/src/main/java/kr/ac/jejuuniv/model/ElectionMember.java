package kr.ac.jejuuniv.model;

public class ElectionMember {

	private int userId;
	private int recommendation;
	private int opposition;

	public ElectionMember(int userId) {
		this.userId = userId;
	}

	public ElectionMember() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(int recommendation) {
		this.recommendation = recommendation;
	}

	public int getOpposition() {
		return opposition;
	}

	public void setOpposition(int opposition) {
		this.opposition = opposition;
	}

}
