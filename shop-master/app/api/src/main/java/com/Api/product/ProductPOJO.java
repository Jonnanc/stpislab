package com.Api.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
@Data
@Builder
public class ProductPOJO implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    private int brand_id;
    private String title;
    private String alias;
    private String content;
    private float price;
    private float old_price;
    private boolean status;
    private String keywords;
    private String description;
    private String img;
    private boolean hits;

}
