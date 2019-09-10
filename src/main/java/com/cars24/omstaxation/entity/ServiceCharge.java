package com.cars24.omstaxation.entity;

import com.cars24.omstaxation.config.audit.Auditable;
import com.cars24.omstaxation.constant.Mode;
import com.cars24.omstaxation.constant.Type;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Audited
@Table(name = "service_charge")
@EntityListeners(AuditingEntityListener.class)
public class ServiceCharge extends Auditable<String> {
  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "key")
  private String key;

  @Enumerated(EnumType.STRING)
  private Mode mode;

  @Enumerated(EnumType.STRING)
  private Type type;



}

