package secondSemester.searchAlgorithms;

public class SearchAlgorithm {
    Search search;

    public SearchAlgorithm(){
        search= new LinearSearch();
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    public Search getSearch() {
        return search;
    }
}
