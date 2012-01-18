package emross.json.bean.item;

public class City {
	private int id;
	private String name;
	private int landtype;
	private int x;
	private int y;

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final int getLandtype() {
		return landtype;
	}

	public final void setLandtype(int landtype) {
		this.landtype = landtype;
	}

	public final int getX() {
		return x;
	}

	public final void setX(int x) {
		this.x = x;
	}

	public final int getY() {
		return y;
	}

	public final void setY(int y) {
		this.y = y;
	}

}