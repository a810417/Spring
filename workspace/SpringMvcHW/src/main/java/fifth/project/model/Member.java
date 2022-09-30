package fifth.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "member")
@Component
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;

	@Column(name="ACCOUNT")
	private String account;
	
	@Column(name="PASSWORD")
	private String password;

	@Column(name="NICKNAME")
	private String nickname;

	@Column(name="EMAIL")
	private String email;

	@Column(name="PHOTO")
	private byte[] photo;

	@Column(name="CREATE_AT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date create_at;

	public Member() {
	}
	
	@PrePersist
	public void onCreate() {
		if(create_at == null) {
			create_at = new Date();
		}
	}



	public Member(String account, String password, String nickname, String email, byte[] photo, Date create_at) {
		this.account = account;
		this.password = password;
		this.nickname = nickname;
		this.email = email;
		this.photo = photo;
		this.create_at = create_at;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

}
