package com.pattern.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class UIMediator {

	private List<UIControl> participants;

	public UIMediator() {
		participants = new ArrayList<>();
	}

	public void register(UIControl control) {
		participants.add(control);
	}

	public void valueChanged(UIControl control) {
		participants.stream().filter(participant -> participant != control)
				.forEach(participant -> participant.controlChanged(control));
	}
}
