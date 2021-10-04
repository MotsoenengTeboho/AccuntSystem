package za.ac.nwu.translator;

import za.ac.nwu.ac.domain.dto.MemberTypeDto;

import java.util.List;

public interface MemberTypeTranslator {
    List<MemberTypeDto> getAllMemberTypes();

    MemberTypeDto create(MemberTypeDto memberType);
}
