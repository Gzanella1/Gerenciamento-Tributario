package com.GerenciamentoTributario.views.services;

import com.GerenciamentoTributario.models.dto.ContribuinteDTO;
import com.GerenciamentoTributario.models.dto.ImovelDTO;
import com.GerenciamentoTributario.models.entity.ContribuinteEntity;
import com.GerenciamentoTributario.models.entity.ImovelEntity;
import com.GerenciamentoTributario.views.repository.ContribuinteRepository;
import com.GerenciamentoTributario.views.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    @Autowired
    private ContribuinteRepository contribuinteRepository;

    public void cadastroImovel(ImovelDTO imovelDTO) {
        ContribuinteEntity proprietario = contribuinteRepository.findByCodigoContribuinte(imovelDTO.getProprietario().getCodigoContribuinte());
        ImovelEntity imovel = ImovelEntity.builder()
                .codigoImovel(imovelDTO.getCodigoImovel())
                .dataInscricao(imovelDTO.getDataInscricao())
                .area(imovelDTO.getArea())
                .valorVenal(imovelDTO.getValorVenal())
                .proprietario(proprietario)
                .tipoImovel(imovelDTO.getTipoImovel())
                .build();
        imovelRepository.save(imovel);
    }


    public List<ImovelDTO> buscarImoveisOrdenadosPorCodigo() {
        return imovelRepository.findAllByOrderByCodigoImovel().stream().map(imovelE -> {
            ImovelDTO imovelDTO = new ImovelDTO();
            imovelDTO.setCodigoImovel(imovelE.getCodigoImovel());
            imovelDTO.setDataInscricao(imovelE.getDataInscricao());
            imovelDTO.setArea(imovelE.getArea());
            imovelDTO.setValorVenal(imovelE.getValorVenal());
            imovelDTO.setTipoImovel(imovelE.getTipoImovel());
            return imovelDTO;
        }).collect(Collectors.toList());
    }

    //Decidi colocar o set<ImovelDTO> pois ele não permite elementos duplicados
    public Set<ImovelDTO> buscarImoveisPorContribuinte(String codigoContribuinte) {
        //Fiz parecido com o que a Je me ensinou
        //Busca um objeto contribuinte caso o codigo corresponde ao codigoContribuinte que é passado por parametro
        ContribuinteEntity contribuinte = contribuinteRepository.findByCodigoContribuinte(codigoContribuinte);
        //pensei em faze esse if pq ele pode colocar um codigo de um contribuinte que não existe
        if (contribuinte != null) {
            //busca um imovel caso o proprietario corresponde ao contribuinte
            List<ImovelEntity> imoveisDoContribuinte = imovelRepository.findByProprietario(contribuinte);
            Set<ImovelDTO> imoveisDTO = imoveisDoContribuinte.stream().map(cE -> {
                //Não sei se esse codigo esta legal, tentei fazer com o Build
                //Funciona
                ImovelDTO imDto = new ImovelDTO();
                imDto.setCodigoImovel(cE.getCodigoImovel());
                imDto.setDataInscricao(LocalDateTime.parse(cE.getDataInscricao()
                                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                        DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
                imDto.setArea(cE.getArea());
                imDto.setValorVenal(cE.getValorVenal());
                imDto.setTipoImovel(cE.getTipoImovel());
                //imDto.setProprietario();
                return imDto;
            }).collect(Collectors.toSet());

            return imoveisDTO;
        } else {
            // Lida com o caso em que o contribuinte não foi encontrado
            return Collections.emptySet();
        }
    }
}


