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
    public String getExpenseById(@PathVariable Long id) {
        return "The expense id is " + id;
    }

    @DeleteMapping("/expenses")
    public String deleteExpenseById(@RequestParam Long id) {
        return "Delete the expense object by its id " + id;
    }

}
