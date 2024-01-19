package guest.controller;

import guest.data.GuestDao;
import guest.data.GuestDto;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GuestController {

    private final NcpObjectStorageService storageService;

    private final GuestDao guestDao;
    private final String bucketName = "bitcamp701aiur";
    private final String folderName = "bootmyshop";
    String photo;

    @PostMapping("/guest/upload")
    public String uploadFile(@RequestParam MultipartFile upload) {
        photo = storageService.uploadFile(bucketName, folderName, upload);
        return photo;
    }

    @PostMapping("guest/insert")
    public void insert(@RequestBody GuestDto dto) {

        GuestDto setDto = GuestDto.builder()
                .content(dto.getContent())
                .nickName(dto.getNickName())
                .photo(photo)
                .build();

        guestDao.addGuest(setDto);

        photo = null;
    }

    @GetMapping("guest/list")
    public List<GuestDto> list() {
        return guestDao.getAllGuests();
    }

    @DeleteMapping("guest/delete")
    public void delete(@RequestParam int gnum) {
        guestDao.deleteGuest(gnum);
    }

}
