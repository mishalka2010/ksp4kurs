package data.balance;

import data.Balance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceService
{
    @Autowired
    public BalanceService(BalanceDAO balanceDataAccessObject)
    {
        this.balanceDataAccessObject = balanceDataAccessObject;
    }

    public Balance balance(int userID) {
        return balanceDataAccessObject.getBalanceByUserID(userID).get(0);
    }

    public void updateUserBalance(int newBalance, int userID)
    {
        balanceDataAccessObject.updateUserBalance(newBalance, userID);
    }

    BalanceDAO balanceDataAccessObject;
}
