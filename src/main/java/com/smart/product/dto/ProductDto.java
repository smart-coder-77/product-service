package com.smart.product.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

/**
 * @author Choudhury Subham on 01-06-2022
 */
@Data
public class ProductDto {

    private String pName;
    private String pDescription;
    private Long pStock;
    private Double pPrice;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date pMfgDate;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date pExpireDate;

}
