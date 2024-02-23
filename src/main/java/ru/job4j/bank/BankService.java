package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса.
 * http://localhost:63342/job4j_tracker/target/site/apidocs/ru/job4j/bank/BankService.html?_ijt=og4n6pm60u0d1bd5j1l0b778b9&_ij_reload=RELOAD_ON_SAVE
 */
public class BankService {
    /**
     * Поле содержит всех пользователей системы с привязанными к ним счетами.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод проверяет есть ли данный пользователь в списке.
     * Если передаваемого пользователя нет, то добавляет его в список.
     * @param user пользователь, которого необходимо добавить.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает на вход номер паспорта и удаляет пользователя из списка.
     * @param passport номер паспорта, по которому происходит удаление пользователя из списка.
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод сначала ищет, по входящему номеру паспорта, пользователя.
     * Если пользователь доступен, получаем список всех его счетов и добавляем новый счет к ним,
     * с условием, что данного счёта ещё нет.
     * @param passport номер паспорта, по которому с помощью метода findPassport() ищем пользователя.
     * @param account счёт, который необходимо добавить.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> values = users.get(user);
            if (!values.contains(account)) {
                values.add(account);
            }
        }
    }

    /**
     * Ищем, используя входящий параметр - номер паспорта, пользователя в списке.
     * @param passport номер паспорта, по которому ищем пользователя.
     * @return возвращаем найденного пользователя. Если пользователя нет, возвращаем null.
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет счет пользователя по реквизитам.
     * Сначала нужно найти пользователя по паспорту с помощью метода findByPassport().
     * Потом получить список счетов этого пользователя и в нем найти нужный счет.
     * Поскольку метод findByPassport() может вернуть null, то прежде чем получать список аккаунтов,
     * требуется проверить что метод findByPassport() вернул отличное от null значение.
     * @param passport номер паспорта, по которому с помощью метода findPassport() ищем пользователя.
     * @param requisite реквизиты, по которым необходимо найти пользователя.
     * @return возвращаем найденного пользователя. Если пользователя нет, возвращаем null.
     */
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

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт. Сначала проверяем, с помощью
     * метода findRequisite(), наличие пользователя, с которого перечисляются средства и пользователя - получателя.
     * Так же проверяем, есть ли, требуемая для перевода сумма на счету.
     * После списываем указанную сумму со счёта отправителя, и начисляем на счёт получателя.
     * @param sourcePassport номер паспорта отправителя.
     * @param sourceRequisite номер счёта отправителя.
     * @param destinationPassport номер паспорта получателя.
     * @param destinationRequisite номер счёта получателя.
     * @param amount сумма для перевода.
     * @return возвращаем false, если пользователь не найден или не хватает денег на счёте, с которого переводят.
     * Если операция прошла успешно, возвращаем true.
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount != null && destinationAccount != null && sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            return true;
        }
        return result;
    }

    /**
     * С помощью метода получаем список счетов пользователя.
     * @param user необходимый пользователь.
     * @return возвращает список счетов пользователя.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
