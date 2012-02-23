package ch.demo.business.service;

import javax.inject.Inject;

import org.junit.runner.RunWith;

import ch.demo.helper.WeldJUnit4Runner;

/**
 * Test the student service mock implementation.
 * 
 * @author hostettler
 */
@RunWith(WeldJUnit4Runner.class)
public class RestStudentServiceImplTest extends AbstractStudentServiceImplTest {

    /** Service retrieved by the Weld container. */
    @Inject
    @RestImpl
    private StudentService mService;

    @Override
    protected StudentService getService() {
        return mService;
    }
}
