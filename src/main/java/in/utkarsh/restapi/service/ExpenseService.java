package in.utkarsh.restapi.service;

import in.utkarsh.restapi.dto.ExpenseDTO;

import java.util.List;

public interface ExpenseService {
    List<ExpenseDTO> getAllExpenses();
}
