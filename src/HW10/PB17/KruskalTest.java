package HW10.PB17;

import java.util.Scanner;

public class KruskalTest 
{
	public static void main(String... arg)
    {
        int adjacency_matrix[][];
        int number_of_vertices;
        int MAX_VALUE = 999;
 
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        number_of_vertices = scan.nextInt();
        adjacency_matrix = new int[number_of_vertices + 1][number_of_vertices + 1];
 
        System.out.println("Enter the Weighted Matrix for the graph");
        for (int i = 1; i <= number_of_vertices; i++)
        {
            for (int j = 1; j <= number_of_vertices; j++)
            {
                adjacency_matrix[i][j] = scan.nextInt();
                if (i == j)
                {
                    adjacency_matrix[i][j] = 0;
                    continue;
                }
                if (adjacency_matrix[i][j] == 0)
                {
                    adjacency_matrix[i][j] = MAX_VALUE;
                }
            }
        }
        Kruskal kruskalAlgorithm = new Kruskal(number_of_vertices);
        kruskalAlgorithm.kruskalAlgorithm(adjacency_matrix);
        scan.close();
    }
}
