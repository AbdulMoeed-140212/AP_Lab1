import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * This code will create Matrices
 * and compute following operations:
 * 							Symbols
 * Addition						+
 * Subtaction					-
 * Multiplication				*
 * Scalar Multiplication		add a number  A * 2
 * Inverse						@
 * Transpose					#
 * 
 * 
 * Equations can be writen in format as 
 * 	A + B
 * 	# A
 * - B
 * 
 *  where A and B are matrices
 *  
 *  Matrices are stored along with a name:
 *  
 *  Matrix Nameing rules: 
 *  
 *  Alphabets only i.e A-Z and a-z
 *  Space is considered as breaking point for name 
 *  
 *  opreations are indicated by symbols stated above
 *  
 * 
 */

public class compute {
		private static ArrayList<Matrix> List = new ArrayList<Matrix>();
	    
	    public static void main(String[] args) {
	        Matrix mat;
	        String eq;
	        Scanner scan = new Scanner(System.in);
	        int opt=1;
	        boolean stop = true;
	        System.out.println("Matrix Calculations");
	        while(stop){
	            System.out.println("press 1 to Enter matrices");
	            System.out.println("press 2 to Enter Equation");
	            System.out.println("press 3 to Exit");
	            opt = scan.nextInt();
	            switch(opt){
	                case 1:
	                    mat = new Matrix();
	                    mat.setName();
	                    mat.setArrayRandom(2,2);
	                    mat.printAll();
	                    List.add(mat);
	                    break;
	                case 2:
	                    System.out.println("Matrix names");
	                    for(Matrix matrix:List){
	                        System.out.print( matrix.getName() + " ");
	                        }
	                    System.out.println();
	                    System.out.print("Enter Equation");
	                    Scanner read = new Scanner(System.in);
	                    eq = read.nextLine();
	                    calculate(eq);
	                    break;
	                case 3:
	                    stop=false;
	                    break;
	                default:
	                    System.out.println("Invalid Entery");
	            }
	        }
	        System.out.println("Exit");
	    }
	    
	    public static void calculate(String E){
	        String[] split =E.split("\\s");
	        char operater='+';
	        Matrix results = null, currentMat;
	        
	        for(String s:split) {
	        	int choice= type(s);
	        	if(choice == 3) {
	        		System.out.println("In Alpha");
	        		int index = find_matrix(s);
	        		if(index < 0 ){
	        				System.out.println("Matrix Not found");
	        			}
	        		else {
	        			currentMat = List.get(index);
	        			if(results == null) {
	        				results = new Matrix();
	        				results.setArraySame(currentMat.getRows(), currentMat.getCols(), 0);
	        			}
	        			
	        				
	        				if(currentMat != null )
	        				{
	        					switch(operater) {
				        			case '+':
				        				if(results.getCols() == currentMat.getCols() && results.getRows() == currentMat.getRows())
				        					results = addition(results,currentMat);
				        				else
				        					System.out.println("Order of matrices is not Equals");
				        				break;
				        			case '-':
				        				if(results.getCols() == currentMat.getCols() && results.getRows() == currentMat.getRows())
				        					results = subtraction(results,currentMat);
				        				else
				        					System.out.println("Order of matrices is not Equals");
				        				break;
				        			case '*':
				        				if(results.getCols() == currentMat.getRows() )
				        				results = Multiplication(results,currentMat);
				        				else
				        					System.out.println("Order of matrices is not Equals");
				        				break;
				        			case '@': // inverse
				        				if(results.getCols() == results.getRows())
				        				results = Inverse(currentMat);
				        				else
				        					System.out.println("Matrix is not square");
				        				break;
				        			case '#': //transpose
				        				if(results.getCols() == results.getRows())
				        					results = transpose(currentMat);
				        				else
				        					System.out.println("Matrix is not square");
				        				break;
				        			default:
				        				System.out.println("Operation not defined");
				        				break;
				        			}
	        					}
	        				results.printAll();
	        			}
	        	}
	        	else if(choice == 2) {
	        		System.out.println("In Number");
	        		results = compute.ScalarMultiplication(results, Integer.valueOf(s)); 
	        	}
	        	else if(choice == 1) {
	        		System.out.println("In operater");
	        		operater = s.charAt(0);
	        		
	        		}
	        	else {
	        		System.out.println("Error");
	        	}
	        }
	    }
	    
	    public static int find_matrix(String name) {
	    	for(int i=0 ; i< List.size();i++) {
	    		if(List.get(i).getName().equals(name)) {
	    			System.out.println("Matrix found at "+ i);
	    			return i;
	    		}
	    	}
	    	System.out.println("Matrix not found");
	    	return -1;
	    }
	    public static int type(String O)// operateion or operand
	    {
	        Pattern p = Pattern.compile("[^A-Za-z0-9]");
	        Matcher m = p.matcher(O);
	        if(m.find())
	        {
	        	return 1; // ooperater
	        }else {
	        	p = Pattern.compile("[0-9]");
	        	m = p.matcher(O);
	        	if(m.find()) {
	        		return 2; // Alphabets
	        	}
	        	else {
	        		return 3; // numbers
	        	}
	        		
	        }
	    }
	    
