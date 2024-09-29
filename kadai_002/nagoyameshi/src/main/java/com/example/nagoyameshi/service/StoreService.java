package com.example.nagoyameshi.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.nagoyameshi.entity.Store;
import com.example.nagoyameshi.form.StoreEditForm;
import com.example.nagoyameshi.form.StoreRegisterForm;
import com.example.nagoyameshi.repository.StoreRepository;

@Service
public class StoreService {
    private final StoreRepository storeRepository;    
    
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;        
    }    
    
    @Transactional
    public void create(StoreRegisterForm storeRegisterForm) {
        Store store = new Store();        
        MultipartFile imageFile = storeRegisterForm.getImageFile();
        
        if (!imageFile.isEmpty()) {
            String imageName = imageFile.getOriginalFilename(); 
            String hashedImageName = generateNewFileName(imageName);
            Path filePath = Paths.get("src/main/resources/static/storage/" + hashedImageName);
            copyImageFile(imageFile, filePath);
            store.setImageName(hashedImageName);
        }
        
        store.setName(storeRegisterForm.getName());                
        store.setDescription(storeRegisterForm.getDescription());
        store.setPriceLow(storeRegisterForm.getPrice_low());
        store.setPrice_high(storeRegisterForm.getPrice_high());
        store.setBusinesshours_open(storeRegisterForm.getBusinesshours_open());
        store.setBusinesshours_close(storeRegisterForm.getBusinesshours_close());
        store.setPostalCode(storeRegisterForm.getPostalCode());
        store.setAddress(storeRegisterForm.getAddress());
        store.setPhoneNumber(storeRegisterForm.getPhoneNumber());
        store.setRegularholiday(storeRegisterForm.getRegularHoliday());
        
        storeRepository.save(store);
    }  
    @Transactional
    public void update(StoreEditForm storeEditForm) {
        Store store = storeRepository.getReferenceById(storeEditForm.getId());
        MultipartFile imageFile = storeEditForm.getImageFile();
        
        if (!imageFile.isEmpty()) {
            String imageName = imageFile.getOriginalFilename(); 
            String hashedImageName = generateNewFileName(imageName);
            Path filePath = Paths.get("src/main/resources/static/storage/" + hashedImageName);
            copyImageFile(imageFile, filePath);
            store.setImageName(hashedImageName);
        }
        
        store.setName(storeEditForm.getName());                
        store.setDescription(storeEditForm.getDescription());
        store.setPriceLow(storeEditForm.getPrice_low());
        store.setPrice_high(storeEditForm.getPrice_high());
        store.setBusinesshours_open(storeEditForm.getBusinesshours_open());
        store.setBusinesshours_close(storeEditForm.getBusinesshours_close());
        store.setPostalCode(storeEditForm.getPostalCode());
        store.setAddress(storeEditForm.getAddress());
        store.setPhoneNumber(storeEditForm.getPhoneNumber());
        store.setRegularholiday(storeEditForm.getRegularholiday());
                    
        storeRepository.save(store);
    }        
    // UUIDを使って生成したファイル名を返す
    public String generateNewFileName(String fileName) {
        String[] fileNames = fileName.split("\\.");                
        for (int i = 0; i < fileNames.length - 1; i++) {
            fileNames[i] = UUID.randomUUID().toString();            
        }
        String hashedFileName = String.join(".", fileNames);
        return hashedFileName;
    }     
    
    // 画像ファイルを指定したファイルにコピーする
    public void copyImageFile(MultipartFile imageFile, Path filePath) {           
        try {
            Files.copy(imageFile.getInputStream(), filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }          
    } 
}
