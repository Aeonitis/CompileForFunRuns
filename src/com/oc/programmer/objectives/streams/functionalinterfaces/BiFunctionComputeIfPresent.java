package com.oc.programmer.objectives.streams.functionalinterfaces;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * BiFunction is a function that accepts two arguments and produces a result. The types of the
 * arguments and the return value can all be different.
 */
public class BiFunctionComputeIfPresent {

  public static void main(String[] args) {
    Map<String, Account> myAccounts = new HashMap<>();
    myAccounts.put("111", new Account("111"));
    myAccounts.put("222", new BankAccount("111", 200.0));

    BiFunction<String, Account, Account> bankAccountUpdaterBiFunction = (a1, a2) ->
        a2 instanceof BankAccount
            ? new BankAccount(a1, 300.0) : new Account(a1);

    /**
     * public V computeIfPresent(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)
     *  If the value for the specified key is present and non-null, attempts to compute a new mapping given the key and its current mapped value.
     *  If the function returns null, the mapping is removed.
     *  If the function itself throws an (unchecked) exception, the exception is rethrown, and the current mapping is left unchanged.
     *
     *  Parameters:
     *  key - key with which the specified value is to be associated
     *  remappingFunction - the function to compute a value Returns: the new value associated with the specified key, or null if none
     *
     *  Returns: the new value associated with the specified key, or null if none
     */
    myAccounts.computeIfPresent("222", bankAccountUpdaterBiFunction);

    BankAccount myBankAccount = (BankAccount) myAccounts.get("222");
    System.out.println(myBankAccount);
  }

}

class Account {

  private String id;

  public Account(String id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "| Account{" +
        "id='" + id + '\'' +
        '}';
  }
}

class BankAccount extends Account {

  private double balance;

  public BankAccount(String id, double balance) {
    super(id);
    this.balance = balance;
  }

  public double getBalance() {
    return balance;
  }

  @Override
  public String toString() {
    return "BankAccount{" +
        "balance=" + balance +
        super.toString() + '}';
  }
}