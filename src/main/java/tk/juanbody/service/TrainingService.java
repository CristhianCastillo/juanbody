package tk.juanbody.service;

import org.springframework.stereotype.Service;
import tk.juanbody.dto.TrainingDto;

import java.util.List;

@Service
public interface TrainingService {

    List<TrainingDto> findAll();

    TrainingDto findById(Long id);
}
