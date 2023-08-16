package com.green.greengram.common.entity;

import com.green.greengram.common.config.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "t_user_follow")
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserFollowEntity extends BaseEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "iuser")
    @ToString.Exclude
    private UserEntity fromUser;

    @Id
    @ManyToOne
    @JoinColumn(name = "iuser")
    @ToString.Exclude
    private UserEntity toUser;
}
