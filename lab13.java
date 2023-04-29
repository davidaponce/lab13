import java.util.*;
import java.io.*;
public class lab13 {
	
	ArrayList<Integer> dataList = new ArrayList<>();
	
	public void readData(String filename) {

		try {

			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			String inn;

			while ((inn = input.readLine()) != null) 
			{
				dataList.add(Integer.parseInt(inn));
			}
			input.close();
		} 
		
		catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
			
	}
	
	public long getTotalCount() {
		return dataList.stream().count();
	}
	
	public long getOddCount() {
		return dataList.stream().filter(x -> x % 2 != 0).count();
	}
	
	public long getEvenCount() {
		return dataList.stream().filter(x -> x % 2 == 0).count();
	}
	
	public long getDistinctGreaterThanFiveCount() {
		return dataList.stream().distinct().filter(x -> x > 5).count();
	}
	
	public Integer[] getResult1()
	{
		return dataList.stream().sorted().filter(x -> x % 2 == 0 && x > 5 && x < 50).toArray(Integer[]::new);
	}
	public Integer[] getResult2()
	{
		return dataList.stream().map(x -> x * x * 3).limit(50).toArray(Integer[]::new);
	}
	public Integer[] getResult3()
	{
		return dataList.stream().filter(x -> x % 2 != 0).map(x -> x * 2).sorted().skip(20).distinct().toArray(Integer[]::new);
	}		
}

