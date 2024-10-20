package secondSemester.sortingAlgorithms;

public class SortingAlgorithm {
    private Sort algortihm;

    public SortingAlgorithm(){
        algortihm= new BubbleSort();
    }
    public Sort getAlgortihm() {
        return algortihm;
    }

    public void setAlgortihm(Sort algortihm) {
        this.algortihm = algortihm;
    }
}
