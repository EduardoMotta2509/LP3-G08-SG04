package EP4;

public class MenorDe3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(menor(1.1, 3.3, 2.2));
	}
	
	public static double menor(double a, double b, double c) {
		if (a<=b && a<=c) return a;
		if (b<=a && b<=c) return b;
		return c;
	}

}
