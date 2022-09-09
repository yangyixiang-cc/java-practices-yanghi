package com.ebooks.entity;

public class Book {
	private int bookId;
	private String bookName;
	private int bookZJ;
	public Book() {}
	public Book(int bookId, String bookName, int bookZJ) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookZJ = bookZJ;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookZJ() {
		return bookZJ;
	}
	public void setBookZJ(int bookZJ) {
		this.bookZJ = bookZJ;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookId;
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + bookZJ;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bookId != other.bookId)
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (bookZJ != other.bookZJ)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookZJ=" + bookZJ + "]";
	}
	
}
