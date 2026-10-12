package com.splitter.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;

    @NotBlank(message = "User name can not be empty")
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_user_id",nullable = false)
    private User createdBy;

    @Column(nullable = false)
    @NotNull(message = "Amount can not be empty")
    private Double amount;

    @NotBlank(message = "Group can not be empty")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_name",nullable = false)
    private Group group;

}
