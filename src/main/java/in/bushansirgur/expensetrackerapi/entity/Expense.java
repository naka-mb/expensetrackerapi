package in.bushansirgur.expensetrackerapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="tbl_expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "expense_name")
    @NotBlank(message = "Expense name must  not be null")
    @Size(min=3,message="Expense name must be atleast 3 character")
    private String name;
    private String description;
    @Column(name = "expense_amount")
    @NotNull(message = "Expense amount should not be null")
    private BigDecimal amount;

    @NotBlank(message = "Catogory should not be null")
    private String category;
    @NotNull(message = "Date must not be null")
    private Date date;
    @Column(name = "create_at",nullable = false,updatable = false)
    @CreationTimestamp
    private Timestamp createAt;

    @Column(name = "update_at")
    @UpdateTimestamp
    private Timestamp updateAt;
}
