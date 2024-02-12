package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(String passport) {
        users.remove(findByPassport(passport));
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> values = users.get(user);
            if (!values.contains(account)) {
                values.add(account);
            }
        }

    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> values = users.get(user);
            for (Account value : values) {
                if (value.getRequisite().equals(requisite)) {
                    return value;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        User sourceUser = findByPassport(sourcePassport);
        User destinationUser = findByPassport(destinationPassport);
        if (sourceUser != null && destinationUser != null) {
            List<Account> sourceAccounts = users.get(sourceUser);
            List<Account> destinationAccounts = users.get(destinationUser);
            for (Account sourceAccount : sourceAccounts) {
                if (sourceAccount.getRequisite().equals(sourceRequisite)
                        && sourceAccount.getBalance() >= amount) {
                    for (Account destinationAccount : destinationAccounts) {
                        if (destinationAccount.getRequisite().equals(destinationRequisite)) {
                            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
                            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
                            return true;
                        }
                    }
                }
            }
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
