package br.com.erudio.mockito.services;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class Order {

    private String productName;
    private Long amount;
    private String id;
    private LocalDateTime creationDate;

}
