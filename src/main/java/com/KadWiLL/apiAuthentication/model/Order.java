package com.KadWiLL.apiAuthentication.model;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name= "ORDERS_TABLE")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "Full_Name")
    private String fullName;

    @NotNull
    @Column(name = "Product")
    private String product;

    @CreationTimestamp
    @Column(name = "Date")
    private Date cDate;

    @UpdateTimestamp
    @Transient
    private Date uDate;
}
