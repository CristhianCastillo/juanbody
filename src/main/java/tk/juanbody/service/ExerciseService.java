package tk.juanbody.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tk.juanbody.dto.ExerciseDto;

@Service
public interface ExerciseService {
	List<ExerciseDto> findAll();
}
