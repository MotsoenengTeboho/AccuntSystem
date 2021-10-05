package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MemberTypeDto;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.translator.MemberTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createAccountTypeFlowName")
public class CreateAccountTypeFlowImpl implements CreateAccountTypeFlow {
    private final MemberTypeTranslator memberTypeTranslator;

    public CreateAccountTypeFlowImpl(MemberTypeTranslator memberTypeTranslator) {
        this.memberTypeTranslator = memberTypeTranslator;
    }

    //@Override
    public MemberTypeDto create(MemberTypeDto memberType){
        if(null == memberType.getCreationDate()){
            memberType.setCreationDate(LocalDate.now());
        }
        return memberTypeTranslator.create(memberType);
    }
}
