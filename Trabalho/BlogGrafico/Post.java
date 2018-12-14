import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*; 
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


class Post implements ActionListener{
	private String title;
	private String date;
	private String content;
	private int likes;
	private int dislikes;

	public JPanel panel;
	public JTextField titleJ;
	public JTextField dateJ;
	public JTextArea contentJ;


	public String getTitle(){
		return this.title;
	}

	public void setTitle(String value){
		this.title = value;
	}

	public String getDate(){
		return this.date;
	}

	public void setDate(String value){
		this.date = value;
	}

	public String getContent(){
		return this.content;
	}

	public void setContent(String value){
		this.content = value;
	}

	public int getLikes(){
		return this.likes;
	}

	public void setLikes(int value){
		this.likes = value;
	}

	public int getDislikes(){
		return this.dislikes;
	}

	public void setDislikes(int value){
		this.dislikes = value;
	}

	private String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public String Show(){
		String html = " ";
		html += "<h4 width='500'>Postagem Post</h4>";
		html += "Likes:" + this.getLikes() + "   Dislikes: " + this.getDislikes() + "<br/>";
		html += "<h1 width='500'>";
		html += this.getTitle() + "</h1><br/>";
		html += "<p width='500'>Data/Hora: " + this.getDate() + "</p><br/>";
		html += "<p width='500'><strong>" + this.getContent() + "</strong></p><br/>";
		html += "<br/><hr><br/>";

		return html;
	}

	public void like(){
		this.likes += 1;
		System.out.println("Total de likes: " + this.likes);
	}

	public void dislike(){
		this.dislikes += 1;
		System.out.println("Total de likes: " + this.dislikes);
	}

	public JPanel getPanel(){
		this.panel 	  = new JPanel();
		String data = this.getDateTime();

		this.titleJ   = new JTextField("Digite o titulo", 46);
		this.dateJ    = new JTextField(data, 46);
		this.contentJ = new JTextArea("Digite aqui o conteudo", 20, 46);

		this.panel.add(this.titleJ);
		this.panel.add(this.dateJ);
		this.panel.add(this.contentJ);

		return this.panel;
	}

	public void actionPerformed(ActionEvent e){
		Post post = new Post();
		post.setTitle(titleJ.getText());
		post.setDate(dateJ.getText());
		post.setContent(contentJ.getText());

		Blog blog = new Blog();
		blog.save(post, 1);
	}

}