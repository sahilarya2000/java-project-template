package com.cars24.omstaxation.entity;

import com.cars24.omstaxation.config.audit.Auditable;
import com.cars24.omstaxation.constant.AmountType;
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
@Table(name = "charge")
@EntityListeners(AuditingEntityListener.class)
public class Charge extends Auditable<String> {

  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "range_start")
  private Double rangeStart;

  @Column(name = "range_end")
  private Double rangeEnd;

  @Column(name = "amount")
  private Double amount;

  @Enumerated(EnumType.STRING)
  @Column(name = "amount_type")
  private AmountType amountType;
}
