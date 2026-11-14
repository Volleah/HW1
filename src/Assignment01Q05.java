import java.util.Arrays;

public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        int len = m.length;
        int[][] distances = new int[len][len]; // containing all vertices, and their distance from i, start with -1 if doesn't exist
        for (int k=0;k<len;k++){
            Arrays.fill(distances[k],-1);
            distances[k][k]=0;
        }

        return findPathUpToDistance(m, i, j, 0, distances);

    }

    public static int findPathUpToDistance(int[][] m, int i, int j, int currDepth, int[][] distances){
        int len = m.length;
        // debug stuff
        System.out.println("--------------");
        for (int k=0;k<len;k++)
            {for (int l=0;l<len;l++)
                System.out.print(" "+distances[k][l]+" ");
            System.out.println(" ");}
        System.out.println("--------------");

        if (currDepth>=len)
            return -1; // not found
        if (m[i][j]==1)
            return 1;
        if (i==j)
            return 0;
        if (distances[i][j]!=-1)
            return distances[i][j]; // if they're already in our list, then return the distance
        int minDistance=-1;
        for (int k=0;k<len;k++){ // iterate through all possible edges
            int newDistance=findPathUpToDistance(m, k, j, currDepth+1, distances);
            if (distances[i][k]==-1)
                distances[k][j] = newDistance;
            if ((distances[k][j]!=-1)&&((minDistance==-1) || (distances[k][j]<minDistance)))
                minDistance=distances[k][j]+1;
        }
        return distances[i][j];
    }
 
    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}