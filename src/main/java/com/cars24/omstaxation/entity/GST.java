package com.cars24.omstaxation.entity;

import com.cars24.omstaxation.config.audit.Auditable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Audited
@Table(name = "gst")
@EntityListeners(AuditingEntityListener.class)
public class GST extends Auditable<String> {
  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Double sgst;
  private Double cgst;
  private Double cess;
  private String state;
}

