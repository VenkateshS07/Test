package practicejavapart;

public class NestedLoopsWorks {
	public static void main(String[] args) {
	
//nested loops - much important
		//int k=1;
	for(int i=0;i<10;i++) {
		if (i %3 == 0) {
		for(int j=1;j<=i;j++) { 
			if (j%3 == 0) {//inner loops
			System.out.print(j);
			}
		}
		System.out.println(" ");
		}
	}
	}
}