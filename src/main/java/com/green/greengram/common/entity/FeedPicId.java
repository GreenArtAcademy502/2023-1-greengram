package com.green.greengram.common.entity;

import com.green.greengram.common.entity.FeedEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@SuperBuilder
public class FeedPicId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "ifeed")
    private FeedEntity feedEntity;
    private String pic;
}
