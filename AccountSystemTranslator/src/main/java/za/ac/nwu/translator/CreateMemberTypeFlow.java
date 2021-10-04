package za.ac.nwu.translator;

import za.ac.nwu.ac.domain.dto.MemberTypeDto;

public interface CreateMemberTypeFlow {
    MemberTypeDto create(MemberTypeDto memberType);
}
