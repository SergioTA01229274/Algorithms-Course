
public class Simpson {
	
	public double simpsonMethod(double[] FZ, double b, int n) {
		double x0 = FZ[0];
		double xn = FZ[FZ.length - 1];
		double xi = 0;
		double xj = 0;
		double result = 0;
		
		for(int i = 1; i < FZ.length; i++) {
			if(i % 2 != 0) {
				xi+=FZ[i];
			}
		}
		for(int j = 1; j < FZ.length; j++) {
			if(j % 2 == 0) {
				xj+=FZ[j];
			}
		}
		
		xi = 4*xi;
		xj = 2*xj;
		
		result = x0 + xi + xj + xn;
		result = b*((result)/(3 * n));
		
		return result;
	}
	
	public double[] calculateF(double alturaM, double distanciaC) {
		int n = (int) Math.floor(alturaM/distanciaC);
		double[] variables = new double[6];
		double cont = 0;
		double[] fz = new double[n];
		double[] fd = new double[n];
		
		for (int i = 0; i < fz.length; i++) {
			fz[i] = 200 * (cont / (5 + cont)) * Math.pow(Math.E, (-cont/ 15));
			cont += distanciaC;
		}
		double F = 0;
		F = simpsonMethod(fz, alturaM, fz.length);
		variables[0] = F;
		
		cont = 0;
		for (int i = 0; i < fd.length; i++) {
			fd[i] = (200*cont) * (cont / (5 + cont)) * Math.pow(Math.E, (-cont/ 15));
			cont += distanciaC;
		}
		
		double d = 0;
		d = simpsonMethod(fd, 30, fd.length)/F;
		variables[1] = d;
		double V = (F*d)/3;
		variables[2] = V;
		double degree = Math.atan(distanciaC/alturaM);
		
		double T = V/(Math.cos(degree));
		variables[3] = T;
		
		double H = F - T*Math.sin(degree);
		variables[4] = H;
		
		variables[5] = degree;
		
		return variables;
	}
	
	public static void main(String[] args) {
	}
	
}
