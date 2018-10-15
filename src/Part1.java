import java.util.ArrayList;

public class Part1 {

    private int[][] map;
    private int startInd;
    private int nodeCount;

    private LinkedList dFSPath;
    private int dFSCost;

    private LinkedList bFSPath;
    private int bFSCost;
    private int bFSStep;

    public Part1(int[][] map) {
        this.map = map;

        nodeCount = map[0].length;
        startInd = findStartInd();

        Node startPos = new Node(startInd);


        dFSPath = new LinkedList(nodeCount);
        dFSPath.addNode(startPos);
        dFSCost = 0;

        bFSPath = new LinkedList(nodeCount);
        bFSPath.addNode(startPos);
        bFSCost = 0;
        bFSStep = 0;
    }

    public int getdFSCost() {
        return dFSCost;
    }

    public int getbFSCost() {
        return bFSCost;
    }

    /**
     * will check to see if the end goal can be reached by any nodes and
     * won’t run the algorithms if it isn’t possible
     * @return
     */
    public boolean isPossible() {
        for (int i = 0; i < map[0].length; i++) {
            if (map[i][i] == 8) {
                for (int k = 0; k < map[i].length; k++) {
                    if (map[i][k] == 5)
                        return true;
                }
            }
        }
        return false;
    }

    /**
     * a quick algorithm to find the start index by looking for
     * a 2 on the diagonal of the map array.
     */
    private int findStartInd() {
        for (int i = 0; i < nodeCount; i++) {
            if (map[i][i] == 2)
                return i;
        }
        return 0;
    }

    /**
     * Calls Depth First Search, sets dFSPath and returns it to the main
     * @return
     */
    public LinkedList startDFS() {
        return depthFirstSearch(dFSPath);
    }

    /**
     * chooses the next node based on alphabetical order and recurses
     * deeper until the solution is found. If no solution is found,
     * it backtracks by deleting nodes until it can iterate through
     * more options for next nodes
     * @param ll
     * @return
     */
    private LinkedList depthFirstSearch(LinkedList ll) {
        dFSCost++;
        System.out.print("Step " +dFSCost +": ");
        ll.printList();
        int current = ll.getTail().data();
        if (map[current][current] == 8) // if current node is goal, return path
            return ll;
        for (int i = 0; i < map[current].length; i++) {
            if (map[current][i] == 5) {
                if (!ll.hasOccurred(i)) {
                    Node newNode = new Node(i);
                    ll.addNode(newNode);
                    depthFirstSearch(ll);
                    current = ll.getTail().data();
                    if (map[current][current] == 8) // if current node is goal, return path
                        return ll;
                }
            }
        }
        if (map[current][current] != 8) { // if current node is not goal and move options exhausted, remove node
            ll.dropNode();
        }
        return ll;
    }

    /**
     * Calls Breadth First Search, initializes paths arraylist and
     * sets bFSPath and returns it to the main
     * @return
     */
    public LinkedList startBFS() {
        ArrayList<LinkedList> paths = new ArrayList<>();
        paths.add(bFSPath);
        return breadthFirstSearch(paths);
    }

    /**
     * creates a path for every possible next node, checks every possible move at a given
     * step, and recurses further until a solution is found.
     * @param paths
     * @return
     */
    public LinkedList breadthFirstSearch(ArrayList<LinkedList> paths) {
        int currNumPaths = paths.size(); // set beforehand so it doesn't keep adding nodes to new paths in the same recursion
        bFSStep++;
        System.out.println("Recursion: " +bFSStep);
        for (int i = 0; i < currNumPaths; i++) { // iterates through current set of paths
            int current = paths.get(i).getTail().data();
            boolean pathUsed = false; // dictates whether to copy path or use current one
            for (int j = 0; j < map[current].length; j++) { // for each next move option per path
                if (map[current][j] == 5) { // if node is next to current node
                    if (!paths.get(i).hasOccurred(j)) { // if this node in this path hasn't been hit yet
                        bFSCost++;
                        Node nextStep = new Node(j); // create new node of index
                        if (pathUsed) {
                            LinkedList branchedPath = new LinkedList(paths.get(i), nodeCount);
                            branchedPath.dropNode(); // since one was added from below
                            branchedPath.addNode(nextStep);
                            paths.add(branchedPath);
                            System.out.print("Step " +bFSCost +": ");
                            branchedPath.printList();
                        }
                        else {
                            pathUsed = true;
                            paths.get(i).addNode(nextStep);
                            System.out.print("Step " +bFSCost +": ");
                            paths.get(i).printList();
                        }
                    }
                }
            }
            current = paths.get(i).getTail().data();
            if (map[current][current] == 8) { // if current node is goal, return path
                return paths.get(i);
            }
        }
        LinkedList ll = breadthFirstSearch(paths);
        return ll;
    }


}
