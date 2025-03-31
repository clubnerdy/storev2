package com.metacoding.storev2.store;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StoreController {

    private StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    //홈
    @GetMapping("/")
    public String index() {
        return "home";
    }

    // 상품 상세보기
    @GetMapping("/store/{id}")
    public  String detail (@PathVariable int id, HttpServletRequest request) {
        Store store = storeService.상세보기(id);
        request.setAttribute("model", store);
        return "store/detail";
    }

    // 상품 리스트
    @GetMapping("/list")
    public  String list (HttpServletRequest request) {
        List<Store> storeList = storeService.상품목록 ();
        request.setAttribute("models", storeList);
        return "store/list";
    }

    // 상품 등록하기
    @GetMapping("/save-form")
    public  String saveForm () {
        return "store/save-form";
    }

    @PostMapping("/save")
    public  String save (String name, int stock, int price) {
        storeService.상품등록(name, stock, price);
        return "redirect:/";
    }

    // 상품 수정하기
    @GetMapping("/1/update-form")
    public  String updateForm () {
        return "store/update-form";
    }

    @PostMapping("1/update")
    public  String update () {
        return "redirect:/";
    }

    //상품 삭제하기
    @PostMapping("/store/1/delete")
    public  String delete () {
        return "redirect:/";
    }
}
