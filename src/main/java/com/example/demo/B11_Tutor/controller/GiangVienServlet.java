package com.sof3011.hangnt.B11_Tutor.controller;

import com.sof3011.hangnt.B11_Tutor.entity.GiangVien1;
import com.sof3011.hangnt.B11_Tutor.repository.GiangVienRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GiangVienServlet", value = {
        "/giang-vien/hien-thi-tat-ca", //get
        "/giang-vien/detail", //get
        "/giang-vien/remove", //get
        "/giang-vien/view-update", //get
        "/giang-vien/update", //post
        "/giang-vien/tim-kiem", //get
        "/giang-vien/add" //post
})
public class GiangVienServlet extends HttpServlet {

    private GiangVienRepository giangVienRepository = new GiangVienRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi-tat-ca")) {
            //ham hien thi
            this.hienThiTatCa(request, response);
        }else if (uri.contains("detail")) {
            // ham detail
            this.detail(request, response);
        }else if (uri.contains("remove")) {
            // ham remove
            this.remove(request, response);
        }else if (uri.contains("view-update")) {
            // view update
            this.viewUpdate(request, response);
        }else {
            // ham gi day
            this.timKiem(request, response);
        }
    }

    private void timKiem(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiTatCa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<GiangVien1> list = giangVienRepository.getAll();
        request.setAttribute("a", list);
        request.getRequestDispatcher("/buoi11/giangviens.jsp").forward(request, response
        );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            //ham hien thi
            this.add(request, response);
        }else {
            // ham gi day
            this.update(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
    }
}
