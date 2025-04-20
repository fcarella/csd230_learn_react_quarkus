package csd230;

import jakarta.persistence.*; // Standard JPA imports
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "gift") // Optional: explicitly name the table
public class Gift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 100)
    private String recipient;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    // --- Constructors ---
    public Gift() {
    }

    public Gift(String name, String recipient, BigDecimal price) {
        this.name = name;
        this.recipient = recipient;
        this.price = price;
    }

    // --- Getters and Setters (Required for JPA access) ---
    public Long getId() { return id; }
    // No setId()
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRecipient() { return recipient; }
    public void setRecipient(String recipient) { this.recipient = recipient; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    // --- Optional: equals() and hashCode() ---
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gift gift = (Gift) o;
        return id != null && Objects.equals(id, gift.id);
    }

    @Override
    public int hashCode() {
        return id != null ? Objects.hash(id) : getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Gift{" + "id=" + id + ", name='" + name + '\'' + ", recipient='" + recipient + '\'' + ", price=" + price + '}';
    }
}