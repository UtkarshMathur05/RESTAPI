package in.utkarsh.restapi.controller;

import in.utkarsh.restapi.dto.ExpenseDTO;
import in.utkarsh.restapi.io.ExpenseResponse;
import in.utkarsh.restapi.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
public class ExpenseController {
    private final ExpenseService expenseService;
    private final ModelMapper modelMapper;

    @GetMapping("/expenses")
    public List getExpenses(){
        //Call the service Method
        List<ExpenseDTO> list = expenseService.getAllExpenses();

        //Convert DTO to Expense Response
        List<ExpenseResponse> response= list.stream().map(expenseDTO-> mapToExpenseResponse(expenseDTO)).collect(Collectors.toList());

        //Return the list
        return response;
    }

    private ExpenseResponse mapToExpenseResponse(ExpenseDTO expenseDTO) {
        return modelMapper.map(expenseDTO, ExpenseResponse.class);
    }
}
