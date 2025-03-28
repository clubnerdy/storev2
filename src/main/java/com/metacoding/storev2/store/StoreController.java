package com.metacoding.storev2.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    @GetMapping("/detail")
    public  String detail () {
        return "store/detail";
    }

    // 상품 리스트
    @GetMapping("/list")
    public  String list () {
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
