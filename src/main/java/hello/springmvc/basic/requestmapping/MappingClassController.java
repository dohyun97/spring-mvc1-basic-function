package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/mapping/users")
@RestController
public class MappingClassController {
    @GetMapping
    public String users(){
        return "get users";
    }

    @PostMapping
    public String addUser(){
        return "post user";
    }

    @GetMapping("/{userId}")
    public String findUser(@PathVariable int userId){
        return "get userId = "+userId;
    }

    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable int userId){
        return "update userId = "+userId;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable int userId){
        return "Delete userId = "+userId;
    }
}
