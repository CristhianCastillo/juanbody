package tk.juanbody.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tk.juanbody.dto.ExerciseDto;
import tk.juanbody.repository.ExerciseRepository;

@Component
public class IExerciseService implements ExerciseService {

	@Autowired
	private ExerciseRepository exerciseRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ExerciseDto> findAll() {
		List<ExerciseDto> result = new ArrayList<>();
		exerciseRepository.findAll().forEach(e -> result.add(modelMapper.map(e, ExerciseDto.class)));
		return result;
	}

}
