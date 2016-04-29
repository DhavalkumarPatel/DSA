package HW2;

public class TableauUtility 
{
	public void insert(Tableau t, int value)
	{
		int i = t.getM()-1;
		int j = t.getN()-1;
		if(t.get(i, j) == t.getNonExistElem())
		{
			t.set(i, j, value);
			
			insertInTableau(t, i, j);
		}
	}
	
	public void insertInTableau(Tableau t, int i, int j)
	{
		int cur = t.get(i, j);
		int top = t.getTop(i, j);
		int left = t.getLeft(i, j);
		
		if(top == -1 && left == -1)
		{
			return;
		}
		
		int nextI = -1;
		int nextJ = -1;
		
		if(top == t.getNonExistElem())
		{
			nextI = i-1;
			nextJ = j;
		}
		else if(left == t.getNonExistElem())
		{
			nextI = i;
			nextJ = j-1;
		}
		else
		{
			if(cur < top && top >= left)
			{
				nextI = i-1;
				nextJ = j;
			}
			else if(cur < left && left >= top)
			{
				nextI = i;
				nextJ = j-1;
			}
		}
		
		if(nextI != -1 || nextJ != -1)
		{
			t.replace(i, j, nextI, nextJ);
			insertInTableau(t, nextI, nextJ);
		}
	}
	
	public int extractMinTableau(Tableau t)
	{
		int min = t.get(0, 0);
		
		if(min == t.getNonExistElem())
		{
			return t.getNonExistElem();
		}
		
		t.set(0, 0, t.getNonExistElem());
		minTableaufy(t,0,0);

		return min;
	}
	
	public void minTableaufy(Tableau t, int i, int j)
	{
		int right = t.getRight(i, j);
		int down = t.getDown(i, j);
		
		int nextI = -1;
		int nextJ = -1;
		
		if((right == -1 || right == t.getNonExistElem()) && (down == -1 || down == t.getNonExistElem()))
		{
			return;
		}
		else if(right == -1 || right == t.getNonExistElem())
		{
			nextI = i+1;
			nextJ = j;
		}
		else if(down == -1 || down == t.getNonExistElem())
		{
			nextI = i;
			nextJ = j+1;
		}
		else
		{
			if(t.getRight(i, j) > t.getDown(i, j))
			{
				nextI = i+1;
				nextJ = j;
			}
			else
			{
				nextI = i;
				nextJ = j+1;
			}
		}
		
		if(nextI != -1 || nextJ != -1)
		{
			t.replace(i, j, nextI, nextJ);
			minTableaufy(t, nextI, nextJ);
		}
	}
	
	public boolean SearchInTableau(Tableau t, int key)
	{
		boolean isPresent = false;
		
		int curI = t.getM()-1;
		int curJ = 0;
		
		while(curI >= 0 && curJ < t.getN())
		{
			int topI = curI - 1;
			int topJ = curJ;
			boolean isTopPos = false;
			if(topI >= 0)
			{
				isTopPos = true;
			}
			
			if(t.get(curI, curJ) == t.getNonExistElem())
			{
				if(isTopPos)
				{
					curI = topI;
					curJ = topJ;
				}
				else
				{
					break;
				}
			}
			else if(t.get(curI, curJ) == key)
			{
				isPresent = true;
				break;
			}
			else if(t.get(curI, curJ) > key)
			{
				if(isTopPos)
				{
					curI = topI;
					curJ = topJ;
				}
				else
				{
					break;
				}
			}
			else if(t.get(curI, curJ) < key)
			{
				int rightJ = curJ + 1;
				if(rightJ < t.getN())
				{
					curJ = rightJ;
				}
				else
				{
					break;
				}
			}
		}
		
		return isPresent;
	}
}
