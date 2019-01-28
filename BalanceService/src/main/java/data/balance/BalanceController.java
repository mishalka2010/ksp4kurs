package data.balance;

import data.Balance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BalanceController
{
    @RequestMapping(value = "balance/{userID}", method = RequestMethod.GET)
    @ResponseBody public Balance getBalance(@PathVariable int userID)
    {
        return balanceService.balance(userID);
    }

    @RequestMapping(value = "balance/{userID}", method = RequestMethod.POST)
    @ResponseBody public void setBalance (@PathVariable int userID, @RequestBody Balance balance)
    {
        balanceService.updateUserBalance(balance.getMoney(),userID);
    }

    @Autowired
    private BalanceService balanceService;
}
