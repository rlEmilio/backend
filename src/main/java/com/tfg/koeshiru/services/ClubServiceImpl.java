package com.tfg.koeshiru.services;

import com.tfg.koeshiru.entities.Club;
import com.tfg.koeshiru.exceptions.ClubException;
import com.tfg.koeshiru.repositories.ClubRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClubServiceImpl implements ClubService {

    private static final Logger logger = LoggerFactory.getLogger(ClubServiceImpl.class);

    @Autowired
    private ClubRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Club> findAll() {
        try {
            logger.info("Obteniendo todos los clubes");
            return (List<Club>) repository.findAll();
        } catch (Exception e) {
            logger.error("Error al obtener los clubes: {}", e.getMessage());
            throw new ClubException("Error al obtener la lista de clubes");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Club> findById(Long id) {
        try {
            logger.info("Buscando club con ID {}", id);
            return repository.findById(id);
        } catch (Exception e) {
            logger.error("Error al buscar club con ID {}: {}", id, e.getMessage());
            throw new ClubException("Error al buscar club");
        }
    }

    @Override
    @Transactional
    public Club save(Club club) {
        try {
            logger.info("Guardando club: {}", club.getNombre());
            return repository.save(club);
        } catch (Exception e) {
            logger.error("Error al guardar club {}: {}", club.getNombre(), e.getMessage());
            throw new ClubException("Error al guardar club");
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        try {
            logger.info("Eliminando club con ID {}", id);
            repository.deleteById(id);
        } catch (Exception e) {
            logger.error("Error al eliminar club con ID {}: {}", id, e.getMessage());
            throw new ClubException("Error al eliminar club");
        }
    }
}
