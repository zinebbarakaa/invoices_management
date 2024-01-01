package com.fsts.gestion_factures.service.serviceImpl;

import com.fsts.gestion_factures.model.request.CommandeRequest;
import com.fsts.gestion_factures.model.response.CommandeResponse;
import com.fsts.gestion_factures.repository.CommandeRepository;
import com.fsts.gestion_factures.service.CommandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommandeServiceImpl implements CommandeService {
    private final CommandeRepository commandeRepository;

    @Override
    public CommandeResponse add(CommandeRequest request) {
        return null;
    }

    @Override
    public List<CommandeResponse> get() {
        return null;
    }

    @Override
    public CommandeResponse update(CommandeRequest request, Long aLong) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public CommandeResponse get(Long aLong) {
        return null;
    }
}
