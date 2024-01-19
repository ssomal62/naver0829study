package guest.data;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class GuestDao {


    private GuestRepository guestRepository;

    public void addGuest(GuestDto dto) {
        guestRepository.save(dto);
    }

    public List<GuestDto> getAllGuests() {
        return guestRepository.findAll(Sort.by(Sort.Direction.DESC,"gnum"));
    }

    public void deleteGuest(int gnum) {
        guestRepository.deleteById(gnum);
    }
}
