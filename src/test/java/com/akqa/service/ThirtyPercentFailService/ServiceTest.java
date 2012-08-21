
package com.akqa.service.ThirtyPercentFailService;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

/**
 * Junit test
 * 
 * @author Christopher.Barham@AKQA.com
 * @since 21 August 2012
 */

public class ServiceTest {

    private Service service;

    @Before
    public void setUp() throws Exception {
        service = new Service();
    }

    @Test
    public void testFour() {
        service = new Service(3);
        assertThat("first call should be true", service.serviceCall(), is(true));
        assertThat("second call should be true", service.serviceCall(), is(true));
        assertThat("third call should be false", service.serviceCall(), is(false));
        assertThat("fourth call should be true", service.serviceCall(), is(true));
    }

    @Test
    public void testLots() {
        int limit = 1000;
        int passed = 0;
        int failed = 0;

        service = new Service(limit);
        for (int i = 0; i < 2 * limit; i++) {
            if (service.serviceCall()) {
                passed++;
            } else {
                failed++;
            }
        }
        assertThat(passed,is(1500));
        assertThat(failed,is(500));
    }
}
