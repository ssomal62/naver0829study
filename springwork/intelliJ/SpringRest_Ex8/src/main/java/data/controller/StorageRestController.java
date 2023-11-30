package data.controller;


import data.dao.MemoDao;
import data.dao.PhotoDao;
import data.dto.PhotoDto;
import naver.storage.NcpObjectStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class StorageRestController {

    @Autowired
    private NcpObjectStorageService storageService;

    @Autowired
    PhotoDao photoDao;
    MemoDao memoDao;

    private String bucketName="bitcamp-lmh";//각자 자기의 버켓명-강사 스토리지
    private String bucketFolder = "photo";

    String fileName;

    @PostMapping("/storage/addphoto")
    public String addPhoto(@RequestParam MultipartFile upload)
    {
        //스토리지에 업로드
        fileName=storageService.uploadFile(bucketName, bucketFolder, upload);
        String photo80="https://fr2k01411649.edge.naverncp.com/82uyvvqSQa/photo/"+fileName+"?type=f&w=80&h=80&faceopt=true&ttype=jpg";

        return photo80;
    }

    @PostMapping("/storage/adddb")
    public void insertPhoto(@RequestParam String title)
    {
        PhotoDto dto=new PhotoDto();
        dto.setTitle(title);

        //원본사진경로
        String photo="https://kr.object.ncloudstorage.com/bitcamp-lmh/photo/"+fileName;
        //150*150
        String photo150="https://fr2k01411649.edge.naverncp.com/82uyvvqSQa/photo/"+fileName+"?type=f&w=150&h=150&faceopt=true&ttype=jpg";
        //80*80
        String photo80="https://fr2k01411649.edge.naverncp.com/82uyvvqSQa/photo/"+fileName+"?type=f&w=80&h=80&faceopt=true&ttype=jpg";

        dto.setPhoto(photo);
        dto.setPhoto80(photo80);
        dto.setPhoto150(photo150);

        //db insert
        photoDao.insertPhoto(dto);

        fileName=null;
    }

    @GetMapping("/storage/list")
    public List<PhotoDto> getAllStorage()
    {
        return photoDao.getAllPhotos();
    }

    @GetMapping("/storage/delete")
    public void deletePhoto(@RequestParam int num)
    {
        photoDao.deletePhoto(num);
    }

}
