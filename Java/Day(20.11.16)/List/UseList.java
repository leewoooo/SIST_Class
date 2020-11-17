package day1116.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * - �˻����� ����� ������ �ߺ� Data�� ������ �� �ִ� List�� ���
 * - ���� ������ : �������� �߰�, ���� �۾��� ���� ���� ������ ����ȴ�.
 * @author owner
 */
public class UseList {

	/**
	 * Multi Thread���� ���� ������ �Ұ��� �մϴ�. (���ȼ��� �䱸 �Ҷ� ���)
	 * ����ȭ�� �Ǿ� �ִ�, �ӵ��� ������ (Arraylist�� ����)
	 */
	public void useVector(){
		
		//1. ���� : Generic�� �⺻�� DatType�� ����� �� ���� , �⺻�� ��� Wrapper Class�� ���
		Vector<Integer> vec = new Vector<Integer>(3); 
		//�⺻ ���� ũ��, size�� ���� ũ�Ⱑ ������ �ʴ´�, Data�� �߰��Ǹ� ���� ũ�Ⱑ �þ��.

		List<String> list = new Vector<String>();
		
		System.out.println( "������ ũ�� " + vec.size());
		System.out.println("����Ʈ�� ũ�� " + vec.size());
		
		//2.�� �߰� : Generic���� ������ Datatype�� �߰� ����
		vec.add(10); // => vec.add(Integer(10));
		//�⺻�� Datatype�� �߰��ϸ� JVM��  �⺻�� Datatype�� �����Ǵ� 
		//Wrapper Class�� ����Ͽ� ��ü�� ������ְ� �߰��Ѵ�. 
		// JDK 1.5���� �߰��� autoboxing ����̶�� �Ѵ�.
		
		vec.add(20);
		System.out.println( "������ ũ�� " + vec.size());
		vec.add(30);
		vec.add(10); //�ߺ��� ���
		//capacity�� ũ�⸦ �ʰ��ϴ��� ���� �����Ͽ� �߰��ȴ�.
		//������ �� ���� ũ�⸦ �������־�� Data�� �߰� �Ǹ� ����ؼ� ���� �����ȴ�.
		System.out.println( "������ ũ�� " + vec.size());
		System.out.println(vec); //Object.toString()�� Vector�� Override�Ͽ� �ּҰ� �ƴ� ���� ���
		
		list.add("������");
		list.add("������");
		list.add("������");
		list.add("������");
		list.add("������"); 
		System.out.println("list�� ũ�� " + list.size() + " / " + list);
		
		//�迭�� ����
		//Generic�� �������� ���� List�� ����� warning�� �߻�
		//�迭�� List�� ũ��� �����մϴ�.
//		int[]arr = new int[vec.size()];  int�� Integer�� ���� Datatype�� �ƴϴ�.
		Integer[]arr = new Integer[vec.size()];  
		String[]arr1 = new String[list.size()];
		
		//���� 
		list.toArray(arr1);
		vec.toArray(arr);
		
		//3. ����� : unboxing �߻�
		String name = list.get(0); //�Է� ������ ���� �����ϴ� ������ ���� ���ٸ� unboxing�� �������� �ʴ´�.
		System.out.println(name);
		
		int num = vec.get(0); 
		//get method�� ��ȯ���� Integer������ unboxing�� �����Ͽ� int�� ����ȴ�.
		//Wrapper Class�� Generic���� �����Ǿ� ���� �� �⺻�� Datatype���� ���� ������ JVM�� Wrapper Class���� �⺻������ ���� ����  Unboxing�� ����.
		//int num=vec.get(0).intValue();
		
		
		System.out.println(name + " / " + num);
		
		//4.�ϰ�ó��
		for(int i = 0 ; i < vec.size() ; i ++) {
			System.out.println(vec.get(i));
		}//end for
		
		for(int j = 0 ; j < list.size() ; j++) {
			System.out.println(list.get(j));
		}//end for
		
		
		//5.�� ����
		
		//index���� �����
		
		vec.remove(1); //1�� Index�� ������ �ִ� ���� �� ����
		list.remove(3); // ������ ����
		System.out.println(vec);
		System.out.println(list);
		//Object���� �����
//		vec.remove(new Integer(30));// 30�� ���� JDK 1.8 ����
		vec.remove(Integer.valueOf(30));// 30�� ���� // JDK9���Ŀ��� �����ڰ� ����õ���� ����Ǿ� Static method���
		list.remove("������");//������ ����
		System.out.println(vec);
		System.out.println(list);
		
		System.out.println("vec�� ����°�?" + vec.isEmpty());
		System.out.println("list�� ����°�?" + list.isEmpty());
		
		//��� ���� ���� ����
		vec.clear();
		list.clear();
		System.out.println("vec�� ����°�?" + vec.isEmpty());
		System.out.println("list�� ����°�?" + list.isEmpty());
		
//		System.out.println(list.size() == 0); //isempty�� ���� ����Դϴ�.
		
		System.out.println("=====�迭�� ������ ���� =====");
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.println(arr[i]);
		}//end for
		
