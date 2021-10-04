package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.MemberTypeDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.FetchMemberTypeFlow;
import za.ac.nwu.translator.CreateMemberTypeFlow;

import java.util.List;

@RestController
@RequestMapping("account-type")
public class DemoController {

    private final FetchMemberTypeFlow fetchMemberTypeFlow;
    private final CreateMemberTypeFlow createMemberTypeFlow;

    @Autowired
    public DemoController(FetchMemberTypeFlow fetchMemberTypeFlow, @Qualifier("createAccountTypeFlowName") CreateMemberTypeFlow createMemberTypeFlow){
        this.fetchMemberTypeFlow = fetchMemberTypeFlow;
        this.createMemberTypeFlow = createMemberTypeFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Account types", notes = "Returns a list of account types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account types returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<MemberTypeDto>>> getAll() {
        List<MemberTypeDto> memberTypes =FetchMemberTypeFlow.getAllMemberTypes();
        GeneralResponse<List<MemberTypeDto>> response = new GeneralResponse<>(true, memberTypes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new AccountType for Member.", notes = "Creates a new AcccountType in Database.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The account type for member has been created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class),

    })
    public ResponseEntity<GeneralResponse<MemberTypeDto>> create(@ApiParam(value = "Request to create a new Account type for Member.", required = true)
                                                                 @RequestBody MemberTypeDto memberType){
        MemberTypeDto memberTypeResponse = createMemberTypeFlow.create(memberType);
        GeneralResponse<MemberTypeDto> response = new GeneralResponse<>(true, memberTypeResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}