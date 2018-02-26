package gridb;

  
import java.awt.GridBagConstraints;  
import java.awt.GridBagLayout; 
import java.awt.event.*;
import java.awt.Component;
  
import javax.swing.*;  
public class GridBagLayoutExample extends JFrame{  
	public static JButton b=new JButton("Submit");
	public static JTextField z1=new JTextField("10");
	public static JTextField z2=new JTextField("0");
	public static JTextField z3=new JTextField("6");
	public static JTextField z4=new JTextField("0");
	public static JTextField z5=new JTextField("8");
	public static JTextField z6=new JTextField("0");
	public static JTextField z7=new JTextField("4");
	public static JTextField z8=new JTextField("0");
	public static JTextField z9=new JTextField("2");
	public static JTextField z10=new JTextField("0");
	public static JTextField z19=new JTextField("30");
	public static JTextField z12=new JTextField("0");
	public static JTextField z11=new JTextField("0");
	
	
    public static void main(String[] args) {  
            GridBagLayoutExample a = new GridBagLayoutExample();  
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {  
                	String s1=z1.getText();
                	int w1=Integer.parseInt(s1);
                	String s2=z2.getText();
                	int w2=Integer.parseInt(s2);
                	String s3=z3.getText();
                	int w3=Integer.parseInt(s3);
                	String s4=z4.getText();
                	int w4=Integer.parseInt(s4);
                	String s5=z5.getText();
                	int w5=Integer.parseInt(s5);
                	String s6=z6.getText();
                	int w6=Integer.parseInt(s6);
                	String s7=z7.getText();
                	int w7=Integer.parseInt(s7);
                	String s8=z8.getText();
                	int w8=Integer.parseInt(s8);
                	String s9=z9.getText();
                	int w9=Integer.parseInt(s9);
                	String s10=z10.getText();
                	int w10=Integer.parseInt(s10);
                	String s11=z19.getText();
                	int w11=Integer.parseInt(s11);
                	String s12=z12.getText();
                	int w12=Integer.parseInt(s12);
                	int diff1;
                	diff1=w1-w2;
                	int sum2=0;
                	int sum3=0;
                	if(diff1 >= 0){
                		w1=diff1;
                		sum2+=w1;
                		sum3+=w2;
                		String ans1=String.valueOf(w1);
                		z1.setText(ans1);
                		if(diff1 == 0){
                			z2.setEnabled(false);
                			}
                	}
                	else{
                		sum2+=w1;
                	}
                	diff1=w3-w4;
                	if(diff1 >= 0){
                		w3=diff1;
                		sum2+=w3;
                		sum3+=w4;
                		String ans1=String.valueOf(w3);
                		z3.setText(ans1);
                		if(diff1 == 0){
                			z4.setEnabled(false);}
                	}
                	else{
                		sum2+=w3;
                	}
                	diff1=w5-w6;
                	if(diff1 >= 0){
                		w5=diff1;
                		sum2+=w5;
                		sum3+=w6;
                		String ans1=String.valueOf(w5);
                		z5.setText(ans1);
                		if(diff1 == 0){
                			z6.setEnabled(false);}
                	}
                	else{
                		sum2+=w5;
                	}
                	diff1=w7-w8;
                	if(diff1 >= 0){
                		w7=diff1;
                		sum2+=w7;
                		sum3+=w8;
                		String ans1=String.valueOf(w7);
                		z7.setText(ans1);
                		if(diff1 == 0){
                			z8.setEnabled(false);}
                	}
                	else{
                		sum2+=w7;
                	}
                	diff1=w9-w10;
                	if(diff1 >= 0){
                		w9=diff1;
                		sum2+=w9;
                		sum3+=w10;
                		String ans1=String.valueOf(w9);
                		z9.setText(ans1);
                		if(diff1 == 0){
                			z10.setEnabled(false);}
                	}
                	else{
                		sum2+=w9;
                	}
                	String sy=String.valueOf(sum2);
                	z19.setText(sy);
                	sy=String.valueOf(sum3);
                	z12.setText(sy);
                        }
             });
           
    }  
    public GridBagLayoutExample() {  
    GridBagLayout grid = new GridBagLayout();  
    GridBagConstraints gbc = new GridBagConstraints();  
    setLayout(grid);  
    setTitle("IIITD Fruit Stall");  
    GridBagLayout layout = new GridBagLayout();  
    this.setLayout(layout);  
    gbc.fill = GridBagConstraints.HORIZONTAL;  
    gbc.gridx = 0;  
    gbc.gridy = 0;  
    gbc.gridwidth=2;
    gbc.ipady=20;
    gbc.ipadx=20;
    z11=new JTextField("Inventory");
    z11.setHorizontalAlignment(z11.CENTER);
    z11.setEditable(false);
    this.add(z11, gbc);  
    gbc.gridx = 2;  
    gbc.gridy = 0;  
    gbc.ipady=20;
    gbc.ipadx=20;
    gbc.gridwidth=2;
    z11=new JTextField("User");
    z11.setHorizontalAlignment(z11.CENTER);
    z11.setEditable(false);
    this.add(z11, gbc);  
    gbc.fill = GridBagConstraints.HORIZONTAL;   
    gbc.gridx = 0;  
    gbc.gridy = 1; 
    gbc.gridwidth=1;
    z11=new JTextField("Items");
    z11.setHorizontalAlignment(z11.CENTER);
    z11.setEditable(false);
    this.add(z11, gbc); 
    gbc.gridx = 1;  
    gbc.gridy = 1;  
    gbc.gridwidth=1;
    z11=new JTextField("Quantity");
    z11.setHorizontalAlignment(z11.CENTER);
    z11.setEditable(false);
    this.add(z11, gbc);  
    gbc.gridx = 2;  
    gbc.gridy = 1;  
    z11=new JTextField("Items");
    z11.setEditable(false);
    z11.setHorizontalAlignment(z11.CENTER);
    this.add(z11, gbc);  
    gbc.gridx=3;
    gbc.gridy=1;
    z11=new JTextField("Quantity");
    z11.setHorizontalAlignment(z11.CENTER);
    z11.setEditable(false);
    this.add(z11,gbc );
    gbc.fill = GridBagConstraints.HORIZONTAL;   
    gbc.gridx = 0;  
    gbc.gridy = 2; 
    gbc.gridwidth=1;
    z11=new JTextField("Apple");
    z11.setHorizontalAlignment(z11.CENTER);
    z11.setEditable(false);
    this.add(z11, gbc); 
    gbc.gridx=1;
    gbc.gridy=2;
    z1.setEditable(false);
    z1.setHorizontalAlignment(z1.CENTER);
    this.add(z1,gbc);
    gbc.gridx=2;
    gbc.gridy=2;
    JTextField z1b=new JTextField("Apple");
    z1b.setEditable(false);
    z1b.setHorizontalAlignment(z1b.CENTER);
    this.add(z1b,gbc);
    gbc.gridx=3;
    gbc.gridy=2;
    z2.setHorizontalAlignment(z2.CENTER);
    this.add(z2,gbc);
    gbc.fill = GridBagConstraints.HORIZONTAL; 
    gbc.gridx=0;
    gbc.gridy=3;
    z11=new JTextField("Mango");
    z11.setHorizontalAlignment(z11.CENTER);
    z11.setEditable(false);
    this.add(z11,gbc);
    gbc.gridx=1;
    gbc.gridy=3;
    z3.setEditable(false);
    z3.setHorizontalAlignment(z3.CENTER);
    this.add(z3,gbc);
    gbc.gridx=2;
    gbc.gridy=3;
    JTextField z1c=new JTextField("Mango");
    z1c.setEditable(false);
    z1c.setHorizontalAlignment(z1c.CENTER);
    this.add(z1c,gbc);
    gbc.gridx=3;
    gbc.gridy=3;
    z4.setHorizontalAlignment(z4.CENTER);
    this.add(z4,gbc);
    z11=new JTextField("Orange");
    z11.setHorizontalAlignment(z11.CENTER);
    z11.setEditable(false);
    gbc.fill = GridBagConstraints.HORIZONTAL; 
    gbc.gridx=1;
    gbc.gridy=4;
    z5.setEditable(false);
    z5.setHorizontalAlignment(z5.CENTER);
    this.add(z5,gbc);
    gbc.gridx=2;
    gbc.gridy=4;
    JTextField z1d=new JTextField("Orange");
    z1d.setEditable(false);
    z1d.setHorizontalAlignment(z1d.CENTER);
    this.add(z1d,gbc);
    gbc.gridx=3;
    gbc.gridy=4;
    z6.setHorizontalAlignment(z6.CENTER);
    this.add(z6,gbc);
    gbc.gridx=0;
    gbc.gridy=4;
    this.add(z11,gbc);
    gbc.fill = GridBagConstraints.HORIZONTAL; 
    gbc.gridx=0;
    gbc.gridy=5;
    z11=new JTextField("Pineapple");
    z11.setHorizontalAlignment(z11.CENTER);
    z11.setEditable(false);
    this.add(z11,gbc);
    gbc.gridx=1;
    gbc.gridy=5;
    z7.setEditable(false);
    z7.setHorizontalAlignment(z7.CENTER);
    this.add(z7,gbc);
    gbc.gridx=2;
    gbc.gridy=5;
    JTextField z1e=new JTextField("Pineapple");
    z1e.setEditable(false);
    z1e.setHorizontalAlignment(z1e.CENTER);
    this.add(z1e,gbc);
    gbc.gridx=3;
    gbc.gridy=5;
    z8.setHorizontalAlignment(z8.CENTER);
    this.add(z8,gbc);
    gbc.fill = GridBagConstraints.HORIZONTAL; 
    gbc.gridx=0;
    gbc.gridy=6;
    z11=new JTextField("Banana");
    z11.setHorizontalAlignment(z11.CENTER);
    z11.setEditable(false);
    this.add(z11,gbc);
    gbc.gridx=1;
    gbc.gridy=6;
    z9.setHorizontalAlignment(z9.CENTER);
    z9.setEditable(false);
    this.add(z9,gbc);
    gbc.gridx=2;
    gbc.gridy=6;
    z10.setHorizontalAlignment(z1.CENTER);
    JTextField z1f=new JTextField("Banana");
    z1f.setEditable(false);
    z1f.setHorizontalAlignment(z1f.CENTER);
    this.add(z1f,gbc);
    gbc.gridx=3;
    gbc.gridy=6;
    this.add(z10,gbc);
    gbc.fill = GridBagConstraints.HORIZONTAL; 
    gbc.gridx=0;
    gbc.gridy=7;
    z11=new JTextField("Total");
    z11.setHorizontalAlignment(z11.CENTER);
    z11.setEditable(false);
    this.add(z11,gbc);
    gbc.gridx=1;
    gbc.gridy=7;
    z19.setHorizontalAlignment(z19.CENTER);
    z19.setEditable(false);
    this.add(z19,gbc);
    gbc.gridx=2;
    gbc.gridy=7;
    JTextField z1g=new JTextField("Total");
    z1g.setEditable(false);
    z1g.setHorizontalAlignment(z1g.CENTER);
    this.add(z1g,gbc);
    gbc.gridx=3;
    gbc.gridy=7;
    z12.setHorizontalAlignment(z12.CENTER);
    z12.setEditable(false);
    this.add(z12,gbc);
    gbc.fill = GridBagConstraints.HORIZONTAL; 
    gbc.gridx=3;
    gbc.gridy=8;
    
    this.add(b,gbc);
    setSize(500, 500);  
    setPreferredSize(getSize());  
    setVisible(true); 
    
    setDefaultCloseOperation(EXIT_ON_CLOSE);  
    
      
        }  
      
}  