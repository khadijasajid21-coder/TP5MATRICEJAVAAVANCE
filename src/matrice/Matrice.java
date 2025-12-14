package matrice;
import java.util.function.*;

public class Matrice {

	static void affiche(int[][] t) {
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				System.out.print(t[i][j] + "\t");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) throws InterruptedException {
		int n = Integer.parseInt(args.length > 0 ? args[0] : "10");
		int m[][] = new int[n][n];
		int som[] = new int[n];
		for (int i = 0; i < m.length; i++)
			for (int j = 0; j < m[i].length; j++)
				m[i][j] = (int) (Math.random() * 10);
		
		 affiche(m);
		 
		  ThreadSom[] threadSoms = new ThreadSom[n];
		  
		  for (int i = 0; i < n; i++) {
	            threadSoms[i] = new ThreadSom(m[i]); 
	            threadSoms[i].start();               
	        }
		  for (int i = 0; i < n; i++) {
	            threadSoms[i].join();
	        }
		  
		  for (int i = 0; i < n; i++) {
	            som[i] = threadSoms[i].som;
	            System.out.println(som[i]);
	        }
		  int total = 0;
	        for (int i = 0; i < n; i++) {
	            total += som[i];
	        }
	        System.out.println("Somme = " + total);

	}
}
