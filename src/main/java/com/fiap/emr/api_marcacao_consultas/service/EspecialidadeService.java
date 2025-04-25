package com.fiap.emr.api_marcacao_consultas.service;

import com.fiap.emr.api_marcacao_consultas.repository.EspecialidadeRepository;
import org.springframework.stereotype.Service;

@Service
public class EspecialidadeService {
    private final EspecialidadeRepository especialidadeRepository;

    public EspecialidadeService(EspecialidadeRepository especialidadeRepository){
        this.especialidadeRepository = especialidadeRepository;
    }

    public List<Especialidade> listarEspecialidade(){
        return especialidadeRepository.findAll();
    }
}
