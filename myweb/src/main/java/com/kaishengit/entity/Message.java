package com.kaishengit.entity;

/**
 * Message实体类
 * 每一个属性生成getter和setter
 */
public class Message {
    /**
     * message的id
     */
    private Integer id;
    /**
     * message的指令
     */
    private String command;
    /**
     * message的说明
     */
    private String description;
    /**
     * message的详细内容
     */
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
