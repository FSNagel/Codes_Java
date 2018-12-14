import javax.swing.*;
import java.awt.event.*; 


class ProductReview extends Post implements Evaluable, ActionListener{
	public String brand;
	public JTextField brandJ;
	public JPanel panel;

	private int stars;

	public void evaluate(int value){
		System.out.println("Evaluate");
	}

	public String getBrand(){
		return this.brand;
	}

	public void setBrand(String value){
		this.brand = value;
	}

	public int getStars(){
		return this.stars;
	}

	public void setStarts(int value){
		this.stars = value;
	}

	public String Show(){

		String html = " ";	
		
		html += "<h4 width='500'>Postagem ProductReview</h4>";
		html += "Likes:" + this.getLikes() + "   Dislikes: " + this.getDislikes() + "<br/>";
		html += "<h1 width='500'>";
		html += this.getTitle() + "</h1><br/>";
		html += "<p width='500'>Data/Hora: " + this.getDate() + "</p><br/>";
		html += "<p width='500'><strong>" + this.getContent() + "</strong></p><br/>";
		html += "<p width='500'><strong>Marca: " + this.getBrand() + "</strong></p><br/>";
		html += "<br/><hr><br/>";

		return html;
	}

	public JPanel getPanel(){
		this.panel  = new JPanel();
		this.panel 	= super.getPanel();
		this.brandJ = new JTextField("Informe a marca.", 46);

		this.panel.add(brandJ);

		return this.panel;
	}

	public void actionPerformed(ActionEvent e){
		ProductReview product = new ProductReview();
		product.setTitle(titleJ.getText());
		product.setDate(dateJ.getText());
		product.setContent(contentJ.getText());
		product.setBrand(brandJ.getText());

		Blog blog = new Blog();
		blog.save(product, 3);
	}


}