package br.edu.ifsul.controle;

import br.edu.ifsul.dao.RacaDAO;
import br.edu.ifsul.modelo.Raca;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


@Named(value = "controleRaca")
@ViewScoped
public class ControleRaca implements Serializable{
    
    @EJB
    private RacaDAO<Raca> dao;
    private Raca objeto;

    public ControleRaca() {
    }
    public String listar(){
        return "/privado/raca/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Raca();
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
    
    public RacaDAO<Raca> getDao() {
        return dao;
    }

    public void setDao(RacaDAO<Raca> dao) {
        this.dao = dao;
    }

    public Raca getObjeto() {
        return objeto;
    }

    public void setObjeto(Raca objeto) {
        this.objeto = objeto;
    }
    
   
    
}
