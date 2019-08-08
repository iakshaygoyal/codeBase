package codingNinjas.numberTheory;
import java.util.*;
public class EulerTotientFunction {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		eulerPhi(n);
		scn.close();
	}
	
	static void eulerPhi(int n){
		int[] phi=new int[n+1];
		for(int i=1;i<=n;i++){
			phi[i]=i;
		}
		for(int i=2;i<=n;i++){
			if(phi[i]==i){
				phi[i]=i-1;
				for(int j=2*i;j<=n;j+=i){
					phi[j]=(phi[j]*(i-1))/i;
				}
			}
		}
		
		for(int i=1;i<=n;i++){
			System.out.println("phi("+i+") : "+phi[i]);
		}
	}

}
