import javax.swing.*;
import java.awt.event.*; 

class News extends Post implements ActionListener{
	private JPanel panel;
	private JTextField sourceJ;
	private JButton botaoSalvar;

	private String source;

	public String getSource(){
		return this.source;
	}

	public void setSource(String value){
		this.source = value;
	}

	public String Show(){

		String html = " ";
		
		html += "<h4 width='500'>Postagem News</h4>";
		html += "Likes:" + this.getLikes() + "   Dislikes: " + this.getDislikes() + "<br/>";
		html += "<h1 width='500'>";
		html += this.getTitle() + "</h1><br/>";
		html += "<p width='500'>Data/Hora: " + this.getDate() + "</p><br/>";
		html += "<p width='500'><strong>" + this.getContent() + "</strong></p><br/>";
		html += "<p width='500'><strong>Fonte: " + this.getSource() + "</strong></p><br/>";
		html += "<br/><hr><br/>";

		return html;
	}

	public JPanel getPanel(){
		this.panel = new JPanel();
		this.panel = super.getPanel();

		this.sourceJ = new JTextField("Informe a fonte:", 46);

		this.panel.add(this.sourceJ);
		
		return this.panel;
	}

	public void actionPerformed(ActionEvent e){
		News news = new News();
		news.setTitle(titleJ.getText());
		news.setDate(dateJ.getText());
		news.setContent(contentJ.getText());
		news.setSource(sourceJ.getText());

		Blog blog = new Blog();
		blog.save(news, 2);
	}

}