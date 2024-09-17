package com.zenovak.cardsviewexample.model;

public class MobModel {
    private int imageResId;
    private String name;
    private String job;


    public MobModel(int imageResId, String name, String job) {
        this.imageResId = imageResId;
        this.name = name;
        this.job = job;
    }
    public MobModel(String name, String job) {
        this(1, name, job);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}
