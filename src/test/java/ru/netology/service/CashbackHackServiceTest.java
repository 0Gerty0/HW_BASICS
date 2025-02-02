package ru.netology.service;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CashbackHackServiceTest {

    private final CashbackHackService service = new CashbackHackService();

    @DataProvider(name = "amounts")
    public Object[][] amounts() {
        return new Object[][] {
                { 0,    1000 },  // корректное поведение: 0 -> 1000 (подсказка – докупить на 1000)
                { 1500, 500  },
                { 1100, 900  },
                { 999,  1    },
                { 1000, 0    }   // ожидается 0, но сервис возвращает 1000 → тест упадёт
        };
    }

    @Test(dataProvider = "amounts")
    public void shouldReturnCorrectRemain(int amount, int expected) {
        int actual = service.remain(amount);
        Assert.assertEquals(actual, expected, "Ошибка при amount = " + amount);
    }
}
