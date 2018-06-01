package metricas;

public class Util {

	public static double truncate(double value) {
        return Math.round(value * 100) / 100d;
    }
	
	public static double calculaMedia(double x1, double x2) {
		return (x1+x2)/2;
	}
	
	public static double calculaPontoX(double x1, double y1, double x2, double y2, double pontoY) {
		
		double m = (y2-y1)/(x2-x1);
		//System.out.println(m);
		double b = y1 - m*x1;
		//System.out.println(b);
		double pontoX = (pontoY-b)/m;
		//System.out.println(pontoX);
				
		return pontoX;
	}
	
	
	public static void calculaLimites(double a, double b, double lsup) {
		double m = calculaMedia(a, b);  
		double px = calculaPontoX(a, 0.5, calculaMedia(a, b), 0, 1);  
		double py = calculaPontoX(b, 0.5, calculaMedia(a, b), 0, 1); 	
		
		System.out.println("(0, 1) ("+ px +", 1) ("+ m +", 0)" );
		System.out.println("("+ px +", 0) ("+ m +", 1) ("+ py +", 0)"   );
		System.out.println("("+ m +", 0) ("+ py +", 1) ("+ lsup +", 1)" );
				
	}
	
	
	
	public static void calculaLimitesFinais(double a, double b, double c, double d, double desloc, double lsup) {
		double m = calculaMedia(a, b);  
		double px = calculaPontoX(a, 0.5, calculaMedia(a, b), 0, 1);  
		double py = calculaPontoX(b, 0.5, calculaMedia(a, b), 0, 1); 	
		
		System.out.println("(0, 1) ("+ truncate(a-desloc) +", 1) ("+ a +", 0)" );
		System.out.println("(" + a + ", 0) ("+ truncate(calculaMedia(a, b)) +", 1) ("+ b +", 0)" );
		System.out.println("(" + b + ", 0) ("+ truncate(calculaMedia(b, c)) +", 1) ("+ c +", 0)" );
		System.out.println("(" + c + ", 0) ("+ truncate(calculaMedia(c, d)) +", 1) ("+ d +", 0)" );
		System.out.println("(" + d + ", 0) ("+ truncate(d+desloc) +", 1) ("+ lsup +", 1)" );
	}
	
	
	
	public static void main(String[] args) {
		
		
////size

//		System.out.println(calculaMedia(3, 5)); // 4
//		System.out.println(calculaPontoX(3, 0.5, calculaMedia(3,5), 0, 1)); //2
//		System.out.println(calculaPontoX(5, 0.5, calculaMedia(3,5), 0, 1)); //	6	

//		System.out.println(calculaMedia(10, 28)); // 22.5 - 19
//		System.out.println(calculaPontoX(10, 0.5, calculaMedia(10,28), 0, 1)); //1.49 - 1
//		System.out.println(calculaPontoX(28, 0.5, calculaMedia(10,28), 0, 1)); //	43.5 - 37	

//		System.out.println(calculaMedia(15, 40)); //30 - 27.5
//		System.out.println(calculaPontoX(15, 0.5, calculaMedia(15,40), 0, 1)); //10 - 2.5 
//		System.out.println(calculaPontoX(40, 0.5, calculaMedia(15,40), 0, 1)); //50 - 52.5
//		
//		
		
//stability
		
//		System.out.println(calculaMedia(1, 1.6)); // 1.3 - 
//		System.out.println(calculaPontoX(1, 0.5, calculaMedia(1, 1.6), 0, 1)); //0.7 - 
//		System.out.println(calculaPontoX(1.6, 0.5, calculaMedia(1, 1.6), 0, 1)); //	1.9 - 
//		System.out.println(calculaMedia(2, 4)); // 2.5 - 3
//		System.out.println(calculaPontoX(2, 0.5, calculaMedia(2, 4), 0, 1)); //1.5 - 1 
//		System.out.println(calculaPontoX(4, 0.5, calculaMedia(2, 4), 0, 1)); //	3.5 - 5
//		System.out.println(calculaMedia(2, 7)); // 3 - 4.5
//		System.out.println(calculaPontoX(2, 0.5, calculaMedia(2, 7), 0, 1)); //1 - -0.4 = 0 
//		System.out.println(calculaPontoX(7, 0.5, calculaMedia(2, 7), 0, 1)); //5 - 9.5

// FLEXIBILITY (RIG)
		
//		System.out.println(calculaMedia(4, 11)); // 10 - 7.5
//		System.out.println(calculaPontoX(4, 0.5, calculaMedia(4, 11), 0, 1)); // 0 - 0.5 
//		System.out.println(calculaPontoX(11, 0.5, calculaMedia(4, 11), 0, 1)); // 20 - 15.5
//		System.out.println(calculaMedia(0.12, 0.36)); // 0.26 - 0.24
//		System.out.println(calculaPontoX(0.12, 0.5, calculaMedia(0.12, 0.36), 0, 1)); // 0.06 - -0
//		System.out.println(calculaPontoX(0.36, 0.5, calculaMedia(0.12, 0.36), 0, 1)); // 0.45 - 0.48
//		System.out.println(calculaMedia(15, 40)); // 30 - 27.5
//		System.out.println(calculaPontoX(15, 0.5, calculaMedia(15, 40), 0, 1)); // 10 - 2.5 
//		System.out.println(calculaPontoX(40, 0.5, calculaMedia(15, 40), 0, 1)); //	 50 - 52.5


// DINAMICITY (adaptability)

//		System.out.println(calculaMedia(6, 13)); // 8 - 9.5
//		System.out.println(calculaPontoX(6, 0.5, calculaMedia(6, 13), 0, 1)); //1.99 - 2.5
//		System.out.println(calculaPontoX(13, 0.5, calculaMedia(6, 13), 0, 1)); //	13.99 - 16.5	
//
//		System.out.println(calculaMedia(2, 5)); // 4.5 - 3.5
//		System.out.println(calculaPontoX(2, 0.5, calculaMedia(2, 5), 0, 1)); //1.5 - 0.5
//		System.out.println(calculaPontoX(5, 0.5, calculaMedia(2, 5), 0, 1)); //	7.5	- 6.5
//
//		System.out.println(calculaMedia(7,16)); //11 - 11.5
//		System.out.println(calculaPontoX(7, 0.5, calculaMedia(7,16), 0, 1)); //3 - 2.5
//		System.out.println(calculaPontoX(16, 0.5, calculaMedia(7,16), 0, 1)); //19 - 20.5
//				
		System.out.println(calculaMedia(5,11)); //7.5 - 8
		System.out.println(calculaPontoX(5, 0.5, calculaMedia(5,11), 0, 1)); //2.5 - 2
		System.out.println(calculaPontoX(11, 0.5, calculaMedia(5,11), 0, 1)); //12.5 - 14
//				
//						
//		

		
	}
	
}
