package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FetchMemberTypeImplTest {
    private FetchMemberTypeImpl classToTest;

    @Before
    public void setUp() throws Exception {
        classToTest = new FetchMemberTypeImpl(null);
    }

    @After
    public void tearDown() throws Exception {
        classToTest = null;
    }

    @Test
    public void methodToTest() {
        assertTrue(classToTest.methodToTest());
    }
}