package org.d3h.application.controllers;

import java.util.List;

import org.d3h.application.entities.User;
import org.d3h.application.exception.ResourceNotFoundException;
import org.d3h.application.payload.response.UserDetail;
import org.d3h.application.payload.response.UserIdentityAvailability;
import org.d3h.application.payload.response.UserProfile;
import org.d3h.application.payload.response.UserSummary;
import org.d3h.application.repositories.UserRepository;
import org.d3h.application.security.CurrentUser;
import org.d3h.application.security.UserPrincipal;
import org.d3h.application.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserService userService;

    //private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/user/me")
    //@PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName(), currentUser.getAuthorities());
        
        System.out.println("######### "+userSummary.toString());
        return userSummary;
    }

    @GetMapping("/user/checkUsernameAvailability")
    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
        Boolean isAvailable = !userRepository.existsByUsername(username);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/user/checkEmailAvailability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
        Boolean isAvailable = !userRepository.existsByEmail(email);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/users/{username}")
    public UserProfile getUserProfile(@PathVariable(value = "username") String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));


        UserProfile userProfile = new UserProfile(user.getId(), user.getUsername(), user.getName(), user.getCreatedAt());

        return userProfile;
    }
   
    @GetMapping("/users")
    public List<UserDetail> getUsers() {
    	return userService.getUsers();
 
    }
    
    @GetMapping("/users/logout/{username}")
    public boolean setOffline(@PathVariable String username) {
   
    	return userService.setOffline(username);
 
    }
  
}
