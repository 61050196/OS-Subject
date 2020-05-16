import	javax.swing.*;
import	java.awt.*;
import	java.awt.event.*;

public class Calculator extends JFrame
{
	String a = ""; // String Number
	String b = ""; // + - * / %
	String c = ""; // .
	
	double an = 0; // Double Number
	long cn = 1; // .
	
	public static void main (String [] args)
	{
		new Calculator ();
	}
	
	public Calculator ()
	{
		
		JPanel jf = new JPanel ();
		
		setSize(300 , 370);
		setTitle("Calculator");
		
		JLabel jl = new JLabel ();
		jl.setPreferredSize(new Dimension (250 , 30));
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		
		Font f = new Font ("Microsoft Sans Serif" , Font.BOLD , 14);
		add (jl , BorderLayout.NORTH);
		
		jl.setFont(f);
		jl.setBackground(new Color (255 , 255 , 255));
		
		
		jf.setLayout(new GridLayout (5 ,7));
		
		
		ActionListener act = new ActionListener ()
				{
					@Override
					public void actionPerformed (ActionEvent e)
					{
						JButton but = (JButton) e.getSource();
						
						String n = jl.getText();
						String m = but.getText();
						
						if (m.equals(String.valueOf(Character.toChars(0x2190)) + " DEL"))
						{
						/*	if (! Character.isDigit(n.charAt(n.length() - 1)))
							{
								b = "";
							}
						*/	
							if (n.equals(""))
								return ;
							
							if (a.equals(""))
							{
								an = 0;
								return ;
							}
							
							if (c.equals("."))
							{
								cn /= 10;
								
								if (cn == 0 || cn == 1)
									cn = 1;
							}
							
							if (a.equals(""))
							{
								a = a.substring(0 , a.length() - 1);
							}
							
							n = n.substring(0 , n.length() - 1);
							
							jl.setText(n);
						}
						
						else if (m.equals("CE"))
						{
							an = 0;
							cn = 1;
							a = b = c = "";
							
							jl.setText("");
						}
						
						else if (m.equals("%"))
						{
							n += but.getText();
							
							if (b.equals(""))
							{
								an += Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "%";
							}
							
							else if (b.equals("%"))
							{
								an %= Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "%";
							}
							
							else if (b.equals("*"))
							{
								an *= Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "%";
							}
							
							else if (b.equals("/"))
							{
								if (Double.parseDouble(a) == 0.0)
								{
									jl.setText("ERROR PLS TRY AGAIN");
									a = b = c = "";
									an = 0;
									cn = 1;
									return ;
								}
								
								an /= Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "%";
							}
							
							else if (b.equals("+"))
							{
								an += Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "%";
							}
							
							else if (b.equals("-"))
							{
								an -= Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "%";
							}
							
							jl.setText(n);
						}
						
						else if (m.equals("/"))
						{
							n += but.getText();
							
							if (b.equals(""))
							{
								an += Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "/";
							}
							
							else if (b.equals("%"))
							{
								an %= Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "/";
							}
							
							else if (b.equals("*"))
							{
								an *= Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "/";
							}
							
							else if (b.equals("/"))
							{
								if (Double.parseDouble(a) == 0.0)
								{
									jl.setText("ERROR PLS TRY AGAIN");
									a = b = c = "";
									an = 0;
									cn = 1;
									return ;
								}
								
								an /= Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "/";
							}
							
							else if (b.equals("+"))
							{
								an += Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "/";
							}
							
							else if (b.equals("-"))
							{
								an -= Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "/";
							}
							
							jl.setText(n);
						}
						
						else if (m.equals("*"))
						{
							n += but.getText();
							
							if (b.equals(""))
							{
								an += Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "*";
							}
							
							else if (b.equals("%"))
							{
								an %= Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "*";
							}
							
							else if (b.equals("*"))
							{
								an *= Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "*";
							}
							
							else if (b.equals("/"))
							{
								if (Double.parseDouble(a) == 0.0)
								{
									jl.setText("ERROR PLS TRY AGAIN");
									a = b = c = "";
									an = 0;
									cn = 1;
									return ;
								}
								
								an /= Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "*";
							}
							
							else if (b.equals("+"))
							{
								an += Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "*";
							}
							
							else if (b.equals("-"))
							{
								an -= Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "*";
							}
							
							jl.setText(n);
						}
						
						else if (m.equals("+"))
						{
							n += but.getText();
							
							if (b.equals(""))
							{
								an += Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "+";
							}
							
							else if (b.equals("%"))
							{
								an %= Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "+";
							}
							
							else if (b.equals("*"))
							{
								an *= Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "+";
							}
							
							else if (b.equals("/"))
							{
								if (Double.parseDouble(a) == 0.0)
								{
									jl.setText("ERROR PLS TRY AGAIN");
									a = b = c = "";
									an = 0;
									cn = 1;
									return ;
								}
								
								an /= Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "+";
							}
							
							else if (b.equals("+"))
							{
								an += Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "+";
							}
							
							else if (b.equals("-"))
							{
								an -= Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "+";
							}
							
							jl.setText(n);
						}
						
						else if (m.equals("-"))
						{
							n += but.getText();
							
							if (b.equals(""))
							{
								an += Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "-";
							}
							
							else if (b.equals("%"))
							{
								an %= Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "-";
							}
							
							else if (b.equals("*"))
							{
								an *= Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "-";
							}
							
							else if (b.equals("/"))
							{
								if (Double.parseDouble(a) == 0.0)
								{
									jl.setText("ERROR PLS TRY AGAIN");
									a = b = c = "";
									an = 0;
									cn = 1;
									return ;
								}
								
								an /= Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "-";
							}
							
							else if (b.equals("+"))
							{
								an += Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "-";
							}
							
							else if (b.equals("-"))
							{
								an -= Double.parseDouble(a) / cn;
								a = c = "";
								cn = 1;
								b = "-";
							}
							
							jl.setText(n);
						}
						
						else if (m.equals("."))
						{
							n += but.getText();
							c = ".";
							jl.setText(n);
							
						}
						
						else if (m.equals("00"))
						{
							n += but.getText();
							a += "00";
							if (c.equals("."))
								cn *= 10;
							
							jl.setText(n);
						}
						
						else if (m.equals("0"))
						{
							
							n += but.getText();
							a += "0";
							if (c.equals("."))
								cn *= 10;
							
							jl.setText(n);
							
						}
						
						else if (m.equals("1"))
						{
							
							n += but.getText();
							a += "1";
							if (c.equals("."))
								cn *= 10;
							
							jl.setText(n);
							
						}
						
						else if (m.equals("2"))
						{
							
							n += but.getText();
							a += "2";
							if (c.equals("."))
								cn *= 10;
							
							jl.setText(n);
							
						}
						
						else if (m.equals("3"))
						{
							
							n += but.getText();
							a += "3";
							if (c.equals("."))
								cn *= 10;
							
							jl.setText(n);
							
						}
						
						else if (m.equals("4"))
						{
							
							n += but.getText();
							a += "4";
							if (c.equals("."))
								cn *= 10;
							
							jl.setText(n);
							
						}
						
						else if (m.equals("5"))
						{
							
							n += but.getText();
							a += "5";
							if (c.equals("."))
								cn *= 10;
							
							jl.setText(n);
							
						}
						
						else if (m.equals("6"))
						{
							
							n += but.getText();
							a += "6";
							if (c.equals("."))
								cn *= 10;
							
							jl.setText(n);
							
						}
						
						else if (m.equals("7"))
						{
							
							n += but.getText();
							a += "7";
							if (c.equals("."))
								cn *= 10;
							
							jl.setText(n);
							
						}
						
						else if (m.equals("8"))
						{
							
							n += but.getText();
							a += "8";
							if (c.equals("."))
								cn *= 10;
							
							jl.setText(n);
							
						}
						
						else if (m.equals("9"))
						{
							
							n += but.getText();
							a += "9";
							if (c.equals("."))
								cn *= 10;
							
							jl.setText(n);
							
						}
						
						else if (m.equals("="))
						{
						//	n += but.getText();
							
							if (b.equals(""))
							{
								an = Double.parseDouble(a) / cn;
								a = b = c = "";
								cn = 1;
							}
							
							else if (b.equals("%"))
							{
								an %= Double.parseDouble(a) / cn;
								a = b = c = "";
								cn = 1;
							}
							
							else if (b.equals("*"))
							{
								an *= Double.parseDouble(a) / cn;
								a = b = c = "";
								cn = 1;
							}
							
							else if (b.equals("/"))
							{
								if (Double.parseDouble(a) == 0.0)
								{
									jl.setText("ERROR PLS TRY AGAIN");
									a = b = c = "";
									an = 0;
									cn = 1;
									return ;
								}
								
								an /= Double.parseDouble(a) / cn;
								a = b = c = "";
								cn = 1;
							}
							
							else if (b.equals("+"))
							{
								an += Double.parseDouble(a) / cn;
								a = b = c = "";
								cn = 1;
							}
							
							else if (b.equals("-"))
							{
								an -= Double.parseDouble(a) / cn;
								a = b = c = "";
								cn = 1;
							}
							
							if (an == (int) an)
							{
								a = (int) an + "";
								an = 0;
								jl.setText(a);
							}
							else
							{
								a = an + "";
								an = 0;
								jl.setText(a);
							}
						}
					}
				};
				
		String backspace = String.valueOf(Character.toChars(0x2190)) + " DEL";
		String b [] = {backspace , "CE" , "%" , "/"
					 , "7" , "8" , "9" , "*"
					 , "4" , "5" , "6" , "-"
					 , "1" , "2" , "3" , "+"
					 , "00" , "0" , "." , "="};
		
		JButton jb;
		
		for (int i = 1 ; i <= b.length ; i++)
		{
			jb = new JButton (b [i - 1]);
			jb.addActionListener(act);
			jf.add (jb);
		}
		
		add (jf , BorderLayout.CENTER);
		setLocationRelativeTo (null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
