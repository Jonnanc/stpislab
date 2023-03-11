package com.Api.category;

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
@Table(name = "category")
@Data
@Builder
public class CategoryPOJO implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String alias;
    private int parent_id;
    private String keywords;
    private String description;
}