	    public static boolean matrixEqual( Matrix a , Matrix b ){
	        if(a.getRows() == b.getRows() && a.getCols() == b.getCols())
	            return true;
	        else 
	            return false;
	    }
	    public static Matrix addition( Matrix a , Matrix b ){
	        Matrix r = new Matrix();
	        r.setName("Addition Array");
	        r.setArraySame(a.getRows(), a.getCols(), 0);
	        
	        for(int i=0; i< a.getRows(); i++ ){
	        	for(int j=0; j< a.getCols(); j++){
	               r.IntArry[i][j] = a.IntArry[i][j]+b.IntArry[i][j];
	            }
	        }
	        
	        return r;
	    }
	    public static Matrix subtraction( Matrix a , Matrix b ){
	        Matrix r = new Matrix();
	        r.setName("Subtraction Array");
	        r.setArraySame(a.getRows(), a.getCols(), 0);
	        
	        for(int i=0; i< a.getRows(); i++ ){
	        	for(int j=0; j< a.getCols(); j++){
	               r.IntArry[i][j] = a.IntArry[i][j]-b.IntArry[i][j];
	            }
	        }
	        r.printAll();
	        return r;
	    }
	    
	    public static Matrix ScalarMultiplication( Matrix a , int b ){
	        Matrix r = new Matrix();
	        r.setName("Multiplication Array");
	        r.setArraySame(a.getRows(), a.getCols(), 0);
	        
	        for(int i=0; i< a.getRows(); i++ ){
	        	for(int j=0; j< a.getCols(); j++){
	               r.IntArry[i][j] = a.IntArry[i][j]*b;
	            }
	        }
	        r.printAll();
	        return r;
	    }
	    
	    public static Matrix transpose( Matrix a ){
	        Matrix r = new Matrix();
	        r.setName("Transpose Array");
	        r.setArraySame(a.getRows(), a.getCols(), 0);
	        
	        for(int i=0; i< a.getRows(); i++ ){
	        	for(int j=0; j< a.getCols(); j++){
	               r.IntArry[j][i] = a.IntArry[i][j];
	            }
	        }
	        r.printAll();
	        
	        return r;
	    }
	    public static Matrix Multiplication( Matrix a , Matrix b){
	        Matrix r = new Matrix();
	        r.setName("Multiplication Array");
	        r.setArraySame(a.getRows(), a.getCols(), 0);
	        
	        for(int i=0; i< a.getRows(); i++ ){
	        	for(int j=0; j< b.getCols(); j++){
	        		for(int k=0;k<b.getRows();k++) {
	        			r.IntArry[i][j] += a.IntArry[i][k] * b.IntArry[k][j];
	        		}
	            }
	        }
	        r.printAll();
	        
	        return r;
	    }
	    
	    public static Matrix Inverse( Matrix a ){
	        Matrix r = new Matrix();
	        r.setName("Inverse Array");
	        r.setArraySame(a.getRows(), a.getCols(), 1);
	        // taken form http://www.sanfoundry.com/java-program-find-inverse-matrix/
	        int n = a.IntArry.length;
	        double x[][] = new double[n][n];
	        double b[][] = new double[n][n];
	        int index[] = new int[n];
	        for (int i=0; i<n; ++i) 
	            b[i][i] = 1;
	 
	 // Transform the matrix into an upper triangle
	        gaussian(a.IntArry, index);
	 
	 // Update the matrix b[i][j] with the ratios stored
	        for (int i=0; i<n-1; ++i)
	            for (int j=i+1; j<n; ++j)
	                for (int k=0; k<n; ++k)
	                    b[index[j]][k]-= a.IntArry[index[j]][i]*b[index[i]][k];
	 
	 // Perform backward substitutions
	        for (int i=0; i<n; ++i) 
	        {
	            x[n-1][i] = b[index[n-1]][i]/a.IntArry[index[n-1]][n-1];
	            for (int j=n-2; j>=0; --j) 
	            {
	                x[j][i] = b[index[j]][i];
	                for (int k=j+1; k<n; ++k) 
	                {
	                    x[j][i] -= a.IntArry[index[j]][k]*x[k][i];
	                }
	                x[j][i] /= a.IntArry[index[j]][j];
	            }
	        }
	        for(int i=0;i <r.getRows() ; i++) {
	        	for(int j= 0; j< r.getCols(); j++){
	        		r.IntArry[i][j] = (int)x[i][j];
	        	}
	        }
	        r.printAll();
	        
	        return r;
	    }
        public static void gaussian(int a[][], int index[]) 
        {
            int n = index.length;
            double c[] = new double[n];
     
     // Initialize the index
            for (int i=0; i<n; ++i) 
                index[i] = i;
     
     // Find the rescaling factors, one from each row
            for (int i=0; i<n; ++i) 
            {
                double c1 = 0;
                for (int j=0; j<n; ++j) 
                {
                    double c0 = Math.abs(a[i][j]);
                    if (c0 > c1) c1 = c0;
                }
                c[i] = c1;
            }
     
     // Search the pivoting element from each column
            int k = 0;
            for (int j=0; j<n-1; ++j) 
            {
                double pi1 = 0;
                for (int i=j; i<n; ++i) 
                {
                    double pi0 = Math.abs(a[index[i]][j]);
                    pi0 /= c[index[i]];
                    if (pi0 > pi1) 
                    {
                        pi1 = pi0;
                        k = i;
                    }
                }
     
       // Interchange rows according to the pivoting order
                int itmp = index[j];
                index[j] = index[k];
                index[k] = itmp;
                for (int i=j+1; i<n; ++i) 	
                {
                    double pj = a[index[i]][j]/a[index[j]][j];
     
     // Record pivoting ratios below the diagonal
                   a[index[i]][j] =(int) pj;
     
     // Modify other elements accordingly
                    for (int l=j+1; l<n; ++l)
                        a[index[i]][l] -= pj*a[index[j]][l];
                }
            }
        }
	    
	
}
