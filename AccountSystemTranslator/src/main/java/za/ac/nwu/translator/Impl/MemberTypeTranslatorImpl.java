package za.ac.nwu.translator.Impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MemberTypeDto;
import za.ac.nwu.ac.domain.persistence.MemberType;
import za.ac.nwu.ac.repo.persistence.MemberTypeRepository;
import za.ac.nwu.translator.MemberTypeTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemberTypeTranslatorImpl implements MemberTypeTranslator {

    private final MemberTypeRepository memberTypeRepository;

    public MemberTypeTranslatorImpl(MemberTypeRepository memberTypeRepository) {
        this.memberTypeRepository = memberTypeRepository;
    }

    @Override
    public List<MemberTypeDto> getAllMemberTypes() {
        List<MemberTypeDto> memberTypeDtos = new ArrayList<>();
        try{
            for(MemberType memberType: memberTypeRepository.findAll()){
                memberTypeDtos.add(new MemberTypeDto(memberType));
            }
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the database", e);
        }
        return memberTypeDtos;
    }

    public MemberTypeDto create(MemberTypeDto memberTypeDto){
        try {
            MemberType memberType = memberTypeRepository.save(memberTypeDto.getMemberType());
            return new MemberTypeDto(memberType);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to the Database", e);
        }
    }
}
