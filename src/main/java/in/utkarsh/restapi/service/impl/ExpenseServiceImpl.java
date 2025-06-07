package in.utkarsh.restapi.service.impl;

import in.utkarsh.restapi.dto.ExpenseDTO;
import in.utkarsh.restapi.entity.ExpenseEntity;
import in.utkarsh.restapi.repository.ExpenseRepository;
import in.utkarsh.restapi.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<ExpenseDTO> getAllExpenses() {

        List <ExpenseEntity> list = expenseRepository.findAll();

        List <ExpenseDTO> listOfExpenses = list.stream().map(expenseEntity -> mapToExpenseDTO(expenseEntity)).collect(Collectors.toList());
        
        return listOfExpenses;
    }

    private ExpenseDTO mapToExpenseDTO(ExpenseEntity expenseEntity) {
        return modelMapper.map(expenseEntity, ExpenseDTO.class);
    }
}
