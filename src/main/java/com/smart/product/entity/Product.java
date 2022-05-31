package com.smart.product.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name ="PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long pid;
    private String pName;
    private String pDescription;
    private Long pStock;
    private Double pPrice;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date pMfgDate;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date pExpireDate;

}
