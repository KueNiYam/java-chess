package domain.point;

import java.util.Arrays;

public enum Column {
	A("a", 0),
	B("b", 1),
	C("c", 2),
	D("d", 3),
	E("e", 4),
	F("f", 5),
	G("g", 6),
	H("h", 7);

	private String column;
	private int index;

	Column(String column, int index) {
		this.column = column;
		this.index = index;
	}

	public Column add(int columnIndex) {
		return find(index + columnIndex);
	}

	public static Column find(String input) {
		return Arrays.stream(values())
				.filter(column -> column.column.equals(input))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

	private Column find(int index) {
		return Arrays.stream(values())
				.filter(column -> column.index == index)
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

	public int getIndex() {
		return index;
	}

	public Column subtract(Column column) {
		return find(this.index - column.index);
	}
}
