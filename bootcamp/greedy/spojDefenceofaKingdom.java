package bootcamp.greedy;
import java.util.*;
import java.lang.*;
public class spojDefenceofaKingdom {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++){
			int w=s.nextInt();
			int h=s.nextInt();
			int n=s.nextInt();
			if(n==0){
				System.out.println(w*h);
				continue;
			}
			Set<Integer> xmap=new HashSet<>();
			Set<Integer> ymap=new HashSet<>();
			for(int j=0;j<n;j++){
				xmap.add(s.nextInt());
				ymap.add(s.nextInt());
			}
			int maxw=0;
			int cnt=0;
			for(int j=1;j<=w;j++){
				if(!xmap.contains(j)){
					cnt++;
					if(cnt>maxw){
						maxw=cnt;
					}
				}
				else{
					cnt=0;
				}
			}
			int maxh=0;
			cnt=0;
			for(int j=1;j<=h;j++){
				if(!ymap.contains(j)){
					cnt++;
					if(cnt>maxh){
						maxh=cnt;
					}
				}
				else{
					cnt=0;
				}
			}
			System.out.println(maxw*maxh);
		}
	}

}
