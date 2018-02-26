package lab3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import lab4.World;

class Creature{
	String name;
	String type;
	int cost;
	int asset;
	int power;
	int health;
	public Creature(int n2,int n3,int n4,int n5){
		//name=n1;
		cost=n2;
		asset=n3;
		power=n4;
		health=n5;
	}
	public int getdamage(Creature obj){
		int gd=0;
		int d1=(int) (Math.random()*100)+1;
		//int d1=13;
		int d=(int) (Math.random()*obj.power);
		//int d=20;
		gd+=d;
		if(obj.type.equals("firedrag")){
			if(d1<=15)
				gd+=25;
		}
		else if(obj.type.equals("icedrag")){
			if(d1<=15)
				gd+=25;
			int d2=(int)(Math.random()*100)+1;
			//int d2=4;
			if(d2<=5)
				gd+=(int)(Math.random()*obj.power);
		}
		else if(obj.type.equals("daemon")){
			if(d1<=50)
				gd+=d;
		}
		return gd;
	}
}

class Dragons extends Creature{
	public Dragons(int n2,int n3,int n4,int n5){
		super(n2, n3, n4,n5);
	}
}

class Humans extends Creature{
	public Humans(int n2,int n3,int n4,int n5){
		super(n2, n3, n4,n5);
	}
}
class Wolves extends Creature{
	public Wolves(int n2, int n3, int n4, int n5) {
		super( n2, n3, n4, n5);
	}
}
class Daemons extends Creature{
	public Daemons(int n2,int n3,int n4,int n5){
		super(n2, n3, n4,n5);
	}
}
class FireDragons extends Dragons{
	public FireDragons(int n2,int n3,int n4,int n5){
		super(n2, n3, n4,n5);
	}
}
class IceDragons extends Dragons{
	public IceDragons(int n2,int n3,int n4,int n5){
		super(n2, n3, n4,n5);
	}
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
			ArrayList<Creature> teamg=new ArrayList<Creature>();
			int tg,tb;
			ArrayList<Creature> teamb=new ArrayList<Creature>();
			int option;
			//ArrayList<Integer> cost=new ArrayList<Integer>();
			int mini=Integer.MAX_VALUE;
			int minf=Integer.MAX_VALUE;
			System.out.println("Enter Team Good’s total money");
			tg=Reader.nextInt();
			System.out.println("Enter Team Bad’s total money");
			tb=Reader.nextInt();
			System.out.println("Enter cost, asset , power and health for Human -");
			int c1=Reader.nextInt();
			int a1=Reader.nextInt();
			int p1=Reader.nextInt();
			int h1=Reader.nextInt();
			if(c1<mini)
				mini=c1;
			//Creature human=new Humans(c1,a1,p1,h1);
			
			System.out.println("Enter cost, asset , power and health for Fire Dragon -");
			int c2=Reader.nextInt();
			int a2=Reader.nextInt();
			int p2=Reader.nextInt();
			int h2=Reader.nextInt();
			if(c2<mini)
				mini=c2;
			//Creature firedrag=new FireDragons(c2,a2,p2,h2);
			
			System.out.println("Enter cost, asset , power and health for Ice Dragon -");
			int c3=Reader.nextInt();
			int a3=Reader.nextInt();
			int p3=Reader.nextInt();
			int h3=Reader.nextInt();
			if(c3<minf)
				minf=c3;
			//Creature icedrag=new IceDragons(c3,a3,p3,h3);
			
			System.out.println("Enter cost, asset , power and health for Daemon -");
			int c4=Reader.nextInt();
			int a4=Reader.nextInt();
			int p4=Reader.nextInt();
			int h4=Reader.nextInt();
			if(c4<minf)
				minf=c4;
			//Creature daemon=new Daemons(c4,a4,p4,h4);
			
			System.out.println("Enter cost, asset , power and health for Wolf -");
			int c5=Reader.nextInt();
			int a5=Reader.nextInt();
			int p5=Reader.nextInt();
			int h5=Reader.nextInt();
			if(c5<mini)
				mini=c5;
			//Creature wolf=new Wolves(c5,a5,p5,h5);
			
