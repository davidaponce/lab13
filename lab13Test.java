import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.io.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class lab13Test {
	
	lab13 lab;
	Integer[] expectedResult1;
	Integer[] expectedResult2;
	Integer[] expectedResult3;
	String inputFilename = "lab13_input_data.txt";
	String expectedResultsFilename = "lab13_expected_results.txt";
	
	@BeforeEach
	void setUp() throws Exception {
		lab = new lab13();
		lab.readData(inputFilename);
		ArrayList<ArrayList<Integer>> testCases = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			testCases.add(new ArrayList<Integer>());
		}
	
		try (BufferedReader input = new BufferedReader(new FileReader(expectedResultsFilename))) {
			for (int i = 0; i < testCases.size(); i++) {
				ArrayList<Integer> currentTestCases = testCases.get(i);
				input.readLine();
				String inn;
				while ((inn = input.readLine()) != null && !inn.isEmpty()) {
					currentTestCases.add(Integer.parseInt(inn));
				}
				System.out.println("testCases.get(" + i + ").size() = " + currentTestCases.size());
			}
		} catch (IOException e) {
			System.out.println(e.toString());
			System.exit(0);
		}
	
		// put code here to populate expectedResult1 with the values in testCases.get(0)
		// so that you can use "assertArrayEquals" to verify expectedResult1 and lab.getResult1() are the same
		expectedResult1 = testCases.get(0).toArray(new Integer[0]);
	
		// put code here to populate expectedResult2 with the values in testCases.get(1)
		// so that you can use "assertArrayEquals" to verify expectedResult2 and lab.getResult2() are the same
		expectedResult2 = testCases.get(1).toArray(new Integer[0]);
	
		// put code here to populate expectedResult3 with the values in testCases.get(2)
		// so that you can use "assertArrayEquals" to verify expectedResult3 and lab.getResult3() are the same
		expectedResult3 = testCases.get(2).toArray(new Integer[0]);
	}
	

	@Test
	public void getTotalCountTest() {
		assertEquals(lab.getTotalCount(), 1000);
	}
	
	@Test
	public void getOddCount() {
		assertEquals(lab.getOddCount(), 507);
	}
	
	@Test
	public void getEvenCount() { 
		assertEquals(lab.getEvenCount(), 493);
	}
	
	@Test
	public void getDistinctGreaterThanFiveCount() {
		assertEquals(lab.getDistinctGreaterThanFiveCount(), 94);
	}
	
	@Test
	public void getResult1() {
		assertArrayEquals(lab.getResult1(), expectedResult1);	
	}
	
	@Test
	public void getResult2() {
		assertArrayEquals(lab.getResult2(), expectedResult2);	
	}
	
	@Test
	public void getResult3() {
		assertArrayEquals(lab.getResult3(), expectedResult3);	
	}
	

}
