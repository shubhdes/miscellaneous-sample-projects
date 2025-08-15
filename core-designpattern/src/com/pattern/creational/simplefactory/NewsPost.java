package com.pattern.creational.simplefactory;

import java.time.LocalDateTime;

public class NewsPost extends Post {

	private String headline;

	private LocalDateTime newsTime;

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public LocalDateTime getNewsTime() {
		return newsTime;
	}

	public void setNewsTime(LocalDateTime newsTime) {
		this.newsTime = newsTime;
	}
}