			int flag=0;
			while(flag == 0){
			if(tg<mini)
				break;
			System.out.println("Select Creatures For Team Good:\n1. Human\n2. Fire Dragon\n3. Wolf\n4. Exit Selection");
			option=Reader.nextInt();
			if(option == 1){
				System.out.println("Enter Name Of The Human");
				Creature human=new Humans(c1,a1,p1,h1);
				human.name=Reader.next();
				human.type="human";
				tg-=human.cost;
				teamg.add(human);
			}
			else if(option == 2){
				System.out.println("Enter Name Of The Fire-Dragon");
				Creature firedrag=new FireDragons(c2,a2,p2,h2);
				firedrag.name=Reader.next();
				firedrag.type="firedrag";
				tg-=firedrag.cost;
				teamg.add(firedrag);
			}
			else if(option == 3){
				System.out.println("Enter Name Of The Wolf");
				Creature wolf=new Wolves(c5,a5,p5,h5);
				wolf.name=Reader.next();
				wolf.type="wolf";
				tg-=wolf.cost;
				teamg.add(wolf);
			}
			else if(option == 4){
				break;
			}
			}
			while(flag == 0){
				if(tb<minf)
					break;
				System.out.println("Select Creatures For Team Bad:\n1. Daemon\n2. Ice Dragon\n3. Exit Selection");
				option=Reader.nextInt();
				if(option == 1){
					System.out.println("Enter Name Of The Daemon");
					Creature daemon=new Daemons(c4,a4,p4,h4);
					daemon.name=Reader.next();
					daemon.type="daemon";
					tb-=daemon.cost;
					teamb.add(daemon);
				}
				else if(option == 2){
					System.out.println("Enter Name Of The Ice-Dragon");
					Creature icedrag=new IceDragons(c3,a3,p3,h3);
					icedrag.name=Reader.next();
					icedrag.type="icedrag";
					tb-=icedrag.cost;
					teamb.add(icedrag);
				}
				else if(option == 3){
					break;
				}
				
			}
			int flag2=0;
			Creature obj1=teamg.get(0);
			Creature obj2=teamb.get(0);
			int count=1;
			System.out.println("The War Begins -");
			System.out.println("Round-"+count+":\nEnter Creature from Good’s Team to fight in the war -");
			String const1=Reader.next();
			System.out.println("Enter Creature from Bad’s Team to fight in the war -");
			String const2=Reader.next();
			int ind1=-1;
			int ind2=-1;
			for(int i=0;i<teamg.size();i++){
				if(teamg.get(i).name.equals(const1)){
					obj1=teamg.get(i);
					ind1=i;
				}
			}
			
			for(int j=0;j<teamb.size();j++){
				if(teamb.get(j).name.equals(const2)){
					obj2=teamb.get(j);
					ind2=j;
				}
			}
			while(flag2 == 0){
			
			obj1.health-=obj1.getdamage(obj2);
			obj2.health-=obj2.getdamage(obj1);
			//System.out.println(obj1.health);
			//System.out.println(obj2.health);
			if(obj1.health <=0 && obj2.health <=0 && teamg.size()!= 0 && teamb.size()!= 0){
				teamg.remove(ind1);
				teamb.remove(ind2);
			}
			else if(obj1.health <=0 && obj2.health>0){
				//System.out.println("Condition 1");
				teamg.remove(ind1);
				System.out.println(obj1.name+" Loses in Round "+count);
				System.out.println("Money Of Good's Team is "+tg);
				tb+=obj2.asset;
				System.out.println("Money Of Bad's Team is "+tb);
				while(tb >= minf){
					System.out.println("Select Creatures For Team Bad:\n1. Daemon\n2. Ice Dragon\n3. Exit Selection");
					option=Reader.nextInt();
					if(option == 1){
						System.out.println("Enter Name Of The Daemon");
						Creature daemon=new Daemons(c4,a4,p4,h4);
						daemon.name=Reader.next();
						tb-=daemon.cost;
						teamb.add(daemon);
					}
					else if(option == 2){
						System.out.println("Enter Name Of The Ice-Dragon");
						Creature icedrag=new IceDragons(c3,a3,p3,h3);
						icedrag.name=Reader.next();
						tb-=icedrag.cost;
						teamb.add(icedrag);
					}
					else if(option == 3){
						break;
					}
				}
				System.out.println("Enter Creature from Good’s Team to fight in the war -");
				const1=Reader.next();
				for(int i=0;i<teamg.size();i++){
					if(teamg.get(i).name.equals(const1)){
						obj1=teamg.get(i);
						ind1=i;
					}
				}
			}
			else if(obj2.health <= 0 && obj1.health>0){
				//System.out.println("Cond 2");
				teamb.remove(ind2);
				System.out.println(obj2.name+" Loses in Round "+count);
				System.out.println("Money Of Bad's Team is "+tb);
				tg+=obj1.asset;
				System.out.println("Money Of Good's Team is "+tg);
				while(tg >= mini){
					System.out.println("Select Creatures For Team Good:\n1. Human\n2. Fire Dragon\n3. Wolf\n4. Exit Selection");
					option=Reader.nextInt();
					if(option == 1){
						System.out.println("Enter Name Of The Human");
						Creature human=new Humans(c1,a1,p1,h1);
						human.name=Reader.next();
						tg-=human.cost;
						teamg.add(human);
					}
					else if(option == 2){
						System.out.println("Enter Name Of The Fire-Dragon");
						Creature firedrag=new FireDragons(c2,a2,p2,h2);
						firedrag.name=Reader.next();
						tg-=firedrag.cost;
						teamg.add(firedrag);
					}
					else if(option == 3){
						System.out.println("Enter Name Of The Wolf");
						Creature wolf=new Wolves(c5,a5,p5,h5);
						wolf.name=Reader.next();
						tg-=wolf.cost;
						teamg.add(wolf);
					}
					else if(option == 4){
						break;
					}
				}
				System.out.println("Enter Creature from Bad’s Team to fight in the war -");
				const2=Reader.next();
				for(int j=0;j<teamb.size();j++){
					if(teamb.get(j).name.equals(const2)){
						obj2=teamb.get(j);
						ind2=j;
					}
				}
			}
			if(teamg.size()==0 && tg<mini && teamb.size() != 0){
				System.out.print("Team Bad wins the war.");
				System.out.println("The money the team has is "+tb);
				break;
			}
			else if(teamb.size()==0 && tb<minf && teamg.size() != 0){
				System.out.println("Team Good wins the war");
				System.out.println("The money the team has is "+tg);
			}
			else if(teamb.size() == 0 && teamg.size() == 0)
				System.out.println("No winner");
			//System.out.println("Condition 3");
			count++;
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
