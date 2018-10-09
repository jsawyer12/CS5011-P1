import java.util.ArrayList;

public class Part1 {

    private int[][] map;


    public Part1(int[][] map) {
        this.map = map;
    }

    /**
     * returns array of indexes of next node[s] to go to from current
     * @return
     */
    public  Integer[] getNextStepz(int current) {
        ArrayList<Integer> nextStepz = new ArrayList<>();
        for (int i = 0; i < map[current].length; i++) {
//            System.out.print(" " +map[current][i]);
            if (map[current][i] == 8) {
                Integer[] ans = new Integer[] {i};
                return ans;
            }
            if (map[current][i] == 5) {
                nextStepz.add(i);
            }
        }
//        for (int i = 0; i < nextStepz.size(); i++) {
//            System.out.println("  " +nextStepz.get(i));
//        }
        Integer[] ans = nextStepz.toArray(new Integer[nextStepz.size()]);
//        System.out.println(Arrays.toString(ans));
        return ans;
    }

    /**
     * Basically want it to see if there any more nodes it can go to next
     * @param ll
     * @return
     */
    public static LinkedList depthFirstSearch(LinkedList ll) {
//        int[] nextNodez = getNextStepz();
        return null;
    }
}
