package o7planningjpatransaction.controller;

import o7planningjpatransaction.dao.BankAccountDAO;
import o7planningjpatransaction.exception.BankTransactionException;
import o7planningjpatransaction.form.SendMoneyForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.prefs.BackingStoreException;

@Controller
public class MainController {

    @Autowired
    private BankAccountDAO bankAccountDAO;

    @GetMapping(value = "/")
    public String viewSendMoneyPage(Model model){

        SendMoneyForm form = new SendMoneyForm(1L, 2L, 700d);

        model.addAttribute("sendMoneyForm", form);

        return "sendMoneyPage";

    }

    @PostMapping(value = "/sendMoney")
    public String processSendMoney(Model model, SendMoneyForm sendMoneyForm){

        System.out.println("Send Money: " + sendMoneyForm.getAmount());

        try{
            bankAccountDAO.sendMoney(sendMoneyForm.getFromAccountId(),
                    sendMoneyForm.getToAccountId(),
                    sendMoneyForm.getAmount());
        } catch (BankTransactionException e){
            model.addAttribute("errorMessage", "Error: " +e.getMessage());
            return "/sendMoneyPage";
        }

        return "redirect:/";

    }

}
