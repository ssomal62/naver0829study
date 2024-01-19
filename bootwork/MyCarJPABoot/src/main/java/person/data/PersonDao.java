package person.data;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class PersonDao {

    private final PersonRepository personRepository;

    //추가
    public void insertPerson(PersonDto dto) {
        personRepository.save(dto);
    }

    //전체 출력
    public List<PersonDto> getAllPersons() {
        return personRepository.findAll();
    }

    public void delete(int num) {
        personRepository.deleteById(num);
    }

}
