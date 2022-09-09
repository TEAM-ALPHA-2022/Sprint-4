package com.Sprint3.sprint3.service;

import com.Sprint3.sprint3.entities.Enterprise;
import com.Sprint3.sprint3.repository.EnterpriseRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EnterpriseService {

    @Autowired
    EnterpriseRepository enterpriseRepository;

    public void CreateAndUpdateEnterprise(Enterprise enterprise){
        //Guardar
        enterpriseRepository.save(enterprise);
    }

    public List<Enterprise> seeEnterprises(){
        List<Enterprise> enterprises = new ArrayList<Enterprise>();
        enterprises.addAll(enterpriseRepository.findAll());
        return enterprises;
    }

    public Enterprise seeEntrepiseId(long id){
        Enterprise enterpriseFound = enterpriseRepository.findById(id).get();

        if (enterpriseFound != null){
            return enterpriseFound;
        } else {
            return null;
        }
    }

    public void deleteEnterprise(Long id){
        enterpriseRepository.deleteById(id);
    }


    public void updateEnterprise(long id, Map<Object, Object> dataToUpdate){
        Enterprise enterpriseFound = seeEntrepiseId(id);

        dataToUpdate.forEach((clave, valor) -> {
            Field campo = ReflectionUtils.findField(Enterprise.class, (String) clave);
            campo.setAccessible(true);
            ReflectionUtils.setField(campo, enterpriseFound, valor);
        });

        enterpriseRepository.save(enterpriseFound);
    }


}
