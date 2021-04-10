/**
 * This class is used for representing the results of a run time comparision of base methods
 * with ArrayList and LinkedList
 */
public class ResultEntity {

    private long arrayListResultTimeInMillis;
    private long linkedListResultTimeInMillis;
    private int numberOfRepetitions;
    private String method;

    public ResultEntity(long arrayListResultTimeInMillis,
                        long linkedListResultTimeInMillis,
                        int numberOfRepetitions,
                        String method) {
        this.arrayListResultTimeInMillis = arrayListResultTimeInMillis;
        this.linkedListResultTimeInMillis = linkedListResultTimeInMillis;
        this.numberOfRepetitions = numberOfRepetitions;
        this.method = method;
    }

    @Override
    public String toString() {
        return "ResultEntity{\n" +
                " arrayListResultTimeInMillis = " + arrayListResultTimeInMillis +
                ",\n linkedListResultTimeInMillis = " + linkedListResultTimeInMillis +
                ",\n numberOfRepetitions = " + numberOfRepetitions +
                ",\n method = '" + method + '\'' +
                '}';
    }
}
