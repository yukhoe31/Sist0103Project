package day0109;

import java.util.Arrays;

public class L15_QuizInOutRank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String [] name= {"홍수연","김수연","최수연","민수연"};
		int [] kor= {90,88,100,78};
		int [] eng= {100,55,100,87};
		int [] mat= {44,55,100,66};
		int [] tot=new int[4];
		double [] avg=new double[4];
		int []rank=new int[4];

		/*
		 * 1:1카톡으로 콘솔창 결과물만 캡쳐1장  보내주세요^^
		 * 
		 * 각 학생들의 점수에 대한 총점 평균 등수를 구하여 출력하세요
		 * 
		 * 번호   이름   국어   영어   수학   총점  평균   등수
		 * =====================================================
		 * 1      홍수연  90     100     44     **   **      4
		 */

		//1.총점 평균  ..배열
		for(int i=0;i<name.length;i++) {
			tot[i]=kor[i]+eng[i]+mat[i];
			avg[i] = tot[i]/3;
		}
		for(int i=0;i<name.length;i++) {
			System.out.print(avg[i]+"  ");
		}

		// 2. 등수
		for(int i=0; i<name.length; i++) {
			rank[i]=1;

			for(int j=0; j<name.length; j++) {
				if(avg[i]<avg[j]) {
					rank[i]++;
				}
			}
		}

		// 3. 출력
		System.out.println();
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t등수");
		System.out.println("===========================================================");

		for(int i=0; i<name.length; i++) {
			System.out.println((i+1)+"\t"+name[i]+"\t"+kor[i]+"\t"+eng[i]+"\t"+mat[i]+"\t"+tot[i]+"\t"+avg[i]+"\t"+rank[i]);

		}	

	}

}
