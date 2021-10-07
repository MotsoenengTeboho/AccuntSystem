package za.ac.nwu.ac.domain.dto;

import org.junit.Test;

import static org.junit.Assert.*;

public class MemberTypeDtoTest {

    @Test
    public void getMnemonic() {
        MemberTypeDto memberTypeDto = new MemberTypeDto();
        assertNull(memberTypeDto.getMnemonic());
    }
}