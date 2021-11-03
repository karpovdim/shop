package by.karpov.shop.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @ToString.Exclude
    private List<Price> prices;

    @ManyToMany(mappedBy = "products", cascade = {
            CascadeType.REMOVE
    })
    @ToString.Exclude
    private List<Category> categories;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return id != null && Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
