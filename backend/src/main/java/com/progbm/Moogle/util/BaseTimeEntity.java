package com.progbm.Moogle.util;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * JPA Auditing 기능 활용
 * Audit : 감시하다
 * JPA Auditing : Spring Data JPA 에서 시간에 대해 자동으로 값을 넣어주는 기능
 * update 시 자동으로 시간을 매핑하여 DB 테이블에 넣어준다
 */

@Getter
@MappedSuperclass // 이 클래스를 JPA Entity 클래스들이 상속하는 경우 필드들을 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class) // Auditing 기능 포함
public class BaseTimeEntity {

    @CreatedDate // Entity 가 생성되어 저장될 때 시간이 자동 저장
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회한 Entity 의 값을 변경할 때 시간이 자동 저장
    private LocalDateTime modifiedDate;
}
