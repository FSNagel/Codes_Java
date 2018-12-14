class Post{
	private String title;
	private String date;
	private String content;
	private int likes;
	private int dislikes;

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

	public void show(){
		System.out.println("=  Likes: " + this.getLikes() + "      Dislikes: " + this.getDislikes());
		System.out.println("=  Titulo: " + this.getTitle());
		System.out.println("=  Data: " + this.getDate());
		System.out.println("=  Conteudo: " + this.getContent());
	}

	public void like(){
		this.likes += 1;
		System.out.println("Total de likes: " + this.getLikes());
	}

	public void dislike(){
		this.dislikes += 1;
		System.out.println("Total de dislikes: " + this.getDislikes());
	}

}