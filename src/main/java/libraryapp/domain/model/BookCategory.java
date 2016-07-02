package libraryapp.domain.model;

public enum BookCategory {
	NOVEL("Novel"), COMEDY("Comedy"), REFERENCE("Reference"), NONE("No category");

	private String category;

	BookCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return category;
	}
}
