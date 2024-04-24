package com.oshadhaviran.pointofsale.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
@TypeDefs({
        @TypeDef(name="json", typeClass = JsonType.class)
}
)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order{

    @Id
    @Column(name = "order_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @ManyToOne                                  //Ref-Baeldung site
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customers;

    @Column(name = "active_state", columnDefinition = "TINYINT default 0 ")
    private boolean activeState;

    @Column (name ="order_date",columnDefinition ="DATETIME" )
    private Date date;

    @Column (name ="total",nullable=false )
    private Double total;

    @OneToMany(mappedBy="orders")           //Ref-Baeldung site
    private Set<OrderDetails> orderDetails;


    public Order(Customer customers, boolean activeState, Date date, Double total) {
        this.customers = customers;
        this.activeState = activeState;
        this.date = date;
        this.total = total;
    }
}
