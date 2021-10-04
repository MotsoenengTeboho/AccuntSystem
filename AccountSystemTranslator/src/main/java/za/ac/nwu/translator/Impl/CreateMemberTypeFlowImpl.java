package za.ac.nwu.translator.Impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MemberTypeDto;
import za.ac.nwu.translator.CreateMemberTypeFlow;
import za.ac.nwu.translator.MemberTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createAccountTypeFlowName")
public class CreateMemberTypeFlowImpl implements CreateMemberTypeFlow{
    private final MemberTypeTranslator memberTypeTranslator;

    public CreateMemberTypeFlowImpl(MemberTypeTranslator memberTypeTranslator) {
        this.memberTypeTranslator = memberTypeTranslator;
    }

    @Override
    public MemberTypeDto create(MemberTypeDto memberType){
        if (null == memberType.getCreationDate()){
            memberType.setCreationDate(LocalDate.now());
        }
        return memberTypeTranslator.create(memberType);
    }
}
