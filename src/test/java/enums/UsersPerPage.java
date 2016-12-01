package enums;


public enum UsersPerPage {
    FIVE(5),
    TEN(10);

    private int resultsPerPage;

    UsersPerPage(int resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }

    public int getResultsPerPage() {
        return resultsPerPage;
    }
}
