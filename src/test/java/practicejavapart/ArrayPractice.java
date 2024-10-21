package practicejavapart;

public class ArrayPractice {

	public static void main(String[] args) {
		int abc[][]= {{8,7,3},{9,2,1},{10,4,5}};
		int min = abc[0][0];
		int mincoloumn = 0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(abc[i][j]<min) {
					min = abc[i][j];
					mincoloumn = j;	
					}
			}
			
		}
		int k = 0;
		int max = abc[0][mincoloumn];	
		while(k<3) {
			if(abc[k][mincoloumn]>max) {
				max=abc[k][mincoloumn];	
			}
			k++;
		}
	
	System.out.println(max);
	}
	}