import java.util.*;

class Ilhas {
    private static String grid = """
    01110100001000001110
    01111100000000011100
    11111110000000011110
    11110000000000000100
    01000010000110000100
    00100000000111000000
    01110000001110000100
    11111110000011000110
    00011100000000000000
    00000000000001110000
    00000000000011100001
    10000010000000000000
    00000011100000000011
    00000111000000000111
    00000000000000000001
    """;
    // 11

    private static char islandChar = '1';
    private static char waterChar = '0';
    private static char verifiedChar = 'X';

    private static int m;
    private static int n;
    private static String[] lines;
    private static Queue<int[]> bfsQueue;
    private static Queue<int[]> bfsQueueIsland;
    private static int islandNum;

    public static void main(String args[]){
        if(grid.isEmpty()){
            return;
        }

        // Inicialização
        grid = grid.trim();
        lines = grid.split("\n");
        m = lines[0].length();
        n = lines.length;
        bfsQueue = new ArrayDeque<>();
        bfsQueueIsland = new ArrayDeque<>();
        islandNum = 0;

        // Começa no centro
        bfs(m / 2, n / 2);

        System.out.println(islandNum);
    }

    private static void bfs(int xStart, int yStart){
        bfsQueue.offer(new int[]{xStart, yStart});

        while(!bfsQueue.isEmpty()){
            int[] next = bfsQueue.poll();

            int x = next[0];
            int y = next[1];

            writeChar(x, y, verifiedChar);

            // Tenta encontrar primeiro uma ilha, se achar, aciona bfsIsland
            // fazendo a ilha toda ser marcada antes de prosseguir
            if(checkNeighbor(x-1, y, islandChar)) {
                islandNum++;
                bfsIsland(x-1, y);
            }
            if(checkNeighbor(x, y+1, islandChar)) {
                islandNum++;
                bfsIsland(x, y+1);
            }
            if(checkNeighbor(x+1, y, islandChar)) {
                islandNum++;
                bfsIsland(x+1, y);
            }
            if(checkNeighbor(x, y-1, islandChar)) {
                islandNum++;
                bfsIsland(x, y-1);
            }

            // Verifica por água e adiciona na fila
            if(checkNeighbor(x-1, y, waterChar)) {
                bfsQueue.offer(new int[]{x-1, y});
            }
            if(checkNeighbor(x, y+1, waterChar)) {
                bfsQueue.offer(new int[]{x, y+1});
            }
            if(checkNeighbor(x+1, y, waterChar)) {
                bfsQueue.offer(new int[]{x+1, y});
            }
            if(checkNeighbor(x, y-1, waterChar)) {
                bfsQueue.offer(new int[]{x, y-1});
            }
        }
    }

    private static void bfsIsland(int xStart, int yStart){
        bfsQueueIsland.offer(new int[]{xStart, yStart});

        while(!bfsQueueIsland.isEmpty()){
            int[] next = bfsQueueIsland.poll();

            int x = next[0];
            int y = next[1];

            writeChar(x, y, verifiedChar);

            if(checkNeighbor(x-1, y, islandChar)) {
                bfsQueueIsland.offer(new int[]{x-1, y});
            }
            if(checkNeighbor(x, y+1, islandChar)) {
                bfsQueueIsland.offer(new int[]{x, y+1});
            }
            if(checkNeighbor(x+1, y, islandChar)) {
                bfsQueueIsland.offer(new int[]{x+1, y});
            }
            if(checkNeighbor(x, y-1, islandChar)) {
                bfsQueueIsland.offer(new int[]{x, y-1});
            }
        }
    }

    private static boolean checkNeighbor(int x, int y, char target){
        if(x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }

        if(readChar(x, y) == target) {
            return true;
        }

        return false;
    }

    private static boolean writeChar(int x, int y, char c){
        if(x < 0 || x >= m || y < 0 || y >= n){
            return false;
        }

        String line = lines[y];
        String newLine = line.substring(0, x) + c + line.substring(x+1);

        lines[y] = newLine;

        return true;
    }

    private static char readChar(int x, int y){
        if(x < 0 || x >= m || y < 0 || y >= n){
            return 'N';
        }

        String line = lines[y];

        return line.charAt(x);
    }

    public static void printGrid(){
        for(String line : lines){
            System.out.println(line);
        }
        System.out.println("\n");
    }
}