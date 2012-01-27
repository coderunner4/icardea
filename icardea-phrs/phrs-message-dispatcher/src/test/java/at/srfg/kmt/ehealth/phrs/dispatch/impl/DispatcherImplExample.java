/*
 * Project :iCardea
 * File : DispatcherImplExample.java
 * Encoding : UTF-8
 * Date : Dec 21, 2011
 * User : Mihai Radulescu
 */
package at.srfg.kmt.ehealth.phrs.dispatch.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Runnable class used to start and run the
 * <code>DispatcherImpl</code>. To run this class from maven environment use :
 * <pre>
 * mvn exec:java -Dexec.mainClass=at.srfg.kmt.ehealth.phrs.dispatch.impl.DispatcherImplExample -Dexec.classpathScope=test
 * </pre> <br/>
 * This class is not design to be extended.
 *
 * @author Mihai
 * @version 0.1
 * @since 0.1
 */
public final class DispatcherImplExample {

    /**
     * The Logger instance. All log messages from this class are routed through
     * this member. The Logger name space is
     * <code>at.srfg.kmt.ehealth.phrs.dispatch.impl.DispatcherImplExample</code>.
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(DispatcherImplExample.class);

    /**
     * Don't let anybody to instantiate this class.
     */
    private DispatcherImplExample() {
        // UNIMPLEMEENTD
    }

    /**
     * Runs this class from the command line.
     *
     * @param args the command line arguments array, no arguments are required.
     */
    public static void main(String... args) {
        
        final DispatcherImpl dispatcher = new DispatcherImpl();
        final Runnable task = new Runnable() {

            @Override
            public void run() {
                System.out.println("Here it goes");
            }
        };
        dispatcher.dispatch(task);
    }
    
    public static void myMethod(final String... args) {
        
        final DispatcherImpl dispatcher = new DispatcherImpl();
        final Runnable task = new Runnable() {

            @Override
            public void run() {
                System.out.println("Here it goes");
                for (String s : args) {
                    System.out.println("--" + s);
                }
            }
            
        };
        dispatcher.dispatch(task);
    }
}
