package com.jc897407.ShubhamEduApp;

import org.junit.Test;

import static org.junit.Assert.*;

import com.jc897407.ShubhamEduApp.model.User;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class EduGameUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
        User user = new User("Sam", "100", "1", "Unknown", "30");
        assertEquals("Sam", user.getUsername());
        assertEquals("100", user.getDuration());
        assertEquals("1", user.getLevel());
        assertEquals("Unknown", user.getDate());
        assertEquals("30", user.getScore());
    }

}