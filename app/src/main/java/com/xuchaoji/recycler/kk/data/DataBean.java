package com.xuchaoji.recycler.kk.data;

public class DataBean {
    private String title; // 新闻的标题
    private String digest; // 新闻的摘要
    private String imgsrc; // 新闻的图片链接
    private String url; // 新闻的详情链接

    // 构造方法
    public DataBean(String title, String digest, String imgsrc, String url) {
        this.title = title;
        this.digest = digest;
        this.imgsrc = imgsrc;
        this.url = url;
    }

    // getter和setter方法
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 重写toString方法，方便打印输出
    @Override
    public String toString() {
        return "DataBean{" +
                "title='" + title + '\'' +
                ", digest='" + digest + '\'' +
                ", imgsrc='" + imgsrc + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
