# Overview #
This project provides a 'service' for testing an implementation of the Circuit Breaker pattern as described in the book "ReleaseIt!"
by the pragmatic programmers: [http://pragprog.com/book/mnee/release-it] http://pragprog.com/book/mnee/release-it

The relevant extract from the book describing the pattern as a PDF is in the docs folder.

# Functionality ##
The service object provides a method called serviceCall that 75% of the time returns true (to denote success), and 
the remaining 25% of the time false, to denote failure.

Service has a constructor that allows the limit to be set as an Integer, so 75% of this limit the calls succeed, the 
following  25% fail.

Unit tests show examples of how to use it.  There is also a concurrent unit test to show this is thread safe.

#Circuit Breaker#
Based roughly on the following logic:

    When Circuit is Closed:
    on call = pass through
    call succeeds = reset count
    call fails = count failure
    threshold reached = trip breaker. Open State
    
    when Circuit is Half-Open
    on call = pass through
    call succeeds = reset go. Close State
    call fails = trip breaker. Open State
    
    when Circuit is Open
    on call = return/fail
    on timeout = attempt reset. Half-Open State

#Links#
## theory ##
* [http://springinpractice.com/2010/07/06/annotation-based-circuit-breakers-with-spring/]http://springinpractice.com/2010/07/06/annotation-based-circuit-breakers-with-spring/
## implementations ##
* [http://code.google.com/p/jianwikis/wiki/CircuitBreakerDesignPattern]http://code.google.com/p/jianwikis/wiki/CircuitBreakerDesignPattern
* [http://www.tzavellas.com/projects/circuit-breaker/]http://www.tzavellas.com/projects/circuit-breaker/
* [https://github.com/sptz45/circuit-breaker]https://github.com/sptz45/circuit-breaker
* [http://anshu-manymoods.blogspot.co.uk/2009/10/introducing-jrugged-library-make-your.html]http://anshu-manymoods.blogspot.co.uk/2009/10/introducing-jrugged-library-make-your.html
* [http://code.google.com/p/jrugged/]http://code.google.com/p/jrugged/
* [http://en.wikipedia.org/wiki/Circuit_breaker_design_pattern]http://en.wikipedia.org/wiki/Circuit_breaker_design_pattern
