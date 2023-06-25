package com.example.mongopractice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

@Data
@Table(name = "Product")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Lazy //use to improve the startup performance as it will only initialize when needed and not during app startup
public class ProductEntity {

    private static final Long UUid = 1231321983719L;

    private String id;
    private String name;
    private double price;
    private String description;
    private boolean deleted;
}
