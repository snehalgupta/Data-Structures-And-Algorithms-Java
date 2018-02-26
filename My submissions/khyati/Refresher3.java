package khyati;

//khyati seth
//2016050
//section A
import java.awt.*;        
import java.awt.event.*;  
import javax.swing.*;
import java.util.*;

public class Refresher3 {

	 /*private TextField tfbanana1;
 private TextField tfapple1;
 private TextField tfmango1;
 private TextField tforange1;
 private TextField tfpineapple1;
 private Label tfTotal;
 
         



*/
private JFrame frame;
	private int sum = 0;
	private JLabel lblapple;
	private JLabel lblmango;
	private JLabel lblorange;
	private JLabel lblpineapple;
	private JLabel lblbanana;
	private JLabel lbltotal;
	private JTextField tfapple;
	private JTextField tfmango;
	private JTextField tforange;
	private JTextField tfpineapple;
	private JTextField tfbanana;
	private JTextField tftotal;

	private JLabel iiit;
	private JLabel User;
	JButton but = new JButton("Submit");

	private JTextField tfappleoutput;
public Refresher3() {
initialize();
	 //setLayout(new FlowLayout());
   // setSize(1200,1200);
    //setVisible(true);
}

private void initialize() {
frame = new JFrame();
frame.getContentPane().setBackground(new Color(240, 240, 240));
frame.setBounds(100, 100, 450, 300);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);
frame.setBackground(new Color(240, 240, 240));


frame.setTitle("IIITD Fruit Stall");
		

but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int appleval = Integer.parseInt(tfapple.getText());
				int mangoval = Integer.parseInt(tfmango.getText());
				int orangeval = Integer.parseInt(tforange.getText());
				int pineappleval = Integer.parseInt(tfpineapple.getText());
				int bananaval = Integer.parseInt(tfbanana.getText());
				
				//sum = ((appleval ) + (mangoval ) +(orangeval ) + (pineappleval ) +( bananaval));
				//tftotal.setText(sum+"");
				int sum2=0;
				int sum3=0;
				int app = Integer.parseInt(lblapple.getText()) - appleval;
				int man = Integer.parseInt(lblmango.getText()) - mangoval;
				int ora = Integer.parseInt(lblorange.getText()) - orangeval;
				int pine = Integer.parseInt(lblpineapple.getText()) - pineappleval;
				int ban = Integer.parseInt(lblbanana.getText()) - bananaval;
				//int newtotal = Integer.parseInt(lbltotal.getText()) - Integer.parseInt(tftotal.getText());
				//int newtotal=0;
				int w1=Integer.parseInt(lblapple.getText());
				if(app >= 0){
            		w1=app;
            		sum2+=w1;
            		sum3+=appleval;
            		lblapple.setText(app+"");
            		if(app== 0){
            			tfapple.setEnabled(false);
            			}
            	}
            	else{
            		sum2+=w1;
            	}
				w1=Integer.parseInt(lblmango.getText());
				if(man>= 0){
            		w1=man;
            		sum2+=w1;
            		sum3+=mangoval;
            		lblmango.setText(man+"");
            		if(man== 0){
            			tfmango.setEnabled(false);
            			}
            	}
            	else{
            		sum2+=w1;
            	}
				w1=Integer.parseInt(lblorange.getText());
				if(ora>= 0){
            		w1=ora;
            		sum2+=w1;
            		sum3+=orangeval;
            		lblorange.setText(ora+"");
            		if(ora== 0){
            			tforange.setEnabled(false);
            			}
            	}
            	else{
            		sum2+=w1;
            	}
				w1=Integer.parseInt(lblpineapple.getText());
				if(pine>= 0){
            		w1=pine;
            		sum2+=w1;
            		sum3+=pineappleval;
            		lblpineapple.setText(pine+"");
            		if(ora== 0){
            			tfpineapple.setEnabled(false);
            			}
            	}
            	else{
            		sum2+=w1;
            	}
				w1=Integer.parseInt(lblbanana.getText());
				if(ban>= 0){
            		w1=ban;
            		sum2+=w1;
            		sum3+=bananaval;
            		lblbanana.setText(ban+"");
            		if(ban== 0){
            			tfbanana.setEnabled(false);
            			}
            	}
            	else{
            		sum2+=w1;
            	}
				
				
				lbltotal.setText(sum2+"");
				tftotal.setText(sum3+"");



				/* tfapple.setText(""); 
    tfmango.setText("");
    tforange.setText("");
    tfpineapple.setText("");
    tfbanana.setText("");*/    // this is for clearing the data in the text box for the next round
				}
		});
		

