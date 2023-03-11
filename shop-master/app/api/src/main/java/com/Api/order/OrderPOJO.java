package com.Api.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order")
@Data
@Builder
public class OrderPOJO implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    private int user_id;
    private boolean status;
    private Timestamp date;
    private Timestamp update_at;
    private String currency;
    private long note;
}
