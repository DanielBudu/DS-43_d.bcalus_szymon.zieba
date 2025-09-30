package e2;

public class DescPend {

        public static int downTheSlope ( char[][] slopeMap, int right, int down){
            int treeCount = 0;
            int i = 0, j = 0; // i vertical, j horizontal

            //Contar la primera posición
            if (slopeMap[i][j] == '#') treeCount++;

            while (i < slopeMap.length) {

                // Mover horizontal paso a paso
                for (int step = 0; step < right; step++) {
                    j = (j + 1) % slopeMap[i].length;
                    if (slopeMap[i][j] == '#') {
                        treeCount++;
                    }
                }

                for (int step = 0; step < down; step++) {
                    i++;
                    if (i >= slopeMap.length) {
                        break;
                    }
                    if (slopeMap[i][j] == '#') {
                        treeCount++;
                    }
                }
            }

            return treeCount;
        }


        public static int jumpTheSlope ( char[][] slopeMap, int right, int down){
            int treeCount = 0;
            int i = 0, j = 0;

            while (i < slopeMap.length) {

                if (slopeMap[i][j] == '#') {
                    treeCount++;
                }

                i+= down;
                if (i >= slopeMap.length) {
                    break;
                }
                j = (j + right) % slopeMap[i].length;

            }
            return treeCount;
        }

    public static void main(String[] args) {
        char[][] matriz = {
                {'.','.','#','#','.','.','.','.','.','.','.'},
                {'#','.','.','.','#','.','.','.','#','.','.'},
                {'.','#','.','.','.','.','#','.','.','#','.'},
                {'.','.','#','.','#','.','.','.','#','.','#'},
                {'.','#','.','.','.','#','#','.','.','#','.'},
                {'.','.','#','.','#','#','.','.','.','.','.'},
                {'.','#','.','#','.','#','.','.','.','.','#'},
                {'.','#','.','.','.','.','.','.','.','.','#'},
                {'#','.','#','#','.','.','.','#','.','.','.'},
                {'#','.','.','.','#','#','.','.','.','.','#'},
                {'.','#','.','.','#','.','.','.','#','.','#'}
        };

        System.out.println(downTheSlope(matriz, 3, 1));
        System.out.println(jumpTheSlope(matriz, 3, 1));
    }

}



