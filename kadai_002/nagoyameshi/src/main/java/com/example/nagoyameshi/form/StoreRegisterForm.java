package com.example.nagoyameshi.form;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class StoreRegisterForm {
    @NotBlank(message = "店舗名を入力してください。")
    private String name;
        
    private MultipartFile imageFile;
    
    @NotBlank(message = "説明を入力してください。")
    private String description;   
    
    @NotNull(message = "下限価格を入力してください。")
    @Min(value = 1, message = "下限価格は1円以上に設定してください。")
    private Integer price_low;  
    
    @NotNull(message = "上限価格を入力してください。")
    @Min(value = 1, message = "上限価格は1円以上に設定してください。")
    private Integer price_high;
    
    @NotNull(message = "開店時間を入力してください。")
    @Max(value = 24, message = "開店時間は24時間以内に設定してください。")
    private Integer businesshours_open;
    
    @NotNull(message = "閉店時間を入力してください。")
    @Max(value = 24, message = "閉店時間は24時間以内に設定してください。")
    private Integer businesshours_close;   
    
    @NotBlank(message = "郵便番号を入力してください。")
    private String postalCode;
    
    @NotBlank(message = "住所を入力してください。")
    private String address;
    
    @NotBlank(message = "電話番号を入力してください。")
    private String phoneNumber;
    
    @NotBlank(message = "定休日を入力してください。")
    private String regularHoliday;
    
    
}
