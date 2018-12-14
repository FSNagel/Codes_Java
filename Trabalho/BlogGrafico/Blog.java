import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import javax.swing.event.*; 

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class Blog implements ActionListener{
	static int indice = 0;
	static Post arrayList[] = new Post[100];
	
	public JFrame frame;
	public JButton botao;
	public JPanel panelWest;
	public JPanel panelCenter;
	public JPanel panelList;
	public JPanel panelClean;
	public JLabel textoBemVindo;
	public JButton botaoNovaNoticia, 
	botaoNovaResenha, 
	botaoNovoAssuntos, 
	botaoListarPosts, 
	botaoCurtirPosts, 
	botaoDescurtirPosts, 
	botaoSair,
	botaoSalvar;

	public Blog(){

		this.frame = new JFrame("Blog");
		this.frame.setLayout(new BorderLayout());
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(750,525);
		this.frame.setVisible(true);

		this.textoBemVindo = new JLabel("<html><h1>Bem Vindo ao Blog Nagel - Gerenciador de Conteudos</h1></html>");

		this.botaoNovaNoticia    = new JButton("Novo post de noticia");
		this.botaoNovaResenha    = new JButton("Nova resenha do produto");
		this.botaoNovoAssuntos   = new JButton("Novo post de outros assuntos");
		this.botaoListarPosts    = new JButton("Listar todas as postagens");
		this.botaoCurtirPosts    = new JButton("Curtir uma postagem");
		this.botaoDescurtirPosts = new JButton("Nao curtir uma postagem");
		this.botaoSair 		     = new JButton("Sair");

		this.botaoNovaNoticia.addActionListener(this);
		this.botaoNovaResenha.addActionListener(this);
		this.botaoNovoAssuntos.addActionListener(this);
		this.botaoListarPosts.addActionListener(this);
		this.botaoCurtirPosts.addActionListener(this);
		this.botaoDescurtirPosts.addActionListener(this);
		this.botaoSair.addActionListener(this);

		this.panelWest = new JPanel();
		this.panelWest.setLayout(new GridLayout(7, 1));

		this.panelWest.add(this.botaoNovaNoticia);
		this.panelWest.add(this.botaoNovaResenha);
		this.panelWest.add(this.botaoNovoAssuntos);
		this.panelWest.add(this.botaoListarPosts);
		this.panelWest.add(this.botaoCurtirPosts);
		this.panelWest.add(this.botaoDescurtirPosts);
		this.panelWest.add(this.botaoSair);

		this.frame.add(BorderLayout.NORTH,this.textoBemVindo);
		this.frame.add(BorderLayout.WEST,this.panelWest);
		this.frame.setVisible(true);


	}

	public static void main(String args[]){
		new Blog();
	}

	public void actionPerformed(ActionEvent e){
		this.panelCenter = new JPanel();
		this.panelList	 = new JPanel();
		this.panelClean  = new JPanel();
		this.botaoSalvar = new JButton("Salvar Novo");

		if(e.getSource() == botaoNovaNoticia || e.getSource() == botaoNovaResenha || e.getSource() == botaoNovoAssuntos){
			
			Post temp;
			
			if(e.getSource() == botaoNovaNoticia){
				temp = new News();
			} else if(e.getSource() == botaoNovaResenha){
				temp = new ProductReview();
			} else {
				temp = new Post();
			} 

			this.panelCenter = temp.getPanel();

			this.botaoSalvar.addActionListener(temp);
			this.panelCenter.add(this.botaoSalvar);

			this.frame.remove(panelCenter);
			this.frame.add(BorderLayout.CENTER,this.panelClean);
			this.frame.remove(panelClean);
			this.frame.add(BorderLayout.CENTER,this.panelCenter);
			this.frame.revalidate();
			this.frame.setVisible(true);

		} else if(e.getSource() == botaoListarPosts){

			JLabel htmlJ;

			String html = "<html>";

			for (int i = 0; i < indice; i++) {
				html += arrayList[i].Show();
			}

			html += "</html>";

			htmlJ = new JLabel(html);
			this.panelList.add(htmlJ);
			this.panelCenter.add(this.panelList);

			this.frame.remove(panelCenter);
			this.frame.add(BorderLayout.CENTER,this.panelClean);
			this.frame.remove(panelClean);
			this.frame.add(BorderLayout.CENTER,this.panelCenter);
			this.frame.revalidate();
			this.frame.setVisible(true);

			JOptionPane.showMessageDialog(null, "Listados " + indice + " registros.");


		}
	}

	public static void save(Post data, int tipo){

		switch(tipo){
			case 1:
			data = (Post)data;
			break;

			case 2:
			data = (News)data;
			break;

			case 3:
			data = (ProductReview)data;
			break;
		}

		arrayList[indice] = data;


		if(arrayList[indice] instanceof News) {
			JOptionPane.showMessageDialog(null, "Postagem do tipo News salva com sucesso! Ja existem " + (indice+1) + " registros.");
		} else if(arrayList[indice] instanceof ProductReview) {
			JOptionPane.showMessageDialog(null, "Postagem do tipo ProductReview salva com sucesso! Ja existem " + (indice+1) + " registros.");
		} else if(arrayList[indice] instanceof Post) {
			JOptionPane.showMessageDialog(null, "Postagem do tipo Post salva com sucesso! Ja existem " + (indice+1) + " registros.");
		}

		indice++;
	}
}
