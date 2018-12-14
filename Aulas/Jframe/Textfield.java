import java.awt.*;
import javax.swing.*;

public class Textfield {
	public static void main(String[] args) {
		new Textfield();
	}
	public Textfield() {
		JFrame f = new JFrame("Exemplo JTextField");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500,120);
		f.setVisible(true);		
		JPanel p = new JPanel(); //painel principal
 		p.setLayout(new BorderLayout());// define o layout do container

		FlowLayout layout = new FlowLayout();//instancia um flowlayout
		layout.setAlignment(FlowLayout.LEFT);//define alinhamento à esquerda
		
		JPanel painel1 = new JPanel(); //painel para campo nome
		painel1.setLayout(layout); //define o layout do painel1

		JPanel painel2 = new JPanel();//painel para campo senha
		painel2.setLayout(layout); 
		
		JPanel painel3 = new JPanel(); //painel para campo sexo
		painel3.setLayout(layout);
		
		JLabel nome = new JLabel("Nome:");//cria um label
		painel1.add(nome); //adiciona o label ao painel 1
		JTextField vnome = new JTextField(30);
		painel1.add(vnome);		
		JLabel senha = new JLabel("Senha:");
		painel2.add(senha);
		JPasswordField vsenha = new JPasswordField(10);
		painel2.add(vsenha);		
		JLabel sexo = new JLabel("Sexo:");
		painel3.add(sexo);
		ButtonGroup vsexo = new ButtonGroup();
		JRadioButton masc = new JRadioButton("Masculino");
		vsexo.add(masc); // adiciona ao grupo
		painel3.add(masc); // adiciona ao painel
		JRadioButton fem = new JRadioButton("Feminino");
		vsexo.add(fem);
		painel3.add(fem);
		p.add(painel1, BorderLayout.NORTH);
		p.add(painel2, BorderLayout.CENTER);
		p.add(painel3, BorderLayout.SOUTH);		
		f.add(p); // adiciona o painel ao frame
	}
}
