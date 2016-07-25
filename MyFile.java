package com.agrothrim.exercise2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MyFile {
	public void fileOperate(){ 
		FileReader fr = null;
		FileWriter fw = null;
		Random r = new Random();
		int  row = r.nextInt(10);//����
		//��������ɵ����������ε���ʽд���ļ�
		try {
			fw = new FileWriter("a.txt");
			BufferedWriter bufw = new BufferedWriter(fw);
			String str = Integer.toString(row);
			bufw.write(str+" ");//����д���ļ�
			bufw.newLine();
			
			int[][] value = new int[row][row];
			for(int i = 0;i < row;i++){
				for(int j = 0;j <=i;j++){
					value[i][j] = r.nextInt(10);
					System.out.print(value[i][j]+" ");
					String str1 = Integer.toString(value[i][j]);
					bufw.write(str1+" ");
				}
				bufw.newLine();
				System.out.println();
			}	
			bufw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//���ļ��ж�ȡ��ֵ������һ��������������
		try {
			fr = new FileReader("a.txt");
			BufferedReader bufr = new BufferedReader(fr);
			String str = "";
			int[][] a = new int[row+1][row+1];
			
			while((str = bufr.readLine()) != null){
				a[0][0] = Integer.parseInt(str);
				for(int i = 1;i < row+1;i++){
					for(int j = 0;j < i;j++){
						a[i][j] = Integer.parseInt(str);
						//System.out.print(a[i][j]);
					}
					//System.out.println();
				}
			} 
			bufr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e){
			//e.printStackTrace();
		}
		
		
	}
}
