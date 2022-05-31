package com.smart.product.entity;

import jdk.internal.net.http.common.Log;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Choudhury Subham on 31-05-2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long pid;
    private String pName;
    private Date pMfgDate;
    private Date pExpireDate;
    private Long pStock;
    private Double pPrice;
}
