package lab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


abstract class Animal implements Comparable<Animal>{
	double x;
	double y;
	double ts;
	double health;
	String name;
	int out;
	
	
	public Animal(double x1,double y1,double ts1,double health1,String n1){
		x=x1;
		y=y1;
		ts=ts1;
		health=health1;
		name=n1;
		out=0;
	}
	
	public abstract void taketurn(Grassland g1,Grassland g2,boolean flag);
	
	@Override
	public int compareTo(Animal other){
		int ans=0;
		if(ts < other.ts)
			ans=-1;
		else if(ts == other.ts){
			if(health > other.health)
				ans=-1;
			else if(health == other.health){
				if(this.getClass().getSimpleName().equals("Herbivore") && other.getClass().getSimpleName().equals("Carnivore"))
					ans=-1;
				else if(this.getClass() == other.getClass()){
					double ans1=Math.pow(x,2)+Math.pow(y,2);
					double ans2=Math.pow(other.x,2)+Math.pow(other.y,2);
					if(ans1 < ans2)
						ans=-1;
					else if(ans1 == ans2)
						ans=0;
					else
						ans=1;
				}
				else{
					ans=1;
				}
			}
			else{
				ans=1;
			}
		}
		else{
			ans=1;
		}
		return ans;
	}
}



class Herbivore extends Animal{
	Carnivore nearest;
	double gh1;
	public Herbivore(double x1,double y1,double ts1,double health1,double gc1,String n1){
		super(x1,y1,ts1,health1,n1);
		gh1=gc1;
	}
	public void taketurn(Grassland g1,Grassland g2,boolean flag){
		if(flag == false){
			double chance=Math.random()*100+1;
			if(chance <= 50){
				if(g1.isinside(this)){
					health-=25;
					double xx=Math.pow(x-g2.x,2);
					double yy=Math.pow(y-g2.y,2);
					double dist=Math.sqrt(xx+yy);
					dist=dist-5;
					double ux=(5*g2.x+dist*x)/(5+dist);
					ux=Math.round(ux);
					x=ux;
					double uy=(5*g2.y+dist*y)/(5+dist);
					uy=Math.round(uy);
					y=uy;
				}
				else if(g2.isinside(this)){
					health-=25;
					double xx=Math.pow(x-g1.x,2);
					double yy=Math.pow(y-g1.y,2);
					double dist=Math.sqrt(xx+yy);
					dist=dist-5;
					double ux=(5*g1.x+dist*x)/(5+dist);
					ux=Math.round(ux);
					x=ux;
					double uy=(5*g1.y+dist*y)/(5+dist);
					uy=Math.round(uy);
					y=uy;
				}
				else{
					double xx1=Math.pow(x-g1.x,2);
					double yy1=Math.pow(y-g1.y,2);
					double dist1=Math.sqrt(xx1+yy1);
					double xx2=Math.pow(x-g2.x,2);
					double yy2=Math.pow(y-g2.y,2);
					double dist2=Math.sqrt(xx2+yy2);
					if(dist1<dist2){
						dist1=dist1-5;
						double ux=(5*g1.x+dist1*x)/(5+dist1);
						ux=Math.round(ux);
						x=ux;
						double uy=(5*g1.y+dist1*y)/(5+dist1);
						uy=Math.round(uy);
						y=uy;
					}
					else{
						dist2=dist2-5;
						double ux=(5*g2.x+dist2*x)/(5+dist2);
						ux=Math.round(ux);
						x=ux;
						double uy=(5*g2.y+dist2*y)/(5+dist2);
						uy=Math.round(uy);
						y=uy;
					}
				}
			}
		}
		else if(!g1.isinside(this) && !g2.isinside(this)){
			double chance=(Math.random()*100)+1;
			if(chance>5){
				double chance1=(Math.random()*100)+1;
				double xx1=Math.pow(x-g1.x,2);
				double yy1=Math.pow(y-g1.y,2);
				double dist1=Math.sqrt(xx1+yy1);
				double xx2=Math.pow(x-g2.x,2);
				double yy2=Math.pow(y-g2.y,2);
				double dist2=Math.sqrt(xx2+yy2);
				if(chance1 <= 65){
					if(dist1<dist2){
						dist1=dist1-5;
						double ux=(5*g1.x+dist1*x)/(5+dist1);
						ux=Math.round(ux);
						x=ux;
						double uy=(5*g1.y+dist1*y)/(5+dist1);
						uy=Math.round(uy);
						y=uy;
					}
					else{
						dist2=dist2-5;
						double ux=(5*g2.x+dist2*x)/(5+dist2);
						ux=Math.round(ux);
						x=ux;
						double uy=(5*g2.y+dist2*y)/(5+dist2);
						uy=Math.round(uy);
						y=uy;
					}
				}
				else{	if(nearest != null){
						double xx3=Math.pow(x-nearest.x,2);
						double yy3=Math.pow(y-nearest.y,2);
						double dist3=Math.sqrt(xx3+yy3);
						double xx=((4+dist3)*x-4*nearest.x)/(dist3);
						double yy=((4+dist3)*y-4*nearest.y)/(dist3);
						xx=Math.round(xx);
						yy=Math.round(yy);
						x=xx;
						y=yy;}
					
				}
			}
		}
		else if(g1.isinside(this)){
			if(g1.g >= this.gh1){
				double chance=Math.random()*100+1;
				if(chance <= 90){
					g1.g=g1.g-this.gh1;
					health+=0.5*health;
				}
				else{
					health-=25;
					double chance1=Math.random()*100+1;
					double xx1=Math.pow(x-g1.x,2);
					double yy1=Math.pow(y-g1.y,2);
					double dist2=Math.sqrt(xx1+yy1);
					if(chance1<=50){
						if(nearest !=null){
						double xx3=Math.pow(x-nearest.x,2);
						double yy3=Math.pow(y-nearest.y,2);
						double dist3=Math.sqrt(xx3+yy3);
						double xx=((2+dist3)*x-2*nearest.x)/(dist3);
						double yy=((2+dist3)*y-2*nearest.y)/(dist3);
						xx=Math.round(xx);
						yy=Math.round(yy);
						x=xx;
						y=yy;}
					}
					else{
						dist2=dist2-3;
						double ux=(3*g1.x+dist2*x)/(3+dist2);
						ux=Math.round(ux);
						x=ux;
						double uy=(3*g1.y+dist2*y)/(3+dist2);
						uy=Math.round(uy);
						y=uy;
					}
				}
			}
			else{
				//System.out.println("yes");
				double xx1=Math.pow(x-g1.x,2);
				double yy1=Math.pow(y-g1.y,2);
				double dist2=Math.sqrt(xx1+yy1);
				double chance2=Math.random()*100+1;
				if(chance2<=20){
					if(g1.g != 0){
					g1.g=0;
					health+=0.2*health;}
				}
				else{
					double chance3=Math.random()*100+1;
					health-=25;
					if(chance3<=70){
						if(nearest != null){
						double xx3=Math.pow(x-nearest.x,2);
						double yy3=Math.pow(y-nearest.y,2);
						double dist3=Math.sqrt(xx3+yy3);
						double xx=((4+dist3)*x-4*nearest.x)/(dist3);
						double yy=((4+dist3)*y-4*nearest.y)/(dist3);
						xx=Math.round(xx);
						yy=Math.round(yy);
						x=xx;
						y=yy;}
					}
					else{
						dist2=dist2-2;
						double ux=(2*g1.x+dist2*x)/(2+dist2);
						ux=Math.round(ux);
						x=ux;
						double uy=(2*g1.y+dist2*y)/(2+dist2);
						uy=Math.round(uy);
						y=uy;
					}
				}
			}
		}
		else if(g2.isinside(this)){
			if(g2.g >= this.gh1){
				double chance=Math.random()*100+1;
				if(chance <= 90){
					g2.g=g2.g-this.gh1;
				}
				else{
					health-=25;
					double chance1=Math.random()*100+1;
					double xx1=Math.pow(x-g2.x,2);
					double yy1=Math.pow(y-g2.y,2);
					double dist2=Math.sqrt(xx1+yy1);
					if(chance1<=50){
						if(nearest != null){
						double xx3=Math.pow(x-nearest.x,2);
						double yy3=Math.pow(y-nearest.y,2);
						double dist3=Math.sqrt(xx3+yy3);
						double xx=((2+dist3)*x-2*g2.x)/(dist3);
						double yy=((2+dist3)*y-2*g2.y)/(dist3);
						xx=Math.round(xx);
						yy=Math.round(yy);
						x=xx;
						y=yy;}
					}
					else{
						dist2=dist2-3;
						double ux=(3*g2.x+dist2*x)/(3+dist2);
						ux=Math.round(ux);
						x=ux;
						double uy=(3*g2.y+dist2*y)/(3+dist2);
						uy=Math.round(uy);
						y=uy;
					}
				}
			}
			else{
				double xx1=Math.pow(x-g2.x,2);
				double yy1=Math.pow(y-g2.y,2);
				double dist2=Math.sqrt(xx1+yy1);
				double chance2=Math.random()*100+1;
				if(chance2<=20){
					g2.g=0;
				}
				else{
					health-=25;
					double chance3=Math.random()*100+1;
					if(chance3<=70){
						if(nearest != null){
						double xx3=Math.pow(x-nearest.x,2);
						double yy3=Math.pow(y-nearest.y,2);
						double dist3=Math.sqrt(xx3+yy3);
						double xx=((4+dist3)*x-4*nearest.x)/(dist3);
						double yy=((4+dist3)*y-4*nearest.y)/(dist3);
						xx=Math.round(xx);
						yy=Math.round(yy);
						x=xx;
						y=yy;}
					}
					else{
						dist2=dist2-2;
						double ux=(2*g2.x+dist2*x)/(2+dist2);
						ux=Math.round(ux);
						x=ux;
						double uy=(2*g2.y+dist2*y)/(2+dist2);
						uy=Math.round(uy);
						y=uy;
					}
				}
			}
		}
	}
}

