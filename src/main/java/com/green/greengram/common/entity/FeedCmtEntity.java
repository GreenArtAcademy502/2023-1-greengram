package com.green.greengram.common.entity;

import com.green.greengram.common.config.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.apache.catalina.User;

@Entity
@Table(name = "t_feed_cmt")
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class FeedCmtEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, columnDefinition = "BIGINT UNSIGNED")
    private Long icmt;

    @ManyToOne
    @JoinColumn(name = "ifeed", updatable = false, nullable = false)
    private FeedEntity feedEntity;

    @ManyToOne
    @JoinColumn(name = "iuser", updatable = false, nullable = false)
    private UserEntity userEntity;

    private String cmt;
}
