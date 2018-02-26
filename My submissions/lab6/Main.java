package lab6;
import java.io.*;
import java.util.Scanner;
import java.util.*;

class Point{
	double x;
	double y;
	
	public Point(double x1,double y1){
		x=x1;
		y=y1;
	}
}

class NonCoordinateException extends Exception{
	public NonCoordinateException(String message ){
		super(message);
	}
}

class StackEmptyException extends Exception{
	public StackEmptyException(String message){
		super(message);
	}
}

class OverlapException extends Exception{
	public OverlapException(String message){
		super(message);
	}
}

class QueenFoundException extends Exception{
	public QueenFoundException(String message){
		super(message);
	}
}
class Node{
	String type;
	Point point;
	String val;
	
	public Node(String s1){
		type=s1;
	}
}

class Knight implements Comparable<Knight>{
	String name;
	Stack<Node> s;
	Point point;
	
	public Knight(){
		s=new Stack<Node>();
	}
	
	public int compareTo(Knight d){
		int ans=0;
		if(name.compareTo(d.name) < 0)
			ans=-1;
		else if(name.compareTo(d.name) > 0)
			ans=1;
		return ans;
	}
}

public class Main {

	public static void main(String[] args) throws IOException,NonCoordinateException,StackEmptyException,OverlapException,QueenFoundException{
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int k=sc.nextInt();
		int n=sc.nextInt();
		double x=sc.nextDouble();
		double y=sc.nextDouble();
		ArrayList<Knight> karr=new ArrayList<Knight>();
		
		PrintWriter w = new PrintWriter("./src/" + "answer" + ".txt");
		for(int i=1;i<=k;i++){
			String s1=Integer.toString(i).concat(".txt");
			File file=new File("./input/"+s1);
			FileReader in=new FileReader(file);
			BufferedReader br = new BufferedReader(in);
			String type=br.readLine();
			Knight kn=new Knight();
			kn.name=type;
			String[] coor=br.readLine().split(" ");
			double x1=Double.parseDouble(coor[0]);
			double y1=Double.parseDouble(coor[1]);
			Point p=new Point(x1,y1);
			kn.point=p;
			String s2=br.readLine();
			int m=Integer.parseInt(s2);
			for(int j=0;j<m;j++){
				String[] arr=br.readLine().split(" ");
				Node nptr=new Node(arr[0]);
				if(arr[0].equals("Coordinate")){
					nptr.point=new Point(Double.parseDouble(arr[1]),Double.parseDouble(arr[2]));
				}
				else{
					nptr.val=arr[1];
				}
				kn.s.push(nptr);
			}
			karr.add(kn);
			}
		int flag=0;
		Collections.sort(karr);
		for(int er=1;er<=n;er++){
			for(int qw=0;qw<karr.size();qw++){
				try{
				w.println(er+" "+karr.get(qw).name+" "+karr.get(qw).point.x+" "+karr.get(qw).point.y);
				if(karr.get(qw).s.isEmpty()){
					throw new StackEmptyException("StackEmptyException:​ ​Stack​ ​Empty​ ​exception​");
				}	
				Node poll=karr.get(qw).s.pop();
				if(!poll.type.equals("Coordinate"))
					throw new NonCoordinateException("​NonCoordinateException: ​Not a coordinate Exception​"+" "+poll.val);
				if(poll.point.x == x && poll.point.y == y){
					karr.get(qw).point.x=poll.point.x;
					karr.get(qw).point.y=poll.point.y;
					throw new QueenFoundException("QueenFoundException:​ ​Queen​ ​has​ ​been​ ​Found.​ ​Abort!​");
				}

				for(int xc=0;xc<karr.size();xc++){
					if(xc != qw){
						if(karr.get(xc).point.x == poll.point.x && karr.get(xc).point.y == poll.point.y ){
							String cv1=karr.get(xc).name;
							karr.get(qw).point.x=poll.point.x;
							karr.get(qw).point.y=poll.point.y;
							karr.remove(xc);
							throw new OverlapException("OverlapException:​ ​Knights​ ​Overlap​ ​Exception​"+" "+cv1);
						}
					}
				}
				w.println("No​ ​exception"+" "+poll.point.x+" "+poll.point.y);
				karr.get(qw).point.x=poll.point.x;
				karr.get(qw).point.y=poll.point.y;
				}
				catch(NonCoordinateException e){
					w.println(e.getMessage());
					System.out.println(e.getMessage());
				}
				catch(StackEmptyException e){
					w.println(e.getMessage());
					System.out.println(e.getMessage());;
				}
				catch(OverlapException e){
					w.println(e.getMessage());
					System.out.println(e.getMessage());
				}
				catch(QueenFoundException e){
					flag=1;
					w.println(e.getMessage());
					System.out.println(e.getMessage());
					break;
				}
			}
			if(flag == 1)
				break;
		}
		w.close();
	}

}
