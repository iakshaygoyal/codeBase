package lec04;

import java.util.Scanner;

public class count {

	public static void main(String[] args) {
		int lines=0,words=0,chars=0;
		Scanner s=new Scanner(System.in);
		boolean b=true;
		while(b)
		{
			String line=s.nextLine().trim();
			lines++;
			words++;
			for(int i=0;i<line.length();i++)
			{
				if(line.charAt(i)=='$')
				{
					words--;
					b=false;
					break;
				}
				if(line.charAt(i)==' ' || line.charAt(i)=='\t')
					words++;
				chars++;
			}
		}
		System.out.println("Lines: "+lines);
		System.out.println("Words:"+words);
		System.out.println("Chars:"+chars);

	}

}
