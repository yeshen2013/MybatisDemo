package com.lyyexample.entry;

import java.util.Date;

public class Message {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.message_content
     *
     * @mbggenerated
     */
    private String messageContent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.mobile
     *
     * @mbggenerated
     */
    private String mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.sender
     *
     * @mbggenerated
     */
    private String sender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.receiver
     *
     * @mbggenerated
     */
    private String receiver;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.creator
     *
     * @mbggenerated
     */
    private String creator;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.id
     *
     * @return the value of message.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.id
     *
     * @param id the value for message.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.message_content
     *
     * @return the value of message.message_content
     *
     * @mbggenerated
     */
    public String getMessageContent() {
        return messageContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.message_content
     *
     * @param messageContent the value for message.message_content
     *
     * @mbggenerated
     */
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent == null ? null : messageContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.mobile
     *
     * @return the value of message.mobile
     *
     * @mbggenerated
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.mobile
     *
     * @param mobile the value for message.mobile
     *
     * @mbggenerated
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.sender
     *
     * @return the value of message.sender
     *
     * @mbggenerated
     */
    public String getSender() {
        return sender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.sender
     *
     * @param sender the value for message.sender
     *
     * @mbggenerated
     */
    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.receiver
     *
     * @return the value of message.receiver
     *
     * @mbggenerated
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.receiver
     *
     * @param receiver the value for message.receiver
     *
     * @mbggenerated
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.create_time
     *
     * @return the value of message.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.create_time
     *
     * @param createTime the value for message.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.creator
     *
     * @return the value of message.creator
     *
     * @mbggenerated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.creator
     *
     * @param creator the value for message.creator
     *
     * @mbggenerated
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }
}