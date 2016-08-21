/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.servlet;

import br.mackenzie.fci.ec.lp2.dao.CargoD;
import br.mackenzie.fci.ec.lp2.dao.CargoDAO;
import br.mackenzie.fci.ec.lp2.dao.FuncionarioD;
import br.mackenzie.fci.ec.lp2.dao.FuncionarioDAO;

import br.mackenzie.fci.ec.lp2.model.Cargo;
import br.mackenzie.fci.ec.lp2.model.Funcionario;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 1146322
 */
@WebServlet(name = "FuncionarioController", urlPatterns = {"/funcionario"})
public class FuncionarioController extends HttpServlet {

    @EJB
    private  FuncionarioD funcionarioDAO;
   
    
    
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
            
            
            
            if ("funcionario.removerPorId".equals(request.getParameter("command"))) {
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(Long.parseLong(request.getParameter("funcionarios")));
                funcionario = new FuncionarioDAO().listarPorId(funcionario);
                request.setAttribute("funcionario", funcionario);
                request.setAttribute("cargos", funcionarioDAO.listar());
                request.getRequestDispatcher("WEB-INF/jsp/funcionario/confirmar-remocao.jsp").forward(request, response);
            }
            
             if ("funcionario.confirmar-remocao".equals(request.getParameter("command"))) {
                
                Funcionario funcionario  =new Funcionario();
                funcionario.setCodigo(Long.parseLong(request.getParameter("codigo")));
                funcionarioDAO.remover(funcionario);
                request.setAttribute("funcionarios",funcionarioDAO.listar());
                request.getRequestDispatcher("WEB-INF/jsp/funcionario/listar.jsp").forward(request, response);
                
            }
            
             
              if ("funcionario.remover".equals(request.getParameter("command"))) {
                request.setAttribute("funcionarios", funcionarioDAO.listar());
                request.getRequestDispatcher("WEB-INF/jsp/funcionario/remover.jsp").forward(request, response);
            }
             
            if ("funcionario.confirmar-alteracao".equals(request.getParameter("command"))) {
                
                Funcionario funcionario  =new Funcionario();
                funcionario.setCodigo(Long.parseLong(request.getParameter("codigo")));
                funcionario.setNome(request.getParameter("nome"));
                Cargo cargo = new Cargo();
                cargo.setId_cargo(Long.parseLong(request.getParameter("cargos")));
                funcionario.setCargo(cargo);
                funcionarioDAO.atualizar(funcionario);
                request.setAttribute("funcionarios", funcionarioDAO.listar());
                request.getRequestDispatcher("WEB-INF/jsp/funcionario/listar.jsp").forward(request, response);
                
            }
            
            if ("funcionario.alterarPorId".equals(request.getParameter("command"))) {
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(Long.parseLong(request.getParameter("funcionarios")));
                funcionario = new FuncionarioDAO().listarPorId(funcionario);
                request.setAttribute("funcionario", funcionario);
                request.setAttribute("cargos", new CargoDAO().listar());
                request.getRequestDispatcher("WEB-INF/jsp/funcionario/confirmar-alteracao.jsp").forward(request, response);
            }

            if ("funcionario.alterar".equals(request.getParameter("command"))) {
                request.setAttribute("funcionarios", funcionarioDAO.listar());
                request.getRequestDispatcher("WEB-INF/jsp/funcionario/alterar.jsp").forward(request, response);
            }

            if ("funcionario.formulario".equals(request.getParameter("command"))) {
                request.setAttribute("cargos", new CargoDAO().listar());
                request.getRequestDispatcher("WEB-INF/jsp/funcionario/inserir.jsp").forward(request, response);
            }

            if ("funcionario.inserir".equals(request.getParameter("command"))) {
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(request.getParameter("nome"));
                Cargo cargo = new Cargo();
                cargo.setId_cargo(Long.parseLong(request.getParameter("cargo")));
                funcionario.setCargo(cargo);
                funcionarioDAO.inserir(funcionario);
                request.setAttribute("funcionarios", funcionarioDAO.listar());
                request.getRequestDispatcher("WEB-INF/jsp/funcionario/listar.jsp").forward(request, response);
            }

            if ("funcionario.listar".equals(request.getParameter("command"))) {
                request.setAttribute("funcionarios",funcionarioDAO.listar());
                request.getRequestDispatcher("WEB-INF/jsp/funcionario/listar.jsp").forward(request, response);
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
