package com.agrothrim.exercise2;

public class Max_Sum {
	public void max_sum(int row,int[][] a){	
		int i,j;
		int[][] maxsum = new int[row][row];
		
		for(j = 0;j <row;j++)
			maxsum[row-1][j] = a[row-1][j];
		for(i = row-1 ;i >= 1;i--){
			for(j = 0;j < i;j++){
				if(maxsum[i][j] > maxsum[i][j+1])
					maxsum[i-1][j] = maxsum[i][j]+a[i-1][j];
				else
					maxsum[i-1][j] = maxsum[i][j+1]+a[i-1][j];
			}
		}
		System.out.println("自底向上求和后的三角形如下:");
		for(i=0; i<row; i++) {
			for(j =0; j<=i; j++) {
				System.out.printf("%-5d",maxsum[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("最佳路径上的和为:"+maxsum[0][0]);
	}
}
