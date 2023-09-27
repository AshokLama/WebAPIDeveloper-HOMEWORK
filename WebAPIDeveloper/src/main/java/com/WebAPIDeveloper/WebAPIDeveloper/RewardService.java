package com.WebAPIDeveloper.WebAPIDeveloper;

import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RewardService {
    // Hardcoded sample data
    List<Transaction> transactions = Arrays.asList(
            new Transaction(1,BigDecimal.valueOf(120), LocalDate.of(2023, 7, 10)),
            new Transaction(1, BigDecimal.valueOf(80), LocalDate.of(2023, 7, 15)),
            new Transaction(2, BigDecimal.valueOf(50), LocalDate.of(2023, 7, 20)),
            new Transaction(2, BigDecimal.valueOf(75), LocalDate.of(2023, 8, 5)),
            new Transaction(1, BigDecimal.valueOf(120), LocalDate.of(2023, 8, 10)),
            new Transaction(3, BigDecimal.valueOf(60), LocalDate.of(2023, 9, 2))
    );

    public int calculateRewardPoints(BigDecimal amount){
        int rewardPoints = 0;
        if (amount.compareTo(BigDecimal.valueOf(100)) > 0) {
            rewardPoints += 2 * (amount.subtract(BigDecimal.valueOf(100))).intValue();
            amount = BigDecimal.valueOf(100);
        }
        if (amount.compareTo(BigDecimal.valueOf(50)) >= 0) {
            rewardPoints += (amount.subtract(BigDecimal.valueOf(50))).intValue();
        }
        return rewardPoints;

    }
    public List<Customer> calculateRewardsForCustomer( int customerId) {
        Map<Integer, Integer> customerRewards = new HashMap<>();

        // Calculate rewards for the specified customer
        for (Transaction transaction : transactions) {
            if (transaction.getCustomerId()==customerId) {
                LocalDate purchaseDate = transaction.getPurchaseDate();
                BigDecimal purchaseAmount = transaction.getPurchaseAmount();

                int rewardPoints = calculateRewardPoints(purchaseAmount);
                int month = purchaseDate.getMonthValue();

                customerRewards.merge(month, rewardPoints, Integer::sum);
            }
        }

        // Convert the map to a list of CustomerReward objects
        List<Customer> result = new ArrayList<>();
        customerRewards.forEach((month, rewardPoints) -> {
            result.add(new Customer(Month.of(month), rewardPoints));
        });

        return result;
    }


    public List<Customer> calculateRewards()  {
        // Group transactions by customer ID and month

        Map<Integer, Map<Month, List<Transaction>>> groupedTransactions = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCustomerId,
                        Collectors.groupingBy(transaction -> transaction.getPurchaseDate().getMonth())));

        // Calculate reward points for each customer per month and total
        List<Customer> customerRewards = new ArrayList<>();
        groupedTransactions.forEach((customerId, monthlyTransactions) -> {
            monthlyTransactions.forEach((month, monthTransactions) -> {
                int totalRewardPoints = monthTransactions.stream()
                        .map(transaction -> calculateRewardPoints(transaction.getPurchaseAmount()))
                        .mapToInt(Integer::intValue)
                        .sum();

                customerRewards.add(new Customer(customerId, month, totalRewardPoints));
            });
        });

        return customerRewards;
    }



}
