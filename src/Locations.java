public class Locations {

    public char[] charSeq = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p'};


    public void printWorld(int[][] loc) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                boolean charFound = false;
                for (int k = 0; k < loc.length; k++) {
//                    System.out.println(Arrays.toString(loc[k]));
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

    public int[][] getLoc1() {
        return loc1;
    }

    public int[][] getLoc2() {
        return loc2;
    }

    public int[][] getLoc3() {
        return loc3;
    }

    public int[][] getLoc4() {
        return loc4;
    }

    public int[][] getLoc5() {
        return loc5;
    }

    public int[][] getLoc6() {
        return loc6;
    }

    public int[][] getLoc7() {
        return loc7;
    }

    public int[][] getLoc8() {
        return loc8;
    }

    public int[][] getLoc9() {
        return loc9;
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
