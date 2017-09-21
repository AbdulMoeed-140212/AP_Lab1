import static org.junit.Assert.*;


import org.junit.Test;

public class computeTest {
	
	private compute test = new compute();
	
	private Matrix a, b, answer;
		
	@Test	
	public void init() {
		
		a = new Matrix() ;
		b = new Matrix();
		answer = new Matrix();
		
		a.setArraySame(2, 2, 10);
		a.printAll();
		b.setArraySame(2,2,20);
		b.printAll();
		//added.setArraySame(2,2,30); 
		answer = test.addition(a, b);
		answer.printAll();
		//test.ScalarMultiplication(a, 6);
		//test.Multiplication(a, b);
		//test.Inverse(a);
		assertNotNull(a);
		assertNotNull(b);
		assertNotNull(answer);
		assertNotNull(test);
		
	}
	
	@Test
	public void additionTest() {
		a = new Matrix() ;
		b = new Matrix();
		answer = new Matrix();
		
		a.setArraySame(2, 2, 10);
		b.setArraySame(2,2,20);
		answer.setArraySame(2, 2, 30);
		assertArrayEquals(answer.IntArry,test.addition(a, b).IntArry);
	}
	
	@Test
	public void subtractionTest() {
		a = new Matrix() ;
		b = new Matrix();
		answer = new Matrix();
		
		a.setArraySame(2, 2, 10);
		b.setArraySame(2,2,20);
		answer.setArraySame(2, 2, -10);
		assertArrayEquals(answer.IntArry,test.subtraction(a, b).IntArry);
	}
	
	@Test
	public void scalarMultiplicationTest() {
		a = new Matrix() ;
		answer = new Matrix();
		
		a.setArraySame(2, 2, 10);
		answer.setArraySame(2, 2, 50);
		assertArrayEquals(answer.IntArry,test.ScalarMultiplication(a, 5).IntArry);
	}
	
	@Test
	public void multiplicationTest() {
		a = new Matrix() ;
		b = new Matrix();
		answer = new Matrix();
		
		a.setArraySame(2, 2, 10);
		b.setArraySame(2,2,20);
		answer.setArraySame(2, 2, 400);
		assertArrayEquals(answer.IntArry,test.Multiplication(a,b).IntArry);
	}
	
	public void transposeTest() {
		a = new Matrix() ;
		answer = new Matrix();
		
		a.setArraySame(2, 2, 10);
		answer.setArraySame(2, 2, 10);
		assertArrayEquals(answer.IntArry,test.transpose(a).IntArry);
	}
}
