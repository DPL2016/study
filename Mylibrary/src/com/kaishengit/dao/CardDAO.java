package com.kaishengit.dao;

import com.kaishengit.entity.Card;
import com.kaishengit.util.DBHelp;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class CardDAO {
	public Boolean add(Card card){
		String sql = "insert into card(code,name,tel) values (?,?,?)";
		return DBHelp.update(sql, card.getCode(),card.getName(),card.getTel());
	}
	public Boolean remove(int id){
		String sql = "delete from card where id = ?";
		return DBHelp.update(sql, id);
	}
	public Card findOne(String code){
		String sql = "select * from card where code = ?";
		return DBHelp.query(sql, new BeanHandler<Card>(Card.class), code);
	}
	public Card findOne(int id){
		String sql = "select * from card where id = ?";
		return DBHelp.query(sql, new BeanHandler<Card>(Card.class), id);
	}
	public List<Card> findAll(){
		String sql = "select * from card";
		return DBHelp.query(sql, new BeanListHandler<Card>(Card.class));
	}
	public Boolean modify(Card card){
		String sql = "update card set code=?,name=?,tel=? where id=?";
		return DBHelp.update(sql, card.getCode(),card.getName(),card.getTel(),card.getId());
	}
}
