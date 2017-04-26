package jvd001.bookstore.app.model.bookmanagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="upload")
public class Upload {
	@Id
	@Column(name="upload_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int upload_Id;
	private String upload_File_Name;
	private String file_Name;
	private int users_Id;
	private int book_Id;
	private String create_Time;
	private String extention;
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
	public int getBook_Id() {
		return book_Id;
	}
	public void setBook_Id(int book_Id) {
		this.book_Id = book_Id;
	}
	public String getCreate_Time() {
		return create_Time;
	}
	public void setCreate_Time(String create_Time) {
		this.create_Time = create_Time;
	}
	public String getExtention() {
		return extention;
	}
	public void setExtention(String extention) {
		this.extention = extention;
	}
	
	
	
}
