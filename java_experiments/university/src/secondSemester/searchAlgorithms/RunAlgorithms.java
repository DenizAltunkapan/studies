package secondSemester.searchAlgorithms;

public class RunAlgorithms {


    public static void main(String[]args) {
        int[] myArray= {8,4,2,6,1,2,4,6,10,5};
        SearchAlgorithm algorithm = new SearchAlgorithm();
        algorithm.setSearch(new BinarySearch());
        int found = algorithm.getSearch().search(myArray,6);
        System.out.println(found);

    }
}
