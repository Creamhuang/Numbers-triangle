/*���������Σ����·���ͣ�����:
 * ����һ��n��������ɵ������Σ�����㷨��������������εĶ����׵�һ��·����
 * ʹ��·�����������ֺ����*/
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
		int  row = r.nextInt(10);//r.nextInt(10)����һ������0~10֮�����������0��10��
		System.out.println("����:"+row);
		
		//��������ɵ������������ε���ʽд���ļ�a.txt
		try {
			fw = new FileWriter("a.txt");
			BufferedWriter bufw = new BufferedWriter(fw);
			
			int[][] value = new int[row][row];
			for(int i=0; i<row; i++){
				for(int j=0; j<=i; j++){
					value[i][j] = r.nextInt(10);
					//System.out.print(value[i][j]+" ");
					String str1 = Integer.toString(value[i][j]);//����������ת��Ϊ�ַ���������д���ļ�
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
		
		//���ļ�a.txt�ж�ȡ��ֵ������һ��������������
		int[][] a = new int[row][row];
		System.out.println("������ɵ���������������:");
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
