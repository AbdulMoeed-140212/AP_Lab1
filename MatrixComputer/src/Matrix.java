import java.util.Scanner;

public class Matrix {
	 	private String name;
	    public int IntArry[][];
	    private int rows , cols;
	    private Scanner scanner = new Scanner(System.in);
	   
	    
	    public void setRows(int r) {
	    	this.rows = r;
	    }
	    public void setCols(int c) {
	    	this.cols = c;
	    }
	    public String getName() {
	        return name;
	    }
	    

	    public int getRows() {
	        return rows;
	    }

	    public int getCols() {
	        return cols;
	    }

	    public void setArray(){
	       System.out.print("Enter Number of Rows >>>>");
	       rows = scanner.nextInt();
	       
	       System.out.print("Enter Number of Colouns >>>>");
	       cols = scanner.nextInt();
	        IntArry = new int[rows][];
	        System.out.println("Enter values for matrix");
	        for(int i = 0 ; i < rows; i++)
	        {
	            
	            IntArry[i] = new int[cols];
	            for(int j=0; j< cols ; j++)
	            {
	                System.out.print(this.name+" ["+String.valueOf(i+1)+"]["+String.valueOf(j+1)+"] = ");
	                IntArry[i][j] = scanner.nextInt();
	            }
	        }
	    }
	    public void setArrayRandom(int r , int c){
	    	this.rows = r;
	    	this.cols = c;
	        IntArry = new int[rows][];
	        for(int i = 0 ; i < rows; i++)
	        {
	            
	            IntArry[i] = new int[cols];
	            for(int j=0; j< cols ; j++)
	            {
	                IntArry[i][j] = (int) (Math.random()*100+1);
	            }
	        }
	    }
	    
	    public void setArraySame(int r , int c ,int value){
	    	this.rows = r;
	    	this.cols = c;
		        IntArry = new int[r][];
		        for(int i = 0 ; i < r; i++)
		        {
		            IntArry[i] = new int[c];
		            for(int j=0; j< c ; j++)
		            {
		                IntArry[i][j] = value;
		            }
		        }
		    }
	    public void setName(){
	        System.out.print("Name of matrix >>>");
	        this.name = scanner.nextLine();
	    }
	    public void setName(String n){
	        this.name = n;
	    }
	    
	    public void printAll(){
	        System.out.println("Matrix "+this.name+" is ");
	        for(int i =0 ; i<rows; i++){
	            for(int j = 0; j<cols;j++){
	                System.out.print(IntArry[i][j]+" ");
	            }
	             System.out.println("");
	        }
	        
	    }
}
