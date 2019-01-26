package com.testing.springboot.model;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(AgeCalculatorUtil.class)
public class AgeCalculatorUtilTests {

    private AgeCalculatorUtil ageCalculatorUtil;

    /**
     * Init setup before the each test load.
     */
    @Before
    public void setUp() {
        ageCalculatorUtil = PowerMockito.mock(AgeCalculatorUtil.class);
    }

    @Test
    public void testCalculateAge() {
        String dob = "1960-12-01";
        LocalDate currentDate = LocalDate.parse("1990-01-01");
        LocalDate date = LocalDate.parse(dob);

        PowerMockito.mockStatic(LocalDate.class);
        when(LocalDate.parse(dob)).thenReturn(date);
        when(LocalDate.now()).thenReturn(currentDate);
        assertEquals(ageCalculatorUtil.calculateAge(dob), 29);
    }

    @Test
    public void testCalculateAge2() {
        String dob = "1911-03-01";
        LocalDate currentDate = LocalDate.parse("1994-01-01");
        LocalDate date = LocalDate.parse(dob);

        PowerMockito.mockStatic(LocalDate.class);
        when(LocalDate.parse(dob)).thenReturn(date);
        when(LocalDate.now()).thenReturn(currentDate);
        assertEquals(ageCalculatorUtil.calculateAge(dob), 82);
    }

    @Test
    public void testCalculateAge3() {
        String dob = "1991-05-25";
        LocalDate currentDate = LocalDate.parse("2018-07-01");
        LocalDate date = LocalDate.parse(dob);

        PowerMockito.mockStatic(LocalDate.class);
        when(LocalDate.parse(dob)).thenReturn(date);
        when(LocalDate.now()).thenReturn(currentDate);
        assertEquals(ageCalculatorUtil.calculateAge(dob), 27);
    }
}

