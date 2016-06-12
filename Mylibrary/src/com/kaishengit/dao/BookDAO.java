package com.kaishengit.dao;

import com.kaishengit.entity.Book;
import com.kaishengit.util.DBHelp;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class BookDAO {

	public Boolean add(Book b){
		String sql = "insert into book(code,title,author,publishing,total,count)  values(?,?,?,?,?,?)";
		return DBHelp.update(sql, b.getCode(), b.getTitle(), b.getAuthor(), b.getPublishing(), b.getTotal(),
				b.getCount());
	}
	public List<Book> allBook(){
		String sql = "select*from book";
		return DBHelp.query(sql,new BeanListHandler<Book>(Book.class));
	}
	
	public List<Book>findBook(String str){
		String sql = "select*from book where title like '%"+str+"%' or author like '%" + str
				+ "%' or code like '%" + str + "%'";
		return DBHelp.query(sql,new BeanListHandler<Book>(Book.class),str);
	}
	
	public Book findOne(String code){
		
		String sql = "select * from book where code=?";
		return DBHelp.query(sql,new BeanHandler<Book>(Book.class),code);
	}
	public Book findOne(int id){
		
		String sql = "select * from book where id=?";
		return DBHelp.query(sql,new BeanHandler<Book>(Book.class),id);
	}
	public Boolean saveBookByCard(Book b){
		String sql = "update book set count = ? where id= ?";
		return DBHelp.update(sql, b.getCount(),b.getId());
	}
	public List<Book> findBooksByCard(String bCode){
		String sql = "select book.* from book INNER JOIN borrow on borrow.bid = book.id INNER JOIN card ON card.id=borrow.cid where card.`code=？`";
		return DBHelp.query(sql,new BeanListHandler<Book>(Book.class),bCode);
	}
	public Boolean saveCount(Book b){
		String sql = "update book set count=? where id=?";
		return DBHelp.update(sql,b.getCode(),b.getId());
	}

	public Boolean updateBook(Book b){
		String sql = "update book set title=?,author=?,publishing=?,total=?,count=? where code=?";
		return DBHelp.update(sql, b.getTitle(),b.getAuthor(),b.getPublishing(),b.getTotal(),b.getCount(),b.getCode());

	}
	public Boolean removeBook(String bCode){
		String sql = "delete from book where code = ?";
		return DBHelp.update(sql, bCode);
	}
	public Boolean removeBook(int id){
		String sql = "delete from book where id = ?";
		return DBHelp.update(sql, id);
	}

	
}
