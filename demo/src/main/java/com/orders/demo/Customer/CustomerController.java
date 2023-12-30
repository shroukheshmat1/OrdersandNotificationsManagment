package com.orders.demo.Customer;
import com.orders.demo.models.Response.LoginResponse;
import com.orders.demo.models.Response.Response;
import com.orders.demo.Customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/check")
    public ResponseEntity<LoginResponse> checkUser(@RequestParam String email, @RequestParam String password) {
        // Perform login
        int customerID = customerService.login(email, password).getCustomerId();
        if (customerID != -1) {
            return ResponseEntity.ok(new LoginResponse(true, "Login successful", customerID));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse(false, "Invalid credentials"));
    }

    @PostMapping("/signup")
    public ResponseEntity<Response> signup(@RequestBody Customer c)

     {
        // Perform signup
        boolean success = customerService.signup(c.getName(),c.getEmail(), c.getPassword(), c.getBalance());
        if (success) {
            return ResponseEntity.ok(new Response(true, "Signup successful"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(false, "User already exists"));
    }
}
