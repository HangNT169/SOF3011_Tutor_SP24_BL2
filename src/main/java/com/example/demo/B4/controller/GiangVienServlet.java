package com.example.demo.B4.controller;

import com.example.demo.B4.entity.GiangVien1;
import com.example.demo.B4.repository.GiangVienRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
        } else if (uri.contains("detail")) {
            // ham detail
            this.detail(request, response);
        } else if (uri.contains("remove")) {
            // ham remove
            this.remove(request, response);
        } else if (uri.contains("view-update")) {
            // view update
            this.viewUpdate(request, response);
        } else {
            // ham gi day
            this.timKiem(request, response);
        }
    }

    private void timKiem(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idUpdate");
        GiangVien1 gv = giangVienRepository.getOne(Long.valueOf(id));
        request.setAttribute("gv1", gv);
        request.getRequestDispatcher("/buoi4/update-giang-vien.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("idXoa");
        GiangVien1 gv = giangVienRepository.getOne(Long.valueOf(id));
        giangVienRepository.deleteGiangVien(gv);
        response.sendRedirect("/giang-vien/hien-thi-tat-ca");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idDetail");
        GiangVien1 gv = giangVienRepository.getOne(Long.valueOf(id));
        request.setAttribute("gvv", gv);
        request.getRequestDispatcher("/buoi4//detail-Giang-Vien.jsp").forward(request, response);
    }

    private void hienThiTatCa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<GiangVien1> list = giangVienRepository.getAll();
        request.setAttribute("a", list);
        request.getRequestDispatcher("/buoi4//giangviens.jsp").forward(request, response
        );
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            //ham hien thi
            this.add(request, response);
        } else {
            // ham gi day
            this.update(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        String id = request.getParameter("id");
        GiangVien1 giangVien1 = giangVienRepository.getOne(Long.valueOf(id));
        BeanUtils.populate(giangVien1, request.getParameterMap());
        giangVienRepository.updateGiangVien(giangVien1);
        response.sendRedirect("/giang-vien/hien-thi-tat-ca");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        GiangVien1 giangVien1 = new GiangVien1();
        BeanUtils.populate(giangVien1, request.getParameterMap());
        giangVienRepository.addGiangVien(giangVien1);
        response.sendRedirect("/giang-vien/hien-thi-tat-ca");
    }
}
