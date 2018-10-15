public class Locations {

    public char[] charSeq = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p'};

    /**
     * I decided to move the maps and locs into separate classes and store them in
     * 3D arrays so they could be chosen as an argument when running the jar files.
     */
    private int[][][] locs;

    public Locations() {
        locs = new int[][][] {loc1, loc2, loc3, loc4, loc5, loc6, loc7, loc8, loc9};
    }

    public int[][] getLoc(int ind) {
        return locs[ind];
    }

    public void printWorld(int[][] loc) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                boolean charFound = false;
                for (int k = 0; k < loc.length; k++) {
                    if (loc[k][0] == j && loc[k][1] == i) {
                        System.out.print(" " +charSeq[k]);
                        charFound = true;
                    }
                }
                if (!charFound)
                    System.out.print(" +");
            }
            System.out.println();
        }
    }

    private int[][] loc1 = new int [][] {
            {0,2},
            {2,0},
            {4,3},
            {7,0},
            {2,4},
            {0,6},
            {0,9},
            {2,7},
            {5,8},
            {5,5},
            {2,9},
            {7,4},
            {8,7},
            {9,9},
            {9,4},
    };

    private int[][] loc2 = new int [][] {
            {0,2},
            {2,0},
            {4,3},
            {7,0},
            {2,4},
            {0,6},
            {0,9},
            {2,7},
            {5,8},
            {5,5},
            {2,9},
            {7,4},
            {8,7},
            {9,9},
            {9,4},
    };

    private int[][] loc3 = new int [][] {
            {0,2},
            {2,0},
            {4,3},
            {7,0},
            {2,4},
            {0,6},
            {0,9},
            {2,7},
            {5,8},
            {5,5},
            {2,9},
            {7,4},
            {8,7},
            {9,9},
            {9,4},
    };

    private int[][] loc4 = new int [][] {
            {0,2},
            {2,0},
            {4,3},
            {7,0},
            {2,4},
            {0,6},
            {0,9},
            {2,7},
            {5,8},
            {5,5},
            {2,9},
            {7,4},
            {8,7},
            {9,9},
            {9,4},
    };
    private int[][] loc5 = new int [][] {
            {0,2},
            {2,0},
            {4,3},
            {7,0},
            {2,4},
            {0,6},
            {0,9},
            {2,7},
            {5,8},
            {5,5},
            {2,9},
            {7,4},
            {8,7},
            {9,9},
            {9,4},
    };

    private int[][] loc6 = new int [][] {
            {0,0},
            {5,3},
            {8,5},
            {9,9},
            {2,5},
            {4,7},
            {6,8},
    };

    private int[][] loc7 = new int [][] {
            {0,0},
            {5,3},
            {8,5},
            {9,9},
            {2,5},
            {4,7},
            {6,8},
    };

    private int[][] loc8 = new int [][] {
            {0,0},
            {3,0},
            {6,0},
            {9,0},
            {0,3},
            {3,3},
            {6,3},
            {9,3},
            {0,6},
            {3,6},
            {6,6},
            {9,6},
            {0,9},
            {3,9},
            {6,9},
            {9,9},
    };
    private int[][] loc9 = new int [][] {
            {0,0},
            {3,0},
            {6,0},
            {9,0},
            {0,3},
            {3,3},
            {6,3},
            {9,3},
            {0,6},
            {3,6},
            {6,6},
            {9,6},
            {0,9},
            {3,9},
            {6,9},
            {9,9},
    };
}
