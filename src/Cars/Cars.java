package Cars;

public class Cars implements Comparable<Cars> {
	protected String model;

	public Cars() {
	}

	public Cars(String model) {
		setModel(model);
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		if (model == null) {
			throw new IllegalArgumentException();
		}

		this.model = model;
	}

	public String toString() {
		return this.model;
	}

	public int compareTo(Cars another) {
		return this.model.compareTo(another.getModel());
	}

	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj instanceof Cars) {
			Cars another = (Cars) obj;
			if (this.model.equals(another.getModel())) {
				return true;
			}
		}

		return false;
	}
}