class Carnivore extends Animal{
	Herbivore nearest;
	public Carnivore(double x1,double y1,double ts1,double health1,String n1){
		super(x1,y1,ts1,health1,n1);
	}
	public void taketurn(Grassland g1,Grassland g2,boolean flag){
		if(flag == false){
			double dist2=Double.MAX_VALUE;
			if(nearest != null){
			double xx2=Math.pow(x-nearest.x,2);
			double yy2=Math.pow(y-nearest.y,2);
			dist2=Math.sqrt(xx2+yy2);}
			if(!g1.isinside(this) && !g2.isinside(this)){
				double chance=Math.random()*100+1;
				if(chance <= 92){
					if(nearest != null){
					dist2=dist2-4;
					double ux=(4*nearest.x+dist2*x)/(4+dist2);
					ux=Math.round(ux);
					x=ux;
					double uy=(4*nearest.y+dist2*y)/(4+dist2);
					uy=Math.round(uy);
					y=uy;}
				}
				else{
					health-=60;
				}
			}
			else{
				double chance1=Math.random()*100+1;
				if(chance1>25){
					if(nearest != null){
					dist2=dist2-2;
					double ux=(2*nearest.x+dist2*x)/(2+dist2);
					ux=Math.round(ux);
					x=ux;
					double uy=(2*nearest.y+dist2*y)/(2+dist2);
					uy=Math.round(uy);
					y=uy;}
				}
				else{
					health-=30;
				}
			}
		}
	}
}

