package com.notification.model;

public enum NotificationStatus {

	CREATED("Created"),
    PENDING("Pending"),
    CONFIRMED("Confirmed"),
    FAILED("Failed");

    private String status;

    private NotificationStatus(final String status){
        this.status = status;
    }
     
    public String getStatus(){
        return this.status;
    }

    public String getName(){
        return this.name();
    }


    @Override
    public String toString(){
        return this.status;
    }
}
