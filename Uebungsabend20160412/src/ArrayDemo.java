import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ArrayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = {{5,18,31,34,42,45},
				{1,17,22,28,37,42},
				{2,8,13,16,25,39},
				{9,13,24,28,33,40},
				{10,13,26,28,36,44},
				{6,10,11,12,17,21},
				{14,31,34,36,41,42},
				{8,10,12,21,26,36},
				{3,5,23,28,30,45},
				{10,17,19,27,28,30},
				{2,15,19,23,31,42},
				{8,12,18,19,35,37},
				{5,9,14,26,36,38},
				{25,9,27,12,14,20},
				{2,13,16,17,20,22},
				{2,5,12,18,22,44},
				{4,5,8,18,26,42},
				{4,20,22,28,32,38},
				{6,13,16,31,43,44},
				{3,5,6,14,17,39},
				{2,7,10,33,35,38},
				{7,10,18,21,32,45},
				{3,4,11,27,28,45},
				{2,14,17,30,33,41},
				{4,14,18,20,28,33},
				{12,24,26,29,31,33},
				{7,10,16,21,23,28},
				{1,2,4,5,13,22},
				{17,26,29,30,43,44},
				{4,5,13,26,38,43},
				{3,6,7,9,20,37},
				{3,9,12,27,33,34},
				{6,13,29,34,35,40},
				{12,17,26,27,29,39}};
		
		System.out.println(array.length);
		System.out.println(array[0].length);
		
		int[]top6 =findTop6Numbers(array);
		for (int i : top6) {
			System.out.println(i);
		}
		
		System.out.println(getCountToNumbers(array));
	}
	
	
	public static HashMap<Integer, Integer> getCountToNumbers(int[][] numbers)
	{
		HashMap<Integer, Integer> map = new
				HashMap<>();
		for(int i = 1; i<= 45;i++)
			map.put(i, 0);
		
		for(int x = 0; x < numbers.length; x++)
		{
			for (int y = 0; 
					y < numbers[x].length; y++)
			{
				map.put(numbers[x][y],
						map.get(numbers[x][y]) + 1);
			}
		}
		
		return map;
	}
	
	
	public static int[] findTop6Numbers(int[][] numbers)
	{
		ArrayList<LottoZahlenAnzahl> list =
					new ArrayList<>();

		for (int i = 0; i < numbers.length; i++) {
			for (int y  = 0; y < numbers[i].length; y++) {
				int zahlinArray = numbers[i][y];

				boolean gefunden =false;
				for (LottoZahlenAnzahl lottoZahlenAnzahl 
						: list) {
					if (lottoZahlenAnzahl.getZahl() 
							== zahlinArray)
					{
						// gefunden
						lottoZahlenAnzahl.increment();
						gefunden = true;
					}
				}
				if (!gefunden)
				{
					list.add(new LottoZahlenAnzahl(zahlinArray));
				}
			}
		}
		
		Collections.sort(list);
		int[] top6 = new int[6];
		for(int i = 0; i < 6;i++)
			top6[i] = list.get(i).getZahl();
				
		return top6;
	}

}