class Grassland{
	double x;
	double y;
	double r;
	double g;
	public Grassland(double x1,double y1,double r1,double g1){
		x=x1;
		y=y1;
		r=r1;
		g=g1;
	}
	public boolean isinside(Animal obj){
		boolean ans=true;
		double xx=Math.pow(obj.x-x,2);
		double yy=Math.pow(obj.y-y,2);
		double dist=Math.sqrt(xx+yy);
		if(dist <= r)
			ans=true;
		else
			ans=false;
		return ans;
	}
}

public class World {
	PriorityQueue<Animal> queue;
	int time;
	public World(int t){
		queue=new PriorityQueue<Animal>();
		time=t;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{int counth=2;
			int countc=2;
			System.out.println("Enter Total Final Time for Simulation:");
			int ti=Reader.nextInt();
			World w=new World(ti);
			System.out.println("Enter x, y centre, radius and Grass Available for First Grassland:");
			double x1=Reader.nextDouble();
			double y1=Reader.nextDouble();
			double r1=Reader.nextDouble();
			double g1=Reader.nextDouble();
			Grassland gl1=new Grassland(x1,y1,r1,g1);
			System.out.println("Enter x, y centre, radius and Grass Available for Second Grassland:");
			double x2=Reader.nextDouble();
			double y2=Reader.nextDouble();
			double r2=Reader.nextDouble();
			double g2=Reader.nextDouble();
			Grassland gl2=new Grassland(x2,y2,r2,g2);
			System.out.println("Enter Health and Grass Capacity for Herbivores:");
			double hh=Reader.nextDouble();
			double gh=Reader.nextDouble();
			System.out.println("Enter x, y position and timestamp for First Herbivore:");
			double xh1=Reader.nextDouble();
			double yh1=Reader.nextDouble();
			double th1=Reader.nextDouble();
			Animal h1=new Herbivore(xh1,yh1,th1,hh,gh,"First Herbivore");
			w.queue.add(h1);
			System.out.println("Enter x, y position and timestamp for Second Herbivore:");
			double xh2=Reader.nextDouble();
			double yh2=Reader.nextDouble();
			double th2=Reader.nextDouble();
			Animal h2=new Herbivore(xh2,yh2,th2,hh,gh,"Second Herbivore");
			w.queue.add(h2);
			System.out.println("Enter Health for Carnivores:");
			double hc=Reader.nextDouble();
			System.out.println("Enter x, y position and timestamp for First Carnivore:");
			double xc1=Reader.nextDouble();
			double yc1=Reader.nextDouble();
			double tc1=Reader.nextDouble();
			Animal c1=new Carnivore(xc1,yc1,tc1,hc,"First Carnivore");
			w.queue.add(c1);
			System.out.println("Enter x, y position and timestamp for Second Carnivore:");
			double xc2=Reader.nextDouble();
			double yc2=Reader.nextDouble();
			double tc2=Reader.nextDouble();
			Animal c2=new Carnivore(xc2,yc2,tc2,hc,"Second Carnivore");
			w.queue.add(c2);
			System.out.println("The Simulation Begins -");
			int yu=w.time;
			boolean flag=false;
			double maxt=0;
			while(yu>0 && !w.queue.isEmpty()){
				Animal max=w.queue.poll();
				System.out.println("It is "+max.name);
				if(max.ts> maxt)
					maxt=max.ts;
				if(max.getClass().getSimpleName().equals("Herbivore")){
					double dist3=Double.MAX_VALUE;
					double dist4=Double.MAX_VALUE;
					if(w.queue.contains(c1)){
						double xx1=Math.pow(c1.x-max.x,2);
						double yy1=Math.pow(c1.y-max.y,2);
						dist3=Math.sqrt(xx1+yy1);
					}
					if(w.queue.contains(c2)){
						double xx1=Math.pow(c2.x-max.x,2);
						double yy1=Math.pow(c2.y-max.y,2);
						dist4=Math.sqrt(xx1+yy1);
					}
					Herbivore cv=(Herbivore)max;
					if(dist3 < dist4){
						cv.nearest=(Carnivore)c1;
					}
					else if(w.queue.contains(c1) |w.queue.contains(c2) ){
						cv.nearest=(Carnivore)c2;
					}
					else{
						cv.nearest=null;
					}
					if(!gl1.isinside(max) && !gl2.isinside(max)){
						max.out+=1;
						if(max.out > 7){
							max.health-=5;
							}
					}
					else{
						max.out=0;
					}
					if(countc > 0)
						flag=true;
					max.taketurn(gl1,gl2,flag);
					
					if(max.health>0){
						System.out.println("It’s health after taking turn is "+max.health);
						double ran=maxt+Math.random()*(w.time-maxt+1);
						if(ran != w.time-1){
							max.ts=ran;
							w.queue.add(max);}
					}
					else{
						System.out.println("It is dead");
						counth-=1;
					}
				}
				else if(max.getClass().getSimpleName().equals("Carnivore")){
					if(counth<0){
						if(!gl1.isinside(max) && !gl2.isinside(max)){
							max.health-=60;
						}
						else{
							max.health-=30;
							if(max.health>0){
								System.out.println("It’s health after taking turn is "+max.health);
								double ran=maxt+Math.random()*(w.time-maxt+1);
								if(ran != w.time-1){
									max.ts=ran;
									w.queue.add(max);}
							}
							else{
								System.out.println("It is dead");
								countc-=1;
							}
						}
						
						}
					else{double dist1=Double.MAX_VALUE;
						double dist2=Double.MAX_VALUE;
						if(w.queue.contains(h1)){
							double xx1=Math.pow(h1.x-max.x,2);
							double yy1=Math.pow(h1.y-max.y,2);
							dist1=Math.sqrt(xx1+yy1);
						}
						if(w.queue.contains(h2)){
							double xx1=Math.pow(h2.x-max.x,2);
							double yy1=Math.pow(h2.y-max.y,2);
							dist2=Math.sqrt(xx1+yy1);
						}
						if(dist1>5 && dist2>5){
							max.out+=1;
							if(max.out>7){
								max.health-=6;
							}
						}
						else{
							max.out=0;
						}
						if(dist1<=1 && dist2<=1 ){
							flag=true;
							if(dist1<dist2){
								max.health+=(2*h1.health)/3;
								w.queue.remove(h1);}
							else{
								max.health+=(2*h2.health)/3;
								w.queue.remove(h2);}
						}
						else if(dist1 <= 1){
							flag=true;
							max.health+=(2*h1.health)/3;
							w.queue.remove(h1);
						}
						else if(dist2 <= 1){
							flag=true;
							max.health+=(2*h2.health)/3;
							w.queue.remove(h2);
						}
						Carnivore cv=(Carnivore)max;
						if(dist1 < dist2){
							cv.nearest=(Herbivore)h1;
						}
						else if(w.queue.contains(h1) | w.queue.contains(h2)){
							cv.nearest=(Herbivore)h2;
						}
						else{
							cv.nearest=null;
						}
						max.taketurn(gl1,gl2,flag);	
						
						if(max.health>0){
							System.out.println("It’s health after taking turn is "+max.health);
							double ran=maxt+Math.random()*(w.time-maxt+1);
							if(ran != w.time-1){
								max.ts=ran;
								w.queue.add(max);}
						}
						else{
							System.out.println("It is dead");
							countc-=1;
						}
					}
				}
				yu-=1;
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
