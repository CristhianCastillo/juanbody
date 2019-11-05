package tk.juanbody.service;

import org.springframework.stereotype.Service;
import tk.juanbody.dto.PracticeDto;

import java.util.List;

@Service
public interface PracticeService {

    PracticeDto save(PracticeDto practiceDto);

    List<PracticeDto> findBuUserId(Long id);
}
