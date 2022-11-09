
public class Tweet {
	private String email;
	private String name;
	private String body;
	private String tags;
	private String date;
	private int likes;
	public Tweet(String email, String name, String body, String tags, String date, int likes) {
		super();
		this.email = email;
		this.name = name;
		this.body = body;
		this.tags = tags;
		this.date = date;
		this.likes = likes;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	

}
