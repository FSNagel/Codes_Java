import javax.swing.*;
public class JFrameTest2 {
	public JFrame f;
	public JButton botao;
	public JPanel p;
	public JFrameTest2(){

				JTextArea texto = new JTextArea (10, 20);
		
		JFrame frame   = new JFrame("Blog");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);

		JLabel textoBemVindo 	   = new JLabel("Bem Vindo ao Blog Nagel, escolha uma opcao:");

		JButton botaoNovaNoticia    = new JButton("Novo post de noticia");
		JButton botaoNovaResenha    = new JButton("Nova resenha do produto");
		JButton botaoNovoAssuntos   = new JButton("Novo post de outros assuntos");
		JButton botaoListarPosts    = new JButton("Listar todas as postagens");
		JButton botaoCurtirPosts    = new JButton("Curtir uma postagem");
		JButton botaoDescurtirPosts = new JButton("Nao curtir uma postagem");
		JButton botaoSair 		    = new JButton("Sair");

		JPanel panel = new JPanel();

		panel.add(textoBemVindo);

		panel.add(botaoNovaNoticia);
		panel.add(botaoNovaResenha);
		panel.add(botaoNovoAssuntos);
		panel.add(botaoListarPosts);
		panel.add(botaoCurtirPosts);
		panel.add(botaoDescurtirPosts);
		panel.add(botaoSair);

		frame.add(panel);

		frame.setVisible(true);

	}
	public static void main(String args[]){
		new JFrameTest2();

		/*JOptionPane.showMessageDialog(null,"Aperte ok se voce eh true!", "Aviso dos mano",JOptionPane.WARNING_MESSAGE);

		int opcao = JOptionPane.showConfirmDialog(null,"Voce quer prosseguir sendo true?");
		
		if (opcao == JOptionPane.YES_OPTION) {
			String dados = JOptionPane.showInputDialog(null,"Qual o seu nome mano true?", "Pergunta", JOptionPane.QUESTION_MESSAGE);
			JOptionPane.showMessageDialog(null,"Voce eh dos manos " + dados, "Aviso dos mano",JOptionPane.WARNING_MESSAGE);
		} else if (opcao == JOptionPane.NO_OPTION) {
			String dados = JOptionPane.showInputDialog(null,"Qual o seu nome mano que nao eh true?", "Pergunta", JOptionPane.QUESTION_MESSAGE);
			JOptionPane.showMessageDialog(null,"Voce eh um vacilao " + dados, "Aviso dos mano",JOptionPane.WARNING_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null,"Voce eh um vacilao mesmo, nem quero saber seu nome!",
			"Aviso dos mano",JOptionPane.WARNING_MESSAGE);
		}*/


	}
}