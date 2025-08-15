package com.pattern.creational.prototype;

public class SwordsMan extends GameUnit {

	private boolean isAttacking;

	public SwordsMan() {
		this.isAttacking = false;
	}

	@Override
	public void initialize() {
		super.initialize();
		this.isAttacking = false;
	}

	public void attack() {
		this.isAttacking = true;
	}

	@Override
	public String toString() {
		return "SwordsMan isAttacking=" + isAttacking + " at position=" + position;
	}
}