		for(int i = 0 ; i < arr1.length ; i++) {
			System.out.println(arr1[i]);
		}//end for
		
	}//useVector
	
	/**
	 * Multi Thread���� ���� ������ �����ϴ�.
	 * �� ����ȭ�� �Ǿ� �ִ�, �ӵ��� ������ (Vector�� ����)
	 */
	public void useArrayList() {
		

		//1. ���� : Generic�� �⺻�� DatType�� ����� �� ���� , �⺻�� ��� Wrapper Class�� ���
		ArrayList<Integer> al = new ArrayList<Integer>(3); 
		//�⺻ ���� ũ��, size�� ���� ũ�Ⱑ ������ �ʴ´�, Data�� �߰��Ǹ� ���� ũ�Ⱑ �þ��.

		List<String> list = new ArrayList<String>();
		
		System.out.println( "ArrayList�� ũ�� " + al.size());
		System.out.println("����Ʈ�� ũ�� " + al.size());
		
		//2.�� �߰� : Generic���� ������ Datatype�� �߰� ����
		al.add(10); // => al.add(Integer(10));
		//�⺻�� Datatype�� �߰��ϸ� JVM��  �⺻�� Datatype�� �����Ǵ� 
		//Wrapper Class�� ����Ͽ� ��ü�� ������ְ� �߰��Ѵ�. 
		// JDK 1.5���� �߰��� autoboxing ����̶�� �Ѵ�.
		
		al.add(20);
		System.out.println( "ArrayList�� ũ�� " + al.size());
		al.add(30);
		al.add(10); //�ߺ��� ���
		//capacity�� ũ�⸦ �ʰ��ϴ��� ���� �����Ͽ� �߰��ȴ�.
		//������ �� ���� ũ�⸦ �������־�� Data�� �߰� �Ǹ� ����ؼ� ���� �����ȴ�.
		System.out.println( "ArrayList�� ũ�� " + al.size());
		System.out.println(al); //Object.toString()�� altor�� Override�Ͽ� �ּҰ� �ƴ� ���� ���
		
		list.add("������");
		list.add("������");
		list.add("������");
		list.add("������");
		list.add("������"); 
		System.out.println("list�� ũ�� " + list.size() + " / " + list);
		
		//�迭�� ����
		//Generic�� �������� ���� List�� ����� warning�� �߻�
		//�迭�� List�� ũ��� �����մϴ�.
//		int[]arr = new int[al.size()];  int�� Integer�� ���� Datatype�� �ƴϴ�.
		Integer[]arr = new Integer[al.size()];  
		String[]arr1 = new String[list.size()];
		
		//���� 
		list.toArray(arr1);
		al.toArray(arr);
		
		//3. ����� : unboxing �߻�
		String name = list.get(0); //�Է� ������ ���� �����ϴ� ������ ���� ���ٸ� unboxing�� �������� �ʴ´�.
		System.out.println(name);
		
		int num = al.get(0); 
		//get method�� ��ȯ���� Integer������ unboxing�� �����Ͽ� int�� ����ȴ�.
		//Wrapper Class�� Generic���� �����Ǿ� ���� �� �⺻�� Datatype���� ���� ������ JVM�� Wrapper Class���� �⺻������ ���� ����  Unboxing�� ����.
		//int num=al.get(0).intValue();
		
		
		System.out.println(name + " / " + num);
		
		//4.�ϰ�ó��
		for(int i = 0 ; i < al.size() ; i ++) {
			System.out.println(al.get(i));
		}//end for
		
		for(int j = 0 ; j < list.size() ; j++) {
			System.out.println(list.get(j));
		}//end for
		
		
		//5.�� ����
		
		//index���� �����
		
		al.remove(1); //1�� Index�� ������ �ִ� ���� �� ����
		list.remove(3); // ������ ����
		System.out.println(al);
		System.out.println(list);
		//Object���� �����
//		al.remove(new Integer(30));// 30�� ���� JDK 1.8 ����
		al.remove(Integer.valueOf(30));// 30�� ���� // JDK9���Ŀ��� �����ڰ� ����õ���� ����Ǿ� Static method���
		list.remove("������");//������ ����
		System.out.println(al);
		System.out.println(list);
		
		System.out.println("al�� ����°�?" + al.isEmpty());
		System.out.println("list�� ����°�?" + list.isEmpty());
		
		//��� ���� ���� ����
		al.clear();
		list.clear();
		System.out.println("al�� ����°�?" + al.isEmpty());
		System.out.println("list�� ����°�?" + list.isEmpty());
		
//		System.out.println(list.size() == 0); //isempty�� ���� ����Դϴ�.
		
		System.out.println("=====�迭�� ������ ���� =====");
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.println(arr[i]);
		}//end for
		
		for(int i = 0 ; i < arr1.length ; i++) {
			System.out.println(arr1[i]);
		}//end for
		
		
	}//useArraylist
	
	public static void main(String[] args) {

		UseList ul = new UseList();
		ul.useVector();
		System.out.println("======================");
		ul.useArrayList();
			
	}//main

}//class
