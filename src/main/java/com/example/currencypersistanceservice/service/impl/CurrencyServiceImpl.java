package com.example.currencypersistanceservice.service.impl;


import com.example.currencypersistanceservice.model.CurrencyInfoDto;
import com.example.currencypersistanceservice.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    @Override
    public void loadCurrencies(){

    }
    @Override
    public void save(CurrencyInfoDto currencyInfoDto) {


//        public TeacherDto save(CreateTeacherCommand command){
//            Teacher toSave = command.toEntity();
//            Teacher saved = teacherRepository.save(toSave);
//            return TeacherDto.fromEntity(saved);
//        }
    }
}
