package com.WebAPIDeveloper.WebAPIDeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {
    @Autowired
    private RewardService rewardService;

    @GetMapping("/calculate")
    public List<Customer> calculateRewards() {

        return rewardService.calculateRewards();
    }
    @GetMapping("/{customerId}")
    public List<Customer> calculateRewardsForCustomer(@PathVariable int customerId) {
        return rewardService.calculateRewardsForCustomer(customerId);
    }


}
