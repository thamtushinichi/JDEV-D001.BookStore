/*
 * ClassName: Upload
 * Version information: 1.0
 * Date: 10/6/2017
 * Copyright
 */
package jvd001.bookstore.app.model.bookmanagement;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "upload")
public class Upload {
	@Id
	@Column(name = "upload_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int upload_Id;
	private String upload_File_Name;
	private String file_Name;
	private int users_Id;
	@Temporal(TemporalType.TIMESTAMP)
	@Generated(GenerationTime.ALWAYS)
	@Column(name = "create_time", insertable = false, updatable = false)
	private Calendar create_Time;
	private String extension;

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getUpload_Id() {
		return upload_Id;
	}

	public void setUpload_Id(int upload_Id) {
		this.upload_Id = upload_Id;
	}

	public String getUpload_File_Name() {
		return upload_File_Name;
	}

	public void setUpload_File_Name(String upload_File_Name) {
		this.upload_File_Name = upload_File_Name;
	}

	public String getFile_Name() {
		return file_Name;
	}

	public void setFile_Name(String file_Name) {
		this.file_Name = file_Name;
	}

	public int getUsers_Id() {
		return users_Id;
	}

	public void setUsers_Id(int users_Id) {
		this.users_Id = users_Id;
	}

	public Calendar getCreate_Time() {
		return create_Time;
	}

	public void setCreate_Time(Calendar create_Time) {
		this.create_Time = create_Time;
	}

}
