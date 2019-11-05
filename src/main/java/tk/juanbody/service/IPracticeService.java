package tk.juanbody.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.juanbody.dto.PracticeDto;
import tk.juanbody.model.PracticeEntity;
import tk.juanbody.repository.PracticeRepository;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class IPracticeService implements PracticeService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PracticeRepository practiceRepository;

    @Override
    @Transactional
    public PracticeDto save(PracticeDto practiceDto) {
        return modelMapper.map(practiceRepository.save(modelMapper.map(practiceDto, PracticeEntity.class)), PracticeDto.class);
    }

    @Override
    @Transactional
    public List<PracticeDto> findBuUserId(Long id) {
        return null;
    }
}
