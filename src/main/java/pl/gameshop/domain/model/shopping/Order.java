package pl.gameshop.domain.model.shopping;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.gameshop.domain.model.ShippingData;
import pl.gameshop.domain.model.ParentEntity;
import pl.gameshop.domain.model.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "orders")

@Getter @Setter @ToString(callSuper = true)
public class Order extends ParentEntity
{
    @OneToMany(fetch = FetchType.LAZY)
    private List<OrderRecord> orderRecords;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    @Column
    private LocalDateTime timeCreated;

    @Column(scale = 2)
    private Double finalPrice;

    @PrePersist
    void timeCreated()
    {
        this.timeCreated = LocalDateTime.now();
    }
}
