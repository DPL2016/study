package com.kaishengit.pojo;

import java.util.Date;

public class Borrow {
    private Integer id;
    private Integer bid;
    private Integer cid;
    private Date btime;
    private Book book;
    private Card card;

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

    public Date getBtime() {
        return btime;
    }

    public void setBtime(Date btime) {
        this.btime = btime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", bid=" + bid +
                ", cid=" + cid +
                ", btime=" + btime +
                '}';
    }
}
