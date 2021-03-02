import java.util.Scanner;

public class Question1 {
	public static int numberOfChecking2(int n){

		int numChecks = 0;
		int[] f = new int[n+1];
		if (n==1) numChecks = 1;
		else if (n==2) numChecks = 2;
		else{ //n>=3
			f[0] = 0; f[1] = 1; f[2] = 2;
			for (int i=3; i<=n; i++){
				int min = n;
				for (int j = 1; j<i; j++){
					int x = Math.max(j, f[i-j]+1);
					if (x < min) min = x;
				}
				f[i] = min;
			}
			numChecks = f[n];
		}
		return numChecks;
	}

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in); 
		System.out.println("Please enter number of floors");
		int num = myObj.nextInt();  
		myObj.close();
		if (num<0) {
			System.out.println("you cant enter a number below 0");
			return;
		}

		System.out.println("minimum number of throws: "+numberOfChecking2(num));  

	}
}

