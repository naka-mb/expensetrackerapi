package in.bushansirgur.expensetrackerapi.service;

import in.bushansirgur.expensetrackerapi.entity.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> getAllExpenses();
}
