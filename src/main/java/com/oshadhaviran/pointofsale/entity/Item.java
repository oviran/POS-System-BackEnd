package com.oshadhaviran.pointofsale.entity;

import com.oshadhaviran.pointofsale.entity.enums.MeasuringUnitType;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
//@ToString
@Data

public class Item {
    @Id
    @Column(name = "item_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "item_name",length = 100, nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measure_type",length = 100, nullable = false)
    private MeasuringUnitType measuringUnitType;

    @Column(name = "balance_Qty",length = 100, nullable = false)
    private double balanceQty;

    @Column(name = "supplier_Price",length = 10, nullable = false)
    private double supplierPrice;

    @Column(name = "selling_price",length = 10, nullable = false)
    private double sellingPrice;

    @Column(name = "active_state", columnDefinition = "TINYINT default 0 ")
    private boolean activeState;

    @OneToMany(mappedBy="items")           //Ref-Baeldung site
    private Set<OrderDetails> orderDetails;





}
