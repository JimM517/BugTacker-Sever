package com.bugtracker.controller;

import com.bugtracker.model.BugList;
import com.bugtracker.service.BugTrackerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@CrossOrigin
public class BugListController {

   private final BugTrackerService bugTrackerService;

   public BugListController(BugTrackerService bugTrackerService) {
       this.bugTrackerService = bugTrackerService;
   }


    //TODO JULY 29 JUST CHECKING IF THESE ENDPOINTS WORK, WILL REFACTOR ONCE BUSINESS LOGIC IS IN PLACE
    @GetMapping("/bugs")
    public BugList listAllBugs(Principal principal) {
        return bugTrackerService.showCurrentListByUser(principal);
    }

//    @GetMapping("/bugs/{userId}")
//    public List<Users> findUsersOnCurrentIssue(@PathVariable int userId) {
//        return jdbcBugListDao.getUsersOnCurrentBuglist(userId);
//    }




}
