package com.kaishengit.pojo;
import java.io.Serializable;
import java.util.Date;

public class Borrow implements Serializable {
    private static final long serialVersionUID = 6036425242343458725L;
    private Integer id;
    private String bid;
    private String cid;
    private Date btime;

    private Book book;
    private Card card;

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", bid='" + bid + '\'' +
                ", cid='" + cid + '\'' +
                ", btime=" + btime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Date getBtime() {
        return btime;
    }

    public void setBtime(Date btime) {
        this.btime = btime;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
