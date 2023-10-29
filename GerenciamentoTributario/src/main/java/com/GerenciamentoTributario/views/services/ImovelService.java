package com.GerenciamentoTributario.views.services;

import com.GerenciamentoTributario.models.dto.ImovelDTO;
import com.GerenciamentoTributario.models.entity.ImovelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    public void cadastroImovel(ImovelDTO imovelDTO){
        ImovelEntity novoImovel=new ImovelEntity();
        novoImovel.setCodigoImovel(imovelDTO.getCodigoImovel());
        novoImovel.setArea(novoImovel.getArea());
        novoImovel.setDataInscricao(imovelDTO.getDataInscricao());
        novoImovel.setValorVenal(imovelDTO.getValorVenal());
        imovelRepository.save(novoImovel);
    }

    public void addImovel(ImovelDTO imovelDTO) {
        ImovelEntity imovel=ImovelEntity.builder()
                .codigoImovel(imovelDTO.getCodigoImovel())
                .dataInscricao(imovelDTO.getDataInscricao())
                .area(imovelDTO.getArea())
                .valorVenal(imovelDTO.getValorVenal())
                .build();
        imovelRepository.save(imovel);
    }
    public List<ImovelDTO>retornaImovel(){
      return imovelRepository.findAll().stream().map(imovelE->{
         ImovelDTO dto=new ImovelDTO();
         dto.setCodigoImovel(imovelE.getCodigoImovel());
         dto.setArea(imovelE.getArea());
         dto.setDataInscricao(imovelE.getDataInscricao());
         dto.setValorVenal(imovelE.getValorVenal());
         return dto;
      }).collect(Collectors.toList());
    }

    public List<ImovelDTO> retornaImovelOrdenado() {
        return imovelRepository.findAll()
                .stream()
                .sorted((imovel1, imovel2) -> imovel1.getCodigoImovel().compareTo(imovel2.getCodigoImovel()))
                .map(imovelE -> {
                    ImovelDTO dto = new ImovelDTO();
                    dto.setCodigoImovel(imovelE.getCodigoImovel());
                    dto.setArea(imovelE.getArea());
                    dto.setDataInscricao(imovelE.getDataInscricao());
                    dto.setValorVenal(imovelE.getValorVenal());
                    return dto;
                }).collect(Collectors.toList());
    }

}
