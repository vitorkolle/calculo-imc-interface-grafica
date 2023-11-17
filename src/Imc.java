import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Imc extends JFrame implements ActionListener{
	
	JButton btnCalc = new JButton("Calcular IMC");
	JButton btnSair = new JButton("Sair");
	
	JLabel lblPeso = new JLabel("Peso(em kg)");
	JLabel lblAltura = new JLabel("Altura(em m)");
	
	JTextField txtPeso = new JTextField();
	JTextField txtAltura = new JTextField();
	
	
	
	public Imc() {
		btnCalc.addActionListener(this);
		btnSair.addActionListener(this);
		
		//Campo de texto
		txtPeso.setBounds(250, 50, 100, 30);
		txtAltura.setBounds(250, 100, 100, 30);
		add(txtPeso);
		add(txtAltura);	
		
		//Label
		lblPeso.setBounds(160, 55 , 100, 20);
		lblAltura.setBounds(160, 105, 110, 20);
		add(lblPeso);
		add(lblAltura);
		
		//Botões
		setLayout(null);
	    btnCalc.setBounds(110, 200, 120, 30);
		btnSair.setBounds(380, 200, 100, 30);
		add(btnCalc);
		add(btnSair);	
		
		//Frame
		setTitle("Calcular IMC");
		setSize(600, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource() == btnCalc) {
			if(!txtPeso.getText().equals("") && !txtAltura.getText().equals("")){
				String situacao = "";
				String pesotxt = txtPeso.getText();
				String alturatxt = txtAltura.getText();
				int peso = Integer.parseInt(pesotxt);
				double altura = Double.parseDouble(alturatxt);
				double imc = peso / (altura * altura);
				
				if(imc < 18.5) {
					situacao = "Abaixo do Peso";				
				}
				if(imc >= 18.6 && imc <= 24.9) {
					situacao = "Peso Ideal";	
				}
				if(imc >= 25 && imc <= 29.9) {
					situacao = "Levemente Acima do Peso";	
				}
				if(imc >= 30 && imc <= 34.9) {
					situacao = "Obesidade Grau I";	
				}
				if(imc >= 35 && imc <= 39.9) {
					situacao = "Obesidade Grau II";	
				}
				if(imc >= 40) {
					situacao = "Obesidade Grau III";	
				}
				
				JOptionPane.showMessageDialog(null, "IMC: " + imc + " \nSituação: " + situacao);				
			}
		}
		if(evento.getSource() == btnSair) {
			System.exit(0);
		}
		
	}
	
	public static void main(String[] args) {
		new Imc();
	}

}
