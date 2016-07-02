package libraryapp.domain.model;

public enum MemberCategory {
	DEPARTMENT_HEAD(50),
	UNDERGRADUATE(3),
	GRADUATE(2),
	RESEARCH_ASSISTANT(15),
	PROFESSOR(10);	
	
	private int loanLimit;
	
	MemberCategory(int loanLimit) {
		this.loanLimit = loanLimit;
	}
	
	public int getLoanLimit() {
		return loanLimit;
	}
}
