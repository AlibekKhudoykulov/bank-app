package ecma.ai.transferapp.controller;

import ecma.ai.transferapp.entity.Income;
import ecma.ai.transferapp.entity.Outcome;
import ecma.ai.transferapp.repository.IncomeRepository;
import ecma.ai.transferapp.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@RestController
@RequestMapping("/api/income")
public class IncomeController {
    @Autowired
    IncomeService incomeService;

    @GetMapping
    public ResponseEntity<?> getAll(HttpServletRequest httpServletRequest){
        Collection<Income> all = incomeService.getAll(httpServletRequest);
        return ResponseEntity.ok(all);
    }
}
