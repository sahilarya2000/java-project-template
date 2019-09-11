package com.cars24.omstaxation.entity;

import com.cars24.omstaxation.config.audit.Auditable;
import com.cars24.omstaxation.constant.Mode;
import com.cars24.omstaxation.constant.Type;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

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

  @Column(name = "charge_key")
  private String chargeKey;

  @Enumerated(EnumType.STRING)
  private Mode chargeMode;

  @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
  private List<Charge> charges;

  @Enumerated(EnumType.STRING)
  @Column(name = "charge_type")
  private Type ChargeType;

}

