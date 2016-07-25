/*数字三角形（最佳路径和）问题:
 * 给定一个n行数字组成的三角形，设计算法，计算出从三角形的顶至底的一条路径，
 * 使该路径经过的数字和最大。*/
package com.agrothrim.exercise2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
 
public class Demo {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		Random r = new Random();
		int  row = r.nextInt(10);//r.nextInt(10)产生一个处于0~10之间的数（包括0和10）
		System.out.println("行数:"+row);
		
		//将随机生成的数字以三角形的形式写入文件a.txt
		try {
			fw = new FileWriter("a.txt");
			BufferedWriter bufw = new BufferedWriter(fw);
			
			int[][] value = new int[row][row];
			for(int i=0; i<row; i++){
				for(int j=0; j<=i; j++){
					value[i][j] = r.nextInt(10);
					//System.out.print(value[i][j]+" ");
					String str1 = Integer.toString(value[i][j]);//将整形数据转换为字符串型数据写入文件
					bufw.write(str1+" ");
				}
				bufw.newLine();
				//System.out.println();
			}	
			bufw.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		//从文件a.txt中读取数值，赋给一个下三角形数组
		int[][] a = new int[row][row];
		System.out.println("随机生成的数字三角形如下:");
		try {
			fr = new FileReader("a.txt");
			BufferedReader bufr = new BufferedReader(fr);
			String str = "";
			
			int i = 0;
			while((str = bufr.readLine()) != null){
//  			a[0][0] = Integer.parseInt(str);
				String[] str1 = str.split(" ");
				int d = 0;
		//		for(int i = 0;i < row;i++){
					for(int j = 0;j <= i;j++){
						a[i][j] = Integer.parseInt(str1[d++]);
						System.out.print(a[i][j]+" ");
					}
					System.out.println();
					i++;
				}
		//	}
			bufr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		new Max_Sum().max_sum(row,a);
	}
}
