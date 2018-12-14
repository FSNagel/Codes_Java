import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
public class TextAreaTest{
	JTextArea text;
	int count;
	public static void main(String args[]) 
	{ 
		TextAreaTest gui = new TextAreaTest(); 
		gui.go();
	}

	public void go() { 
		JFrame janela = new JFrame("Testando JTextArea"); 
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
		janela.setSize(350, 300); 
		janela.setVisible(true); 		
		JPanel painel = new JPanel(); 
		JButton botao = new JButton("Clique aqui");  
		botao.addActionListener(this);		
		text = new JTextArea (10, 20); // 10 linhas, 20 colunas
		text.setLineWrap(true);
		JScrollPane scroller = new JScrollPane(text);	
		scroller.setVerticalScrollBarPolicy(
						JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(
						JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		painel.add(scroller);
		janela.add(BorderLayout.CENTER, painel);
		janela.add(BorderLayout.SOUTH, botao);
	}  
	public void actionPerformed(ActionEvent event) 
	{ 	
		this.count++;		
		text.append("Botão clicado pela "+count+"ª vez\n");
	} 
} 
