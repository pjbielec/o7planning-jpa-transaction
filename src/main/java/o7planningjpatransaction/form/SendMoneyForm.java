package o7planningjpatransaction.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SendMoneyForm {

    private Long fromAccountId;
    private Long toAccountId;
    private double amount;

}
