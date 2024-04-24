package com.oshadhaviran.pointofsale.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
@TypeDefs({
        @TypeDef(name="json", typeClass = JsonType.class)
}
)
@NoArgsConstructor
@AllArgsConstructor
@Data

public class OrderDetails {

    @Id
    @Column(name = "order_details_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @Column(name = "item_name",length = 100, nullable = false)
    private String itemName;

    @Column(name = "selling_price",length = 10, nullable = false)
    private String sellingPrice;

    @Column(name = "Qty",length = 10, nullable = false)
    private double Qty;

    @Column (name ="amount",nullable = false )
    private Double amount;


    @ManyToOne                                  //Ref-Baeldung site
    @JoinColumn(name="order_id", nullable=false)
    private Order orders;

    @ManyToOne                                  //Ref-Baeldung site
    @JoinColumn(name="item_id", nullable=false)
    private Item items;













}