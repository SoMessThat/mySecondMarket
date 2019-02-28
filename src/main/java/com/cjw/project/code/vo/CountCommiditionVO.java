package com.cjw.project.code.vo;

public class CountCommiditionVO {
	
	/**
	 * 出售中
	 */
	private int saleing;
	
	/**
	 * 已出售
	 */
	private int saled;
	
	/**
	 * 我的关注
	 */
	private int attention;
	
	/**
	 * 我的收藏
	 */
	private int collect;

	public int getSaleing() {
		return saleing;
	}

	public void setSaleing(int saleing) {
		this.saleing = saleing;
	}

	public int getSaled() {
		return saled;
	}

	public void setSaled(int saled) {
		this.saled = saled;
	}

	public int getAttention() {
		return attention;
	}

	public void setAttention(int attention) {
		this.attention = attention;
	}

	public int getCollect() {
		return collect;
	}

	public void setCollect(int collect) {
		this.collect = collect;
	}

	@Override
	public String toString() {
		return "CountCommiditionVO [saleing=" + saleing + ", saled=" + saled + ", attention=" + attention + ", collect="
				+ collect + "]";
	}
	
	
}
