package logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Juho
 */
public class UserTest {

    private User user;

    @Before
    public void initialize() {
        user = new User();
    }

    @Test
    public void correctCapacity() {
        assertEquals(1, user.getDailyCapacity());
    }

    @Test
    public void settingCapacityWorks() {
        user.setDailyCapacity(100);
        assertEquals(100, user.getDailyCapacity());
    }
}
