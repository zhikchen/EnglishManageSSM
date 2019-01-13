package cn.edu.jxufe.czk.entity;

public class User {

	private Integer id;
	private String userName;
	private String passwd;
	private char sex;
	private String nickName;
	private String mail;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String userName, String passwd, char sex, String nickName, String mail) {
		super();
		this.id = id;
		this.userName = userName;
		this.passwd = passwd;
		this.sex = sex;
		this.nickName = nickName;
		this.mail = mail;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passwd=" + passwd + ", sex=" + sex + ", nickName="
				+ nickName + ", mail=" + mail + "]";
	}
	
}
