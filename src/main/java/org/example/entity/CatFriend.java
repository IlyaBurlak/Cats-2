package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "catfriends")
public class CatFriend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private Long cat_id;

    @Column(name = "friend_cat_id")
    private Long friend_cat_id;

    public Long getFriend_cat_id() {

        return friend_cat_id;
    }

    public void setFriend_cat_id(Long friend_cat_id) {
        this.friend_cat_id = friend_cat_id;
    }

    public Long getCat_id() {
        return cat_id;
    }

    public void setCat_id(Long cat_id) {
        this.cat_id = cat_id;
    }
}
