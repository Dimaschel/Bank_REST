//package com.example.bankcards.controller;
//
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/test")
//public class TestController {
//
//    @GetMapping("/user")
//    @PreAuthorize("hasRole('USER')")
//    public String userAccess() {
//        return "User Content";
//    }
//
//    @GetMapping("/admin")
//    @PreAuthorize("hasRole('ADMIN')")
//    public String adminAccess() {
//        return "Admin Content";
//    }
//}