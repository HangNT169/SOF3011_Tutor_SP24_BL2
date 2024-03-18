package com.example.demo.controller;

import com.example.demo.entity.GiangVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GiangVienServlet", value = {
        "/giang-vien/hien-thi",  // GET
        "/giang-vien/search",    // GET
        "/giang-vien/remove",   // GET
        "/giang-vien/detail",   // GET
        "/giang-vien/view-update",  // GET
        "/giang-vien/update",       // POST
        "/giang-vien/add",          // POST
        "/giang-vien/view-add",     // GET
        "/giang-vien/giang-vien-nu" // GET
})
public class GiangVienServlet extends HttpServlet {

    private List<GiangVien> lists = new ArrayList<>();

    public GiangVienServlet() {
        // add du lieu
        lists.add(new GiangVien("1", "abc", "abcd", 12, true, "ha noi"));
        lists.add(new GiangVien("2", "abcd", "gfds", 12, true, "ha nreqwoi"));
        lists.add(new GiangVien("3", "abce", "abgsdfcd", 12, false, "ha noi"));
        lists.add(new GiangVien("4", "abcf", "abcd", 12, true, "ha newqoi"));
        lists.add(new GiangVien("5", "abcg", "abcd", 12, true, "ha noi"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            // hien thi
            this.hienThiDanhSach(request, response);
        } else if (uri.contains("giang-vien-nu")) {
            this.searchGiangVienNu(request, response);
        } else if (uri.contains("remove")) {
            this.removeGiangVien(request, response);
        } else if (uri.contains("detail")) {
            this.detailGiangVien(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("view-add")) {
            this.viewAdd(request, response);
        } else {
            this.searchTheoTen(request, response);
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.add(request, response);
        } else {
            this.update(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        // B1: Lay lai doi tuong gv can up thong qua id
        String id = request.getParameter("id");
        GiangVien gv = new GiangVien();
        int index = -1;
        for (int i = 0 ;i < lists.size();i++){
            if(lists.get(i).getId().equalsIgnoreCase(id)){
                gv = lists.get(i);
                index = i;
            }
        }
        BeanUtils.populate(gv,request.getParameterMap());
        lists.set(index,gv);
        response.sendRedirect("/giang-vien/hien-thi");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        GiangVien gv = new GiangVien();
        BeanUtils.populate(gv, request.getParameterMap()); // Lay gia tri cua cac o input map vao doi tuong
        this.lists.add(gv);
        response.sendRedirect("/giang-vien/hien-thi");
    }

    private void searchTheoTen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("ten");
        List<GiangVien> listSearch = new ArrayList<>();
        for (GiangVien giangVien : lists) {
            if (giangVien.getTen().contains(ten)) {
                listSearch.add(giangVien);
            }
        }
        request.setAttribute("a" , listSearch);
        request.getRequestDispatcher("/buoi1/giangVien.jsp").forward(request, response);
   }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/buoi1/add-giang-vien.jsp").forward(request, response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id1"); // lay tu phia jsp ve servlet
        for (GiangVien gv : lists) {
            if (gv.getId().equalsIgnoreCase(id)) {
                request.setAttribute("gv111", gv); // truyen gia tri tu phia servlet => jsp
            }
        }
        request.getRequestDispatcher("/buoi1/update-giang-vien.jsp").forward(request, response);
    }

    private void detailGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id"); // lay tu phia jsp ve servlet
        for (GiangVien gv : lists) {
            if (gv.getId().equalsIgnoreCase(id)) {
                request.setAttribute("gv111", gv); // truyen gia tri tu phia servlet => jsp
            }
        }
        request.getRequestDispatcher("/buoi1/detail-Giang-Vien.jsp").forward(request, response);
    }

    private void removeGiangVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("abc");
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).getId().equalsIgnoreCase(id)) {
                lists.remove(i);
            }
        }
        response.sendRedirect("/giang-vien/hien-thi");
        // https://viblo.asia/p/su-dung-streams-filter-trong-java-8-naQZReedKvx
    }

    private void searchGiangVienNu(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiDanhSach(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("a", this.lists);
        request.getRequestDispatcher("/buoi1/giangVien.jsp").forward(request, response);
    }

}
