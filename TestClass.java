
public class TestClass {
	
	public static void main(String[] args) {
		Double[] v1Arr = {3.0, 6.0, 2.0}; 
		Integer[] v2Arr = {2, 4, 7};
		Vector<Double> v1 = new Vector<Double>(v1Arr);
		Vector<Integer> v2 = new Vector<Integer>(v2Arr);
		System.out.println(v1);
		System.out.println(v2);
		
		System.out.println("\nAddition:");
		System.out.println(v1.add(v2));
		System.out.println(v1);
		System.out.println("\nDot product:");
		System.out.println(v1.dotProd(v2));
	}

}
