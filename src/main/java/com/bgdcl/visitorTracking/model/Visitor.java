package com.bgdcl.visitorTracking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Entity
@Table(name = "visitor")
public class  Visitor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;


    @NotNull
    @Pattern(regexp = "^\\d{11}$")
    private String phone;


    private String address;

    @NotNull
    private int noOfPeople = 1;

    @NotNull
    private LocalDateTime entryTime = LocalDateTime.now();

    private LocalDateTime exitTime = null;

    @NotNull
    private String reason;


    public void setExitTime(LocalDateTime now) {
        this.exitTime = now;
    }
}
