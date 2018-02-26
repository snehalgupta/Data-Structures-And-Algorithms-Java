package LAB2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


class mess{
	double fooda;
	double foodn;
	double hyg;
	double del;
	int mr;
	
	public mess(double n1,double n2,double n3,double n4){
		fooda=n1;
		foodn=n2;
		hyg=n3;
		del=n4;
		mr=0;
	}
	
	public boolean isless(mess obj){
		if(fooda > obj.fooda)
			return true;
		else if(fooda == obj.fooda){
		if(foodn > obj.foodn)
			return true;
		else if(foodn == obj.foodn){
		if(hyg > obj.hyg)
			return true;
		else if(hyg == obj.hyg){
		 if(del < obj.del)
			return true;}}}
		return false;
	}
}
class messh{
	mess[] harr;
	int capacity;
	int heap_size;
	
	public messh(int n){
		heap_size=0;
		capacity=n;
		harr=new mess[n];
	}
	
	public int parent(int i){
		return (i-1)/2;
	}
	
	public int left(int i){
		return 2*i + 1;
	}
	
	public int right(int i){
		return 2*i +2;
	}
	
	public void insert(mess k){
		mess temp;
		if(heap_size == capacity){
			System.out.println("Overflow");
			return;
		}
		heap_size++;
		int i=heap_size-1;
		harr[i]=k;
		while( i != 0 && !harr[parent(i)].isless(harr[i])){
			temp=harr[i];
			harr[i]=harr[parent(i)];
			harr[parent(i)]=temp;
			i=parent(i);
		}
	}
	
	
	public mess extractmin(){
		if(heap_size <= 0){
			return null;
		}
		if(heap_size == 1){
			heap_size--;
			return harr[0];
		}
		mess root=harr[0];
		harr[0]=harr[heap_size - 1];
		heap_size--;
		this.MinHeapify(0);
		return root;
	}
	
	private void MinHeapify(int i){
		mess temp;
		int l = left(i);
		int r= right(i);
		int smallest = i;
		if( l < heap_size && harr[l].isless(harr[i])){
			smallest=l;
		}
		if( r < heap_size && harr[r].isless(harr[smallest])){
			smallest=r;
		}
		if( smallest != i){
			temp=harr[i];
			harr[i]=harr[smallest];
			harr[smallest]=temp;
			MinHeapify(smallest);
		}
	}
	
}
class hostel{
	double rc;
	double sf;
	double cl;
	double rf;
	int hr;
	public hostel(double n1,double n2,double n3,double n4){
		rc=n1;
		sf=n2;
		cl=n3;
		rf=n4;
		hr=0;
	}
	
	public boolean isless(hostel obj){
		if(rc > obj.rc)
			return true;
		else if(rc == obj.rc){
		if(sf > obj.sf)
			return true;
		else if(sf == obj.sf){
		 if(cl > obj.cl)
			return true;
		 else if(cl == obj.cl){
		 if(rf > obj.rf)
			return true;}}}
		return false;
		
	}
}

class hostelh{
	hostel[] harr;
	int capacity;
	int heap_size;
	
	public hostelh(int n){
		heap_size=0;
		capacity=n;
		harr=new hostel[n];
	}
	
	public int parent(int i){
		return (i-1)/2;
	}
	
	public int left(int i){
		return 2*i + 1;
	}
	
	public int right(int i){
		return 2*i +2;
	}
	
	public void insert(hostel k){
		hostel temp;
		if(heap_size == capacity){
			System.out.println("Overflow");
			return;
		}
		heap_size++;
		int i=heap_size-1;
		harr[i]=k;
		while( i != 0 && !harr[parent(i)].isless(harr[i])){
			temp=harr[i];
			harr[i]=harr[parent(i)];
			harr[parent(i)]=temp;
			i=parent(i);
		}
	}
	
	
	public hostel extractmin(){
		if(heap_size <= 0){
			return null;
		}
		if(heap_size == 1){
			heap_size--;
			return harr[0];
		}
		hostel root=harr[0];
		harr[0]=harr[heap_size - 1];
		heap_size--;
		this.MinHeapify(0);
		return root;
	}
	
	private void MinHeapify(int i){
		hostel temp;
		int l = left(i);
		int r= right(i);
		int smallest = i;
		if( l < heap_size && harr[l].isless(harr[i])){
			smallest=l;
		}
		if( r < heap_size && harr[r].isless(harr[smallest])){
			smallest=r;
		}
		if( smallest != i){
			temp=harr[i];
			harr[i]=harr[smallest];
			harr[smallest]=temp;
			MinHeapify(smallest);
		}
	}
	
}
class library{
	double ba;
	double df;
	double se;
	int lr;
	public library(double n1,double n2,double n3){
		ba=n1;
		df=n2;
		se=n3;
		lr=0;
	}
	
