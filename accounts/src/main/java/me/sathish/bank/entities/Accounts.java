package me.sathish.bank.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Accounts extends AccountMSBaseEntity {
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "account_number")
    @Id
    private Long accountNumber;

    @NotEmpty(message = "Account Type cannot be empty")
    @Column(name = "account_type")
    private String accountType;

    @NotEmpty(message = "Branch Address cannot be empty")
    @Column(name = "bank_address")
    private String bankAddress;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Accounts accounts = (Accounts) o;
        return accountNumber != null && Objects.equals(accountNumber, accounts.accountNumber);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
