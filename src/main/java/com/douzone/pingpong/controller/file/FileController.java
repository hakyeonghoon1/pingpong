package com.douzone.pingpong.controller.file;

import com.douzone.pingpong.domain.post.Post;
import com.douzone.pingpong.service.post.PostService;
import com.douzone.pingpong.util.FileStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
@RequiredArgsConstructor
public class FileController {
    private final FileStore fileStore;
    private final PostService postService;



//    @GetMapping("/file")
//    public String newFile(@ModelAttribute EditForm form) {
//        return "file/image-form";
//    }
//
//    @PostMapping("/file")
//    public String uploadFile(@ModelAttribute EditForm editForm,
//                             RedirectAttributes redirectAttributes,
//                             @Login Member loginMember)
//            throws IOException {
//
//        UploadFile imageFile = fileStore.storeFile(editForm.getImageFile());
//        fileService.saveFile(imageFile);
//
//        UpdateMemberDto updateMemberDto =
//                new UpdateMemberDto(editForm.getName(), editForm.getStatus(), imageFile);
//
//
//        log.info("request={}", editForm);
//        Long memberId = memberService.update(loginMember.getId(), updateMemberDto);
//
//        redirectAttributes.addAttribute("memberId", memberId);
//
//        return "redirect:/member/{memberId}";
//    }
//
//    @GetMapping("/member/{memberId}")
//    public String member(@PathVariable Long memberId, Model model) {
//        Member member = memberService.findMember(memberId);
//
//        log.info("memberName:{}", member.getName());
//        log.info("memberImage:{}", member.getUploadFile());
//        log.info("memberImage:{}", member.getUploadFile().getFilePath());
//
//        model.addAttribute("member", member);
//        return "file/member-view";
//    }

//    @ResponseBody
//    @GetMapping("/images/{filename}")
//    public Resource downloadImage(@PathVariable String filename) throws
//            IOException {
//        System.out.println("=======================================");
//        System.out.println("file:" + fileStore.getFullPath(filename));
//        return new UrlResource("file:" + fileStore.getFullPath(filename));
//    }

//    @GetMapping("/attach/{itemId}")
//    public ResponseEntity<Resource> downloadAttach(@PathVariable Long itemId)
//            throws IOException {
//
//        // ????????? ?????? -> ????????? ID??? ????????? ???????????? ??????
//        Post post = postService.getPostById(postId);
//
//        // ????????? ???????????? ????????? ????????? ?????????  Ex)631f-2462fa-3g3f-5315d.png
//        String storeFileName = post.getAttachFile().getStoreFileName();
//
//        // ???????????? ???????????? ????????? ?????????      Ex) apple.png
//        String uploadFileName = post.getAttachFile().getUploadFileName();
//
//
//        // ????????? ????????? ??????????????? ????????????   ex) /Users/jinyoung/project/pingpong/file/631f-2462fa-3g3f-5315d.png
//        UrlResource resource = new UrlResource("file:" +
//                fileStore.getFullPath(storeFileName));
//
//        log.info("uploadFileName={}", uploadFileName);
//
//        // ????????? ????????? ????????????
//        String encodedUploadFileName = UriUtils.encode(uploadFileName,
//                StandardCharsets.UTF_8);
//
//
//        /**
//         * ???????????? ???????????????
//         * 1. HTTP????????? ??????????????? ????????????
//         * 2. body?????? ????????? ????????? resource ??????
//         * 3. Response ??????
//         *
//         *
//         * HTTP ??????????????? ex)
//         * Content-Disposition: attachment; filename="apple.png"
//         *
//         * body : resource (????????????)
//         */
//        String contentDisposition = "attachment; filename=\"" +
//                encodedUploadFileName + "\"";
//
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
//                .body(resource);
//        }
    }