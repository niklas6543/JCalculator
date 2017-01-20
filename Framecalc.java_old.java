package Calculator;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.JTextComponent;

import org.omg.CORBA.PRIVATE_MEMBER;

import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.lang.reflect.Array;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.RenderingHints.Key;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSpinner;

public class Framecalc extends JFrame {

	private JPanel contentPane;
	private JTextField currentInput;
	private String formula = "";
	private Boolean sin = false;
	private Boolean cos = false;
	private Boolean paint = false;
	private int canvMin = -10;
	private int canvMax = 10 ;
	private JTextField txtVarX;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Framecalc frame = new Framecalc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Framecalc() {
		setTitle("JCalculator");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel comBlock = new JPanel();
		contentPane.add(comBlock, BorderLayout.WEST);
		GridBagLayout gbl_comBlock = new GridBagLayout();
		gbl_comBlock.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0};
		comBlock.setLayout(gbl_comBlock);
		
		final JButton btnOpPer = new JButton("%");
		GridBagConstraints gbc_btnOpPer = new GridBagConstraints();
		gbc_btnOpPer.insets = new Insets(0, 0, 5, 5);
		gbc_btnOpPer.gridx = 0;
		gbc_btnOpPer.gridy = 0;
		comBlock.add(btnOpPer, gbc_btnOpPer);
		btnOpPer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formula += buildF(btnOpPer, formula);
			}
		});
		
		final JButton btnOpDiv = new JButton("/");
		GridBagConstraints gbc_btnOpDiv = new GridBagConstraints();
		gbc_btnOpDiv.insets = new Insets(0, 0, 5, 5);
		gbc_btnOpDiv.gridx = 1;
		gbc_btnOpDiv.gridy = 0;
		comBlock.add(btnOpDiv, gbc_btnOpDiv);
		btnOpDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formula += buildF(btnOpDiv, formula);
			}
		});
		
		final JButton btnOpMul = new JButton("*");
		GridBagConstraints gbc_btnOpMul = new GridBagConstraints();
		gbc_btnOpMul.insets = new Insets(0, 0, 5, 5);
		gbc_btnOpMul.gridx = 2;
		gbc_btnOpMul.gridy = 0;
		comBlock.add(btnOpMul, gbc_btnOpMul);
		btnOpMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formula += buildF(btnOpMul, formula);
			}
		});
		
		final JButton btnOpSub = new JButton("-");
		GridBagConstraints gbc_btnOpSub = new GridBagConstraints();
		gbc_btnOpSub.insets = new Insets(0, 0, 5, 0);
		gbc_btnOpSub.gridx = 3;
		gbc_btnOpSub.gridy = 0;
		comBlock.add(btnOpSub, gbc_btnOpSub);
		btnOpSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formula += buildF(btnOpSub, formula);	
			}
		});
		
		final JButton btnNumber7 = new JButton("7");
		GridBagConstraints gbc_btnNumber7 = new GridBagConstraints();
		gbc_btnNumber7.insets = new Insets(0, 0, 5, 5);
		gbc_btnNumber7.gridx = 0;
		gbc_btnNumber7.gridy = 1;
		comBlock.add(btnNumber7, gbc_btnNumber7);
		btnNumber7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				formula += buildF(btnNumber7, formula);
			}
		});
		
		final JButton btnNumber8 = new JButton("8");
		GridBagConstraints gbc_btnNumber8 = new GridBagConstraints();
		gbc_btnNumber8.insets = new Insets(0, 0, 5, 5);
		gbc_btnNumber8.gridx = 1;
		gbc_btnNumber8.gridy = 1;
		comBlock.add(btnNumber8, gbc_btnNumber8);
		btnNumber8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				formula += buildF(btnNumber8, formula);
			}
		});
		
		final JButton btnNumber9 = new JButton("9");
		GridBagConstraints gbc_btnNumber9 = new GridBagConstraints();
		gbc_btnNumber9.insets = new Insets(0, 0, 5, 5);
		gbc_btnNumber9.gridx = 2;
		gbc_btnNumber9.gridy = 1;
		comBlock.add(btnNumber9, gbc_btnNumber9);
		btnNumber9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				formula += buildF(btnNumber9, formula);
			}
		});
		
		final JButton btnOpAdd = new JButton("+");
		GridBagConstraints gbc_btnOpAdd = new GridBagConstraints();
		gbc_btnOpAdd.insets = new Insets(0, 0, 5, 0);
		gbc_btnOpAdd.gridx = 3;
		gbc_btnOpAdd.gridy = 1;
		comBlock.add(btnOpAdd, gbc_btnOpAdd);
		btnOpAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				formula += buildF(btnOpAdd, formula);	
			}
		});
		
		final JButton btnNumber4 = new JButton("4");
		GridBagConstraints gbc_btnNumber4 = new GridBagConstraints();
		gbc_btnNumber4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNumber4.gridx = 0;
		gbc_btnNumber4.gridy = 2;
		comBlock.add(btnNumber4, gbc_btnNumber4);
		btnNumber4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				formula += buildF(btnNumber4, formula);
			}
		});
		
		final JButton btnNumber5 = new JButton("5");
		GridBagConstraints gbc_btnNumber5 = new GridBagConstraints();
		gbc_btnNumber5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNumber5.gridx = 1;
		gbc_btnNumber5.gridy = 2;
		comBlock.add(btnNumber5, gbc_btnNumber5);
		btnNumber5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				formula += buildF(btnNumber5, formula);
			}
		});
		
		final JButton btnNumber6 = new JButton("6");
		GridBagConstraints gbc_btnNumber6 = new GridBagConstraints();
		gbc_btnNumber6.insets = new Insets(0, 0, 5, 5);
		gbc_btnNumber6.gridx = 2;
		gbc_btnNumber6.gridy = 2;
		comBlock.add(btnNumber6, gbc_btnNumber6);
		btnNumber6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				formula += buildF(btnNumber6, formula);
			}
		});
		
		final JButton btnOpPow = new JButton("^");
		GridBagConstraints gbc_btnOpPow = new GridBagConstraints();
		gbc_btnOpPow.insets = new Insets(0, 0, 5, 0);
		gbc_btnOpPow.gridx = 3;
		gbc_btnOpPow.gridy = 2;
		comBlock.add(btnOpPow, gbc_btnOpPow);
		btnOpPow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formula += buildF(btnOpPow, formula);
			}
		});
		
		final JButton btnNumber1 = new JButton("1");
		GridBagConstraints gbc_btnNumber1 = new GridBagConstraints();
		gbc_btnNumber1.fill = GridBagConstraints.BOTH;
		gbc_btnNumber1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNumber1.gridx = 0;
		gbc_btnNumber1.gridy = 3;
		comBlock.add(btnNumber1, gbc_btnNumber1);
		btnNumber1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				formula += buildF(btnNumber1, formula);
			}
		});
		
		final JButton btnNumber2 = new JButton("2");
		GridBagConstraints gbc_btnNumber2 = new GridBagConstraints();
		gbc_btnNumber2.fill = GridBagConstraints.BOTH;
		gbc_btnNumber2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNumber2.gridx = 1;
		gbc_btnNumber2.gridy = 3;
		comBlock.add(btnNumber2, gbc_btnNumber2);
		btnNumber2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				formula += buildF(btnNumber2, formula);
			}
		});
		
		final JButton btnNumber3 = new JButton("3");
		GridBagConstraints gbc_btnNumber3 = new GridBagConstraints();
		gbc_btnNumber3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNumber3.gridx = 2;
		gbc_btnNumber3.gridy = 3;
		comBlock.add(btnNumber3, gbc_btnNumber3);
		btnNumber3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				formula += buildF(btnNumber3, formula);
			}
		});
		
		
		
		final JButton btnNumber0 = new JButton("0");
		GridBagConstraints gbc_btnNumber0 = new GridBagConstraints();
		gbc_btnNumber0.gridwidth = 2;
		gbc_btnNumber0.insets = new Insets(0, 0, 5, 5);
		gbc_btnNumber0.gridx = 0;
		gbc_btnNumber0.gridy = 4;
		comBlock.add(btnNumber0, gbc_btnNumber0);
		btnNumber0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formula += buildF(btnNumber0, formula);
			}
		});
		
		final JButton btnCom = new JButton(".");
		GridBagConstraints gbc_btnCom = new GridBagConstraints();
		gbc_btnCom.insets = new Insets(0, 0, 5, 5);
		gbc_btnCom.gridx = 2;
		gbc_btnCom.gridy = 4;
		comBlock.add(btnCom, gbc_btnCom);
		btnCom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formula += buildF(btnCom, formula);
			}
		});
		
		final MyCanvas canvas = new MyCanvas(this);
		contentPane.add(canvas);
		
		JPanel funcBlock = new JPanel();
		contentPane.add(funcBlock, BorderLayout.NORTH);
		GridBagLayout gbl_funcBlock = new GridBagLayout();
		gbl_funcBlock.columnWidths = new int[]{252, 252, 0};
		gbl_funcBlock.rowHeights = new int[] {4};
		gbl_funcBlock.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_funcBlock.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		funcBlock.setLayout(gbl_funcBlock);
		
		final JLabel lblOperation = new JLabel("");
		GridBagConstraints gbc_lblOperation = new GridBagConstraints();
		gbc_lblOperation.gridwidth = 3;
		gbc_lblOperation.insets = new Insets(0, 0, 5, 0);
		gbc_lblOperation.fill = GridBagConstraints.BOTH;
		gbc_lblOperation.gridx = 0;
		gbc_lblOperation.gridy = 0;
		funcBlock.add(lblOperation, gbc_lblOperation);
		
		currentInput = new JTextField();
		currentInput.setEditable(false);
		GridBagConstraints gbc_currentInput = new GridBagConstraints();
		gbc_currentInput.gridwidth = 26;
		gbc_currentInput.insets = new Insets(0, 0, 5, 0);
		gbc_currentInput.fill = GridBagConstraints.BOTH;
		gbc_currentInput.gridx = 0;
		gbc_currentInput.gridy = 2;
		funcBlock.add(currentInput, gbc_currentInput);
		currentInput.setColumns(10);
		
		JButton btnKill = new JButton("Kill");
		GridBagConstraints gbc_btnKill = new GridBagConstraints();
		gbc_btnKill.insets = new Insets(0, 0, 5, 5);
		gbc_btnKill.gridx = 0;
		gbc_btnKill.gridy = 3;
		funcBlock.add(btnKill, gbc_btnKill);
		btnKill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentInput.setText("");
				lblOperation.setText("");
				formula = "";
			}
		});
		
		JButton btnDel = new JButton("<-");
		GridBagConstraints gbc_btnDel = new GridBagConstraints();
		gbc_btnDel.insets = new Insets(0, 0, 5, 0);
		gbc_btnDel.gridx = 1;
		gbc_btnDel.gridy = 3;
		funcBlock.add(btnDel, gbc_btnDel);
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (formula.length() != 0){
					formula = formula.substring(0, formula.length()-1);
				}
				currentInput.setText(formula);
				lblOperation.setText("");
				paint = false;
			}
		});
		
		final JButton btnOpEqual = new JButton("=");
		GridBagConstraints gbc_btnOpEqual = new GridBagConstraints();
		gbc_btnOpEqual.gridheight = 2;
		gbc_btnOpEqual.insets = new Insets(0, 0, 5, 0);
		gbc_btnOpEqual.gridx = 3;
		gbc_btnOpEqual.gridy = 3;
		comBlock.add(btnOpEqual, gbc_btnOpEqual);
		btnOpEqual.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try{
					if (formula.contains("x")){
						paint = true;
						HashMap<String, Double> var = new HashMap<String, Double>();
						//nicht fertig !! hier könnte der Benutzer den Wert der Variable durch ein Textfeld festlegen
						var.put("x", (double) 1);
						lblOperation.setText(formula+" = "+Double.toString(calculate(var)));
					}else
					{
						paint = false;
						lblOperation.setText(formula+" = "+Double.toString(calculate(new HashMap<String, Double>())));
					}
				
					repaint();
					
				}catch(NumberFormatException e)	
				{
					lblOperation.setText("!!! error: wrong entry !!!");
				}catch(Exception e)
				{
					lblOperation.setText("!!! error: unknown failure !!!");
				}
			}
		});
		
		keysHandler(comBlock);
		
		final JButton btnVarX = new JButton("x");
		btnVarX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formula += buildF(btnVarX, formula);
				paint = true;
			}
		});
		GridBagConstraints gbc_btnVarX = new GridBagConstraints();
		gbc_btnVarX.insets = new Insets(0, 0, 5, 5);
		gbc_btnVarX.gridx = 0;
		gbc_btnVarX.gridy = 5;
		comBlock.add(btnVarX, gbc_btnVarX);
		
		txtVarX = new JTextField();
		txtVarX.setEnabled(false);
		GridBagConstraints gbc_txtVarX = new GridBagConstraints();
		gbc_txtVarX.gridwidth = 2;
		gbc_txtVarX.insets = new Insets(0, 0, 5, 5);
		gbc_txtVarX.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVarX.gridx = 1;
		gbc_txtVarX.gridy = 5;
		comBlock.add(txtVarX, gbc_txtVarX);
		txtVarX.setColumns(10);
		
		JButton btnOpSin = new JButton("sin");
		btnOpSin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sin = true;
				cos = false;
				canvas.repaint();
			}
		});
		GridBagConstraints gbc_btnOpSin = new GridBagConstraints();
		gbc_btnOpSin.insets = new Insets(0, 0, 5, 5);
		gbc_btnOpSin.gridx = 0;
		gbc_btnOpSin.gridy = 6;
		comBlock.add(btnOpSin, gbc_btnOpSin);
		
		SpinnerNumberModel model1 = new SpinnerNumberModel(-10, -100, -2, 1);
		
		JButton btnOpCos = new JButton("cos");
		btnOpCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cos = true;
				sin = false;
				canvas.repaint();
			}
		});
		GridBagConstraints gbc_btnOpCos = new GridBagConstraints();
		gbc_btnOpCos.insets = new Insets(0, 0, 5, 5);
		gbc_btnOpCos.gridx = 1;
		gbc_btnOpCos.gridy = 6;
		comBlock.add(btnOpCos, gbc_btnOpCos);
		
		SpinnerNumberModel model2 = new SpinnerNumberModel(10, 2, 100, 1);
		final JSpinner spinMinX = new JSpinner(model1);
		spinMinX.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
				canvMin = (int) spinMinX.getValue();
				
			}	
		});
		GridBagConstraints gbc_spinMinX = new GridBagConstraints();
		gbc_spinMinX.insets = new Insets(0, 0, 5, 5);
		gbc_spinMinX.gridx = 2;
		gbc_spinMinX.gridy = 6;
		comBlock.add(spinMinX, gbc_spinMinX);
		final JSpinner spinMaxX = new JSpinner(model2);
		spinMaxX.setEnabled(false);
		spinMaxX.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
				canvMax = (int) spinMaxX.getValue();
			}	
		});
		GridBagConstraints gbc_spinMaxX = new GridBagConstraints();
		gbc_spinMaxX.insets = new Insets(0, 0, 5, 0);
		gbc_spinMaxX.gridx = 3;
		gbc_spinMaxX.gridy = 6;
		comBlock.add(spinMaxX, gbc_spinMaxX);
		
		
		
		
	}
	

	public void keysHandler(final JPanel panel){
		KeyboardFocusManager.getCurrentKeyboardFocusManager()
		  .addKeyEventDispatcher(new KeyEventDispatcher() {
		      @Override
		      public boolean dispatchKeyEvent(KeyEvent e) {
		    	  //System.out.println(KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner());
		    	  if(e.getID() == KeyEvent.KEY_TYPED){
		    		  //alle Componenten des Panels werden durchlaufeb
		    		  for (int i = 1; i < panel.getComponentCount(); i++){
		    			  //ist das Panel Objekt ein Button
			    			if (panel.getComponent(i) instanceof JButton){
			    				//Component wird zum Button geparst
			    				JButton button = (JButton) panel.getComponent(i);
				    			//Button gleich Keyboard Eingabe ?
			    				if (button.getText().equals(""+e.getKeyChar())){
				    				button.doClick();
				    			}
			    			}  	
			    	  }
		    		  
		    	  }
		    	
		        return false;
		      }
		});
	}
	
	public String buildF(JButton button, String currentFormula){
		//sammel Eingabe und baue Formel als String zusammen
		currentFormula += button.getText();
		currentInput.setText("");
		currentInput.setText(currentFormula);
		return button.getText();
	}
	
	public ArrayList<String> parseF(){
		
		ArrayList<String> FasList = new ArrayList<String>();
		//aus dem Formel String wird eine Liste mit allen einzelnen elementen erstellt
		for (int i = 0; i < formula.length(); i++) {
			//char to string
			String s = ""+formula.charAt(i);
			//Komma wird richtig platziert
			if (FasList.size() > 1 && FasList.get(FasList.size()-1) == "."){
				s += "."+FasList.get(FasList.size()-1);
				FasList.remove(FasList.size()-1);
			}
			
			FasList.add(s);
			
			
		}
		System.out.println("Formel als Liste");
		System.out.println(FasList);
		return FasList;
	}
	
	public ArrayList<String> convertFtoUPN(){
		
		ArrayList<String> FasList = parseF();
	
		ArrayList<String> FasUPN = new ArrayList<String>();
		ArrayList<String> opStack = new ArrayList<String>();
		//Gewichtung der Operatoren (Punkt vor Strich)
		Map<String, Integer> opPrecendence = new HashMap<String, Integer>();
		opPrecendence.put("+", 1);
		opPrecendence.put("-", 1);
		opPrecendence.put("*", 2);
		opPrecendence.put("/", 2);
		opPrecendence.put("%", 3);
		opPrecendence.put("^", 3);
		
		//Liste wird in die umgekehrte Polnische Notation(UPN) umgewandelt
		//Beispiel 2+2 => 2 2 +
		
		String stack = "";
		
		for (int i = 0; i < FasList.size(); i++){
			String s = FasList.get(i);
			//Operator ?
			if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("%") || s.equals("^")){
				FasUPN.add(stack);
				//stack wird entleert | Operatoren werden nach Gewichtung sortiert
				while (opStack.size() > 0 && opPrecendence.get(opStack.get(opStack.size()-1)) >= opPrecendence.get(s)){
					FasUPN.add(opStack.get(opStack.size()-1));
					opStack.remove(opStack.size()-1);
				}
				opStack.add(s);
				stack = "";
			}else
			{
				//zahl sammeln/zusammenbauen
				stack += s;
			}
		}
		//letzte Zahl
		FasUPN.add(stack);
		
		//verbliebene Operatoren werden umgekehrt ans UPN angefügt
		Collections.reverse(opStack);
		FasUPN.addAll(opStack);
		
		System.out.println("Formel als UPN");
		System.out.println(FasUPN);
		return FasUPN;
	}
		
	
		
	public double calculate(HashMap<String, Double> var){
		ArrayList<String> FasUPN = convertFtoUPN();
		ArrayList<Double> numbers = new ArrayList<Double>();
		double result = 0;
		
		if (FasUPN.contains("x") && var.size() != 0){
			for (int i = 0; i < FasUPN.size(); i++){
				if (FasUPN.get(i).equals("x")){
					FasUPN.set(i, Double.toString(var.get("x")));
				}
			}
		}
		
		//UPN wird für die Berechnung aufgelöst
		for (int i = 0; i < FasUPN.size(); i++){
			String s = FasUPN.get(i);
			
			if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("%") || s.equals("^")){					
				//Operator und die letzten zwei zahlen vom numbers stack
				result = calcOP(s, numbers.get(numbers.size()-2), numbers.get(numbers.size()-1));
				//verwendete Zahlen werden gelöscht
				numbers.remove(numbers.size()-1);
				numbers.remove(numbers.size()-1);
				numbers.add(result);
			}else
			{
				//String to Double
				numbers.add(Double.parseDouble(s));
			}
			
		}
		
		if (FasUPN.size() == 1 && numbers.size() == 1){
			result = numbers.get(0);
		}
		System.out.println("Ergebnis");
		System.out.println(result);
		return result;
	}
	
	public double calcOP(String op, double x, double y){
		switch (op) {
		case "+":
			return x + y;

		case "-":
			return x - y;

		case "*":
			return x * y;

		case "/":
			return x / y;
			
		case "%":
			return x / 100 * y;
		
		case "^":
			return Math.pow(x, y);

		default:
			// default
		}
		
		
		
		return 0;
	}
	
	public TreeMap<Double, Double> pointsGraph(Double pixel){
		TreeMap<Double, Double> points = new TreeMap<Double, Double>();
		HashMap<String, Double> var = new HashMap<String, Double>();
		
		for (double i = canvMin; i < canvMax; i+=pixel){
			var.put("x", i);
			System.out.println(var);
			points.put(i, calculate(var));
		}
		
		return points;
	}
	
	public class MyCanvas extends Canvas {
		private Framecalc frame;
		

		public MyCanvas(Framecalc frame){
			super();
			this.frame = frame;
			
		}
		
		public void paint(Graphics g){
			g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
			g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
			
			double stepX = this.getWidth()/(canvMax-canvMin);
			double stepY = this.getHeight()/(canvMax-canvMin);
			g.setColor(Color.RED);
			double pixel =   (double)(canvMax-canvMin)/this.getWidth();
			
			if (sin){
				int sinus;
	
				for (double i = canvMin; i < canvMax; i+=pixel){
					sinus = -(int) (Math.sin(i)*stepY)+this.getHeight()/2;
					g.drawLine((int) (i*stepX)+this.getWidth()/2, sinus, (int) (i*stepX)+this.getWidth()/2, sinus);
				}
			}
			
			if (cos){
				int cosinus;
				
				for (double i = canvMin; i < canvMax; i+=pixel){
					cosinus = -(int) (Math.cos(i)*stepY)+this.getHeight()/2;
					g.drawLine((int) (i*stepX)+this.getWidth()/2, cosinus, (int) (i*stepX)+this.getWidth()/2, cosinus);
		
				}
			}
			
			if (paint && formula.contains("x")){
				
				TreeMap<Double, Double> points = pointsGraph(pixel);
				int x;
				Boolean firstTime = true;
				int x_old = 0;
				int y_old = 0;
				int y;
				//System.out.println(points);
				for (Double key : points.keySet()){
					y = (int)(double)(points.get(key)*stepX+this.getHeight()/2);
					x = (int)(double)(key*stepY+this.getWidth()/2);
					
					if (firstTime){
						firstTime = false;
					}else
					{
						g.drawLine(x_old, this.getHeight()-y_old, x, this.getHeight()-y);
					}
					x_old = x;
					y_old = y;
				}
				
				
			}
		}
	}
}
