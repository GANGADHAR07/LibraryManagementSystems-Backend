package com.dxc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")

public class Books {
	
		@Id
		@Column(name="title")
		private String title;
		
		@Column(name= "author")
		private String author;
		
		@Column(name= "genre")
		private String genre;
		
		@Column(name= "publisher")
		private String publisher;
		
		@Column(name= "floor_no")
		private int floor_no;
		
		@Column(name= "shelf_no")
		private int shelf_no;

		public Books() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Books(String title, String author, String genre, String publisher, int floor_no, int shelf_no) {
			super();
			this.title = title;
			this.author = author;
			this.genre = genre;
			this.publisher = publisher;
			this.floor_no = floor_no;
			this.shelf_no = shelf_no;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public String getPublisher() {
			return publisher;
		}

		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}

		public int getFloor_no() {
			return floor_no;
		}

		public void setFloor_no(int floor_no) {
			this.floor_no = floor_no;
		}

		public int getShelf_no() {
			return shelf_no;
		}

		public void setShelf_no(int shelf_no) {
			this.shelf_no = shelf_no;
		}

		@Override
		public String toString() {
			return "Books [title=" + title + ", author=" + author + ", genre=" + genre + ", publisher=" + publisher
					+ ", floor_no=" + floor_no + ", shelf_no=" + shelf_no + "]";
		}
		
}
