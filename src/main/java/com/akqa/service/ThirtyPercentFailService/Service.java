
package com.akqa.service.ThirtyPercentFailService;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * A 'Service' returns true 3/4 of the time to indicate success, and false 1/3 of the time in order to demonstrate
 * failure
 * 
 * @author Christopher.Barham@AKQA.com
 * @since 21 August 2012
 * 
 */
public class Service {
    static final int DEFAULT_LIMIT = 100000;
    AtomicInteger counter;
    int limit;
    int threeQuartersOfLimit;

    public Service() {
        this(DEFAULT_LIMIT);
    }

    public Service(int limit) {
        super();
        this.limit = limit;
        threeQuartersOfLimit = (int) (0.75 * limit);
        counter = new AtomicInteger();
    }

    public boolean serviceCall() {
            if (counter.incrementAndGet() > threeQuartersOfLimit) {
                if (counter.get() >= limit) {
                    counter.set(0);
                }
                return false;
            }
        return true;
    }
}
