package com.jobhunt.api.service;

import com.jobhunt.api.entity.HR;
import com.jobhunt.api.repository.HRRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class HRServiceImpl implements HRService{

    @Autowired
    private HRRepository hrRepository;

    @Override
    public List<HR> getAllHr(){

        return hrRepository.findAll();
    }


    @Override
    public HR newHr(HR hr){
        return hrRepository.save(hr);
    }

    @Override
    public HR update(HR hr){
        Optional<HR> optional = hrRepository.findById(hr.getHrId());
        if (optional.isPresent()){
            return hrRepository.save(hr);
        }
        throw new RuntimeException("Hr not updated");
    }

    @Override
    public HR deleteById(Long id){
        Optional<HR> optional = hrRepository.findById(id);
        if (optional.isPresent()){
            hrRepository.deleteById(id);
            return null;
        }
        throw new RuntimeException("Hr not deleted");
    }

    @Override
    public HR findByHrEmailId(String emailId){
        Optional<HR> optional = Optional.ofNullable(hrRepository.findByEmailId(emailId));
        if (optional.isPresent()){
            return optional.get();
        }
        throw new RuntimeException("EmailId not matched");
    }

    @Override
    public Optional<HR> getHrById(Long hrId){
        log.info("Hr found"+hrId);
        return hrRepository.findById(hrId);
    }
}
