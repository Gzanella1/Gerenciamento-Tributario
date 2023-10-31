package com.GerenciamentoTributario.views.services;

import com.GerenciamentoTributario.models.dto.ContribuinteDTO;
import com.GerenciamentoTributario.models.dto.ImovelDTO;
import com.GerenciamentoTributario.models.entity.ContribuinteEntity;
import com.GerenciamentoTributario.models.entity.ImovelEntity;
import com.GerenciamentoTributario.views.repository.ContribuinteRepository;
import com.GerenciamentoTributario.views.repository.ImovelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
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

    public List<ImovelDTO> buscarImoveisPorContribuinte(String codigoContribuinte) {
        ContribuinteEntity contribuinte = new ContribuinteEntity();
        try {
            log.info("Executando find para encontrar contribuinte no banco de dados");
            //Busca um objeto contribuinte caso o codigo corresponde ao codigoContribuinte que é passado por parametro
            contribuinte = contribuinteRepository.findByCodigoContribuinte(codigoContribuinte);
        } catch (Exception e) {
            log.error("Contribuinte não encontrado na base de dados");
        }
        if (contribuinte != null) {
            try {
                //busca um imovel caso o proprietario corresponde ao contribuinte
                ContribuinteDTO contribuinteDTO = ContribuinteDTO.builder()
                        .codigoContribuinte(contribuinte.getCodigoContribuinte())
                        .cpf(contribuinte.getCodigoContribuinte())
                        .email(contribuinte.getEmail())
                        .nome(contribuinte.getNome())
                        .telefone(contribuinte.getTelefone())
                        .build();

                List<ImovelEntity> imoveisDoContribuinte = imovelRepository.findByProprietario(contribuinte);

                List<ImovelDTO> imoveisDTO = imoveisDoContribuinte.stream().map(cE -> {
                    ImovelDTO imDto = new ImovelDTO();
                    imDto.setCodigoImovel(cE.getCodigoImovel());
                    imDto.setDataInscricao(LocalDateTime.parse(cE.getDataInscricao()
                                    .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
                    imDto.setArea(cE.getArea());
                    imDto.setValorVenal(cE.getValorVenal());
                    imDto.setTipoImovel(cE.getTipoImovel());
                    imDto.setProprietario(contribuinteDTO);
                    return imDto;
                }).collect(Collectors.toList());

                return imoveisDTO;

            } catch (Exception e) {
                log.error("Não foi possivel encontrar imoveis no banco de dados");
            }
        } else {
            // Lida com o caso em que o contribuinte não foi encontrado
            log.info("Contribuinte não encontrado na base de dados");
            return Collections.emptyList();
        }
        return Collections.emptyList();
    }

    public List<ImovelDTO> buscarImoveisOrdenadosPorCodigo() {
        List<ImovelEntity> imovelEntities = imovelRepository.findByOrderByCodigoImovelAsc();

        return imovelEntities.stream().map(imovelE -> {

            ContribuinteEntity contribuinte = imovelE.getProprietario();
            ContribuinteDTO contribuinteDTO = new ContribuinteDTO();
            contribuinteDTO.setCodigoContribuinte(contribuinte.getCodigoContribuinte());
            contribuinteDTO.setCpf(contribuinte.getCodigoContribuinte());
            contribuinteDTO.setEmail(contribuinte.getEmail());
            contribuinteDTO.setNome(contribuinte.getNome());
            contribuinteDTO.setTelefone(contribuinte.getTelefone());

            ImovelDTO imovelDTO = new ImovelDTO();
            imovelDTO.setCodigoImovel(imovelE.getCodigoImovel());
            imovelDTO.setDataInscricao(imovelE.getDataInscricao());
            imovelDTO.setArea(imovelE.getArea());
            imovelDTO.setValorVenal(imovelE.getValorVenal());
            imovelDTO.setTipoImovel(imovelE.getTipoImovel());

            imovelDTO.setProprietario(contribuinteDTO);
            return imovelDTO;
        }).collect(Collectors.toList());
    }

}


