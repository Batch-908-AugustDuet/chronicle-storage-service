package com.revature.chronicle.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * A video uploaded by a user. Will be streamed and viewable in Chronicle.
 */
@Entity
@Table(name = "video")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video extends Media{
    @Id
    @Column(name = "video_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "url")
    private String url;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    @CreationTimestamp
    private Date date;

    @Column(name = "user_id")
    private String user;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "video_tag",
            joinColumns = @JoinColumn(name = "video_id", referencedColumnName = "video_id", columnDefinition = "INT"),
            inverseJoinColumns = @JoinColumn(name = "tag_id",referencedColumnName = "tag_id", columnDefinition = "INT"))
    private List<Tag> tags;

    public Video(String title, String description, Date date, String user, List<Tag> tags) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.user = user;
    }
}
