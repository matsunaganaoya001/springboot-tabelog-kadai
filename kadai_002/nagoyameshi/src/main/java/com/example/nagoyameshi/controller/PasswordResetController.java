//package com.example.nagoyameshi.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.nagoyameshi.repository.UserRepository;
//
//@RestController
//@RequestMapping("/api/password-reset")
//public class PasswordResetController {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PasswordResetTokenRepository passwordResetTokenRepository;
//
//    @Autowired
//    private EmailService emailService;
//
//    @PostMapping("/request")
//    public ResponseEntity<?> requestPasswordReset(@RequestParam("email") String email) {
//        // メールアドレスの検証
//        User user = userRepository.findByEmail(email);
//        if (user == null) {
//            return ResponseEntity.badRequest().body("無効なメールアドレスです。");
//        }
//
//        // トークンの生成と保存
//        PasswordResetToken token = new PasswordResetToken(user);
//        passwordResetTokenRepository.save(token);
//
//        // パスワードリセットリンクの送信
//        String resetLink = "https://yourdomain.com/reset-password?token=" + token.getToken();
//        emailService.sendPasswordResetEmail(user.getEmail(), resetLink);
//
//        return ResponseEntity.ok("パスワードリセットリンクを送信しました。");
//    }	
//}
