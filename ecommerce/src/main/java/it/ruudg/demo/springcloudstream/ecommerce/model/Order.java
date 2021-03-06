package it.ruudg.demo.springcloudstream.ecommerce.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @NonNull
    private Customer customer;
    @NonNull
    private Double amount;

}
