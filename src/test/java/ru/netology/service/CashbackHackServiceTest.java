package ru.netology.service;

import org.junit.Assert;
import org.junit.Test;

public class CashbackHackServiceTest {

    private final CashbackHackService service = new CashbackHackService();

    @Test
    public void shouldReturnCorrectRemain() {

        Assert.assertEquals("Error with amount = 0", 1000, service.remain(0));
        Assert.assertEquals("Error with amount = 1500", 500, service.remain(1500));
        Assert.assertEquals("Error with amount = 1100", 900, service.remain(1100));
        Assert.assertEquals("Error with amount = 999", 1, service.remain(999));
        Assert.assertEquals("Error with amount = 1000", 0, service.remain(1000));
    }
}
