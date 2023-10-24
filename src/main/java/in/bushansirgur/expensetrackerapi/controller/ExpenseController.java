package in.bushansirgur.expensetrackerapi.controller;

import in.bushansirgur.expensetrackerapi.entity.Expense;
import in.bushansirgur.expensetrackerapi.service.ExpenseService;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping(value = "/expenses")
    public Page<Expense> getAllExpenses(Pageable page) {
//        int number = 1;
//        calculaterFactorial(number);
        return expenseService.getAllExpenses(page);
    }

    @GetMapping(value = "/expenses/{id}")
    public Expense getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/expenses")
    public void deleteExpenseById(@RequestParam Long id) {
        expenseService.deleteExpenseById(id);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(value = "/expenses")
    public Expense saveExpenseDetails(@Valid @RequestBody Expense expense) {
        return expenseService.saveExpenseDetails(expense);
    }

    @PutMapping(value = "/expenses/{id}")
    public Expense updateExpanseDetails(@Valid @RequestBody Expense expense, @PathVariable Long id) {
        return expenseService.updateExpenseDetails(id,expense);
    }

//    public int calculaterFactorial(int number) {
//        return number * calculaterFactorial(number -1);
//    }

    @GetMapping(value = "/expenses/category")
    public List<Expense> getExpensesByCategory(@RequestParam String category,Pageable page){
        return expenseService.readByCategory(category,page);
    }


    @GetMapping(value = "/expenses/name")
    public List<Expense> getExpensesByName(@RequestParam String keyword,Pageable page){
        return expenseService.readByNameContaining(keyword,page);
    }

    @GetMapping("/expenses/date")
    public List<Expense> getExpensesByDates(@RequestParam(required = false) @DateTimeFormat(pattern= "yyyy-MM-dd") Date startDate,
                                            @RequestParam(required = false) @DateTimeFormat(pattern= "yyyy-MM-dd") Date endDate,
                                            Pageable page) {
        return expenseService.readByDate(startDate, endDate, page);
    }
}
