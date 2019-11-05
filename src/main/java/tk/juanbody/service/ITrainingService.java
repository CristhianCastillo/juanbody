package tk.juanbody.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.juanbody.dto.TrainingDto;
import tk.juanbody.model.TrainingEntity;
import tk.juanbody.repository.TrainingRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class ITrainingService implements TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public List<TrainingDto> findAll() {
        List<TrainingDto> result = new ArrayList<>();
        trainingRepository.findAll().forEach(e -> result.add(modelMapper.map(e, TrainingDto.class)));
        return result;
    }

    @Override
    public TrainingDto findById(Long id) {
        TrainingEntity trainingEntity = trainingRepository.findById(id).get();
        if (trainingEntity.getId() != null) {
            return modelMapper.map(trainingEntity, TrainingDto.class);
        } else return null;
    }
}
