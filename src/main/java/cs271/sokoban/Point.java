package cs271.sokoban;

public class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public Point move(char direction) {
		switch(direction) {
			case 'U':
				return new Point(this.x, this.y - 1);
			case 'R':
				return new Point(this.x + 1, this.y);
			case 'D':
				return new Point(this.x, this.y + 1);
			case 'L':
				return new Point(this.x - 1, this.y);
			default:
				throw new IllegalArgumentException("Illegal move given");
		}
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Point)) return false;

		Point convertedObj = (Point) obj;
		return this.x == convertedObj.getX() && this.y == convertedObj.getY();
	}

	@Override
	public int hashCode() {
		return 31 * this.x + this.y;
	}
}
