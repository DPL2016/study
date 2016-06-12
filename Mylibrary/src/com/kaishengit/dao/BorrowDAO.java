package com.kaishengit.dao;

import com.kaishengit.entity.Borrow;
import com.kaishengit.util.DBHelp;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class BorrowDAO {
	public Boolean add(Borrow b){
		String sql  = "insert into borrow(bid,cid) values(?,?)";
		return DBHelp.update(sql, b.getBid(),b.getCid());
	}
	public Borrow findOne(Borrow bor) {
		String sql = "select * from borrow where bid = ? and cid = ?";
		return DBHelp.query(sql, new BeanHandler<>(Borrow.class), bor.getBid(),bor.getCid());
				
	}
	public Boolean remove(int id){
		String sql = "delete from borrow where id=?";
		return DBHelp.update(sql,id);
	}
}
