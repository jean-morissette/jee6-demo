/**
 * 
 */
package ch.demo.helper;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

/**
 * Helper class that injects the dependencies into the test class
 * using weld.
 * @author hostettler
 * Taken from http://objectopia.com/2011/05/29/weld-junit-4-runner/.
 */
public class WeldJUnit4Runner extends BlockJUnit4ClassRunner {

    /** The test class to run. */
    private final Class<?> mKlass;
    /** Weld infrastructure. */
    private final Weld weld;
    /** The container itself. */
    private final WeldContainer container;

    /**
     * Runs the class passed as a parameter within the container.
     * @param klass to run
     * @throws InitializationError if anything goes wrong.
     */
    public WeldJUnit4Runner(final Class<Object> klass) throws InitializationError {
        super(klass);
        this.mKlass = klass;
        this.weld = new Weld();
        this.container = weld.initialize();
    }

    
    @Override
    protected Object createTest() throws Exception {
        final Object test = container.instance().select(mKlass).get();
        return test;
    }
}
