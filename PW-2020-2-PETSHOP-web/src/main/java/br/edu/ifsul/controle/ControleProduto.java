package br.edu.ifsul.controle;

import br.edu.ifsul.dao.ProdutoDAO;
import br.edu.ifsul.modelo.Produto;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "controleProduto")
@ViewScoped
public class ControleProduto implements Serializable {
    @EJB
    private ProdutoDAO<Produto> dao;
    private Produto objeto;
    
    public ControleProduto() {
    }
    
    public String listar(){
        return "/privado/produto/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Produto();
    }
    public void alterar(Object id){
        try{
            objeto = dao.getObjectById(id);
        } catch(Exception e){
            Util.menssagemInformacao("Erro ao recuperar Objeto: "+ Util.getMensaemErro(e));
        }
    }
    
    public void excluir(Object id){
        try{
            objeto = dao.getObjectById(id);
            dao.remove(objeto);
            Util.menssagemInformacao("Objeto removido com sucesso!!");
        } catch(Exception e){
            Util.menssagemInformacao("Erro ao remover Objeto: "+ Util.getMensaemErro(e));
        }
    }
    public void salvar(){
        try{
            if(objeto.getId() == null){
                dao.persist(objeto);
            }else{
                dao.merge(objeto);
            }
            Util.menssagemInformacao("Objeto persistido com sucesso!");
        } catch(Exception e){
            Util.menssagemInformacao("Erro ao salvar Objeto: "+ Util.getMensaemErro(e));
        }
    }
    public ProdutoDAO<Produto> getDao() {
        return dao;
    }

    public void setDao(ProdutoDAO<Produto> dao) {
        this.dao = dao;
    }

    public Produto getObjeto() {
        return objeto;
    }

    public void setObjeto(Produto objeto) {
        this.objeto = objeto;
    }
    
}