	public boolean isless(library obj){
		double c1=(ba+df+se)/3;
		double c2=(obj.ba+obj.df+obj.se)/3;
		if(c1 < c2)
			return true;
		return false;
	}
}
class libh{
	library[] harr;
	int capacity;
	int heap_size;
	
	public libh(int n){
		heap_size=0;
		capacity=n;
		harr=new library[n];
	}
	
	public int parent(int i){
		return (i-1)/2;
	}
	
	public int left(int i){
		return 2*i + 1;
	}
	
	public int right(int i){
		return 2*i +2;
	}
	
	public void insert(library k){
		library temp;
		if(heap_size == capacity){
			System.out.println("Overflow");
			return;
		}
		heap_size++;
		int i=heap_size-1;
		harr[i]=k;
		while( i != 0 && harr[parent(i)].isless(harr[i])){
			temp=harr[i];
			harr[i]=harr[parent(i)];
			harr[parent(i)]=temp;
			i=parent(i);
		}
	}
	
	
	public library extractmin(){
		if(heap_size <= 0){
			return null;
		}
		if(heap_size == 1){
			heap_size--;
			return harr[0];
		}
		library root=harr[0];
		harr[0]=harr[heap_size - 1];
		heap_size--;
		this.MinHeapify(0);
		return root;
	}
	
	private void MinHeapify(int i){
		library temp;
		int l = left(i);
		int r= right(i);
		int smallest = i;
		if( l < heap_size && !harr[l].isless(harr[i])){
			smallest=l;
		}
		if( r < heap_size && !harr[r].isless(harr[smallest])){
			smallest=r;
		}
		if( smallest != i){
			temp=harr[i];
			harr[i]=harr[smallest];
			harr[smallest]=temp;
			MinHeapify(smallest);
		}
	}
	
}
class Academics{
	double ki;
	double dc;
	double cs;
	int ar;
	public Academics(double n1,double n2,double n3){
		ki=n1;
		dc=n2;
		cs=n3;
		ar=0;
	}
	
	public boolean isless(Academics obj){
		double c1=ki+dc+cs*2;
		double c2=obj.ki+obj.dc+obj.cs*2;
		if(c1 > c2)
			return true;
		return false;
	}
}

class acadh{
	Academics[] harr;
	int capacity;
	int heap_size;
	
	public acadh(int n){
		heap_size=0;
		capacity=n;
		harr=new Academics[n];
	}
	
	public int parent(int i){
		return (i-1)/2;
	}
	
	public int left(int i){
		return 2*i + 1;
	}
	
	public int right(int i){
		return 2*i +2;
	}
	
	public void insert(Academics k){
		Academics temp;
		if(heap_size == capacity){
			System.out.println("Overflow");
			return;
		}
		heap_size++;
		int i=heap_size-1;
		harr[i]=k;
		while( i != 0 && !harr[parent(i)].isless(harr[i])){
			temp=harr[i];
			harr[i]=harr[parent(i)];
			harr[parent(i)]=temp;
			i=parent(i);
		}
	}
	
	
	public Academics extractmin(){
		if(heap_size <= 0){
			return null;
		}
		if(heap_size == 1){
			heap_size--;
			return harr[0];
		}
		Academics root=harr[0];
		harr[0]=harr[heap_size - 1];
		heap_size--;
		this.MinHeapify(0);
		return root;
	}
	
	private void MinHeapify(int i){
		Academics temp;
		int l = left(i);
		int r= right(i);
		int smallest = i;
		if( l < heap_size && harr[l].isless(harr[i])){
			smallest=l;
		}
		if( r < heap_size && harr[r].isless(harr[smallest])){
			smallest=r;
		}
		if( smallest != i){
			temp=harr[i];
			harr[i]=harr[smallest];
			harr[smallest]=temp;
			MinHeapify(smallest);
		}
	}
	
}

class College{
	String name;
	mess m;
	hostel h;
	library l;
	Academics a;
	int fees;
	char grade;
	int rank;
	double att;
	
	public College(String s,mess n1,hostel n2,library n3,Academics n4,int n5,char c){
		name=s;
		m=n1;
		h=n2;
		l=n3;
		a=n4;
		fees=n5;
		grade=c;
	}
	
	public void find(){
		att=0.25*m.mr+0.2*h.hr+0.25*l.lr+0.3*a.ar;
	}
	
	public boolean isless(College obj){
		if(att > obj.att)
			return true;
		else if(att == obj.att){
		 if(fees < obj.fees)
			return true;
		 else if(fees == obj.fees){
		 if(grade < obj.grade)
			return true;}}
		return false;
	}
	
}
class Collegeh{
	College[] harr;
	int capacity;
	int heap_size;
	
