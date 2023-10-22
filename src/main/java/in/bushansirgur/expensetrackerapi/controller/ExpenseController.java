package in.bushansirgur.expensetrackerapi.controller;

import in.bushansirgur.expensetrackerapi.entity.Expense;
import in.bushansirgur.expensetrackerapi.service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping(value = "/expenses")
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping(value = "/expenses/{id}")
    public Expense getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }

    @DeleteMapping(value = "/expenses")
    public void deleteExpenseById(@RequestParam Long id) {
        expenseService.deleteExpenseById(id);
    }

    @PostMapping(value = "/expenses")
    public Expense saveExpenseDetails(@RequestBody Expense expense) {
        return expenseService.saveExpenseDetails(expense);
    }

}
