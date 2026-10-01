package br.com.etechoracio.academia.service;

import br.com.etechoracio.academia.DTO.ExercicioFisicoResponseDTO; 
import br.com.etechoracio.academia.repository.ExercicioFisicoRepository; 
import br.com.etechoracio.academia.mapper.ExercicioFisicoMapper;
import br.com.etechoracio.academia.entity.ExercicioFisico; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExercicioFisicoService {

    @Autowired
    private ExercicioFisicoRepository repository;

    @Autowired
    private ExercicioFisicoMapper mapper;

    public List<ExercicioFisicoResponseDTO> listarAprovados() {
        List<ExercicioFisico> exerciciosAprovados = repository.findByAprovadoTrue();
        return mapper.toResponseDTOList(exerciciosAprovados);
    }

    public ExercicioFisicoResponseDTO buscarPorId(Long id) {
        return repository.findByIdAndAprovadoTrue(id)
                .map(mapper::toResponseDTO)
                .orElse((null));
    }
}
