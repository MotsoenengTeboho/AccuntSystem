package za.ac.nwu.ac.logic.flow.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FetchMemberTypeImplTest {
    private FetchMemberTypeImpl testClass;

    @BeforeEach
    void setUp() {
        testClass = new FetchMemberTypeImpl(null);
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Test
    void methodToTest() {
        assert(testClass.methodToTest());
    }
}