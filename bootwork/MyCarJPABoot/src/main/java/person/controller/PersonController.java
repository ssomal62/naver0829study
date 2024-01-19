package person.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import person.data.PersonDao;
import person.data.PersonDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonDao personDao;

    //추가
    @PostMapping("/person/add")
    public void insert(@RequestBody PersonDto dto) {
        System.out.println("add >>" + dto);
        personDao.insertPerson(dto);
    }

    //출력
    @GetMapping("/person/list")
    public List<PersonDto> list() {
        System.out.println("list > ");
        return personDao.getAllPersons();
    }

    @DeleteMapping("/person/delete/{pnum}")
    public void delete(@PathVariable int pnum) {
        personDao.delete(pnum);
    }
}