	public Collegeh(int n){
		heap_size=0;
		capacity=n;
		harr=new College[n];
	}
	
	public int parent(int i){
		return (i-1)/2;
	}
	
	public int left(int i){
		return 2*i + 1;
	}
	
	public int right(int i){
		return 2*i +2;
	}
	
	public void insert(College k){
		College temp;
		if(heap_size == capacity){
			System.out.println("Overflow");
			return;
		}
		heap_size++;
		int i=heap_size-1;
		harr[i]=k;
		while( i != 0 && harr[parent(i)].isless(harr[i])){
			temp=harr[i];
			harr[i]=harr[parent(i)];
			harr[parent(i)]=temp;
			i=parent(i);
		}
	}
	
	
	public College extractmin(){
		if(heap_size <= 0){
			return null;
		}
		if(heap_size == 1){
			heap_size--;
			return harr[0];
		}
		College root=harr[0];
		harr[0]=harr[heap_size - 1];
		heap_size--;
		this.MinHeapify(0);
		return root;
	}
	
	private void MinHeapify(int i){
		College temp;
		int l = left(i);
		int r= right(i);
		int smallest = i;
		if( l < heap_size && !harr[l].isless(harr[i])){
			smallest=l;
		}
		if( r < heap_size && !harr[r].isless(harr[smallest])){
			smallest=r;
		}
		if( smallest != i){
			temp=harr[i];
			harr[i]=harr[smallest];
			harr[smallest]=temp;
			MinHeapify(smallest);
		}
	}
	
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
			int m=Reader.nextInt();
			messh mh=new messh(m);
			libh lh=new libh(m);
			hostelh hh=new hostelh(m);
			acadh ah=new acadh(m);
			Collegeh coh=new Collegeh(m);
			ArrayList<College> arr1=new ArrayList<College>();
			for(int i=0;i<m;i++){
				String s=Reader.next();
				String s1=Reader.next();
				mess m1;
				library l1;
				hostel h1;
				Academics a1; 
				int ds;
				char ch;
				//if(s1.equals("Mess")){
					double n1=Reader.nextDouble();
					double n2=Reader.nextDouble();
					double n3=Reader.nextDouble();
					double n4=Reader.nextDouble();
					m1=new mess(n1,n2,n3,n4);
					mh.insert(m1);//}
					
				String s2=Reader.next();
				//if(s2.equals("Hostel")){
					double n5=Reader.nextDouble();
					double n6=Reader.nextDouble();
					double n7=Reader.nextDouble();
					double n8=Reader.nextDouble();
					h1=new hostel(n5,n6,n7,n8);
					hh.insert(h1);
				//}
				String s3=Reader.next();
				//if(s3.equals("Library")){
					double r1=Reader.nextDouble();
					double r2=Reader.nextDouble();
					double r3=Reader.nextDouble();
					l1=new library(r1,r2,r3);
					lh.insert(l1);
				//}
				String s4=Reader.next();
				//if(s4.equals("Academics")){
					double x1=Reader.nextDouble();
					double x2=Reader.nextDouble();
					double x3=Reader.nextDouble();
					a1=new Academics(x1,x2,x3);
					ah.insert(a1);
				//}
				String s5=Reader.next();
				//if(s5.equals("Fees")){
					 ds=Reader.nextInt();
				//}
				String s8=Reader.next();
				String sa=Reader.next();
				//if(sa.equals("Certificate")){
					String sb=Reader.next();
					ch=sb.charAt(0);
				//}
				College c1=new College(s,m1,h1,l1,a1,ds,ch);
				arr1.add(c1);
			}
			int count=0;
			while(mh.heap_size!= 0){
				mess b=mh.extractmin();
				//System.out.println(b.fooda);
				count++;
				b.mr=count;
			}
			count=0;
			while(hh.heap_size != 0){
				hostel x=hh.extractmin();
				count++;
				x.hr=count;
			}
			count=0;
			while(lh.heap_size != 0){
				library x=lh.extractmin();
				count++;
				x.lr=count;
			}
			count=0;
			while(ah.heap_size != 0){
				Academics x=ah.extractmin();
				count++;
				x.ar=count;
			}
			for(int f=0;f<arr1.size();f++){
				arr1.get(f).find();
				coh.insert(arr1.get(f));
			}
			while(coh.heap_size != 0){
				College yu=coh.extractmin();
				System.out.println(yu.name);
				System.out.println(yu.m.mr+" "+yu.h.hr+" "+yu.l.lr+" "+yu.a.ar+" "+yu.att);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
/** Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}