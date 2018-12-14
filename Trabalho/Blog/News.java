
class News extends Post{
	private String source;

	public String getSource(){
		return this.source;
	}

	public void setSource(String value){
		this.source = value;
	}

	@Override
	public void show(){
		super.show();
		System.out.println("=  Fonte: " + this.getSource());
	}
}	