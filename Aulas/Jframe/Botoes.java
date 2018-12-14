import java.awt.*;
import javax.swing.*;
public class Botoes {
	public Botoes() {
		JFrame f = new JFrame("Exemplo JButton");
		f.setSize(400, 200);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		JPanel p = new JPanel();
		JButton b1 = new JButton("Botao normal");
		b1.setMnemonic('B');
		p.add(b1);
		ImageIcon brasil = new ImageIcon("brasil.gif");
		JButton b2 = new JButton(brasil);
		b2.setBackground(Color.yellow); // Define a cor de fundo do botão
		p.add(b2);
		f.add(p);		
		f.setVisible(true);
	}	
	public static void main(String[] args) {
		new Botoes();
	}
}
