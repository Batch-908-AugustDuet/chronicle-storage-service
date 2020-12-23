package com.revature.chronicle.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * A video uploaded by a user. Will be streamed and viewable in Chronicle.
 */
@Entity
@Table(name = "video")
@Data
public class Video {
    @Id
    @Column(name = "video_id",columnDefinition = "serial primary key")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int videoID;

    @Column(name = "url")
    private String url;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", columnDefinition = "INT")
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "video_tag",
            joinColumns = @JoinColumn(name = "video_id", referencedColumnName = "video_id", columnDefinition = "INT"),
            inverseJoinColumns = @JoinColumn(name = "tag_id",referencedColumnName = "tag_id", columnDefinition = "INT"))
    private Set<Tag> video_tags;
}