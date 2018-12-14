import javax.swing.*;
public class JFrameTest2 {
	public JFrame f;
	public JButton botao;
	public JFrameTest2(){
		f = new JFrame("Exemplo 2: frame com botao ");
		botao = new JButton("pressione");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300,300); // tamanho do frame		
		f.add(botao); // adiciona o botão ao frame
		f.setVisible(true);		
	}
	public static void main(String args[]){
		new JFrameTest2();
	}
}