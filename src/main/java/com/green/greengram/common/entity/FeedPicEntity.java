package com.green.greengram.common.entity;

import com.green.greengram.common.config.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "t_feed_pic")
@Data
@SuperBuilder
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class FeedPicEntity extends BaseEntity {
    @EmbeddedId
    private FeedPicId feedPicId;
}
