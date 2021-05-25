package ecma.ai.transferapp.controller;

import ecma.ai.transferapp.entity.Outcome;
import ecma.ai.transferapp.payload.ApiResponse;
import ecma.ai.transferapp.payload.OutcomeDto;
import ecma.ai.transferapp.service.OutcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/outcome")
public class OutcomeController {

    @Autowired
    OutcomeService outcomeService;

    @GetMapping
    public ResponseEntity<?> getAll(HttpServletRequest httpServletRequest){
        Collection<Outcome> all = outcomeService.getAll(httpServletRequest);
        return ResponseEntity.ok(all);
    }

    @PostMapping
    public HttpEntity<?> add(@RequestBody OutcomeDto outcomeDto, HttpServletRequest httpServletRequest) {

        ApiResponse response = outcomeService.add(outcomeDto, httpServletRequest);
        return ResponseEntity.status(response.isSuccess() ? 200 : 409).body(response);

    }
}
