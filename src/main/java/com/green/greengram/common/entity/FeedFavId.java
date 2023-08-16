package com.green.greengram.common.entity;

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
public class FeedFavId implements Serializable  {
    @ManyToOne
    @JoinColumn(name = "ifeed")
    @ToString.Exclude
    private FeedEntity feedEntity;

    @ManyToOne
    @JoinColumn(name = "iuser")
    @ToString.Exclude
    private UserEntity userEntity;
}
