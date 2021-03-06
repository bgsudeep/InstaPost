//package com.instapost.domain;
//
//import java.util.Date;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//
//import org.hibernate.validator.constraints.NotEmpty;
//
//@Entity(name="NEWS")
//public class News {
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Long id;
//	
//	@NotEmpty
//	@Size(min=2, max=15, message="{Size.name.validation}")
//	private String title;
//	
//	@NotEmpty
//	@Size(message="{Size.name.validation}")
//	private String description;
//
////	@Transient
////	private MultipartFile image;
//	
//	@NotNull
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="user_id")
//	private User user;
//	
//	@NotNull
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="category_id")
//	private Category category;
//	
//	@NotNull
//	@Temporal(TemporalType.TIMESTAMP)
////	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//	private Date postDate;
//	
//	@NotNull
//	private Date publishDate;
//	
////	@Column(columnDefinition="default 0")
//	private boolean isPublish;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getDesctiption() {
//		return description;
//	}
//
//	public void setDesctiption(String desctiption) {
//		this.description = desctiption;
//	}
//
////	@XmlTransient
////	public MultipartFile getImage() {
////		return image;
////	}
////
////	public void setImage(MultipartFile image) {
////		this.image = image;
////	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public Category getCategory() {
//		return category;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}
//
//	public Date getPostDate() {
//		return postDate;
//	}
//
//	public void setPostDate(Date postDate) {
//		this.postDate = postDate;
//	}
//
//	public Date getPublishDate() {
//		return publishDate;
//	}
//
//	public void setPublishDate(Date publishDate) {
//		this.publishDate = publishDate;
//	}
//
//	public boolean isPublish() {
//		return isPublish;
//	}
//
//	public void setPublish(boolean isPublish) {
//		this.isPublish = isPublish;
//	}
//	
//	
//}

package com.instapost.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity(name="NEWS")
public class News {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotEmpty
	@Size(min=2, max=15, message="{Size.name.validation}")
	private String title;
	
//	@Size(min=1, max=2500, message="{Size.name.validation}")

	@NotEmpty
	@Lob
	@Column(columnDefinition = "TEXT", length=10000)
	private String description;

	@OneToOne(cascade=CascadeType.MERGE, orphanRemoval = true)
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="category_id")
	private Category category;
	
//	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date postDate = new Date();
	
	private boolean isPublish;
	
	@ManyToOne
	private Magazine magazine;
	
	public Magazine getMagazine() {
		return magazine;
	}

	public void setMagazine(Magazine magazine) {
		this.magazine = magazine;
	}

	private Date publishDate =  new Date();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public boolean isPublish() {
		return isPublish;
	}

	public void setPublish(boolean isPublish) {
		this.isPublish = isPublish;
	}
}

