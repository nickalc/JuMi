package com.puxiang.jumi.bean;


/**
 * 新闻实体类
 * Created by Administrator on 2015/1/18.
 */
public class OrderListItem {

    private String title;   //标题
    private String date;    //日期
    private String content;
    private String price;
    private String status;  //订单状态


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPrice() {
        return  price;
    }

    public void setPrice(String price){
        this.price = price;
    }

    public String getStatus() {
        return  status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderListItem{" +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", price='" + price + '\'' +
                ", status='" + status + '\'' +
                ", content='" + content + '\'' +
                '}';
    }



}
