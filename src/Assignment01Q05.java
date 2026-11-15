import java.util.Arrays;

public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        int len = m.length;
        int[][] distances = new int[len][len]; // containing all vertices, and their distance from i, start with -1 if doesn't exist
        for (int k=0;k<len;k++)
            {
            for (int l=0;l<len;l++)
                {
                if (l==k)
                    distances[l][k]=0;
                else if (m[l][k]==1)
                    distances[l][k]=1;
                else
                    distances[l][k]=len+1;
                }
                    
             }  
        for (int k=0;k<len;k++)
            {
            for (int l=0;l<len;l++)
            {
                for (int h=0;h<len;h++)
                {
                    if (distances[l][k]+distances[k][h]<distances[l][h])
                    {
                        distances[l][h]=distances[l][k]+distances[k][h];
                    }

                }
            }
        }
        if (distances[i][j]==len+1)
            return -1;
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