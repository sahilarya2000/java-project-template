package com.cars24.omstaxation.entity;

import com.cars24.omstaxation.config.audit.Auditable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
/**@author Saunik Singh*/
@Entity
@Getter
@Setter
@Audited
@Table(name = "tax_config")
@EntityListeners(AuditingEntityListener.class)
public class TaxConfig extends Auditable<String> {
  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name="sgst")
  private Double sgst;
  @Column(name ="cgst")
  private Double cgst;
  @Column(name="cess")
  private Double cess;
  @Column(name = "state")
  private String state;
}

