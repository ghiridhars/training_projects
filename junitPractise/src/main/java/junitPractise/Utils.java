package junitPractise;

public class Utils {
	
	public int add(int a, int b) {
		return a + b;
	}

	public int sub(int a, int b) {
		return a - b;
	}

	public int mul(int a, int b) {
		return a * b;
	}

	public int div(int a, int b) {
		return a / b;
	}

	public double computeArea(double radius) {
		return Math.PI * radius * radius;
	}

	public int[] multiplicationTable(int num) {
		int[] arr= new int[5];
		for (int i=1; i<=5; i++) {
			arr[i-1] = num*i;
		}
		return arr;
	}

}
