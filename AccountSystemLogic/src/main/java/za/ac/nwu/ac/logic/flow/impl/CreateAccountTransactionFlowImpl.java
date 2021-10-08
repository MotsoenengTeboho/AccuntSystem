package za.ac.nwu.ac.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.ac.logic.flow.FetchMemberTypeFlow;

import javax.transaction.Transactional;

@Transactional
@Component
public class CreateAccountTransactionFlowImpl implements CreateAccountTransactionFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountTransactionFlowImpl.class);

    private final FetchMemberTypeFlow fetchMemberTypeFlow;

    public CreateAccountTransactionFlowImpl(FetchMemberTypeFlow fetchMemberTypeFlow) {
        this.fetchMemberTypeFlow = fetchMemberTypeFlow;
    }

    public AccountTransactionDto create(AccountTransactionDto accountTransactionDto){
        LOGGER.info("The input objects was {}", accountTransactionDto, accountTransactionDto.getDetails());

        accountTransactionDto.setTransactionId(null);

        return new AccountTransactionDto();
    }
}
