package com.GerenciamentoTributario.views.services;

import com.GerenciamentoTributario.models.dto.IptuDTO;
import com.GerenciamentoTributario.models.entity.IptuEntity;
import com.GerenciamentoTributario.models.entity.TributoEntity;
import com.GerenciamentoTributario.views.repository.IptuRepository;
import com.GerenciamentoTributario.views.repository.TributoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IptuService extends TributoService {

    @Autowired
    private TributoRepository tributoRepository;
    @Autowired
    private IptuRepository iptuRepository;

    public void addTributoIptu(IptuDTO iptuDTO) {

    }

}
