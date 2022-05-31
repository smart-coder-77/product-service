package com.smart.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author Choudhury Subham on 31-05-2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {

    private Integer errorCode;
    private String details;
    private Date date;

}
