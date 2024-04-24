package br.com.samuel.gestao_vagas.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.samuel.gestao_vagas.exceptions.UserAlreadyExistis;
import br.com.samuel.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.samuel.gestao_vagas.modules.candidate.CandidateRepository;

@Service
public class CreateCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepository;
    
    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail()).ifPresent((user) -> {
            throw new UserAlreadyExistis();
        });;

       return this.candidateRepository.save(candidateEntity);
    }
}
