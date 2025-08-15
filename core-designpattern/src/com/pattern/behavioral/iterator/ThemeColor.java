package com.pattern.behavioral.iterator;

public class ThemeColor {

	private String[] colors;

	public ThemeColor() {
		colors = new String[] { "Red", "Green", "Blue", "Pink" };
	}

	public Iterator getIterator() {
		return new ThemeColorIterator();
	}

	private class ThemeColorIterator implements Iterator {

		private int position;

		@Override
		public boolean hasNext() {
			return position < colors.length;
		}

		@Override
		public String next() {
			return colors[position++];
		}

	}
}
