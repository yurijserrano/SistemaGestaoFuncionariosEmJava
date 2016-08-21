/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.servlet;

import br.mackenzie.fci.ec.lp2.dao.CargoDAO;
import br.mackenzie.fci.ec.lp2.dao.CargoDLocal;
import br.mackenzie.fci.ec.lp2.model.Cargo;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yuri Serrano
 */
@WebServlet(name = "CargoController", urlPatterns = {"/cargo"})
public class CargoController extends HttpServlet {

    
    
   @EJB
   private CargoDLocal cargoDAO;
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        if (request != null && request.getParameter("command") != null) {

            if ("cargo.remover".equals(request.getParameter("command"))) {
                request.setAttribute("cargos", cargoDAO.listar());
                request.getRequestDispatcher("WEB-INF/jsp/cargo/remover.jsp").
                        forward(request, response);
            }

            if ("cargo.removerPorId".equals(request.getParameter("command"))) {
                Cargo cargo = new Cargo();
                cargo.setId_cargo(Long.parseLong(request.getParameter("cargos")));
                cargo = new CargoDAO().listarPorId(cargo);
                request.setAttribute("cargo", cargo);
                request.getRequestDispatcher("WEB-INF/jsp/cargo/confirmar-remocao.jsp").forward(request, response);
            }
            if ("cargo.confirmar-remocao".equals(request.getParameter("command"))) {
                Cargo cargo = new Cargo();
                cargo.setId_cargo(Long.parseLong(request.getParameter("codigo")));
                cargo.setNome(request.getParameter("nome"));
                cargoDAO.remover(cargo);
                request.setAttribute("cargos", cargoDAO.listar());
                request.getRequestDispatcher("WEB-INF/jsp/cargo/listar.jsp").forward(request, response);
            }

            if ("cargo.alterar".equals(request.getParameter("command"))) {
                request.setAttribute("cargos", cargoDAO.listar());
                request.getRequestDispatcher("WEB-INF/jsp/cargo/alterar.jsp").
                        forward(request, response);
            }

            if ("cargo.alterarPorId".equals(request.getParameter("command"))) {
                Cargo cargo = new Cargo();
                cargo.setId_cargo(Long.parseLong(request.getParameter("cargos")));
                cargo = new CargoDAO().listarPorId(cargo);
                request.setAttribute("cargo", cargo);
                request.getRequestDispatcher("WEB-INF/jsp/cargo/confirmar-alteracao.jsp").forward(request, response);
            }
            if ("cargo.confirmar-alteracao".equals(request.getParameter("command"))) {
                Cargo cargo = new Cargo();
                cargo.setId_cargo(Long.parseLong(request.getParameter("codigo")));
                cargo.setNome(request.getParameter("nome"));
                cargoDAO.atualizar(cargo);
                request.setAttribute("cargos", cargoDAO.listar());
                request.getRequestDispatcher("WEB-INF/jsp/cargo/listar.jsp").forward(request, response);
            }
            if ("cargo.formulario".equals(request.getParameter("command"))) {
                request.getRequestDispatcher("WEB-INF/jsp/cargo/inserir.jsp").forward(request, response);
            }
            if ("cargo.inserir".equals(request.getParameter("command"))) {
                Cargo cargo = new Cargo();
                cargo.setNome(request.getParameter("nome"));
                cargoDAO.inserir(cargo);
                request.setAttribute("cargos", cargoDAO.listar());
                request.getRequestDispatcher("WEB-INF/jsp/cargo/listar.jsp").forward(request, response);
            }
            if ("cargo.listar".equals(request.getParameter("command"))) {
                //Listar banco, criar uma lista e inserir na request
                List<Cargo> cargos = cargoDAO.listar();
                request.setAttribute("cargos", cargos);

                request.getRequestDispatcher("WEB-INF/jsp/cargo/listar.jsp").forward(request, response);
            }
        }


    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
