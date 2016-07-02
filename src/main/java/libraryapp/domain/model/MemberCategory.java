package libraryapp.domain.model;

public enum MemberCategory {
	DEPARTMENT_HEAD("Department Head", 50), 
	UNDERGRADUATE("Undergraduate", 3), 
	GRADUATE("Graduate", 2), 
	RESEARCH_ASSISTANT("Research Assistant", 15), 
	PROFESSOR("Professor", 10);

	private String category;
	private int loanLimit;

	MemberCategory(String category, int loanLimit) {
		this.category = category;
		this.loanLimit = loanLimit;
	}
	
	public int getLoanLimit() {
		return loanLimit;
	}
	
	@Override
	public String toString() {
		return category;	
	}
}
