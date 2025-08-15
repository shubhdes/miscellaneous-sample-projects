package com.pattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private int count;

	private double itemCost;

	private List<OrderObserver> observerList;

	public Order() {
		observerList = new ArrayList<>();
	}

	public void addItem(int cost) {
		itemCost = itemCost + cost;
		count++;
		observerList.forEach(observer -> observer.updated(this));
	}

	public double getItemCost() {
		return itemCost;
	}

	public int getCount() {
		return count;
	}

	public void attach(OrderObserver observer) {
		observerList.add(observer);
	}

	public void detach(OrderObserver observer) {
		observerList.remove(observer);
	}
}
