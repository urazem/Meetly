package com.nomercy.meetly;

public class Groups {

    private String groupName;
    private String groupImage;

    public Groups(String groupName,  String groupImage){

        this.groupName=groupName;
        this.groupImage = groupImage;
}

    public String getgroupName() {
        return this.groupName;
    }

    public void setgroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getgroupImage() {
        return this.groupImage;
    }

    public void setgroupImage(String groupImage) {
        this.groupImage = groupImage;
    }


}
