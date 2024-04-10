package org.example.dto;

public class CatFriendDto {

    private Long catId;
    private Long friendCatId;

    public Long getFriendCatId() {
        return friendCatId;
    }

    public void setFriendCatId(Long friendCatId) {
        this.friendCatId = friendCatId;
    }

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }
}