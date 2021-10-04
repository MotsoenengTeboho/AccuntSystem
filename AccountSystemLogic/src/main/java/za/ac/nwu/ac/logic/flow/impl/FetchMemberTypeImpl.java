package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MemberTypeDto;
import za.ac.nwu.ac.logic.flow.FetchMemberTypeFlow;
import za.ac.nwu.translator.MemberTypeTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchMemberTypeImpl implements FetchMemberTypeFlow{
    private final MemberTypeTranslator memberTypeTranslator;

    @Autowired
    public FetchMemberTypeImpl(MemberTypeTranslator memberTypeTranslator) {
        this.memberTypeTranslator = memberTypeTranslator;
    }


    public List<MemberTypeDto> getAllMemberTypes() {
        return memberTypeTranslator.getAllMemberTypes();
    }
}