/*tfapple.addActionListener(this);
    tfmango.addActionListener(this);
    tforange.addActionListener(this);
    tfpineapple.addActionListener(this);
    tfbanana.addActionListener(this);*/



		but.setBounds(148, 238, 89, 23);
		frame.getContentPane().add(but);
		JLabel Apple = new JLabel("apple");
		Apple.setBounds(21, 92, 46, 14);
		frame.getContentPane().add(Apple);
		JLabel Mango = new JLabel("mango");
		Mango.setBounds(21, 117, 46, 14);
		frame.getContentPane().add(Mango);
		JLabel Orange = new JLabel("orange");
		Orange.setBounds(21, 142, 46, 14);
		frame.getContentPane().add(Orange);
		JLabel Pineapple = new JLabel("pineapple");
		Pineapple.setBounds(21, 167, 46, 14);
		frame.getContentPane().add(Pineapple);
		JLabel Banana = new JLabel("banana");
		Banana.setBounds(21, 192, 46, 14);
		frame.getContentPane().add(Banana);
		lblapple = new JLabel("10");
		lblapple.setBounds(93, 92, 46, 14);
		frame.getContentPane().add(lblapple);
		lblmango = new JLabel("6");
		lblmango.setBounds(93, 117, 46, 14);
		frame.getContentPane().add(lblmango);
		lblorange = new JLabel("8");
		lblorange.setBounds(93, 142, 46, 14);
		frame.getContentPane().add(lblorange);
		

/*  public void gridLayout2()
    {

    Panel panel  = new Panel();
    panel.setSize(60,600);
    GridLayout layout = new GridLayout(7,0);
    layout.setHgap(10);
    layout.setVgap(10);
    
    panel.setLayout(layout);
    
    apple = new Label("Apple");
   
    tfapple = new TextField(10);
     panel.add(apple);
     panel.add(tfapple);
    mango = new Label("Mango");
    
    tfmango = new TextField(10);
    panel.add(mango);
    panel.add(tfmango);
    orange = new Label("Orange");
    
    tforange = new TextField(10);
    panel.add(orange);
    panel.add(tforange);
    pineapple = new Label("Pineapple");
    
    tfpineapple = new TextField(10);
    panel.add(pineapple);
    panel.add(tfpineapple);
    banana = new Label("Banana");
    
    tfbanana = new TextField(10);
    panel.add(banana);
    panel.add(tfbanana); */







		lblpineapple = new JLabel("4");
		lblpineapple.setBackground(Color.WHITE);
		lblpineapple.setBounds(93, 167, 46, 14);
		frame.getContentPane().add(lblpineapple);
		lblbanana = new JLabel("2");
		lblbanana.setBounds(93, 192, 46, 14);
		frame.getContentPane().add(lblbanana);
		JLabel lblItems = new JLabel("Items");
		lblItems.setBounds(21, 58, 46, 14);
		frame.getContentPane().add(lblItems);
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(77, 58, 62, 14);
		frame.getContentPane().add(lblQuantity);
		JLabel lblInventory = new JLabel("Inventory");
		lblInventory.setBounds(44, 33, 75, 14);
		frame.getContentPane().add(lblInventory);
		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(278, 33, 46, 14);
		frame.getContentPane().add(lblUser);
		






		JLabel lblitemuser = new JLabel("Items");
		lblitemuser.setBounds(239, 58, 46, 14);
		frame.getContentPane().add(lblitemuser);
		JLabel lblquanuser = new JLabel("Quantity");
		lblquanuser.setBounds(288, 58, 62, 14);
		frame.getContentPane().add(lblquanuser);
		JLabel appleuser = new JLabel("apple");
		appleuser.setBounds(239, 92, 46, 14);
		frame.getContentPane().add(appleuser);
		JLabel mangouser = new JLabel("mango");
		mangouser.setBounds(239, 117, 46, 14);
		frame.getContentPane().add(mangouser);
		JLabel orangeuser = new JLabel("orange");
		orangeuser.setBounds(239, 142, 46, 14);
		frame.getContentPane().add(orangeuser);
		JLabel pineappleuser = new JLabel("pineapple");
		pineappleuser.setBounds(239, 167, 46, 14);
		frame.getContentPane().add(pineappleuser);
		JLabel bananauser = new JLabel("banana");
		bananauser.setBounds(239, 192, 46, 14);
		frame.getContentPane().add(bananauser);
		












		tfapple = new JTextField();
		tfapple.setBounds(287, 89, 86, 20);
		frame.getContentPane().add(tfapple);
		tfapple.setColumns(10);
		
		tfmango = new JTextField();
		tfmango.setBounds(288, 114, 86, 20);
		frame.getContentPane().add(tfmango);
		tfmango.setColumns(10);
		
		tforange = new JTextField();
		tforange.setBounds(287, 139, 86, 20);
		frame.getContentPane().add(tforange);
		tforange.setColumns(10);
		
		tfpineapple = new JTextField();
		tfpineapple.setBounds(287, 164, 86, 20);
		frame.getContentPane().add(tfpineapple);
		tfpineapple.setColumns(10);
		
		tfbanana = new JTextField();
		tfbanana.setBounds(287, 189, 86, 20);
		frame.getContentPane().add(tfbanana);
		tfbanana.setColumns(10);
		
		JLabel total = new JLabel("Total");
		total.setBounds(21, 217, 46, 14);
		frame.getContentPane().add(total);
		
		lbltotal = new JLabel("30");
		lbltotal.setBounds(93, 217, 46, 14);
		frame.getContentPane().add(lbltotal);
		
		JLabel totaluser = new JLabel("Total");
		totaluser.setBounds(239, 213, 46, 14);
		frame.getContentPane().add(totaluser);
		
		tftotal = new JTextField();
		tftotal.setBounds(287, 214, 86, 20);
		frame.getContentPane().add(tftotal);
		tftotal.setColumns(10);
	}







public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				Refresher3 frm = new Refresher3();
					frm.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
