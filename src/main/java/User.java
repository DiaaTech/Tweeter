
public class User {
	private String email;
	private String name;
	private String bio;
	private String location;
	private String date;
	private String image;
	public User(String email, String name, String bio, String location, String date, String image) {
		super();
		this.email = email;
		this.name = name;
		this.bio = bio;
		this.location = location;
		this.date = date;
		this.image = image;
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
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	

	
}
