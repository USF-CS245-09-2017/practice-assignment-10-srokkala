import java.util.ArrayList;
import java.util.List;

public class GraphImplementation implements Graph 
{

	public int [][] adjmatrix; 
	public int vertices;
	
	
	public GraphImplementation(int vertices) 
	{
		// TODO Auto-generated constructor stub
		adjmatrix = new int[vertices][vertices];			
		this.vertices = vertices;							
		
		
	}

	@Override
	public void addEdge(int v1, int v2) 
	{
		// TODO Auto-generated method stub
		adjmatrix[v1][v2] = 1;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see Graph#topologicalSort()
	 * 
	 */
	public List<Integer> topologicalSort() 
	{
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		int[] incident = new int[vertices];
	
		for(int i = 0; i < adjmatrix.length;i++)
		{
			incident[i] = 0;

		}
		
		
		for(int j = 0; j< adjmatrix.length; j++)
		{
			for(int k = 0; k< adjmatrix.length; k++)
			{
				incident[k]+=adjmatrix[j][k];
			}

			
			
		}
		for(int j = 0; j< vertices; j++)
		{
			for(int k = 0; k< vertices; k++)
			{
				if(incident[k] == 0)
				{
					int []counts = neighbors(j);
					
					for(int z = 0; z< counts.length;z++)
					{
						incident[counts[z]]= incident[counts[z]] - 1;
					}
					list.add(k);
					incident[k] = -1;
				}
			}
		}	
		return list;
	}

	@Override
	public int[] neighbors(int vertex) 
	{

		ArrayList<Integer> neighbors = new ArrayList<>(); 
		
		for (int i = 0; i < vertices; i++) {
			
			if(adjmatrix[vertex][i] == 0)
			{
				neighbors.add(i);
			}
		}
		
		int size = neighbors.size();
		
		int[] neighbor = new int[size];
		
		for(int i = 0; i < size; i++){

			neighbor[i] = neighbors.get(i);
		}
		return neighbor;
	}
}
