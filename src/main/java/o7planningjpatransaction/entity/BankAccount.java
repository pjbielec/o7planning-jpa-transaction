package o7planningjpatransaction.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Bank_Account")
@Getter
@Setter
public class BankAccount {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Full_Name", length = 128, nullable = false)
    private String fullName;

    @Column(name = "Balance", nullable = false)
    private double balance;

}
